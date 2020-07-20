package kirothebluefox.moblocks.content.furnitures.lamps;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

@OnlyIn(Dist.CLIENT)
public class SmallLampTileRenderer extends TileEntityRenderer<LampTile> {
	public SmallLampTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(LampTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack = tileEntityIn.getItem();
		if (!itemstack.isEmpty()) {
			matrixStackIn.push();
            matrixStackIn.translate(0.5, 0.5, 0.5);
	        Minecraft.getInstance().getItemRenderer().renderItem(itemstack, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
	        matrixStackIn.pop();
		}
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.SMALL_LAMP, SmallLampTileRenderer::new);
	}
}
