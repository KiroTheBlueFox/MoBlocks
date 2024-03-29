package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleDrawerTileRenderer implements BlockEntityRenderer<SimpleDrawerTile> {
	public SimpleDrawerTileRenderer(BlockEntityRendererProvider.Context context) {

	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(SimpleDrawerTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
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

		matrixStackIn.pushPose();
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.OAK_DRAWER_MODEL.getLocation());
        Block baseBlock = Blocks.OAK_PLANKS;
        Direction direction = tileEntityIn.getBlockState().getValue(SimpleDrawer.FACING);
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
		RenderType renderType = ItemBlockRenderTypes.getMovingBlockRenderType(blockstate); // RenderTypeLookup.getRenderType
		BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
		Level world = tileEntityIn.getLevel();

        switch (direction) {
        case NORTH:
        	matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
            matrixStackIn.translate(-1, 0, -1);
        	break;
        case EAST:
        	matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90F));
            matrixStackIn.translate(-1, 0, 0);
        	break;
        case WEST:
        	matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(270F));
            matrixStackIn.translate(0, 0, -1);
        	break;
        case SOUTH:
        	break;
		default:
			break;
        }
        matrixStackIn.translate(0, 0, -offset);

		blockDispatcher.getModelRenderer().renderModel(
				matrixStackIn.last(),
				bufferIn.getBuffer(renderType),
				blockstate,
				model,
				0.0f,
				0.0f,
				0.0f,
				combinedLightIn,
				combinedOverlayIn
		);

        matrixStackIn.popPose();
	}

	public static void register() {
		BlockEntityRenderers.register(ModTileEntities.SIMPLE_DRAWER, SimpleDrawerTileRenderer::new);
	}
}
