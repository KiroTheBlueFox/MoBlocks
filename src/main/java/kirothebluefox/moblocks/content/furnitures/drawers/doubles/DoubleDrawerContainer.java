package kirothebluefox.moblocks.content.furnitures.drawers.doubles;

import kirothebluefox.moblocks.content.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class DoubleDrawerContainer extends Container {
	private DoubleDrawerTile tileEntity;
	private final IItemHandler inventory;
	
	public DoubleDrawerContainer(int id, BlockPos pos, PlayerInventory playerInv) {
		super(ModContainers.DOUBLE_DRAWER_CONTAINER, id);
		this.tileEntity = (DoubleDrawerTile) playerInv.player.world.getTileEntity(pos);
		this.inventory = tileEntity.getItems();
		

		for(int j = 0; j < 2; ++j) {
			for(int k = 0; k < 8; ++k) {
				this.addSlot(new SlotItemHandler(this.inventory, k + j * 8, 17 + k * 18, 17 + j * 18));
         	}
		}
		
		for(int j = 0; j < 2; ++j) {
			for(int k = 0; k < 8; ++k) {
				this.addSlot(new SlotItemHandler(this.inventory, k + j * 8 + 16, 17 + k * 18, 66 + j * 18));
         	}
		}
		
        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
               this.addSlot(new Slot(playerInv, j1 + l * 9 + 9, 8 + j1 * 18, 115 + l * 18));
            }
         }

         for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInv, i1, 8 + i1 * 18, 173));
         }
	}

	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			int numberOfSlots = this.inventory.getSlots();
			if (index < numberOfSlots) {
				if (!this.mergeItemStack(itemstack1, numberOfSlots, 36+numberOfSlots, true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, numberOfSlots, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
			} else {
	            slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}
		
		return itemstack;
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}
	
	public IItemHandler getBlockInventory() {
		return this.inventory;
	}
}
