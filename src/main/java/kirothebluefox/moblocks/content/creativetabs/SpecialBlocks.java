package kirothebluefox.moblocks.content.creativetabs;

import kirothebluefox.moblocks.content.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SpecialBlocks extends CreativeModeTab {
	public SpecialBlocks() {
		super("special_blocks_creative_tab");
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Item.BY_BLOCK.get(ModBlocks.OAK_ARCH));
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
