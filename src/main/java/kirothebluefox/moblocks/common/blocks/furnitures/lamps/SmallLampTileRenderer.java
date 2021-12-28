package kirothebluefox.moblocks.common.blocks.furnitures.lamps;

import com.mojang.blaze3d.vertex.PoseStack;
import kirothebluefox.moblocks.common.init.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SmallLampTileRenderer implements BlockEntityRenderer<LampTile> {
    public SmallLampTileRenderer(BlockEntityRendererProvider.Context context) {

    }

    public static void register() {
        BlockEntityRenderers.register(ModTileEntities.SMALL_LAMP, SmallLampTileRenderer::new);
    }

    @Override
    public void render(LampTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        ItemStack itemstack = tileEntityIn.getItem();
        if (!itemstack.isEmpty()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5, 0.5, 0.5);
            Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, (int) tileEntityIn.getBlockPos().asLong());
            matrixStackIn.popPose();
        }
    }
}
