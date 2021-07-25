package teletubbies.world.gen.feature.structure;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

public class DomeStructure extends StructureFeature<NoneFeatureConfiguration> {

	public DomeStructure(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}
	
	@Override
	public StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
		return Start::new;
	}

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }
    
	@Override
	protected boolean isFeatureChunk(ChunkGenerator generator, BiomeSource biomeProvider, long seed, WorldgenRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoneFeatureConfiguration config) {
		int centerY = generator.getBaseHeight(chunkX * 16, chunkZ * 16, Heightmap.Types.WORLD_SURFACE_WG);
        BlockPos centerPos = new BlockPos(chunkX * 16, centerY - 3, chunkZ * 16);
        
        int height_TinkyWinky = generator.getBaseHeight(centerPos.getX() - 16, centerPos.getZ() - 16, Heightmap.Types.WORLD_SURFACE_WG);
        int height_Dipsy = generator.getBaseHeight(centerPos.getX() + 12, centerPos.getZ() - 16, Heightmap.Types.WORLD_SURFACE_WG);
        int height_LaaLaa = generator.getBaseHeight(centerPos.getX() + 12, centerPos.getZ() + 14, Heightmap.Types.WORLD_SURFACE_WG);
        int height_Po = generator.getBaseHeight(centerPos.getX() - 16, centerPos.getZ() + 14, Heightmap.Types.WORLD_SURFACE_WG);
        
        if (Math.abs(centerY - height_TinkyWinky) <= 3 &&
    		Math.abs(centerY - height_Dipsy) <= 3 &&
			Math.abs(centerY - height_LaaLaa) <= 3 &&
			Math.abs(centerY - height_Po) <= 3) {
        	return true;
        }
		return false;
	}
   
	public static class Start extends StructureStart<NoneFeatureConfiguration> {
		
		public Start(StructureFeature<NoneFeatureConfiguration> structure, int chunkX, int chunkZ, BoundingBox bounds, int reference, long seed) {
			super(structure, chunkX, chunkZ, bounds, reference, seed);
		}
		
		@Override
		public void generatePieces(RegistryAccess dr, ChunkGenerator generator, StructureManager manager, int chunkX, int chunkZ, Biome biome, NoneFeatureConfiguration config) {
            int centerY = generator.getBaseHeight(chunkX * 16, chunkZ * 16, Heightmap.Types.WORLD_SURFACE_WG);
            BlockPos centerPos = new BlockPos(chunkX * 16, centerY - 3, chunkZ * 16);
			
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_TINKYWINKY, centerPos.offset(-16, 0, -16)));
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_DIPSY, centerPos.offset(0, 0, -16)));
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_LAALAA, centerPos));
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_PO, centerPos.offset(-16, 0, 0)));
	        
			this.calculateBoundingBox();
		}
	}
}
