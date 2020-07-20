package kirothebluefox.moblocks.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientReferences {
	public static PlayerEntity getPlayer() {
		return Minecraft.getInstance().player;
	}
	
	public static World getWorld(PlayerEntity player) {
		return player.world;
	}
	
	public static World getWorld() {
		return Minecraft.getInstance().player.world;
	}
}
