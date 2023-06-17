package com.rexbas.teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.rexbas.teletubbies.inventory.container.TinkyWinkyBagContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyBagScreen extends AbstractContainerScreen<TinkyWinkyBagContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	private final int inventoryRows;
	   
	public TinkyWinkyBagScreen(TinkyWinkyBagContainer container, Inventory playerInv, Component title) {
		super(container, playerInv, title);
		this.inventoryRows = container.numRows;
		this.imageHeight = 114 + this.inventoryRows * 18;
	}

	@Override
	public void render(GuiGraphics p_282060_, int p_282533_, int p_281661_, float p_281873_) {
		this.renderBackground(p_282060_);
		super.render(p_282060_, p_282533_, p_281661_, p_281873_);
		this.renderTooltip(p_282060_, p_282533_, p_281661_);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
		guiGraphics.drawString(this.font, this.title.getString(), 8.0F, 6.0F, 4210752, false);
		guiGraphics.drawString(this.font, this.playerInventoryTitle.getString(), 8.0F, (float) (this.imageHeight - 96 + 2), 4210752, false);
	}
	
	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		guiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.inventoryRows * 18 + 17);
		guiGraphics.blit(TEXTURE, i, j + this.inventoryRows * 18 + 17, 0, 126, this.imageWidth, 96);
	}
}