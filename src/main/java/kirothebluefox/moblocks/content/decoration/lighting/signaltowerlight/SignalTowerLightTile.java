package kirothebluefox.moblocks.content.decoration.lighting.signaltowerlight;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class SignalTowerLightTile extends TileEntity {
	public static final String COLOR1_KEY = "color1";
	public static final String COLOR2_KEY = "color2";
	public static final String COLOR3_KEY = "color3";
    public int color1 = 0xFFFFFF, color2 = 0xFFFFFF, color3 = 0xFFFFFF;

	public SignalTowerLightTile(int color1, int color2, int color3) {
		super(ModTileEntities.SIGNAL_TOWER_LIGHT);
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
	}

	public SignalTowerLightTile() {
		super(ModTileEntities.SIGNAL_TOWER_LIGHT);
	}
	
	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
	    this.color1 = compound.getInt(COLOR1_KEY);
	    this.color2 = compound.getInt(COLOR2_KEY);
	    this.color3 = compound.getInt(COLOR3_KEY);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    compound.putInt(COLOR1_KEY, this.color1);
	    compound.putInt(COLOR2_KEY, this.color2);
	    compound.putInt(COLOR3_KEY, this.color3);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    tag.putInt(COLOR1_KEY, this.color1);
	    tag.putInt(COLOR2_KEY, this.color2);
	    tag.putInt(COLOR3_KEY, this.color3);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setColor1(tag.getInt(COLOR1_KEY));
		setColor2(tag.getInt(COLOR2_KEY));
		setColor3(tag.getInt(COLOR3_KEY));
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

	public void setColor1(int color) {
		this.color1 = color;
		notifyBlock();
	}
	
	public int getColor1() {
		return this.color1;
	}

	public void setColor2(int color) {
		this.color2 = color;
		notifyBlock();
	}
	
	public int getColor2() {
		return this.color2;
	}

	public void setColor3(int color) {
		this.color3 = color;
		notifyBlock();
	}
	
	public int getColor3() {
		return this.color3;
	}

	public void setColors(int color1, int color2, int color3) {
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
		notifyBlock();
	}

	public int getColor(Integer index) {
		if (index == 0) {
			return this.color1;
		} else if (index == 1) {
			return this.color2;
		} else {
			return this.color3;
		}
	}
}
