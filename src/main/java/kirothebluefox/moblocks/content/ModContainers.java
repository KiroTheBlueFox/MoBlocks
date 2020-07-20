package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawerContainer;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawerContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoBlocks.MODID)
public class ModContainers {
	public static final ContainerType<SimpleDrawerContainer> SIMPLE_DRAWER_CONTAINER = null;
	public static final ContainerType<DoubleDrawerContainer> DOUBLE_DRAWER_CONTAINER = null;
}
