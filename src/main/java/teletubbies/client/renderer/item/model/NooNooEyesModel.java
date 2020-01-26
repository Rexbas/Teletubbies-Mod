package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NooNooEyesModel extends BipedModel<LivingEntity> {
	
	public static NooNooEyesModel model = new NooNooEyesModel();
	
	public ModelRenderer eyes;

	public NooNooEyesModel() {
		super(1.0F);
		textureWidth = 16;
		textureHeight = 16;

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(0.0F, 24.0F, 0.0F);
		eyes.addBox(null, 1.0F, -6.0F, -7.0F, 1, 3, 3, 0.0F, 0, 10);
		eyes.addBox(null, 0.0F, -5.0F, -7.0F, 3, 1, 3, 0.0F, 0, 0);
		eyes.addBox(null, -3.0F, -4.0F, -7.0F, 3, 1, 3, 0.0F, 0, 4);
		eyes.addBox(null, -2.0F, -5.0F, -7.0F, 1, 3, 3, 0.0F, 8, 10);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		eyes.copyModelAngles(bipedHead);
		eyes.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}