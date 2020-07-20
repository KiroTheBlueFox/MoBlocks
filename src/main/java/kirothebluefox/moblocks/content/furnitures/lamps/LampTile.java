package kirothebluefox.moblocks.content.furnitures.lamps;

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

public class LampTile extends TileEntity {
	public static final String INV_KEY = "inventory";
    public ItemStack stack = ItemStack.EMPTY;
	
	public LampTile() {
		super(ModTileEntities.SMALL_LAMP);
	}
	
	@Override
	public void read(BlockState blockstate, CompoundNBT compound) {
		super.read(blockstate, compound);
	    CompoundNBT inventory = compound.getCompound(INV_KEY);
	    this.stack = ItemStack.read(inventory);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    CompoundNBT inventory = new CompoundNBT();
	    this.stack.write(inventory);
	    compound.put(INV_KEY, inventory);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    CompoundNBT inventory = new CompoundNBT();
	    this.stack.write(inventory);
		tag.put(INV_KEY, inventory);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		if (!tag.getCompound(INV_KEY).isEmpty()) this.stack = ItemStack.read(tag.getCompound(INV_KEY));
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
        if (itemstack.getItem().getTags().contains(new ResourceLocation(MoBlocks.MODID, "lamp_shades"))) {
    		this.stack = itemstack.split(1);
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
		return this.stack;
	}

	public boolean dropItem(PlayerEntity player, Hand handIn) {
		if (!this.stack.isEmpty()) {
			if (player.getActiveItemStack().isEmpty()) {
				player.setHeldItem(handIn, this.stack);
	        } else if (!player.addItemStackToInventory(this.stack)) {
	        	player.dropItem(this.stack, false);
	        }
			this.notifyBlock();
			this.stack = ItemStack.EMPTY;
			return true;
		} else {
			return false;
		}
	}

	public boolean dropItem() {
		if (!this.stack.isEmpty()) {
			ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), this.stack);
			return true;
		} else {
			return false;
		}
	}
}
