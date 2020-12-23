package teletubbies.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.inventory.container.TinkyWinkyBagContainer;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyBagScreen extends ContainerScreen<TinkyWinkyBagContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	private final int inventoryRows;
	   
	public TinkyWinkyBagScreen(TinkyWinkyBagContainer container, PlayerInventory playerInv, ITextComponent title) {
		super(container, playerInv, title);
		this.passEvents = false;
		this.inventoryRows = container.numRows;
		this.ySize = 114 + this.inventoryRows * 18;
	}
	
	@Override
	public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(p_230430_1_);
		super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderHoveredTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {		
		this.font.func_243248_b(matrixStack, this.title, 8.0F, 6.0F, 4210752);
		this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(matrixStack, i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.blit(matrixStack, i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
	}
}
