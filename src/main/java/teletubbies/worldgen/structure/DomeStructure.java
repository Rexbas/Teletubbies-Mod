package teletubbies.worldgen.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.material.Fluids;
import teletubbies.block.FullGrassBlock;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesStructures;

public class DomeStructure extends Structure {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final Codec<DomeStructure> CODEC = RecordCodecBuilder.<DomeStructure>mapCodec(instance ->
	    instance.group(DomeStructure.settingsCodec(instance),
	            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
	            HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight)
	    ).apply(instance, DomeStructure::new)).codec();
    
    private final Holder<StructureTemplatePool> startPool;
    private final HeightProvider startHeight;
    
	public DomeStructure(Structure.StructureSettings config, Holder<StructureTemplatePool> startPool, HeightProvider startHeight) {
		super(config);
		this.startPool = startPool;
		this.startHeight = startHeight;
	}

    private static boolean isFeatureChunk(GenerationContext context) {
    	BlockPos chunkBlockPos = context.chunkPos().getWorldPosition();
    	final int halfRectangleLength = 16;
    	final int stepSize = 4;
        final int maxHeightDifference = 2;
        
        int centerY = context.chunkGenerator().getFirstOccupiedHeight(chunkBlockPos.getX(), chunkBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
        BlockPos centerPos = new BlockPos(
        		chunkBlockPos.getX() + 14,
        		centerY,
        		chunkBlockPos.getZ() + 15);
                
        List<Integer> heightList = new ArrayList<>();
        
        for (int i = -halfRectangleLength; i < halfRectangleLength; i += stepSize) {
        	for (int j = -halfRectangleLength; j < halfRectangleLength; j += stepSize) {
        		BlockPos pos = new BlockPos(centerPos.getX() + i, centerPos.getY(), centerPos.getZ() + j);
                int height = context.chunkGenerator().getFirstOccupiedHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
                heightList.add(height);
                
                // If there is fluid than return false
                NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(pos.getX(), pos.getZ(), context.heightAccessor(), context.randomState());
                if (!columnOfBlocks.getBlock(height).getFluidState().isEmpty()) {
                	return false;
                }
        	}
        }
        
        Collections.sort(heightList);
        int median = (heightList.get(heightList.size() / 2) + heightList.get(heightList.size() / 2 - 1)) / 2;
        int min = heightList.get(0);
        int max = heightList.get(heightList.size() - 1);
        
        if (median - min <= maxHeightDifference || max - median <= maxHeightDifference) {
        	return true;
        }
        return false;
    }
    
	@Override
	public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
		if (!isFeatureChunk(context)) {
        	return Optional.empty();
        }
    	BlockPos chunkBlockPos = new BlockPos(context.chunkPos().getWorldPosition().getX(), context.chunkPos().getWorldPosition().getY(), context.chunkPos().getWorldPosition().getZ());

    	Optional<Structure.GenerationStub> structurePiecesGenerator =
				JigsawPlacement.addPieces(context, this.startPool, Optional.empty(), 1, chunkBlockPos, false, Optional.of(Heightmap.Types.WORLD_SURFACE_WG), 1);
    	
		return structurePiecesGenerator;
	}
	
	@Override
	public void afterPlace(WorldGenLevel level, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource rand, BoundingBox bb, ChunkPos chunkPos, PiecesContainer container) {
		BlockPos piecePos;
		final int maxFillLengthDown = 10;
		final int height = 6;

		// Check if there are pieces. Number of pieces should always be 1
		if (container.pieces().size() > 0) {
			piecePos = new BlockPos(chunkPos.getWorldPosition().getX(), container.pieces().get(0).getBoundingBox().minY(), chunkPos.getWorldPosition().getZ());
		}
		else {
			piecePos = chunkPos.getWorldPosition();
		}
        
		// Get all footprint blocks from the dome
    	for (int i = 0; i < bb.getXSpan(); i++) {
    		for (int j = 0; j < bb.getZSpan(); j++) {
    			
    			BlockPos blockPos = new BlockPos(piecePos.getX() + i, piecePos.getY(), piecePos.getZ() + j);
    			if (level.getBlockState(blockPos).getBlock() instanceof FullGrassBlock) {
    							
					// Fill all air or water under the dome down to maxFillLengthDown blocks
					for (int m = 1; m < maxFillLengthDown; m++) {
						if (blockPos.below(m).getY() <= 0) break;
						
						if (level.getBlockState(blockPos.below(m)).isAir() || level.getFluidState(blockPos.below(m)).getType() == Fluids.WATER) {
							level.setBlock(blockPos.below(m), TeletubbiesBlocks.FULL_GRASS.get().defaultBlockState(), 2);
						}
						else {
							break;
						}
					}
					
					// Remove all waterlogged blockstates
					for (int m = 1; m < height; m++) {
						if (blockPos.above(m).getY() >= level.getMaxBuildHeight()) break;
						
						BlockState blockState = level.getBlockState(blockPos.above(m));
						if (blockState.hasProperty(WATERLOGGED) && blockState.getValue(WATERLOGGED)) {
							level.setBlock(blockPos.above(m), blockState.setValue(WATERLOGGED, false), 2);
						}
					}
    			}
    		}
    	}
	}

	@Override
	public StructureType<?> type() {
		return TeletubbiesStructures.DOME_STRUCTURE.get();
	}
}