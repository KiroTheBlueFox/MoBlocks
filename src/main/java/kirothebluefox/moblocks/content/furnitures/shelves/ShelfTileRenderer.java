package kirothebluefox.moblocks.content.furnitures.shelves;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

@OnlyIn(Dist.CLIENT)
public class ShelfTileRenderer extends TileEntityRenderer<ShelfTile> {
	public ShelfTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(ShelfTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack1 = tileEntityIn.getItem(0);
		ItemStack itemstack2 = tileEntityIn.getItem(1);
		ItemStack itemstack3 = tileEntityIn.getItem(2);
		ItemStack itemstack4 = tileEntityIn.getItem(3);
		Direction direction = tileEntityIn.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
		if (itemstack1 != ItemStack.EMPTY) {
			matrixStackIn.push();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1.25);
            	break;
            case WEST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(1.75, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderItem(itemstack1, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
	        matrixStackIn.pop();
		}
		if (itemstack2 != ItemStack.EMPTY) {
			matrixStackIn.push();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1);
            	break;
            case WEST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(0.575, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderItem(itemstack2, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
	        matrixStackIn.pop();
		}
		if (itemstack3 != ItemStack.EMPTY) {
			matrixStackIn.push();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1);
            	break;
            case WEST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(-0.575, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderItem(itemstack3, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
	        matrixStackIn.pop();
		}
		if (itemstack4 != ItemStack.EMPTY) {
			matrixStackIn.push();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1);
            	break;
            case WEST:
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(-1.75, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderItem(itemstack4, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
	        matrixStackIn.pop();
		}
		if (MoBlocks.config.shelves_quantity.get()) {
			for (int i = 0; i < 4; i++) {
				if (!tileEntityIn.getItem(i).isEmpty() && tileEntityIn.getPos().withinDistance(Minecraft.getInstance().player.getPositionVec(), 5)) {
					matrixStackIn.push();
	                FontRenderer fontrenderer = this.renderDispatcher.getFontRenderer();
	                matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180F));
	                switch (direction) {
	                case NORTH:
	                	break;
	                case SOUTH:
	                	matrixStackIn.translate(1, 0, -1);
	                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
	                	break;
	                case EAST:
	                	matrixStackIn.translate(1, 0, 0);
	                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
	                	break;
	                case WEST:
	                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
	                	matrixStackIn.translate(-1, 0, 0);
	                	break;
	    			default:
	    				break;
	                }
	                matrixStackIn.translate(0.225f*i+0.125f,-0.25f,-0.51f);
	                matrixStackIn.scale(0.0075f, 0.0075f, 0.0075f);
	                GL11.glNormal3f(0.0F, 0.0F, -1.0F);
	                ITextProperties itextproperties = ITextProperties.func_240652_a_(Integer.toString(tileEntityIn.getItem(i).getCount()));
                	if (itextproperties != null) {
                		fontrenderer.renderString(itextproperties.getString(), 0, 0, 0xffffff, false, matrixStackIn.getLast().getMatrix(), bufferIn, false, 0, combinedLightIn);
                	}
			        matrixStackIn.pop();
				}
			}
		}
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.SHELF, ShelfTileRenderer::new);
	}
}
