package kirothebluefox.moblocks.content.creativetabs;

import kirothebluefox.moblocks.content.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Decoration extends ItemGroup {
	public Decoration() {
		super("decoration_creative_tab");
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModBlocks.COLORABLE_FLOWER_POT);
	}
}
