package kirothebluefox.moblocks.content.decoration.colorableflowerpot;

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

public class ColorableFlowerPotTile extends TileEntity {
	public static final String COLOR_KEY = "color";
    public int color = 0xFFFFFF;
    public static final String ITEM_KEY = "flower";
    public ItemStack item = ItemStack.EMPTY;;
    
	public ColorableFlowerPotTile() {
		super(ModTileEntities.COLORABLE_FLOWER_POT);
	}
	
	@Override
	public void read(BlockState blockstate, CompoundNBT compound) {
		super.read(blockstate, compound);
	    this.color = compound.getInt(COLOR_KEY);
	    CompoundNBT inventory = compound.getCompound(ITEM_KEY);
	    this.item = ItemStack.read(inventory);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    CompoundNBT inventory = new CompoundNBT();
	    this.item.write(inventory);
	    compound.put(ITEM_KEY, inventory);
	    return super.write(compound);
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setColor(tag.getInt(COLOR_KEY));
		if (!tag.getCompound(ITEM_KEY).isEmpty()) this.item = ItemStack.read(tag.getCompound(ITEM_KEY));
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    CompoundNBT inventory = new CompoundNBT();
	    this.item.write(inventory);
		tag.put(ITEM_KEY, inventory);
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
	
	public boolean addItem(ItemStack itemstack) {
        if (this.item.isEmpty()) {
    		this.item = itemstack.split(1);
    		this.notifyBlock();
    		return true;
    	}
        return false;
	}

	private void notifyBlock() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	public ItemStack getItem() {
		return this.item;
	}

	public boolean dropItem(PlayerEntity player, Hand handIn) {
		if (!this.item.isEmpty()) {
			if (player.getActiveItemStack().isEmpty()) {
				player.setHeldItem(handIn, this.item);
	        } else if (!player.addItemStackToInventory(this.item)) {
	        	player.dropItem(this.item, false);
	        }
			this.notifyBlock();
			this.item = ItemStack.EMPTY;
			return true;
		} else {
			return false;
		}
	}

	public boolean dropItem() {
		if (!this.item.isEmpty()) {
			ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), this.item);
			return true;
		} else {
			return false;
		}
	}

	public void setColor(int color) {
		this.color = color;
		notifyBlock();
	}
	
	public int getColor() {
		return this.color;
	}
}
