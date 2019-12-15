package teletubbies.client.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entities.Teletubby;

@OnlyIn(Dist.CLIENT)
public class TeletubbyModel<T extends Teletubby> extends BipedModel<T> {
	public RendererModel leftEar;
	public RendererModel rightEar;
	
	public TeletubbyModel() {
		leftEar = new RendererModel(this);
		leftEar.setRotationPoint(-6.8333F, 19.5F, -0.3333F);
		leftEar.cubeList.add(new ModelBox(leftEar, 56, 21, 1.8333F, -26.5F, 0.3333F, 1, 3, 1, 0.0F, false));
		leftEar.cubeList.add(new ModelBox(leftEar, 56, 25, 1.8333F, -25.5F, -1.6667F, 1, 3, 2, 0.0F, false));
		leftEar.cubeList.add(new ModelBox(leftEar, 56, 30, 1.8333F, -26.5F, -0.6667F, 1, 1, 1, 0.0F, false));

		rightEar = new RendererModel(this);
		rightEar.setRotationPoint(6.8333F, 19.5F, -0.3333F);
		rightEar.cubeList.add(new ModelBox(rightEar, 56, 21, -2.8333F, -26.5F, 0.3333F, 1, 3, 1, 0.0F, false));
		rightEar.cubeList.add(new ModelBox(rightEar, 56, 25, -2.8333F, -25.5F, -1.6667F, 1, 3, 2, 0.0F, false));
		rightEar.cubeList.add(new ModelBox(rightEar, 56, 30, -2.8333F, -26.5F, -0.6667F, 1, 1, 1, 0.0F, false));
	}
	
	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		leftEar.render(scale);
		rightEar.render(scale);
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
}
