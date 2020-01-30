package teletubbies.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.item.PoScooterEntity;

@OnlyIn(Dist.CLIENT)
public class PoScooterModel extends EntityModel<PoScooterEntity> {
	public ModelRenderer scooter;
	
	public PoScooterModel() {
		textureWidth = 64;
		textureHeight = 64;
		
		scooter = new ModelRenderer(this);
		scooter.setRotationPoint(0.0F, 24.0F, 0.0F);
		scooter.addBox(null, -2.0F, -23.0F, -14.0F, 3, 5, 5, 0.0F, 16, 0);
		scooter.addBox(null, -1.0F, -42.0F, -10.0F, 1, 18, 1, 0.0F, 0, 10);
		scooter.addBox(null, -4.0F, -43.0F, -10.0F, 7, 1, 1, 0.0F, 0, 0);
		scooter.addBox(null, -1.0F, -24.0F, -10.0F, 1, 1, 4, 0.0F, 0, 2);
		scooter.addBox(null, -1.0F, -23.0F, -7.0F, 1, 2, 1, 0.0F, 0, 7);
		scooter.addBox(null, -3.0F, -22.0F, -6.0F, 5, 1, 15, 0.0F, 0, 30);
		scooter.addBox(null, -5.0F, -23.0F, 6.0F, 3, 5, 5, 0.0F, 16, 10);
		scooter.addBox(null, 1.0F, -23.0F, 6.0F, 3, 5, 5, 0.0F, 16, 20);
	}

	@Override
	public void render(PoScooterEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		scooter.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
