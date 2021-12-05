package kirothebluefox.moblocks.content.decoration.lighting.siren;

import kirothebluefox.moblocks.content.ModSounds;
import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.*;

public class SirenTile extends BlockEntity {
	public static final String COLOR_KEY = "color";
	public static final String MAX_COLOR_KEY = "max_color";
    public int color = 0xFFFFFF,
    		animation = 0,
    		animationMax = 40,
    		rAnim, gAnim, bAnim, maxColor = 0xFFFFFF;
    public double factor = 1.1;

	public SirenTile(BlockPos pos, BlockState state) {
		super(ModTileEntities.SIREN, pos, state);
		Color color = new Color(maxColor);
		int r = color.getRed(),
				g = color.getGreen(),
				b = color.getBlue();
		this.rAnim = (int) Math.round(r/(animationMax*factor));
		this.gAnim = (int) Math.round(g/(animationMax*factor));
		this.bAnim = (int) Math.round(b/(animationMax*factor));
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
	    this.color = compound.getInt(COLOR_KEY);
	    setMaxColor(compound.getInt(MAX_COLOR_KEY));
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    compound.putInt(MAX_COLOR_KEY, this.maxColor);
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    tag.putInt(MAX_COLOR_KEY, this.maxColor);
		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.load(tag);
		setColor(tag.getInt(COLOR_KEY));
		setMaxColor(tag.getInt(MAX_COLOR_KEY));
	}

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet)
    {
        handleUpdateTag(packet.getTag());
    }

	private void notifyBlock() {
		this.setChanged();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
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

	public void tick() {
		if (this.getBlockState().getValue(Siren.POWERED)) {
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
				this.getLevel().playSound(null, this.getBlockPos(), ModSounds.SIREN, SoundSource.BLOCKS, 3, 1);
			}
			setColor(r*256*256 + g*256 + b);
		} else {
			setColor(maxColor);
			this.animation = 0;
		}
	}
}
