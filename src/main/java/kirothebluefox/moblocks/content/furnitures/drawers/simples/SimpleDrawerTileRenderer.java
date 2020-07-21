package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class SimpleDrawerTileRenderer extends TileEntityRenderer<SimpleDrawerTile> {
	public SimpleDrawerTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(SimpleDrawerTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		long animationTime = tileEntityIn.getAnimationTime();
		long currentTime = System.currentTimeMillis();
		long animationDuration = 100;
		double offset = 0;
		long animationProgression = (currentTime - animationTime);
		if (tileEntityIn.getIsOpened()) {
			if (animationProgression < animationDuration) {
				offset = Math.sin((double) animationProgression/(animationDuration*2));
			} else {
				offset = 0.5;
			}
		} else {
			if (animationProgression < animationDuration) {
				offset = 0.5 - Math.sin((double) animationProgression/(animationDuration*2));
			} else {
				offset = 0;
			}
		}
		
		matrixStackIn.push();
        IBakedModel model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.OAK_DRAWER_MODEL.getLocation());
        Block baseBlock = Blocks.OAK_PLANKS;
        Direction direction = tileEntityIn.getBlockState().get(SimpleDrawer.FACING);
        if (tileEntityIn.getBlockState().getBlock() instanceof SimpleDrawer) {
        	baseBlock = ((SimpleDrawer)tileEntityIn.getBlockState().getBlock()).getBaseBlock();
        	if (baseBlock == Blocks.SPRUCE_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.SPRUCE_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.BIRCH_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.BIRCH_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.JUNGLE_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.JUNGLE_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.ACACIA_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.ACACIA_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.DARK_OAK_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.DARK_OAK_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.NETHER_BRICKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.NETHER_BRICK_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.CRIMSON_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.CRIMSON_DRAWER_MODEL.getLocation());
        	} else if (baseBlock == Blocks.WARPED_PLANKS) {
        		model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.WARPED_DRAWER_MODEL.getLocation());
        	}
        }

		BlockState blockstate = tileEntityIn.getBlockState();
		RenderType renderType = RenderTypeLookup.func_239221_b_(blockstate); // RenderTypeLookup.getRenderType
		net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
		BlockRendererDispatcher blockDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
		World world = tileEntityIn.getWorld();
		
        switch (direction) {
        case NORTH:
        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
            matrixStackIn.translate(-1, 0, -1);
        	break;
        case EAST:
        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
            matrixStackIn.translate(-1, 0, 0);
        	break;
        case WEST:
        	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270F));
            matrixStackIn.translate(0, 0, -1);
        	break;
        case SOUTH:
        	break;
		default:
			break;
        }
        matrixStackIn.translate(0, 0, -offset);
        
		blockDispatcher.getBlockModelRenderer().renderModelSmooth(
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
		
        matrixStackIn.pop();
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIMPLE_DRAWER, SimpleDrawerTileRenderer::new);
	}
}
