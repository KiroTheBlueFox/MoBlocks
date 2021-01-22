package kirothebluefox.moblocks.content.decoration.lighting.siren;

import java.awt.Color;

import kirothebluefox.moblocks.content.ModSounds;
import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;

public class SirenTile extends TileEntity implements ITickableTileEntity {
	public static final String COLOR_KEY = "color";
	public static final String MAX_COLOR_KEY = "max_color";
    public int color = 0xFFFFFF,
    		animation = 0,
    		animationMax = 40,
    		rAnim, gAnim, bAnim, maxColor = 0xFFFFFF;
    public double factor = 1.1;

	public SirenTile() {
		super(ModTileEntities.SIREN);
		Color color = new Color(maxColor);
		int r = color.getRed(),
				g = color.getGreen(),
				b = color.getBlue();
		this.rAnim = (int) Math.round(r/(animationMax*factor));
		this.gAnim = (int) Math.round(g/(animationMax*factor));
		this.bAnim = (int) Math.round(b/(animationMax*factor));
	}
	
	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
	    this.color = compound.getInt(COLOR_KEY);
	    setMaxColor(compound.getInt(MAX_COLOR_KEY));
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    compound.putInt(MAX_COLOR_KEY, this.maxColor);
	    return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    tag.putInt(MAX_COLOR_KEY, this.maxColor);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setColor(tag.getInt(COLOR_KEY));
		setMaxColor(tag.getInt(MAX_COLOR_KEY));
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

	public void setMaxColor(int color) {
		this.maxColor = color;
		Color colorColor = new Color(maxColor);
		int r = colorColor.getRed(),
				g = colorColor.getGreen(),
				b = colorColor.getBlue();
		this.rAnim = (int) Math.round(r/(animationMax*factor));
		this.gAnim = (int) Math.round(g/(animationMax*factor));
		this.bAnim = (int) Math.round(b/(animationMax*factor));
	}
	
	public int getColor() {
		return this.color;
	}
	
	public int getMaxColor() {
		return maxColor;
	}

	@Override
	public void tick() {
		if (this.getBlockState().get(Siren.POWERED)) {
			Color color = new Color(getColor());
			int r = color.getRed(),
					g = color.getGreen(),
					b = color.getBlue();
			if (animation < animationMax/2) {
				r -= rAnim;
				g -= gAnim;
				b -= bAnim;
				animation++;
			} else if (animation < animationMax) {
				r += rAnim;
				g += gAnim;
				b += bAnim;
				animation++;
			} else {
				animation = 0;
				this.getWorld().playSound(null, this.getPos(), ModSounds.SIREN, SoundCategory.BLOCKS, 3, 1);
			}
			setColor(r*256*256 + g*256 + b);
		} else {
			setColor(maxColor);
			this.animation = 0;
		}
	}
}
