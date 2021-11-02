package kirothebluefox.moblocks.content.creativetabs;

import kirothebluefox.moblocks.content.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Decoration extends CreativeModeTab {
	public Decoration() {
		super("decoration_creative_tab");
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ModBlocks.COLORABLE_FLOWER_POT);
	}
}
