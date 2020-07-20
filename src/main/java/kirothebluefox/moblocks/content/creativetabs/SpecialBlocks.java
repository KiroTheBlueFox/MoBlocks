package kirothebluefox.moblocks.content.creativetabs;

import kirothebluefox.moblocks.content.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SpecialBlocks extends ItemGroup {
	public SpecialBlocks() {
		super("special_blocks_creative_tab");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Item.BLOCK_TO_ITEM.get(ModBlocks.OAK_ARCH));
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
