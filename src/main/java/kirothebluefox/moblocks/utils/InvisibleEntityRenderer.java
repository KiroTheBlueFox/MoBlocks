package kirothebluefox.moblocks.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class InvisibleEntityRenderer extends EntityRenderer<Entity> {
	protected InvisibleEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}
	
	public InvisibleEntityRenderer() {
		this(Minecraft.getInstance().getRenderManager());
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}
}
