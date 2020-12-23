package teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.Teletubbies;
import teletubbies.inventory.container.ToastMachineContainer;

@OnlyIn(Dist.CLIENT)
public class ToastMachineScreen extends ContainerScreen<ToastMachineContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(Teletubbies.MODID, "textures/gui/container/toast_machine.png");	   

	public ToastMachineScreen(ToastMachineContainer container, PlayerInventory playerInv, ITextComponent title) {
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
		this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int i = this.guiLeft;
		int j = this.guiTop;
	    this.blit(i, j, 0, 0, this.xSize, this.ySize);
	    
	    switch (this.container.getTileEntity().getProgress()) {
	    case 4:
	    case 3:
		    this.blit(i + 83, j + 26, 176, 0, 11, 11);
	    case 2:
		    this.blit(i + 83, j + 39, 176, 0, 11, 11);
	    case 1:
		    this.blit(i + 83, j + 52, 176, 0, 11, 11);
	    }
	    
	    if (this.container.getTileEntity().isPowered()) {
			this.blit(i + 45, j + 40, 176, 11, 4, 11);
	    }
	}
}
