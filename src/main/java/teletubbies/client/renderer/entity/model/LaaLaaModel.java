package teletubbies.client.renderer.entity.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LaaLaaModel<T extends PathfinderMob> extends TeletubbyModel<T> {
	public ModelPart stick;

	public LaaLaaModel(ModelPart part, boolean isZombie) {
		super(part, isZombie);
		stick = part.getChild("head").getChild("stick");
	}
	
	public LaaLaaModel(ModelPart part) {
		this(part, false);
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = TeletubbyModel.createMesh();
		PartDefinition def = mesh.getRoot();
		
		def.getChild("head").addOrReplaceChild("stick", CubeListBuilder.create()
				.addBox(null, -1.0F, -35.0F, -1.0F, 2, 3, 2, 27, 20)
				.addBox(null, 0.0F, -38.0F, 0.0F, 2, 4, 2, 27, 25),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 32);
	}
}
