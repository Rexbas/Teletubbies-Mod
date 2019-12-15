package teletubbies.client.models;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entities.Dipsy;

@OnlyIn(Dist.CLIENT)
public class DipsyModel extends TeletubbyModel<Dipsy> {
	public RendererModel stick;

	public DipsyModel() {
		stick = new RendererModel(this);
		stick.setRotationPoint(0.0F, 24.0F, 0.0F);
		stick.cubeList.add(new ModelBox(stick, 27, 20, -1.0F, -38.0F, -1.0F, 2, 6, 2, 0.0F, false));
	}
	
	@Override
	public void render(Dipsy entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		stick.render(scale);
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
}
