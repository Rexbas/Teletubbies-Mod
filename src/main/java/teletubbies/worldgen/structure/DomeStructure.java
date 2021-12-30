package teletubbies.worldgen.structure;

import java.util.Optional;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.JigsawPlacement;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import teletubbies.Teletubbies;

public class DomeStructure extends StructureFeature<JigsawConfiguration> {
	
	public DomeStructure(Codec<JigsawConfiguration> codec) {
        super(codec, (context) -> {
                if (!DomeStructure.isFeatureChunk(context)) {
                    return Optional.empty();
                }
                else {
                    return DomeStructure.createPiecesGenerator(context);
                }
            },
            PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        BlockPos chunkBlockPos = context.chunkPos().getWorldPosition();

        // Grab height of land. Will stop at first non-air block.
        int landHeight = context.chunkGenerator().getFirstOccupiedHeight(chunkBlockPos.getX(), chunkBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());

        // Grabs column of blocks at given position. In overworld, this column will be made of stone, water, and air.
        // In nether, it will be netherrack, lava, and air. End will only be endstone and air. It depends on what block
        // the chunk generator will place for that dimension.
        NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(chunkBlockPos.getX(), chunkBlockPos.getZ(), context.heightAccessor());

        // Combine the column of blocks with land height and you get the top block itself which you can test.
        BlockState topBlock = columnOfBlocks.getBlock(landHeight);

        // Now we test to make sure our structure is not spawning on water or other fluids.
        // You can do height check instead too to make it spawn at high elevations.
        //return topBlock.getFluidState().isEmpty(); //landHeight > 100;
        
        
        
        BlockPos centerPos = new BlockPos(
        		chunkBlockPos.getX(),
        		context.chunkGenerator().getFirstOccupiedHeight(chunkBlockPos.getX(), chunkBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor()),
        		chunkBlockPos.getZ());
        
        if (topBlock.getFluidState().isEmpty()) {
        	System.out.println("center pos: " + centerPos);
        	return true;
        }
        return false;
        
        
        
		/*int centerY = generator.getBaseHeight(pos.x * 16, pos.z * 16, Heightmap.Types.WORLD_SURFACE_WG, levelAccessor);
        BlockPos centerPos = new BlockPos(pos.x * 16, centerY - 3, pos.z * 16);
        
        int height_TinkyWinky = generator.getBaseHeight(centerPos.getX() - 16, centerPos.getZ() - 16, Heightmap.Types.WORLD_SURFACE_WG, levelAccessor);
        int height_Dipsy = generator.getBaseHeight(centerPos.getX() + 12, centerPos.getZ() - 16, Heightmap.Types.WORLD_SURFACE_WG, levelAccessor);
        int height_LaaLaa = generator.getBaseHeight(centerPos.getX() + 12, centerPos.getZ() + 14, Heightmap.Types.WORLD_SURFACE_WG, levelAccessor);
        int height_Po = generator.getBaseHeight(centerPos.getX() - 16, centerPos.getZ() + 14, Heightmap.Types.WORLD_SURFACE_WG, levelAccessor);
        
        if (Math.abs(centerY - height_TinkyWinky) <= 3 &&
    		Math.abs(centerY - height_Dipsy) <= 3 &&
			Math.abs(centerY - height_LaaLaa) <= 3 &&
			Math.abs(centerY - height_Po) <= 3) {
        	return true;
        }
		return false;*/
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        BlockPos chunkBlockPos = context.chunkPos().getWorldPosition();
        
        JigsawConfiguration newConfig = new JigsawConfiguration(
                () -> context.registryAccess().ownedRegistryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
                        .get(new ResourceLocation(Teletubbies.MODID, "dome/start_pool")), 7
        );

        PieceGeneratorSupplier.Context<JigsawConfiguration> newContext = new PieceGeneratorSupplier.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.heightAccessor(),
                context.validBiome(),
                context.structureManager(),
                context.registryAccess()
        );

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator = JigsawPlacement.addPieces(newContext, DomeStructure::pieceFactory, chunkBlockPos, false, true);

        if(structurePiecesGenerator.isPresent()) {
            
            System.out.println("dome at: " + chunkBlockPos);
        }
        
        return structurePiecesGenerator;
    }
    
	public static PoolElementStructurePiece pieceFactory(StructureManager structureManager, StructurePoolElement element, BlockPos blockpos, int groundLevelDelta, Rotation rotation, BoundingBox bb) {
		return new PoolElementStructurePiece(structureManager, element, blockpos, groundLevelDelta, Rotation.NONE, element.getBoundingBox(structureManager, blockpos, Rotation.NONE));
	}
}
