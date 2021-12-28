package kirothebluefox.moblocks.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blockentities.CrateTile;
import kirothebluefox.moblocks.common.init.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CrateTileRenderer implements BlockEntityRenderer<CrateTile> {
    public CrateTileRenderer(BlockEntityRendererProvider.Context context) {
    }

    public static void register() {
        BlockEntityRenderers.register(ModTileEntities.CRATE, CrateTileRenderer::new);
    }

    @Override
    public void render(CrateTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        Direction direction = tileEntityIn.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        int layer = tileEntityIn.layer;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                double height = 0;
                ItemStack itemstack = tileEntityIn.getItem(i, j);
                matrixStackIn.pushPose();
                matrixStackIn.translate(0.2, 0.2, 0.2);
                matrixStackIn.scale(0.15f, 0.15f, 0.15f);
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
                switch (layer) {
                    case 0:
                        switch (i) {
                            case 0 -> height = 6;
                            case 1 -> height = 3;
                            case 2 -> height = 1.5;
                            case 3 -> height = 0;
                        }
                        break;
                    case 1:
                        height = switch (i) {
                            case 0 -> 0;
                            case 1 -> 6;
                            case 2 -> 3;
                            case 3 -> 1.5;
                            default -> height;
                        };
                        break;
                    case 2:
                        height = switch (i) {
                            case 0 -> 1.5;
                            case 1 -> 0;
                            case 2 -> 6;
                            case 3 -> 3;
                            default -> height;
                        };
                        break;
                    case 3:
                        height = switch (i) {
                            case 0 -> 3;
                            case 1 -> 1.5;
                            case 2 -> 0;
                            case 3 -> 6;
                            default -> height;
                        };
                        break;
                }
                switch (direction) {
                    case NORTH -> matrixStackIn.translate(j % 4 + (j % 4 * 0.3333333333), height, j / 4 + (j / 4 * 0.3333333333));
                    case SOUTH -> matrixStackIn.translate(j % 4 + (j % 4 * 0.3333333333) - 4, height, j / 4 + (j / 4 * 0.3333333333) - 4);
                    case EAST -> matrixStackIn.translate(j % 4 + (j % 4 * 0.3333333333), height, 5 - (j / 4 + (j / 4 * 0.3333333333)) - 5);
                    case WEST -> matrixStackIn.translate((j % 4 + (j % 4 * 0.3333333333)) - 4, height, 5 - (j / 4 + (j / 4 * 0.3333333333)) - 1);
                    default -> matrixStackIn.translate(j % 4 + (j % 4 * 0.3333333333), height, j / 4 + (j / 4 * 0.3333333333));
                }
                Minecraft.getInstance().getItemRenderer().renderStatic(
                        itemstack,
                        ItemTransforms.TransformType.NONE,
                        combinedLightIn,
                        combinedOverlayIn,
                        matrixStackIn,
                        bufferIn,
                        (int) tileEntityIn.getBlockPos().asLong()
                );

                matrixStackIn.popPose();

                if (i == layer &&
                        MoBlocks.config.crates_quantity.get() &&
                        !tileEntityIn.getItem(j).isEmpty() &&
                        tileEntityIn.getBlockPos().closerThan(Minecraft.getInstance().player.position(), 5)) {
                    matrixStackIn.pushPose();

                    matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180F));
                    switch (direction) {
                        case NORTH:
                            break;
                        case SOUTH:
                            matrixStackIn.translate(1, 0, -1);
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
                            break;
                        case EAST:
                            matrixStackIn.translate(1, 0, 0);
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                            break;
                        case WEST:
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
                            matrixStackIn.translate(-1, 0, 0);
                            break;
                        default:
                            break;
                    }
                    switch (direction) {
                        case NORTH -> matrixStackIn.translate(((j % 4 + (j % 4 * 0.3333333333))) * 0.15 + 0.15, -1.25, (5 - (j / 4 + (j / 4 * 0.3333333333))) * 0.15 - 0.95);
                        case SOUTH -> matrixStackIn.translate(((j % 4 + (j % 4 * 0.3333333333))) * 0.15 + 0.15, -1.25, (5 - (j / 4 + (j / 4 * 0.3333333333))) * 0.15 - 0.95);
                        case EAST -> matrixStackIn.translate(((j % 4 + (j % 4 * 0.3333333333))) * 0.15 + 0.15, -1.25, ((j / 4 + (j / 4 * 0.3333333333))) * 0.15 - 0.8);
                        case WEST -> matrixStackIn.translate(((j % 4 + (j % 4 * 0.3333333333))) * 0.15 + 0.15, -1.25, ((j / 4 + (j / 4 * 0.3333333333))) * 0.15 - 0.8);
                        default -> {
                        }
                    }
                    matrixStackIn.scale(0.0075f, 0.0075f, 0.0075f);

                    Font fontrenderer = Minecraft.getInstance().font;
                    FormattedText itextproperties = FormattedText.of(Integer.toString(itemstack.getCount()));
                    if (itextproperties != null) {
                        fontrenderer.drawInBatch(itextproperties.getString(), 0f, 0f, 0xffffff, false, matrixStackIn.last().pose(), bufferIn, false, 0, combinedLightIn);
                    }
                    matrixStackIn.popPose();
                }
            }
        }
    }
}
