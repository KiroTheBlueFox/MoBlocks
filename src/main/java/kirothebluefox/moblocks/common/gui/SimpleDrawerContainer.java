package kirothebluefox.moblocks.common.gui;

import kirothebluefox.moblocks.common.blockentities.SimpleDrawerTile;
import kirothebluefox.moblocks.common.init.ModContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SimpleDrawerContainer extends AbstractContainerMenu {
    private final IItemHandler inventory;
    private final SimpleDrawerTile tileEntity;

    public SimpleDrawerContainer(int id, BlockPos pos, Inventory playerInv) {
        super(ModContainers.SIMPLE_DRAWER_CONTAINER, id);
        this.tileEntity = (SimpleDrawerTile) playerInv.player.level.getBlockEntity(pos);
        this.inventory = tileEntity.getItems();


        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 8; ++k) {
                this.addSlot(new SlotItemHandler(this.inventory, k + j * 8, 17 + k * 18, 17 + j * 18));
            }
        }

        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInv, j1 + l * 9 + 9, 8 + j1 * 18, 66 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInv, i1, 8 + i1 * 18, 124));
        }
    }

    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int numberOfSlots = this.inventory.getSlots();
            if (index < numberOfSlots) {
                if (!this.moveItemStackTo(itemstack1, numberOfSlots, 36 + numberOfSlots, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, numberOfSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return true;
    }

    public IItemHandler getBlockInventory() {
        return this.inventory;
    }
}
