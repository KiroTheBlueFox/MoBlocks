package kirothebluefox.moblocks.content.furnitures.crates;

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
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class CrateTileRenderer extends TileEntityRenderer<CrateTile> {
	public CrateTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}
	
	@Override
	public void render(CrateTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		Direction direction = tileEntityIn.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
		int layer = tileEntityIn.layer;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
				double height = 0;
				ItemStack itemstack = tileEntityIn.getItem(i,j);
				matrixStackIn.push();
	            matrixStackIn.translate(0.2, 0.2, 0.2);
	            matrixStackIn.scale(0.15f, 0.15f, 0.15f);
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
	            switch (layer) {
	            case 0:
	            	switch (i) {
	            	case 0:
	            		height = 6;
	            		break;
	            	case 1:
	            		height = 3;
	            		break;
	            	case 2:
	            		height = 1.5;
	            		break;
	            	case 3:
	            		height = 0;
	            		break;
	            	}
	            	break;
	            case 1:
	            	switch (i) {
	            	case 0:
	            		height = 0;
	            		break;
	            	case 1:
	            		height = 6;
	            		break;
	            	case 2:
	            		height = 3;
	            		break;
	            	case 3:
	            		height = 1.5;
	            		break;
	            	}
	            	break;
	            case 2:
	            	switch (i) {
	            	case 0:
	            		height = 1.5;
	            		break;
	            	case 1:
	            		height = 0;
	            		break;
	            	case 2:
	            		height = 6;
	            		break;
	            	case 3:
	            		height = 3;
	            		break;
	            	}
	            	break;
	            case 3:
	            	switch (i) {
	            	case 0:
	            		height = 3;
	            		break;
	            	case 1:
	            		height = 1.5;
	            		break;
	            	case 2:
	            		height = 0;
	            		break;
	            	case 3:
	            		height = 6;
	            		break;
	            	}
	            	break;
	            }
	            switch (direction) {
	            case NORTH:
		            matrixStackIn.translate(j%4+(j%4*0.3333333333), height, j/4+(j/4*0.3333333333));
	            	break;
	            case SOUTH:
		            matrixStackIn.translate(j%4+(j%4*0.3333333333)-4, height, j/4+(j/4*0.3333333333)-4);
	            	break;
	            case EAST:
		            matrixStackIn.translate(j%4+(j%4*0.3333333333), height, 5-(j/4+(j/4*0.3333333333))-5);
	            	break;
	            case WEST:
		            matrixStackIn.translate((j%4+(j%4*0.3333333333))-4, height, 5-(j/4+(j/4*0.3333333333))-1);
	            	break;
	            default:
		            matrixStackIn.translate(j%4+(j%4*0.3333333333), height, j/4+(j/4*0.3333333333));
	            	break;
	            }
		        Minecraft.getInstance().getItemRenderer().renderItem(itemstack, ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
				matrixStackIn.pop();
	            if (i == layer &&
	            		MoBlocks.config.crates_quantity.get() &&
	            		!tileEntityIn.getItem(j).isEmpty() &&
	            		tileEntityIn.getPos().withinDistance(Minecraft.getInstance().player.getPositionVec(), 5)) {
					matrixStackIn.push();

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
	                switch (direction) {
	                case NORTH:
		                matrixStackIn.translate(((j%4+(j%4*0.3333333333)))*0.15+0.15, -1.25, (5-(j/4+(j/4*0.3333333333)))*0.15-0.95);
	                	break;
	                case SOUTH:
		                matrixStackIn.translate(((j%4+(j%4*0.3333333333)))*0.15+0.15, -1.25, (5-(j/4+(j/4*0.3333333333)))*0.15-0.95);
	                	break;
	                case EAST:
		                matrixStackIn.translate(((j%4+(j%4*0.3333333333)))*0.15+0.15, -1.25, ((j/4+(j/4*0.3333333333)))*0.15-0.8);
	                	break;
	                case WEST:
		                matrixStackIn.translate(((j%4+(j%4*0.3333333333)))*0.15+0.15, -1.25, ((j/4+(j/4*0.3333333333)))*0.15-0.8);
	                	break;
	    			default:
	    				break;
	                }
	                matrixStackIn.scale(0.0075f, 0.0075f, 0.0075f);
	                
	                FontRenderer fontrenderer = this.renderDispatcher.getFontRenderer();
	                ITextProperties itextproperties = ITextProperties.func_240652_a_(Integer.toString(itemstack.getCount()));
                	if (itextproperties != null) {
                		fontrenderer.func_238416_a_(itextproperties, 0, 0, 0xffffff, false, matrixStackIn.getLast().getMatrix(), bufferIn, false, 0, combinedLightIn);
                	}
					matrixStackIn.pop();
	            }
			}
		}
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.CRATE, CrateTileRenderer::new);
	}
}
