package teletubbies.world.gen.feature.structure;

import com.mojang.serialization.Codec;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DomeStructure extends Structure<NoFeatureConfig> {

	public DomeStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
	}
	
	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return Start::new;
	}

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }
    
	@Override
	protected boolean isFeatureChunk(ChunkGenerator generator, BiomeProvider biomeProvider, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig config) {
		int centerY = generator.getBaseHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
        BlockPos centerPos = new BlockPos(chunkX * 16, centerY - 3, chunkZ * 16);
        
        int height_TinkyWinky = generator.getBaseHeight(centerPos.getX() - 16, centerPos.getZ() - 16, Heightmap.Type.WORLD_SURFACE_WG);
        int height_Dipsy = generator.getBaseHeight(centerPos.getX() + 12, centerPos.getZ() - 16, Heightmap.Type.WORLD_SURFACE_WG);
        int height_LaaLaa = generator.getBaseHeight(centerPos.getX() + 12, centerPos.getZ() + 14, Heightmap.Type.WORLD_SURFACE_WG);
        int height_Po = generator.getBaseHeight(centerPos.getX() - 16, centerPos.getZ() + 14, Heightmap.Type.WORLD_SURFACE_WG);
        
        if (Math.abs(centerY - height_TinkyWinky) <= 3 &&
    		Math.abs(centerY - height_Dipsy) <= 3 &&
			Math.abs(centerY - height_LaaLaa) <= 3 &&
			Math.abs(centerY - height_Po) <= 3) {
        	return true;
        }
		return false;
	}
   
	public static class Start extends StructureStart<NoFeatureConfig> {
		
		public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox bounds, int reference, long seed) {
			super(structure, chunkX, chunkZ, bounds, reference, seed);
		}
		
		@Override
		public void generatePieces(DynamicRegistries dr, ChunkGenerator generator, TemplateManager manager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            int centerY = generator.getBaseHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos centerPos = new BlockPos(chunkX * 16, centerY - 3, chunkZ * 16);
			
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_TINKYWINKY, centerPos.offset(-16, 0, -16)));
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_DIPSY, centerPos.offset(0, 0, -16)));
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_LAALAA, centerPos));
	        this.pieces.add(new DomePieces.Piece(manager, DomePieces.DOME_PO, centerPos.offset(-16, 0, 0)));
	        
			this.calculateBoundingBox();
		}
	}
}
