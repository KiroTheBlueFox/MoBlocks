package kirothebluefox.moblocks.content.furnitures.shelves;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.ModTileEntities;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class ShelfTileRenderer implements BlockEntityRenderer<ShelfTile> {
	public ShelfTileRenderer(BlockEntityRendererProvider.Context context) {

	}

	@Override
	public void render(ShelfTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack1 = tileEntityIn.getItem(0);
		ItemStack itemstack2 = tileEntityIn.getItem(1);
		ItemStack itemstack3 = tileEntityIn.getItem(2);
		ItemStack itemstack4 = tileEntityIn.getItem(3);
		Direction direction = tileEntityIn.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (itemstack1 != ItemStack.EMPTY) {
			matrixStackIn.pushPose();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1.25);
            	break;
            case WEST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(1.75, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderStatic(itemstack1, ItemTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, (int) tileEntityIn.getBlockPos().asLong());
	        matrixStackIn.popPose();
		}
		if (itemstack2 != ItemStack.EMPTY) {
			matrixStackIn.pushPose();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1);
            	break;
            case WEST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(0.575, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderStatic(itemstack2, ItemTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, (int) tileEntityIn.getBlockPos().asLong());
	        matrixStackIn.popPose();
		}
		if (itemstack3 != ItemStack.EMPTY) {
			matrixStackIn.pushPose();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1);
            	break;
            case WEST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(-0.575, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderStatic(itemstack3, ItemTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, (int) tileEntityIn.getBlockPos().asLong());
	        matrixStackIn.popPose();
		}
		if (itemstack4 != ItemStack.EMPTY) {
			matrixStackIn.pushPose();
            matrixStackIn.translate(-0.125, 0.35, 0.5);
            switch (direction) {
            case NORTH:
                matrixStackIn.translate(0.63333333, 0, -0.63333333);
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
            	break;
            case SOUTH:
                matrixStackIn.translate(0.63333333, 0, 0.63333333);
            	break;
            case EAST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
                matrixStackIn.translate(0, 0, 1);
            	break;
            case WEST:
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
            	break;
			default:
				break;
            }
            matrixStackIn.scale(0.2f, 0.2f, 0.2f);
            matrixStackIn.translate(-1.75, 0, -1.25);
	        Minecraft.getInstance().getItemRenderer().renderStatic(itemstack4, ItemTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, (int) tileEntityIn.getBlockPos().asLong());
	        matrixStackIn.popPose();
		}
		if (MoBlocks.config.shelves_quantity.get()) {
			for (int i = 0; i < 4; i++) {
				if (!tileEntityIn.getItem(i).isEmpty() && tileEntityIn.getBlockPos().closerToCenterThan(Minecraft.getInstance().player.position(), 5)) {
					matrixStackIn.pushPose();
	                Font fontrenderer = Minecraft.getInstance().font;
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
	                matrixStackIn.translate(0.225f*i+0.125f,-0.25f,-0.51f);
	                matrixStackIn.scale(0.0075f, 0.0075f, 0.0075f);
	                //GL11.glNormal3f(0.0F, 0.0F, -1.0F);
	                FormattedText itextproperties = FormattedText.of(Integer.toString(tileEntityIn.getItem(i).getCount()));
                	if (itextproperties != null) {
                		fontrenderer.drawInBatch(itextproperties.getString(), 0, 0, 0xffffff, false, matrixStackIn.last().pose(), bufferIn, false, 0, combinedLightIn);
                	}
			        matrixStackIn.popPose();
				}
			}
		}
	}

	public static void register() {
		BlockEntityRenderers.register(ModTileEntities.SHELF, ShelfTileRenderer::new);
	}
}
