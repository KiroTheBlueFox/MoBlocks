package kirothebluefox.moblocks.content.furnitures.bookshelves;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class BookshelfTileRenderer extends TileEntityRenderer<BookshelfTile> {
	public BookshelfTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(BookshelfTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		Direction direction = tileEntityIn.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
		List<IBakedModel> bookCoverModels = new ArrayList<IBakedModel>();
		List<IBakedModel> bookPagesModels = new ArrayList<IBakedModel>();
		double bookWidth = 0.95;
		for (int i = 0; i < tileEntityIn.getNumberOfLayers()*7+tileEntityIn.getStacksPerLayers(); i++) {
			bookCoverModels.add(Minecraft.getInstance().getModelManager().getModel(allCustomModels.BOOK_COVER_MODEL.getLocation()));
			bookPagesModels.add(Minecraft.getInstance().getModelManager().getModel(allCustomModels.BOOK_PAGES_MODEL.getLocation()));
		}

		for (int layer = 0; layer < tileEntityIn.getNumberOfLayers(); layer++) {
			for (int stackIndex = 0; stackIndex < tileEntityIn.getStacksPerLayers(); stackIndex++) {
				ItemStack itemstack = tileEntityIn.getItem(layer, stackIndex);
				matrixStackIn.push();
				if (!itemstack.isEmpty()) {
					matrixStackIn.translate(0, (layer == 0 ? 0.25 : -0.25)+((1-tileEntityIn.getSizes()[layer][stackIndex])/4), 0);
			        switch (direction) {
			        case NORTH:
			        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
			            matrixStackIn.translate(-1+(stackIndex-3)*0.125, 0, -0.75);
			        	break;
			        case EAST:
			        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
			            matrixStackIn.translate(-1-(stackIndex-3)*0.125, 0, 0.25);
			        	break;
			        case WEST:
			        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
			            matrixStackIn.translate(0-(stackIndex-3)*0.125, 0, -0.75);
			        	break;
			        case SOUTH:
			            matrixStackIn.translate(0+(stackIndex-3)*0.125, 0, 0.25);
			        	break;
					default:
						break;
			        }
			        matrixStackIn.scale((float) bookWidth, (float) tileEntityIn.getSizes()[layer][stackIndex], 1F);
		            matrixStackIn.translate((1-bookWidth)/2, 0, 0);
		            
		            BlockState blockstate = tileEntityIn.getBlockState();
		            IBakedModel model = bookCoverModels.get(layer*7+stackIndex);
		            RenderType renderType = RenderTypeLookup.func_239221_b_(blockstate); // RenderTypeLookup.getRenderType
					net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
					BlockRendererDispatcher blockDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
					World world = tileEntityIn.getWorld();
					BlockModelRenderer blockModelRenderer = blockDispatcher.getBlockModelRenderer();
					blockModelRenderer.renderModel(
							world,
							model,
							blockstate,
							tileEntityIn.getPos(),
							matrixStackIn,
							bufferIn.getBuffer(renderType),
							false,
							world.rand,
							blockstate.getPositionRandom(tileEntityIn.getPos()),
							OverlayTexture.NO_OVERLAY,
							net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);
				}
				matrixStackIn.pop();
			}
		}
		
		for (int layer = 0; layer < tileEntityIn.getNumberOfLayers(); layer++) {
			for (int stackIndex = 0; stackIndex < tileEntityIn.getStacksPerLayers(); stackIndex++) {
				ItemStack itemstack = tileEntityIn.getItem(layer, stackIndex);
				matrixStackIn.push();
				if (!itemstack.isEmpty()) {
					matrixStackIn.translate(0, (layer == 0 ? 0.25 : -0.25)+((1-tileEntityIn.getSizes()[layer][stackIndex])/4), 0);
			        switch (direction) {
			        case NORTH:
			        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
			            matrixStackIn.translate(-1+(stackIndex-3)*0.125, 0, -0.75);
			        	break;
			        case EAST:
			        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
			            matrixStackIn.translate(-1-(stackIndex-3)*0.125, 0, 0.25);
			        	break;
			        case WEST:
			        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
			            matrixStackIn.translate(0-(stackIndex-3)*0.125, 0, -0.75);
			        	break;
			        case SOUTH:
			            matrixStackIn.translate(0+(stackIndex-3)*0.125, 0, 0.25);
			        	break;
					default:
						break;
			        }
			        matrixStackIn.scale((float) bookWidth, (float) tileEntityIn.getSizes()[layer][stackIndex], 1F);
		            matrixStackIn.translate((1-bookWidth)/2, 0, 0);
		            
					BlockState blockstate = tileEntityIn.getBlockState();
		            IBakedModel model = bookPagesModels.get(layer*7+stackIndex);
					RenderType renderType = RenderTypeLookup.func_239221_b_(blockstate); // RenderTypeLookup.getRenderType
					net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
					BlockRendererDispatcher blockDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
					World world = tileEntityIn.getWorld();
					BlockModelRenderer blockModelRenderer = blockDispatcher.getBlockModelRenderer();
					blockModelRenderer.renderModel(
							world,
							model,
							blockstate,
							tileEntityIn.getPos(),
							matrixStackIn,
							bufferIn.getBuffer(renderType),
							false,
							world.rand,
							blockstate.getPositionRandom(tileEntityIn.getPos()),
							OverlayTexture.NO_OVERLAY,
							net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);
				}
				
				matrixStackIn.pop();
			}
		}
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.SMALL_BOOKSHELF, BookshelfTileRenderer::new);
	}
}
