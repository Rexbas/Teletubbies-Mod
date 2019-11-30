package teletubbies.world.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import teletubbies.Teletubbies;

public class BabySunSkyRenderer2 extends IRenderHandler {

	private static final ResourceLocation MOON_PHASES_TEXTURES = new ResourceLocation("textures/environment/moon_phases.png");
	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation(Teletubbies.MODID + ":textures/environment/sun.png");

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		Tessellator tessellator = Tessellator.getInstance();
		net.minecraft.client.renderer.VertexBuffer vertexbuffer = tessellator.getBuffer();

		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.pushMatrix();
		float f16 = 1.0F - world.getRainStrength(partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, f16);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		float f17 = 30.0F;
		mc.renderEngine.bindTexture(SUN_TEXTURES);
		vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		vertexbuffer.pos((double) (-f17), 100.0D, (double) (-f17)).tex(0.0D, 0.0D).endVertex();
		vertexbuffer.pos((double) f17, 100.0D, (double) (-f17)).tex(1.0D, 0.0D).endVertex();
		vertexbuffer.pos((double) f17, 100.0D, (double) f17).tex(1.0D, 1.0D).endVertex();
		vertexbuffer.pos((double) (-f17), 100.0D, (double) f17).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();
		f17 = 20.0F;
		mc.renderEngine.bindTexture(MOON_PHASES_TEXTURES);
		int i = world.getMoonPhase();
		int k = i % 4;
		int i1 = i / 4 % 2;
		float f22 = (float) (k + 0) / 4.0F;
		float f23 = (float) (i1 + 0) / 2.0F;
		float f24 = (float) (k + 1) / 4.0F;
		float f14 = (float) (i1 + 1) / 2.0F;
		vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		vertexbuffer.pos((double) (-f17), -100.0D, (double) f17).tex((double) f24, (double) f14).endVertex();
		vertexbuffer.pos((double) f17, -100.0D, (double) f17).tex((double) f22, (double) f14).endVertex();
		vertexbuffer.pos((double) f17, -100.0D, (double) (-f17)).tex((double) f22, (double) f23).endVertex();
		vertexbuffer.pos((double) (-f17), -100.0D, (double) (-f17)).tex((double) f24, (double) f23).endVertex();
		tessellator.draw();
		GlStateManager.disableTexture2D();
		float f15 = world.getStarBrightness(partialTicks) * f16;
	}
}