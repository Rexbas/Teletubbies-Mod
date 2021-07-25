package teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.Teletubbies;
import teletubbies.inventory.container.CustardMachineContainer;

@OnlyIn(Dist.CLIENT)
public class CustardMachineScreen extends AbstractContainerScreen<CustardMachineContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Teletubbies.MODID, "textures/gui/container/custard_machine.png");	   

	public CustardMachineScreen(CustardMachineContainer container, Inventory playerInv, Component title) {
		super(container, playerInv, title);
		this.passEvents = false;
		this.imageHeight = 187;
	}
	
	@Override
	public void render(PoseStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(p_230430_1_);
		super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
	}

	@Override
	protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
		String s = this.title.getString();
		this.font.draw(matrixStack, s, (float) (this.imageWidth / 2 - this.font.width(s) / 2), 6.0F, 4210752);
		this.font.draw(matrixStack, this.inventory.getDisplayName(), 8.0F, (float) (this.imageHeight - 96 + 2), 4210752);
	}

	@Override
	protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		GlStateManager._color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(TEXTURE);
		int i = this.leftPos;
		int j = this.topPos;
	    this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);

	    if (this.menu.getTileEntity().isProcessing()) {
	    	this.blit(matrixStack, i + 51, j + 47, 176, 0, (int) (this.menu.getTileEntity().getProgress() * 74), 9);
	    }
	}
}
