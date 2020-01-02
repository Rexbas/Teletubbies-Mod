package teletubbies.world.gen.feature.structure;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DomeStructure extends ScatteredStructure<NoFeatureConfig> {

	public DomeStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}
	
	@Override
	public IStartFactory getStartFactory() {
		return Start::new;
	}

	@Override
	public String getStructureName() {
		return this.getRegistryName().toString();
	}
	
	@Override
	protected int getSeedModifier() {
		return 0;
	}

	@Override
	public int getSize() {
		return 1;
	}
	
	public static class Start extends StructureStart {
		
		public Start(Structure<?> structure, int chunkX, int chunkZ, Biome biome, MutableBoundingBox bounds, int reference, long seed) {
			super(structure, chunkX, chunkZ, biome, bounds, reference, seed);
		}
		
		@Override
		public void generateStructure(IWorld world, Random rand, MutableBoundingBox bb, ChunkPos pos) {
			MutableBoundingBox fullBB = this.getBoundingBox();
			if (this.components.iterator().hasNext()) {
				if (this.components.iterator().next() instanceof DomePiece) {
					DomePiece p = (DomePiece) this.components.iterator().next();
					if (p.getSpawnHeight() == -1) {
						p.setSpawnHeight(world.getHeight(Type.WORLD_SURFACE, fullBB.minX + 15, fullBB.minZ + 15));
					}
				}
			}
			super.generateStructure(world, rand, bb, pos);
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager manager, int chunkX, int chunkZ, Biome biome) {
			this.components.add(new DomePiece(manager, this.rand, chunkX * 16, chunkZ * 16, 29, 9, 31));
			this.recalculateStructureSize();
		}
	}
}
