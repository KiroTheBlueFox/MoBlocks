package kirothebluefox.moblocks.content.decoration.colorableblock;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColorableLightBlockTile extends BlockEntity {
	public static final String COLOR_KEY = "color";
    public int color = 0xFFFFFF;
    public static final String LIGHT_COLOR_KEY = "light_color";
    public int lightColor = 0xFFFFFF;

	public ColorableLightBlockTile(BlockPos pos, BlockState state) {
		super(ModTileEntities.COLORABLE_LIGHT_BLOCK, pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
	    this.color = compound.getInt(COLOR_KEY);
	    this.lightColor = compound.getInt(LIGHT_COLOR_KEY);
	}

	@Override
	public CompoundTag save(CompoundTag compound) {
	    compound.putInt(COLOR_KEY, this.color);
	    compound.putInt(LIGHT_COLOR_KEY, this.lightColor);
	    return super.save(compound);
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
	    tag.putInt(LIGHT_COLOR_KEY, this.lightColor);
		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.load(tag);
		setColor(tag.getInt(COLOR_KEY));
		setLightColor(tag.getInt(LIGHT_COLOR_KEY));
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

	public void setLightColor(int color) {
		this.lightColor = color;
		notifyBlock();
	}

	public int getLightColor() {
		return lightColor;
	}
}
