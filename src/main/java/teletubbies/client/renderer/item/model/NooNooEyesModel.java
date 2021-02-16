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
		eyes.setTextureOffset(0, 7).addBox(0.0F, -6.0F, -8.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		eyes.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -8.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		eyes.copyModelAngles(bipedHead);
		eyes.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}