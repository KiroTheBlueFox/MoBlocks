package kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class ColorableKitchenCounterTile extends TileEntity {
	public static final String COLOR_KEY1 = "counter_color";
    public int color1 = 0xFFFFFF;
	public static final String COLOR_KEY2 = "planks_color";
    public int color2 = 0xFFFFFF;
    
	public ColorableKitchenCounterTile() {
		super(ModTileEntities.COLORABLE_KITCHEN_COUNTER);
	}
	
	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
	    this.color1 = compound.getInt(COLOR_KEY1);
	    this.color2 = compound.getInt(COLOR_KEY2);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    compound.putInt(COLOR_KEY1, this.color1);
	    compound.putInt(COLOR_KEY2, this.color2);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY1, this.color1);
	    tag.putInt(COLOR_KEY2, this.color2);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setCounterColor(tag.getInt(COLOR_KEY1));
		setPlanksColor(tag.getInt(COLOR_KEY2));
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

	private void notifyBlock() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	public void setCounterColor(int color) {
		this.color1 = color;
		notifyBlock();
	}
	
	public int getCounterColor() {
		return this.color1;
	}

	public void setPlanksColor(int color) {
		this.color2 = color;
		notifyBlock();
	}
	
	public int getPlanksColor() {
		return this.color2;
	}
}
