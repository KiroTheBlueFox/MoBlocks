package kirothebluefox.moblocks.utils;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class InvisibleEntityRenderer extends EntityRenderer<Entity> {


	public InvisibleEntityRenderer(EntityRendererProvider.Context p_174008_) {
		super(p_174008_);
	}

	@Override
	public ResourceLocation getTextureLocation(Entity entity) {
		return null;
	}
}
