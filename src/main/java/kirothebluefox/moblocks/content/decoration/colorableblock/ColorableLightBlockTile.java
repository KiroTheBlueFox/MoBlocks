package kirothebluefox.moblocks.content.decoration.colorableblock;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class ColorableLightBlockTile extends TileEntity {
	public static final String COLOR_KEY = "color";
    public int color = 0xFFFFFF;
    public static final String LIGHT_COLOR_KEY = "light_color";
    public int lightColor = 0xFFFFFF;
    
	public ColorableLightBlockTile() {
		super(ModTileEntities.COLORABLE_LIGHT_BLOCK);
	}
	
	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
	    this.color = compound.getInt(COLOR_KEY);
	    this.lightColor = compound.getInt(LIGHT_COLOR_KEY);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    compound.putInt(LIGHT_COLOR_KEY, this.lightColor);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    tag.putInt(LIGHT_COLOR_KEY, this.lightColor);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setColor(tag.getInt(COLOR_KEY));
		setLightColor(tag.getInt(LIGHT_COLOR_KEY));
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

	public void setColor(int color) {
		this.color = color;
		notifyBlock();
	}
	
	public int getColor() {
		return this.color;
	}

	public void setLightColor(int color) {
		this.lightColor = color;
		notifyBlock();
	}
    
	public int getLightColor() {
		return lightColor;
	}
}
