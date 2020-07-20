package kirothebluefox.moblocks.content.creativetabs;

import kirothebluefox.moblocks.content.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Furnitures extends ItemGroup {
	public Furnitures() {
		super("furnitures_creative_tab");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Item.BLOCK_TO_ITEM.get(ModBlocks.OAK_TABLE));
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
