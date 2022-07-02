package teletubbies.worldgen.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraft.world.level.material.Fluids;
import teletubbies.block.FullGrassBlock;
import teletubbies.init.TeletubbiesBlocks;

public class DomeStructure extends StructureFeature<JigsawConfiguration> {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public DomeStructure() {
        super(JigsawConfiguration.CODEC, DomeStructure::createPiecesGenerator, DomeStructure::afterPlace);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static Optional<BlockPos> isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context, Rotation rotation) {
    	BlockPos chunkBlockPos = new BlockPos(context.chunkPos().getWorldPosition().getX(), context.chunkPos().getWorldPosition().getY() - 3, context.chunkPos().getWorldPosition().getZ());
    	final int halfRectangleLength = 16;
    	final int stepSize = 4;
        final int maxHeightDifference = 2;
        
        int centerY = context.chunkGenerator().getFirstOccupiedHeight(chunkBlockPos.getX(), chunkBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        BlockPos relativeCenter = new BlockPos(14, 0, 15).rotate(rotation); // Defined for entrance towards east and rotated for other rotations
        BlockPos centerPos = new BlockPos(
        		chunkBlockPos.getX() + relativeCenter.getX(),
        		centerY,
        		chunkBlockPos.getZ() + relativeCenter.getZ());
                
        List<Integer> heightList = new ArrayList<>();
        
        for (int i = -halfRectangleLength; i < halfRectangleLength; i += stepSize) {
        	for (int j = -halfRectangleLength; j < halfRectangleLength; j += stepSize) {
        		BlockPos pos = new BlockPos(centerPos.getX() + i, centerPos.getY(), centerPos.getZ() + j);
                int height = context.chunkGenerator().getFirstOccupiedHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
                heightList.add(height);
                
                // If there is fluid than return false
                NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(pos.getX(), pos.getZ(), context.heightAccessor());
                if (!columnOfBlocks.getBlock(height).getFluidState().isEmpty()) {
                	return Optional.empty();
                }
        	}
        }
        
        Collections.sort(heightList);
        int median = (heightList.get(heightList.size() / 2) + heightList.get(heightList.size() / 2 - 1)) / 2;
        int min = heightList.get(0);
        int max = heightList.get(heightList.size() - 1);
        
        if (median - min <= maxHeightDifference || max - median <= maxHeightDifference) {
        	return Optional.of(chunkBlockPos);
        }
        return Optional.empty();
    }

    private static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
		WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
		worldgenrandom.setLargeFeatureSeed(context.seed(), context.chunkPos().x, context.chunkPos().z);
		Rotation rotation = Rotation.getRandom(worldgenrandom);

    	Optional<BlockPos> chunkPosition = isFeatureChunk(context, rotation);
        if (!chunkPosition.isPresent()) {
        	return Optional.empty();
        }
    	BlockPos chunkBlockPos = chunkPosition.get();

    	Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator = DomeJigsawPlacement.addPieces(context, PoolElementStructurePiece::new, chunkBlockPos, worldgenrandom, rotation);
        return structurePiecesGenerator;
    }
	
	private static void afterPlace(WorldGenLevel level, StructureFeatureManager structureManager, ChunkGenerator chunkGenerator, Random rand, BoundingBox bb, ChunkPos chunkPos, PiecesContainer container) {
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
}