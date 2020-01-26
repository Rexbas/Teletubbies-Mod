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
		textureWidth = 32;
		textureHeight = 32;
	
		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 24.0F, 0.0F);
		hat.addBox(null, -3.0F, -16.0F, -4.0F, 6, 7, 1, 0.0F, 0, 24);
		hat.addBox(null, -3.0F, -16.0F, 3.0F, 6, 7, 1, 0.0F, 0, 16);
		hat.addBox(null, -4.0F, -16.0F, -3.0F, 1, 7, 6, 0.0F, 18, 19);
		hat.addBox(null, 3.0F, -16.0F, -3.0F, 1, 7, 6, 0.0F, 18, 19);
		hat.addBox(null, -6.0F, -9.0F, 3.0F, 12, 2, 3, 0.0F, 0, 0);
		hat.addBox(null, -6.0F, -9.0F, -6.0F, 12, 2, 3, 0.0F, 0, 0);
		hat.addBox(null, -6.0F, -9.0F, -3.0F, 3, 2, 6, 0.0F, 14, 6);
		hat.addBox(null, 3.0F, -9.0F, -3.0F, 3, 2, 6, 0.0F, 0, 8);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		hat.copyModelAngles(this.bipedHead);
		hat.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
