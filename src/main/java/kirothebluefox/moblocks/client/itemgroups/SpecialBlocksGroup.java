package kirothebluefox.moblocks.client.itemgroups;

import kirothebluefox.moblocks.common.init.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SpecialBlocksGroup extends CreativeModeTab {
    public SpecialBlocksGroup() {
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
