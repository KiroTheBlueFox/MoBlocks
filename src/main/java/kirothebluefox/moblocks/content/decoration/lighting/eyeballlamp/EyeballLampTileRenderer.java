package kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.allCustomModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class EyeballLampTileRenderer extends TileEntityRenderer<EyeballLampTile> {
	public EyeballLampTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(EyeballLampTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		float horizontalAngle = tileEntityIn.getHorizontalAngle(),
				verticalAngle = tileEntityIn.getVerticalAngle();
		matrixStackIn.push();
		
		if (tileEntityIn.followPlayer()) {
			List<Entity> nearEntities = tileEntityIn.getWorld().getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(tileEntityIn.getPos().add(-6, -6, -6), tileEntityIn.getPos().add(6, 6, 6)));
			double distance = -1;
			Entity nearest = null;
			for (Entity entity : nearEntities) {
				double distanceFromEntity = tileEntityIn.getPos().distanceSq(entity.getPosX(), entity.getPosY(), entity.getPosZ(), true);
				if (distance < 0 || distanceFromEntity < distance) {
					distance = distanceFromEntity;
					nearest = entity;
				}
			}
			if (!(nearest == null)) {
				Vector3d thisPos = new Vector3d(tileEntityIn.getPos().getX()+0.5, tileEntityIn.getPos().getY()+0.5, tileEntityIn.getPos().getZ()+0.5);
				Vector3d nearestPos = nearest.getEyePosition(partialTicks);
				Vector3d vector = nearestPos.subtract(thisPos);
				double pitch = Math.toDegrees(Math.acos(vector.y/Math.sqrt(Math.pow(vector.x,2)+Math.pow(vector.y,2)+Math.pow(vector.z,2))));
				double yaw = Math.toDegrees(Math.atan(vector.z/vector.x))+270;
				yaw += (nearestPos.x >= thisPos.x) ? 180 : 0;
				tileEntityIn.setAngle((float) -yaw, (float) -pitch+90);
				horizontalAngle = tileEntityIn.getHorizontalAngle();
				verticalAngle = tileEntityIn.getVerticalAngle();
			}
		}
		
		matrixStackIn.translate(0.5f, 0.5f, 0.5f);
    	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(horizontalAngle));
    	matrixStackIn.rotate(Vector3f.XP.rotationDegrees(verticalAngle));
		matrixStackIn.translate(-0.5f, -0.5f, -0.5f);
		
		RenderType renderType = RenderType.getCutoutMipped(); // RenderTypeLookup.func_239221_b_(blockstate); // RenderTypeLookup.getRenderType
		net.minecraftforge.client.ForgeHooksClient.setRenderLayer(renderType);
		BlockRendererDispatcher blockDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
		IBakedModel model = Minecraft.getInstance().getModelManager().getModel(allCustomModels.EYEBALL_LAMP.getLocation());

		blockDispatcher.getBlockModelRenderer().renderModel(
				matrixStackIn.getLast(),
				bufferIn.getBuffer(renderType),
				tileEntityIn.getBlockState(),
				model,
				((tileEntityIn.getColor()&0xFF0000)>>16)/255f,
				((tileEntityIn.getColor()&0xFF00)>>8)/255f,
				(tileEntityIn.getColor()&0xFF)/255f,
				0x00F000F0,
				OverlayTexture.NO_OVERLAY,
				net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);

		matrixStackIn.pop();
	}
	
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(ModTileEntities.EYEBALL_LAMP, EyeballLampTileRenderer::new);
	}
}
