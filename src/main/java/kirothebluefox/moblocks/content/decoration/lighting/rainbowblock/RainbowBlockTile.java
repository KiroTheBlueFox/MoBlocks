package kirothebluefox.moblocks.content.decoration.lighting.rainbowblock;

import java.awt.Color;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class RainbowBlockTile extends TileEntity implements ITickableTileEntity {
	public static final String COLOR_KEY = "color";
    public int color = 0xFF0000;
    public static final String SPEED_KEY = "speed";
    public int speed = 1;

	public RainbowBlockTile() {
		super(ModTileEntities.RAINBOW_BLOCK);
	}
	
	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
	    this.color = compound.getInt(COLOR_KEY);
	    this.speed = compound.getInt(SPEED_KEY);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    compound.putInt(SPEED_KEY, this.speed);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    tag.putInt(SPEED_KEY, this.speed);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setColor(tag.getInt(COLOR_KEY));
		setSpeed(tag.getInt(SPEED_KEY));
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

	public void setSpeed(int speed) {
		this.speed = speed;
		notifyBlock();
	}
	
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void tick() {
		Color color = new Color(getColor());
		int r = color.getRed(),
				g = color.getGreen(),
				b = color.getBlue();
		if(r > 0 && b <= 0){
			r -= speed;
			if (r < 0) r = 0;
			g += speed;
			if (g > 255) g = 255;
		}
		if(g > 0 && r <= 0){
			g -= speed;
			if (g < 0) g = 0;
			b += speed;
			if (b > 255) b = 255;
		}
		if(b > 0 && g <= 0){
			b -= speed;
			if (b < 0) b = 0;
			r += speed;
			if (r > 255) r = 255;
		}
		setColor(r*256*256 + g*256 + b);
	}
}
