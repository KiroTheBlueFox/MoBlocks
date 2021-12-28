package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SimpleDrawerContainerScreen extends AbstractContainerScreen<SimpleDrawerContainer> {
    private final ResourceLocation GUI = new ResourceLocation(MoBlocks.MODID, "textures/gui/container/simple_drawer.png");

    public SimpleDrawerContainerScreen(SimpleDrawerContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStackIn);
        super.render(matrixStackIn, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStackIn, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
        this.font.draw(p_230451_1_, this.title.getString(), (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
        this.font.draw(p_230451_1_, this.playerInventoryTitle.getString(), (float) this.inventoryLabelX, 55.0F, 4210752);
    }

    @Override
    protected void renderBg(PoseStack matrixStackIn, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, GUI);
        int relX = (this.width - this.imageWidth) / 2;
        int relY = (this.height - this.imageHeight) / 2;
        this.blit(matrixStackIn, relX, relY, 0, 0, this.imageWidth, this.imageHeight);
    }
}
