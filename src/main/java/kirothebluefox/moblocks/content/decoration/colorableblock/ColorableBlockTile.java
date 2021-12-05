package kirothebluefox.moblocks.content.decoration.colorableblock;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ColorableBlockTile extends BlockEntity {
	public static final String COLOR_KEY = "color";
    public int color = 0xFFFFFF;

	public ColorableBlockTile(BlockPos pos, BlockState state) {
		super(ModTileEntities.COLORABLE_BLOCK, pos, state);
	}

	public ColorableBlockTile(BlockPos pos, BlockState state, BlockEntityType<? extends ColorableBlockTile> colorableBlock) {
		super(colorableBlock, pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
	    this.color = compound.getInt(COLOR_KEY);
	}

	@Override
	protected void saveAdditional(CompoundTag compound) {
		compound.putInt(COLOR_KEY, this.color);
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
	    tag.putInt(COLOR_KEY, this.color);
		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.load(tag);
		setColor(tag.getInt(COLOR_KEY));
	}

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        handleUpdateTag(packet.getTag());
    }

	protected void notifyBlock() {
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
}
