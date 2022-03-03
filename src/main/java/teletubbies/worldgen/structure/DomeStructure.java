package teletubbies.worldgen.structure;

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
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
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

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        BlockPos chunkBlockPos = context.chunkPos().getWorldPosition();
        final int maxHeightDifference = 3;
        
        int centerY = context.chunkGenerator().getFirstOccupiedHeight(chunkBlockPos.getX(), chunkBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        BlockPos centerPos = new BlockPos(
        		chunkBlockPos.getX() + 14,
        		centerY,
        		chunkBlockPos.getZ() + 15);
        
        BlockPos pos_tinkywinky = new BlockPos(centerPos.getX() - 16, centerPos.getY(), centerPos.getZ() - 16);
        int height_tinkywinky = context.chunkGenerator().getFirstOccupiedHeight(pos_tinkywinky.getX(), pos_tinkywinky.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        NoiseColumn columnOfBlocks_tinkywinky = context.chunkGenerator().getBaseColumn(pos_tinkywinky.getX(), pos_tinkywinky.getZ(), context.heightAccessor());

        BlockPos pos_dipsy = new BlockPos(centerPos.getX() + 12, centerPos.getY(), centerPos.getZ() - 16);
        int height_dipsy = context.chunkGenerator().getFirstOccupiedHeight(pos_dipsy.getX(), pos_dipsy.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        NoiseColumn columnOfBlocks_dipsy = context.chunkGenerator().getBaseColumn(pos_dipsy.getX(), pos_dipsy.getZ(), context.heightAccessor());

        BlockPos pos_laalaa = new BlockPos(centerPos.getX() + 12, centerPos.getY(), centerPos.getZ() + 14);
        int height_laalaa = context.chunkGenerator().getFirstOccupiedHeight(pos_laalaa.getX(), pos_laalaa.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        NoiseColumn columnOfBlocks_laalaa = context.chunkGenerator().getBaseColumn(pos_laalaa.getX(), pos_laalaa.getZ(), context.heightAccessor());

        BlockPos pos_po = new BlockPos(centerPos.getX() - 16, centerPos.getY(), centerPos.getZ() + 14);
        int height_po = context.chunkGenerator().getFirstOccupiedHeight(pos_po.getX(), pos_po.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        NoiseColumn columnOfBlocks_po = context.chunkGenerator().getBaseColumn(pos_po.getX(), pos_po.getZ(), context.heightAccessor());
        
        if (Math.abs(centerY - height_tinkywinky) <= maxHeightDifference && columnOfBlocks_tinkywinky.getBlock(height_tinkywinky).getFluidState().isEmpty() &&
    		Math.abs(centerY - height_dipsy) <= maxHeightDifference && columnOfBlocks_dipsy.getBlock(height_dipsy).getFluidState().isEmpty() &&
			Math.abs(centerY - height_laalaa) <= maxHeightDifference && columnOfBlocks_laalaa.getBlock(height_laalaa).getFluidState().isEmpty() &&
			Math.abs(centerY - height_po) <= maxHeightDifference && columnOfBlocks_po.getBlock(height_po).getFluidState().isEmpty()) {
        	return true;
        }
        return false;
    }

    private static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        if (!isFeatureChunk(context)) {
        	return Optional.empty();
        }
    	
    	BlockPos chunkBlockPos = new BlockPos(context.chunkPos().getWorldPosition().getX(), context.chunkPos().getWorldPosition().getY() - 3, context.chunkPos().getWorldPosition().getZ());

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator = JigsawPlacement.addPieces(context, DomeStructure::pieceFactory, chunkBlockPos, false, true);
        return structurePiecesGenerator;
    }
    
	private static PoolElementStructurePiece pieceFactory(StructureManager structureManager, StructurePoolElement element, BlockPos blockpos, int groundLevelDelta, Rotation rotation, BoundingBox bb) {
		return new PoolElementStructurePiece(structureManager, element, blockpos, groundLevelDelta, Rotation.NONE, element.getBoundingBox(structureManager, blockpos, Rotation.NONE));
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
    							
					// Fill all air under the dome down to maxFillLengthDown blocks
					for (int m = 1; m < maxFillLengthDown; m++) {
						if (blockPos.below(m).getY() <= 0) break;
						
						if (level.getBlockState(blockPos.below(m)).isAir()) {
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
