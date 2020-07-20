package kirothebluefox.moblocks.content.furnitures.shelves;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.utils.ItemStackUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;

public class ShelfTile extends TileEntity {
	public static final String ITEM1_KEY = "item1";
	public static final String ITEM2_KEY = "item2";
	public static final String ITEM3_KEY = "item3";
	public static final String ITEM4_KEY = "item4";
    public ItemStack[] inventory = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
	
	public ShelfTile() {
		super(ModTileEntities.SHELF);
	}
	
	@Override
	public void read(BlockState blockstate, CompoundNBT compound) {
		super.read(blockstate, compound);
	    CompoundNBT item1 = compound.getCompound(ITEM1_KEY);
	    CompoundNBT item2 = compound.getCompound(ITEM2_KEY);
	    CompoundNBT item3 = compound.getCompound(ITEM3_KEY);
	    CompoundNBT item4 = compound.getCompound(ITEM4_KEY);
	    this.inventory[0] = ItemStack.read(item1);
	    this.inventory[1] = ItemStack.read(item2);
	    this.inventory[2] = ItemStack.read(item3);
	    this.inventory[3] = ItemStack.read(item4);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    CompoundNBT inventory1 = new CompoundNBT();
	    CompoundNBT inventory2 = new CompoundNBT();
	    CompoundNBT inventory3 = new CompoundNBT();
	    CompoundNBT inventory4 = new CompoundNBT();
	    this.inventory[0].write(inventory1);
	    this.inventory[1].write(inventory2);
	    this.inventory[2].write(inventory3);
	    this.inventory[3].write(inventory4);
	    compound.put(ITEM1_KEY, inventory1);
	    compound.put(ITEM2_KEY, inventory2);
	    compound.put(ITEM3_KEY, inventory3);
	    compound.put(ITEM4_KEY, inventory4);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    CompoundNBT inventory1 = new CompoundNBT();
	    CompoundNBT inventory2 = new CompoundNBT();
	    CompoundNBT inventory3 = new CompoundNBT();
	    CompoundNBT inventory4 = new CompoundNBT();
	    this.inventory[0].write(inventory1);
	    this.inventory[1].write(inventory2);
	    this.inventory[2].write(inventory3);
	    this.inventory[3].write(inventory4);
		tag.put(ITEM1_KEY, inventory1);
		tag.put(ITEM2_KEY, inventory2);
		tag.put(ITEM3_KEY, inventory3);
		tag.put(ITEM4_KEY, inventory4);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		if (!tag.getCompound(ITEM1_KEY).isEmpty()) this.inventory[0] = ItemStack.read(tag.getCompound(ITEM1_KEY));
		if (!tag.getCompound(ITEM2_KEY).isEmpty()) this.inventory[1] = ItemStack.read(tag.getCompound(ITEM2_KEY));
		if (!tag.getCompound(ITEM3_KEY).isEmpty()) this.inventory[2] = ItemStack.read(tag.getCompound(ITEM3_KEY));
		if (!tag.getCompound(ITEM4_KEY).isEmpty()) this.inventory[3] = ItemStack.read(tag.getCompound(ITEM4_KEY));
	}

    @Override
    public SUpdateTileEntityPacket getUpdatePacket()
    {
        return new SUpdateTileEntityPacket(pos, 0, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)
    {
        handleUpdateTag(getBlockState(), packet.getNbtCompound());
    }
	
	public boolean addItem(ItemStack itemstack, int pos, PlayerEntity player, Hand hand) {
		if (inventory[pos].isEmpty()) {
			inventory[pos] = itemstack.copy();
	    	player.setHeldItem(hand, ItemStack.EMPTY);
		} else {
			if (inventory[pos].getItem().equals(itemstack.getItem())) {
				int numberOfItems = inventory[pos].getCount();
				int numberOfItemsInHand = itemstack.getCount();
				int numberOfItemsMax = itemstack.getMaxStackSize()-numberOfItems;
				
				if (numberOfItemsInHand < numberOfItemsMax) {
					inventory[pos].grow(numberOfItemsInHand);
			    	player.setHeldItem(hand, ItemStack.EMPTY);
				} else {
					inventory[pos].grow(numberOfItemsMax);
			    	itemstack.shrink(numberOfItemsMax);
				}
			} else {
				dropItem(player, hand, pos);
			}
		}
    	this.notifyBlock();
    	return true;
	}

	private void notifyBlock() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	public ItemStack getItem(int pos) {
		return inventory[pos];
	}

	public boolean dropItem(PlayerEntity player, Hand handIn, int pos) {
		ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), this.inventory[pos]);
		this.notifyBlock();
		this.inventory[pos] = ItemStack.EMPTY;
		return true;
	}

	public boolean dropItems() {
		int i = 0;
		for (ItemStack stack : inventory) {
			if (!stack.isEmpty()) {
				ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), stack);
				i++;
			}
		}
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}
}
