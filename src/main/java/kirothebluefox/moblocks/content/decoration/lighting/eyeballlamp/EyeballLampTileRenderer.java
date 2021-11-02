package kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class EyeballLampTileRenderer implements BlockEntityRenderer<EyeballLampTile> {

	public EyeballLampTileRenderer(BlockEntityRendererProvider.Context context) {
	}

	@Override
	public void render(EyeballLampTile tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		float horizontalAngle = tileEntityIn.getHorizontalAngle(),
				verticalAngle = tileEntityIn.getVerticalAngle();
		matrixStackIn.pushPose();

		if (tileEntityIn.followPlayer()) {
			List<Player> nearEntities = tileEntityIn.getLevel().getEntitiesOfClass(Player.class, new AABB(tileEntityIn.getBlockPos().offset(-6, -6, -6), tileEntityIn.getBlockPos().offset(6, 6, 6)));
			double distance = -1;
			Entity nearest = null;
			for (Entity entity : nearEntities) {
				double distanceFromEntity = tileEntityIn.getBlockPos().distSqr(entity.getX(), entity.getY(), entity.getZ(), true);
				if (distance < 0 || distanceFromEntity < distance) {
					distance = distanceFromEntity;
					nearest = entity;
				}
			}
			if (!(nearest == null)) {
				Vec3 thisPos = new Vec3(tileEntityIn.getBlockPos().getX()+0.5, tileEntityIn.getBlockPos().getY()+0.5, tileEntityIn.getBlockPos().getZ()+0.5);
				Vec3 nearestPos = nearest.getEyePosition(partialTicks);
				Vec3 vector = nearestPos.subtract(thisPos);
				double pitch = Math.toDegrees(Math.acos(vector.y/Math.sqrt(Math.pow(vector.x,2)+Math.pow(vector.y,2)+Math.pow(vector.z,2))));
				double yaw = Math.toDegrees(Math.atan(vector.z/vector.x))+270;
				yaw += (nearestPos.x >= thisPos.x) ? 180 : 0;
				tileEntityIn.setAngle((float) -yaw, (float) -pitch+90);
				horizontalAngle = tileEntityIn.getHorizontalAngle();
				verticalAngle = tileEntityIn.getVerticalAngle();
			}
		}

		matrixStackIn.translate(0.5f, 0.5f, 0.5f);
    	matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(horizontalAngle));
    	matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(verticalAngle));
		matrixStackIn.translate(-0.5f, -0.5f, -0.5f);

		RenderType renderType = RenderType.cutoutMipped(); // RenderTypeLookup.getMovingBlockRenderType(blockstate); // RenderTypeLookup.getRenderType
		net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
		BlockRenderDispatcher blockDispatcher = Minecraft.getInstance().getBlockRenderer();
		BakedModel model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.EYEBALL_LAMP.getLocation());

		blockDispatcher.getModelRenderer().renderModel(
				matrixStackIn.last(),
				bufferIn.getBuffer(renderType),
				tileEntityIn.getBlockState(),
				model,
				((tileEntityIn.getColor()&0xFF0000)>>16)/255f,
				((tileEntityIn.getColor()&0xFF00)>>8)/255f,
				(tileEntityIn.getColor()&0xFF)/255f,
				0x00F000F0,
				OverlayTexture.NO_OVERLAY,
				net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);

		matrixStackIn.popPose();
	}

	public static void register() {
		BlockEntityRenderers.register(ModTileEntities.EYEBALL_LAMP, EyeballLampTileRenderer::new);
	}
}
