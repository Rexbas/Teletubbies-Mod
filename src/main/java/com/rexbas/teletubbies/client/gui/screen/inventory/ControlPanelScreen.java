package com.rexbas.teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.inventory.container.ControlPanelContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ControlPanelScreen extends AbstractContainerScreen<ControlPanelContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Teletubbies.MODID, "textures/gui/container/control_panel.png");

    public ControlPanelScreen(ControlPanelContainer container, Inventory playerInv, Component title) {
        super(container, playerInv, title);
    }

    @Override
    public void render(GuiGraphics p_282060_, int p_282533_, int p_281661_, float p_281873_) {
        this.renderBackground(p_282060_);
        super.render(p_282060_, p_282533_, p_281661_, p_281873_);
        this.renderTooltip(p_282060_, p_282533_, p_281661_);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        String s = this.title.getString();
        Component text = Component.translatable("block.teletubbies.control_panel.text");
        guiGraphics.drawString(this.font, s, (float) (this.imageWidth / 2 - this.font.width(s) / 2), 6.0F, 4210752, false);
        guiGraphics.drawString(this.font, text, 4, 14, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle.getString(), 8.0F, (float) (this.imageHeight - 96 + 2), 4210752, false);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}