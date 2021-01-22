package kirothebluefox.moblocks.content.furnitures.potionshelves;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

@OnlyIn(Dist.CLIENT)
public class PotionShelfTileRenderer extends TileEntityRenderer<PotionShelfTile> {
	public PotionShelfTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(PotionShelfTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		Direction direction = tileEntityIn.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ItemStack item = tileEntityIn.getItem(i, j);
				matrixStackIn.push();
	            switch (direction) {
	            case NORTH:
	            	break;
	            case SOUTH:
	                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
	            	break;
	            case EAST:
	                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
	            	break;
	            case WEST:
	                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
	            	break;
				default:
					break;
	            }
	            switch (direction) {
	            case NORTH:
	            	matrixStackIn.translate(1,0,1);
	            	break;
	            case SOUTH:
	            	break;
	            case EAST:
	            	matrixStackIn.translate(1,0,0);
	            	break;
	            case WEST:
	            	matrixStackIn.translate(0,0,1);
	            	break;
				default:
					break;
	            }
	            matrixStackIn.scale(0.3f, 0.3f, 0.3f);
	            matrixStackIn.translate(-2.74+j*1.04, 0.66+i*1.04, -3);
		        Minecraft.getInstance().getItemRenderer().renderItem(item, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
		        matrixStackIn.pop();
			}
		}
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.POTION_SHELF, PotionShelfTileRenderer::new);
	}
}
