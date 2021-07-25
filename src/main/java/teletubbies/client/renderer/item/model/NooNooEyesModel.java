package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NooNooEyesModel extends HumanoidModel<LivingEntity> {
	
	public static NooNooEyesModel model = new NooNooEyesModel();
	
	public ModelPart eyes;

	public NooNooEyesModel() {
		super(1.0F);
		texWidth = 16;
		texHeight = 16;

		eyes = new ModelPart(this);
		eyes.setPos(0.0F, 24.0F, 0.0F);
		eyes.texOffs(0, 7).addBox(0.0F, -6.0F, -8.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		eyes.texOffs(0, 0).addBox(-3.0F, -5.0F, -8.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
	}
	
	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		eyes.copyFrom(head);
		eyes.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}