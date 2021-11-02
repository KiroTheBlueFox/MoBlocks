package kirothebluefox.moblocks.content.decoration.lighting.rainbowblock;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.*;

public class RainbowBlockTile extends BlockEntity {
	public static final String COLOR_KEY = "color";
    public int color = 0xFF0000;
    public static final String SPEED_KEY = "speed";
    public int speed = 1;

	public RainbowBlockTile(BlockPos pos, BlockState state) {
		super(ModTileEntities.RAINBOW_BLOCK, pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
	    this.color = compound.getInt(COLOR_KEY);
	    this.speed = compound.getInt(SPEED_KEY);
	}

	@Override
	public CompoundTag save(CompoundTag compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    compound.putInt(SPEED_KEY, this.speed);
	    return super.save(compound);
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    tag.putInt(SPEED_KEY, this.speed);
		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.load(tag);
		setColor(tag.getInt(COLOR_KEY));
		setSpeed(tag.getInt(SPEED_KEY));
	}

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return new ClientboundBlockEntityDataPacket(worldPosition, 0, getUpdateTag());
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
