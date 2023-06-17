package com.rexbas.teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.inventory.container.ToastMachineContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ToastMachineScreen extends AbstractContainerScreen<ToastMachineContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Teletubbies.MODID, "textures/gui/container/toast_machine.png");

    public ToastMachineScreen(ToastMachineContainer container, Inventory playerInv, Component title) {
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
        guiGraphics.drawString(this.font, s, (float) (this.imageWidth / 2 - this.font.width(s) / 2), 6.0F, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);

        switch (this.menu.getBlockEntity().getProgress()) {
            case 4:
            case 3:
                guiGraphics.blit(TEXTURE, i + 83, j + 26, 176, 0, 11, 11);
            case 2:
                guiGraphics.blit(TEXTURE, i + 83, j + 39, 176, 0, 11, 11);
            case 1:
                guiGraphics.blit(TEXTURE, i + 83, j + 52, 176, 0, 11, 11);
        }

        if (this.menu.getBlockEntity().isPowered()) {
            guiGraphics.blit(TEXTURE, i + 45, j + 40, 176, 11, 4, 11);
        }
    }
}