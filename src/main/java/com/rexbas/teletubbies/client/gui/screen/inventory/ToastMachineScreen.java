package com.rexbas.teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.inventory.container.ToastMachineContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ToastMachineScreen extends ContainerScreen<ToastMachineContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Teletubbies.MODID, "textures/gui/container/toast_machine.png");	   

	public ToastMachineScreen(ToastMachineContainer container, PlayerInventory playerInv, ITextComponent title) {
		super(container, playerInv, title);
		this.passEvents = false;
	}

	@Override
	public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(p_230430_1_);
		super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
	}

	@Override
	protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
		String s = this.title.getString();
		this.font.draw(matrixStack, s, (float) (this.imageWidth / 2 - this.font.width(s) / 2), 6.0F, 4210752);
		this.font.draw(matrixStack, this.inventory.getDisplayName(), 8.0F, (float) (this.imageHeight - 96 + 2), 4210752);
	}

	@Override
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		GlStateManager._color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(TEXTURE);
		int i = this.leftPos;
		int j = this.topPos;
	    this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
	    
	    switch (this.menu.getTileEntity().getProgress()) {
	    case 4:
	    case 3:
		    this.blit(matrixStack, i + 83, j + 26, 176, 0, 11, 11);
	    case 2:
		    this.blit(matrixStack, i + 83, j + 39, 176, 0, 11, 11);
	    case 1:
		    this.blit(matrixStack, i + 83, j + 52, 176, 0, 11, 11);
	    }
	    
	    if (this.menu.getTileEntity().isPowered()) {
			this.blit(matrixStack, i + 45, j + 40, 176, 11, 4, 11);
	    }
	}
}
