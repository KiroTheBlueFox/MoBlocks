package kirothebluefox.moblocks.content.decoration.colorableflowerpot;

import com.mojang.blaze3d.vertex.PoseStack;
import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.EmptyModelData;

public class ColorableFlowerPotTileRenderer implements BlockEntityRenderer<ColorableFlowerPotTile> {

	public ColorableFlowerPotTileRenderer(BlockEntityRendererProvider.Context context) {

	}

	public static void register() {
		BlockEntityRenderers.register(ModTileEntities.COLORABLE_FLOWER_POT, ColorableFlowerPotTileRenderer::new);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(ColorableFlowerPotTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack = tileEntityIn.getItem();
		Item item = itemstack.getItem();

		if (!itemstack.isEmpty()) {
			if (item instanceof BlockItem) {
				matrixStackIn.pushPose();
	    		matrixStackIn.translate(0, 0.25, 0);

				BlockState blockstate = ((BlockItem) item).getBlock().defaultBlockState();
				RenderType renderType = ItemBlockRenderTypes.getMovingBlockRenderType(blockstate); // RenderTypeLookup.getRenderType
				net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
				BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
				Level world = tileEntityIn.getLevel();
				ModelBlockRenderer renderer = new ModelBlockRenderer(BlockColors.createDefault());
				renderer.renderModel(
						matrixStackIn.last(),
						bufferIn.getBuffer(renderType),
						blockstate,
						blockDispatcher.getBlockModel(blockstate),
						0.0f,
						0.0f,
						0.0f,
						combinedLightIn,
						combinedOverlayIn,
						EmptyModelData.INSTANCE
				);

	    		matrixStackIn.popPose();
			}
		}
	}
}
