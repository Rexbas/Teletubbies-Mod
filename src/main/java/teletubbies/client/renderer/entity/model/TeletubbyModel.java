package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeletubbyModel<T extends CreatureEntity> extends BipedModel<T> {
	public ModelRenderer leftEar;
	public ModelRenderer rightEar;
		
	public TeletubbyModel() {
		super(0.0F);
		leftEar = new ModelRenderer(this);
		leftEar.setRotationPoint(-6.8333F, 19.5F, -0.3333F);
		leftEar.addBox(null, 1.8333F, -26.5F, 0.3333F, 1, 3, 1, 0.0F, 56, 21);
		leftEar.addBox(null, 1.8333F, -25.5F, -1.6667F, 1, 3, 2, 0.0F, 56, 25);
		leftEar.addBox(null, 1.8333F, -26.5F, -0.6667F, 1, 1, 1, 0.0F, 56, 30);

		rightEar = new ModelRenderer(this);
		rightEar.setRotationPoint(6.8333F, 19.5F, -0.3333F);
		rightEar.addBox(null, -2.8333F, -26.5F, 0.3333F, 1, 3, 1, 0.0F, 56, 21);
		rightEar.addBox(null, -2.8333F, -25.5F, -1.6667F, 1, 3, 2, 0.0F, 56, 25);
		rightEar.addBox(null, -2.8333F, -26.5F, -0.6667F, 1, 1, 1, 0.0F, 56, 30);
		
		bipedHead.addChild(leftEar);
		bipedHead.addChild(rightEar);
	}
}
