package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SimpleDrawerContainerScreen extends ContainerScreen<SimpleDrawerContainer> {
	private ResourceLocation GUI = new ResourceLocation(MoBlocks.MODID, "textures/gui/container/simple_drawer.png");
	
	public SimpleDrawerContainerScreen(SimpleDrawerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStackIn);
		super.render(matrixStackIn, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStackIn, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
		this.font.drawString(p_230451_1_, this.title.getString(), (float)this.titleX, (float)this.titleY, 4210752);
		this.font.drawString(p_230451_1_, this.playerInventory.getDisplayName().getString(), (float)this.playerInventoryTitleX, 55.0F, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStackIn, float partialTicks, int mouseX, int mouseY) {
		this.getMinecraft().getTextureManager().bindTexture(GUI);
		int relX = (this.width - this.xSize)/2;
		int relY = (this.height - this.ySize)/2;
		this.blit(matrixStackIn, relX, relY, 0, 0, this.xSize, this.ySize);
	}
}
