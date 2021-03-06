package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DipsyHatModel extends BipedModel<LivingEntity> {
	
	public static DipsyHatModel model = new DipsyHatModel();
	
	public ModelRenderer hat;

	public DipsyHatModel() {
		super(1.0F);
		textureWidth = 64;
		textureHeight = 64;

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 24.0F, 0.0F);
		hat.setTextureOffset(20, 10).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		hat.setTextureOffset(0, 10).addBox(-4.0F, -16.0F, 2.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		hat.setTextureOffset(12, 27).addBox(-4.0F, -16.0F, -2.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		hat.setTextureOffset(0, 27).addBox(2.0F, -16.0F, -2.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		hat.setTextureOffset(0, 5).addBox(-6.0F, -9.0F, 3.0F, 12.0F, 2.0F, 3.0F, 0.0F, false);
		hat.setTextureOffset(0, 0).addBox(-6.0F, -9.0F, -6.0F, 12.0F, 2.0F, 3.0F, 0.0F, false);
		hat.setTextureOffset(18, 19).addBox(-6.0F, -9.0F, -3.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(0, 19).addBox(3.0F, -9.0F, -3.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		hat.copyModelAngles(bipedHead);
		hat.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
