package teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.Teletubbies;
import teletubbies.inventory.container.ControlPanelContainer;

@OnlyIn(Dist.CLIENT)
public class ControlPanelScreen extends ContainerScreen<ControlPanelContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Teletubbies.MODID, "textures/gui/container/control_panel.png");	   

	public ControlPanelScreen(ControlPanelContainer container, PlayerInventory playerInv, ITextComponent title) {
		super(container, playerInv, title);
		this.passEvents = false;
	}
	
	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground();
		super.render(p_render_1_, p_render_2_, p_render_3_);
		this.renderHoveredToolTip(p_render_1_, p_render_2_);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.title.getFormattedText();
		String text = new TranslationTextComponent("block.teletubbies.control_panel.text").getFormattedText();
		this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
		this.font.drawString(text, 4.0F, 14.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft;
		int j = this.guiTop;
	    this.blit(i, j, 0, 0, this.xSize, this.ySize);
	}
}
