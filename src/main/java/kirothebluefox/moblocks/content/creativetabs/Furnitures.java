package kirothebluefox.moblocks.content.creativetabs;

import kirothebluefox.moblocks.content.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Furnitures extends CreativeModeTab {
    public Furnitures() {
        super("furnitures_creative_tab");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Item.BY_BLOCK.get(ModBlocks.OAK_TABLE));
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
