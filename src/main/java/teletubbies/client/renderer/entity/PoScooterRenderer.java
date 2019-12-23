package teletubbies.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.PoScooterModel;
import teletubbies.entity.item.PoScooterEntity;

@OnlyIn(Dist.CLIENT)
public class PoScooterRenderer extends EntityRenderer<PoScooterEntity> {
	private static PoScooterModel model = new PoScooterModel();

	public PoScooterRenderer(EntityRendererManager manager) {
		super(manager);
		this.shadowSize = 0.5F;
	}
	
	@Override
	public void doRender(PoScooterEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translatef((float) x, (float) y + 0.375F, (float) z);
		this.setupRotation(entity, entityYaw, partialTicks);
		this.bindEntityTexture(entity);
		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.setupSolidRenderingTextureCombine(this.getTeamColor(entity));
		}

		model.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if (this.renderOutlines) {
			GlStateManager.tearDownSolidRenderingTextureCombine();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	
	public void setupRotation(PoScooterEntity entityIn, float entityYaw, float partialTicks) {
		GlStateManager.rotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		float f = (float) entityIn.getTimeSinceHit() - partialTicks;
		float f1 = entityIn.getDamageTaken() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			GlStateManager.rotatef(MathHelper.sin(f) * f * f1 / 10.0F * (float) entityIn.getForwardDirection(), 1.0F,
					0.0F, 0.0F);
		}

		float f2 = entityIn.getRockingAngle(partialTicks);
		if (!MathHelper.epsilonEquals(f2, 0.0F)) {
			GlStateManager.rotatef(entityIn.getRockingAngle(partialTicks), 1.0F, 0.0F, 1.0F);
		}

		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(PoScooterEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/po_scooter.png");
	}
	
	public static class RenderFactory implements IRenderFactory<PoScooterEntity> {
		
		@Override
		public EntityRenderer<? super PoScooterEntity> createRenderFor(EntityRendererManager manager) {
			return new PoScooterRenderer(manager);
		}
	}
}
