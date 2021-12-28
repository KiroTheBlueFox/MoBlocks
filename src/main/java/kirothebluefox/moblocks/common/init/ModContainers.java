package kirothebluefox.moblocks.common.init;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.gui.DoubleDrawerContainer;
import kirothebluefox.moblocks.common.gui.SimpleDrawerContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoBlocks.MODID)
public class ModContainers {
    public static final MenuType<SimpleDrawerContainer> SIMPLE_DRAWER_CONTAINER = null;
    public static final MenuType<DoubleDrawerContainer> DOUBLE_DRAWER_CONTAINER = null;
}
