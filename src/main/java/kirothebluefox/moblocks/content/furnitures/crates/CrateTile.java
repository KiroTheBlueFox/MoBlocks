package kirothebluefox.moblocks.content.furnitures.crates;

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

public class CrateTile extends TileEntity {
	public String[][] KEYS = new String[4][16];
    public ItemStack[][] inventory = new ItemStack[4][16];
	public int layer = 0;
	
	public CrateTile() {
		super(ModTileEntities.CRATE);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
				KEYS[i][j] = String.format("item%d_%d",i,j);
				inventory[i][j] = ItemStack.EMPTY;
			}
		}
	}
	
	@Override
	public void read(BlockState blockstate, CompoundNBT compound) {
		super.read(blockstate, compound);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
			    CompoundNBT item = compound.getCompound(KEYS[i][j]);
			    this.inventory[i][j] = ItemStack.read(item);
			}
		}
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
			    CompoundNBT inventory = new CompoundNBT();
			    this.inventory[i][j].write(inventory);
			    compound.put(KEYS[i][j], inventory);
			}
		}
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 16; j++) {
			    CompoundNBT inventory = new CompoundNBT();
			    this.inventory[i][j].write(inventory);
				tag.put(KEYS[i][j], inventory);
			}
		}
		return tag;
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
		if (inventory[this.layer][pos].isEmpty()) {
			inventory[this.layer][pos] = itemstack.copy();
	    	player.setHeldItem(hand, ItemStack.EMPTY);
		} else {
			if (inventory[this.layer][pos].getItem().equals(itemstack.getItem())) {
				int numberOfItems = inventory[this.layer][pos].getCount();
				int numberOfItemsInHand = itemstack.getCount();
				int numberOfItemsMax = itemstack.getMaxStackSize()-numberOfItems;
				
				if (numberOfItemsInHand < numberOfItemsMax) {
					inventory[this.layer][pos].grow(numberOfItemsInHand);
			    	player.setHeldItem(hand, ItemStack.EMPTY);
				} else {
					inventory[this.layer][pos].grow(numberOfItemsMax);
			    	itemstack.shrink(numberOfItemsMax);
				}
			} else {
				dropItem(player, hand, pos);
			}
		}
    	this.notifyBlock();
    	return true;
	}

	public ItemStack getItem(int pos) {
		return inventory[this.layer][pos];
	}

	public ItemStack getItem(int layer, int pos) {
		return inventory[layer][pos];
	}
	
	public void nextLayer() {
		this.layer = (this.layer+1)%4;
    	this.notifyBlock();
	}

	private void notifyBlock() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	public boolean dropItem(PlayerEntity player, Hand handIn, int pos) {
		ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), this.inventory[this.layer][pos]);
		this.notifyBlock();
		this.inventory[this.layer][pos] = ItemStack.EMPTY;
		return true;
	}

	public boolean dropItems() {
		int i = 0;
		for (ItemStack[] layer : inventory) {
			for (ItemStack stack : layer) {
				if (!stack.isEmpty()) {
					ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), stack);
					i++;
				}
			}
		}
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}
}
