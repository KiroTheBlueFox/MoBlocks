package kirothebluefox.moblocks.content.decoration.lighting.neonblock;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class NeonBlockTileRenderer extends TileEntityRenderer<NeonBlockTile> {
	public NeonBlockTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(NeonBlockTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.push();
		
		RenderType renderType = RenderType.getSolid();
		net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
		BlockRendererDispatcher blockDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
		IBakedModel model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.NEON_BLOCK.getLocation());

		blockDispatcher.getBlockModelRenderer().renderModel(
				matrixStackIn.getLast(),
				bufferIn.getBuffer(renderType),
				tileEntityIn.getBlockState(),
				model,
				((tileEntityIn.getColor()&0xFF0000)>>16)/255f,
				((tileEntityIn.getColor()&0xFF00)>>8)/255f,
				(tileEntityIn.getColor()&0xFF)/255f,
				0x00F000F0,
				OverlayTexture.NO_OVERLAY,
				net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);
		
		matrixStackIn.pop();
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.NEON_BLOCK_TILE, NeonBlockTileRenderer::new);
	}
}
