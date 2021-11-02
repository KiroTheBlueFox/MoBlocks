package kirothebluefox.moblocks.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ClientReferences {
	public static Player getPlayer() {
		return Minecraft.getInstance().player;
	}
	
	public static Level getWorld(Player player) {
		return player.level;
	}
	
	public static Level getWorld() {
		return Minecraft.getInstance().player.level;
	}
}
