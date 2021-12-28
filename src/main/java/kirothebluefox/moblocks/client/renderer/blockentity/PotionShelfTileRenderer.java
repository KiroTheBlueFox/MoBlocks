package kirothebluefox.moblocks.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import kirothebluefox.moblocks.common.blockentities.PotionShelfTile;
import kirothebluefox.moblocks.common.init.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PotionShelfTileRenderer implements BlockEntityRenderer<PotionShelfTile> {
    public PotionShelfTileRenderer(BlockEntityRendererProvider.Context context) {

    }

    public static void register() {
        BlockEntityRenderers.register(ModTileEntities.POTION_SHELF, PotionShelfTileRenderer::new);
    }

    @Override
    public void render(PotionShelfTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        Direction direction = tileEntityIn.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ItemStack item = tileEntityIn.getItem(i, j);
                matrixStackIn.pushPose();
                switch (direction) {
                    case NORTH:
                        break;
                    case SOUTH:
                        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
                        break;
                    case EAST:
                        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
                        break;
                    case WEST:
                        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                        break;
                    default:
                        break;
                }
                switch (direction) {
                    case NORTH:
                        matrixStackIn.translate(1, 0, 1);
                        break;
                    case SOUTH:
                        break;
                    case EAST:
                        matrixStackIn.translate(1, 0, 0);
                        break;
                    case WEST:
                        matrixStackIn.translate(0, 0, 1);
                        break;
                    default:
                        break;
                }
                matrixStackIn.scale(0.3f, 0.3f, 0.3f);
                matrixStackIn.translate(-2.74 + j * 1.04, 0.66 + i * 1.04, -3);
                Minecraft.getInstance().getItemRenderer().renderStatic(item, ItemTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, (int) tileEntityIn.getBlockPos().asLong());
                matrixStackIn.popPose();
            }
        }
    }
}
