package teletubbies.world.gen.feature.structure;

import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DomeStructure extends ScatteredStructure<NoFeatureConfig> {

	public DomeStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory) {
		super(configFactory);
	}
	
	/*@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if (super.place(world, generator, rand, pos, config) && world instanceof ServerWorld) {
			ServerWorld server = (ServerWorld) world;
			TemplateManager manager = server.getStructureTemplateManager();
			Template template = manager.getTemplate(new ResourceLocation(Teletubbies.MODID, "kruis"));
			
			if (template == null) {
				System.out.println("null template");
			} else {
				System.out.println(pos);
				template.addBlocksToWorld(world, pos, new PlacementSettings());
				return true;
			}
		} else {
			System.out.println("no server or no super");
		}
		return false;
	}*/
	
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
		public void init(ChunkGenerator<?> generator, TemplateManager manager, int chunkX, int chunkZ, Biome biome) {
			DomePiece domePiece = new DomePiece(manager, this.rand, chunkX * 16, chunkZ * 16);
			this.components.add(domePiece);
			this.recalculateStructureSize();
		}
	}
}
