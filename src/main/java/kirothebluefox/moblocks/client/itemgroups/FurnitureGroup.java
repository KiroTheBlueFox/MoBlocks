package kirothebluefox.moblocks.client.itemgroups;

import kirothebluefox.moblocks.common.init.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class FurnitureGroup extends CreativeModeTab {
    public FurnitureGroup() {
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
