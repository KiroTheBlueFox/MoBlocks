package kirothebluefox.moblocks.content.furnitures.potionshelves;

import kirothebluefox.moblocks.MoBlocks;
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
import net.minecraft.util.ResourceLocation;

public class PotionShelfTile extends TileEntity {
	private int layers = 3, stacksPerLayer = 3;
	public String[][] KEYS = new String[layers][stacksPerLayer];
    public ItemStack[][] inventory = new ItemStack[layers][stacksPerLayer];

	public PotionShelfTile() {
		super(ModTileEntities.POTION_SHELF);
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
				KEYS[i][j] = String.format("item%d_%d",i,j);
				inventory[i][j] = ItemStack.EMPTY;
			}
		}
	}
	
	@Override
	public void read(BlockState blockstate, CompoundNBT compound) {
		super.read(blockstate, compound);
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
			    CompoundNBT item = compound.getCompound(KEYS[i][j]);
			    this.inventory[i][j] = ItemStack.read(item);
			}
		}
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
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
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
			    CompoundNBT inventory = new CompoundNBT();
			    this.inventory[i][j].write(inventory);
				tag.put(KEYS[i][j], inventory);
			}
		}
		return tag;
	}

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 0, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        handleUpdateTag(getBlockState(), packet.getNbtCompound());
    }
	
	public boolean addItem(ItemStack itemstack, int layer, int pos, PlayerEntity player, Hand hand) {
		if (inventory[layer][pos].isEmpty() && itemstack.getItem().getTags().contains(new ResourceLocation(MoBlocks.MODID, "potion_items"))) {
			inventory[layer][pos] = itemstack.split(1);
		} else {
			dropItem(player, hand, layer, pos);
		}
    	this.notifyBlock();
    	return true;
	}

	public ItemStack getItem(int layer, int pos) {
		return inventory[layer][pos];
	}
	
	public ItemStack[][] getItems() {
		return this.inventory;
	}
	
	private void notifyBlock() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	public boolean dropItem(PlayerEntity player, Hand handIn, int layer, int pos) {
		ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), this.inventory[layer][pos]);
		this.notifyBlock();
		this.inventory[layer][pos] = ItemStack.EMPTY;
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

	public int getNumberOfLayers() {
		return this.layers;
	}

	public int getStacksPerLayers() {
		return this.stacksPerLayer;
	}
}
