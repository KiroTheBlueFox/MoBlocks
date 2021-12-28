package kirothebluefox.moblocks.common.network;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class MoBlocksPacketHandler {
    static SimpleChannel INSTANCE;
    private static int ID = 0;

    @SuppressWarnings("unused")
    private static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(MoBlocks.MODID, "main"),
                () -> "1.0",
                s -> true,
                s -> true);
    }

    public static void sendToClient(Object packet, ServerPlayer player) {
        INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}
