package kirothebluefox.moblocks.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import kirothebluefox.moblocks.common.blockentities.BookshelfTile;
import kirothebluefox.moblocks.common.init.ModTileEntities;
import kirothebluefox.moblocks.common.init.ModCustomModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.EmptyModelData;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class BookshelfTileRenderer implements BlockEntityRenderer<BookshelfTile> {
    public BookshelfTileRenderer(BlockEntityRendererProvider.Context context) {
    }

    public static void register() {
        BlockEntityRenderers.register(ModTileEntities.SMALL_BOOKSHELF, BookshelfTileRenderer::new);
    }

    @Override
    public void render(BookshelfTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        Direction direction = tileEntityIn.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        List<BakedModel> bookCoverModels = new ArrayList<BakedModel>();
        List<BakedModel> bookPagesModels = new ArrayList<BakedModel>();
        double bookWidth = 0.95;
        for (int i = 0; i < tileEntityIn.getNumberOfLayers() * 7 + tileEntityIn.getStacksPerLayers(); i++) {
            bookCoverModels.add(Minecraft.getInstance().getModelManager().getModel(ModCustomModels.BOOK_COVER_MODEL.getLocation()));
            bookPagesModels.add(Minecraft.getInstance().getModelManager().getModel(ModCustomModels.BOOK_PAGES_MODEL.getLocation()));
        }

        for (int layer = 0; layer < tileEntityIn.getNumberOfLayers(); layer++) {
            for (int stackIndex = 0; stackIndex < tileEntityIn.getStacksPerLayers(); stackIndex++) {
                ItemStack itemstack = tileEntityIn.getItem(layer, stackIndex);
                matrixStackIn.pushPose();
                if (!itemstack.isEmpty()) {
                    matrixStackIn.translate(0, (layer == 0 ? 0.25 : -0.25), 0);
                    switch (direction) {
                        case NORTH -> {
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
                            matrixStackIn.translate(-1 + (stackIndex - 3) * 0.125, 0, -0.75);
                        }
                        case EAST -> {
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                            matrixStackIn.translate(-1 - (stackIndex - 3) * 0.125, 0, 0.25);
                        }
                        case WEST -> {
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
                            matrixStackIn.translate(0 - (stackIndex - 3) * 0.125, 0, -0.75);
                        }
                        case SOUTH -> matrixStackIn.translate(0 + (stackIndex - 3) * 0.125, 0, 0.25);
                        default -> {
                        }
                    }
                    matrixStackIn.scale((float) bookWidth, 1F, 1F);
                    matrixStackIn.translate((1 - bookWidth) / 2, 0, 0);

                    BlockState blockstate = tileEntityIn.getBlockState();
                    BakedModel model = bookCoverModels.get(layer * 7 + stackIndex);
                    RenderType renderType = ItemBlockRenderTypes.getMovingBlockRenderType(blockstate); // RenderTypeLookup.getRenderType
                    net.minecraftforge.client.ForgeHooksClient.setRenderType(renderType);
                    BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
                    Level world = tileEntityIn.getLevel();
                    ModelBlockRenderer blockModelRenderer = blockDispatcher.getModelRenderer();
                    blockModelRenderer.renderModel(
                            matrixStackIn.last(),
                            bufferIn.getBuffer(renderType),
                            blockstate,
                            model,
                            0.0f,
                            0.0f,
                            0.0f,
                            combinedLightIn,
                            combinedOverlayIn,
                            EmptyModelData.INSTANCE
                    );
                }
                matrixStackIn.popPose();
            }
        }

        for (int layer = 0; layer < tileEntityIn.getNumberOfLayers(); layer++) {
            for (int stackIndex = 0; stackIndex < tileEntityIn.getStacksPerLayers(); stackIndex++) {
                ItemStack itemstack = tileEntityIn.getItem(layer, stackIndex);
                matrixStackIn.pushPose();
                if (!itemstack.isEmpty()) {
                    matrixStackIn.translate(0, (layer == 0 ? 0.25 : -0.25), 0);
                    switch (direction) {
                        case NORTH -> {
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
                            matrixStackIn.translate(-1 + (stackIndex - 3) * 0.125, 0, -0.75);
                        }
                        case EAST -> {
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                            matrixStackIn.translate(-1 - (stackIndex - 3) * 0.125, 0, 0.25);
                        }
                        case WEST -> {
                            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
                            matrixStackIn.translate(0 - (stackIndex - 3) * 0.125, 0, -0.75);
                        }
                        case SOUTH -> matrixStackIn.translate(0 + (stackIndex - 3) * 0.125, 0, 0.25);
                        default -> {
                        }
                    }
                    matrixStackIn.scale((float) bookWidth, 1F, 1F);
                    matrixStackIn.translate((1 - bookWidth) / 2, 0, 0);

                    BlockState blockstate = tileEntityIn.getBlockState();
                    BakedModel model = bookPagesModels.get(layer * 7 + stackIndex);
                    RenderType renderType = ItemBlockRenderTypes.getMovingBlockRenderType(blockstate); // RenderTypeLookup.getRenderType
                    net.minecraftforge.client.ForgeHooksClient.setRenderType(renderType);
                    BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
                    Level world = tileEntityIn.getLevel();
                    ModelBlockRenderer blockModelRenderer = blockDispatcher.getModelRenderer();
                    blockModelRenderer.renderModel(
                            matrixStackIn.last(),
                            bufferIn.getBuffer(renderType),
                            blockstate,
                            model,
                            0.0f,
                            0.0f,
                            0.0f,
                            combinedLightIn,
                            combinedOverlayIn,
                            EmptyModelData.INSTANCE
                    );
                }

                matrixStackIn.popPose();
            }
        }
    }
}
