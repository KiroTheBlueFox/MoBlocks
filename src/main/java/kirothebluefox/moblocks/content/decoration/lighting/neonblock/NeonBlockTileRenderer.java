package kirothebluefox.moblocks.content.decoration.lighting.neonblock;

import com.mojang.blaze3d.vertex.PoseStack;
import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;

public class NeonBlockTileRenderer implements BlockEntityRenderer<NeonBlockTile> {
	public NeonBlockTileRenderer(BlockEntityRendererProvider.Context context) {}

	@Override
	public void render(NeonBlockTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.pushPose();

		RenderType renderType = RenderType.solid();
		net.minecraftforge.client.ForgeHooksClient.setRenderType(renderType);
		BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
		BakedModel model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.NEON_BLOCK.getLocation());

		blockDispatcher.getModelRenderer().renderModel(
				matrixStackIn.last(),
				bufferIn.getBuffer(renderType),
				tileEntityIn.getBlockState(),
				model,
				((tileEntityIn.getColor()&0xFF0000)>>16)/255f,
				((tileEntityIn.getColor()&0xFF00)>>8)/255f,
				(tileEntityIn.getColor()&0xFF)/255f,
				0x00F000F0,
				OverlayTexture.NO_OVERLAY,
				net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);

		matrixStackIn.popPose();
	}

	public static void register() {
		BlockEntityRenderers.register(ModTileEntities.NEON_BLOCK_TILE, NeonBlockTileRenderer::new);
	}
}
