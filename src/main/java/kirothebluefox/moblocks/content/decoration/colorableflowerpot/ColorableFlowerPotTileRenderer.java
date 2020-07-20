package kirothebluefox.moblocks.content.decoration.colorableflowerpot;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ColorableFlowerPotTileRenderer extends TileEntityRenderer<ColorableFlowerPotTile> {
	public ColorableFlowerPotTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.COLORABLE_FLOWER_POT, ColorableFlowerPotTileRenderer::new);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(ColorableFlowerPotTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack = tileEntityIn.getItem();
		Item item = itemstack.getItem();
		
		if (!itemstack.isEmpty()) {
			if (item instanceof BlockItem) {
				matrixStackIn.push();
	    		matrixStackIn.translate(0, 0.25, 0);
	    		
				BlockState blockstate = ((BlockItem) item).getBlock().getDefaultState();
				RenderType renderType = RenderTypeLookup.func_239221_b_(blockstate); // RenderTypeLookup.getRenderType
				net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
				BlockRendererDispatcher blockDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
				World world = tileEntityIn.getWorld();
				blockDispatcher.getBlockModelRenderer().renderModel(
						world,
						blockDispatcher.getModelForState(blockstate),
						blockstate,
						tileEntityIn.getPos(),
						matrixStackIn,
						bufferIn.getBuffer(renderType),
						false,
						world.rand,
						blockstate.getPositionRandom(tileEntityIn.getPos()),
						OverlayTexture.NO_OVERLAY,
						net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);

	    		matrixStackIn.pop();
			}
		}
	}
}
