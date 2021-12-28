package kirothebluefox.moblocks.common.blockentities;

import kirothebluefox.moblocks.common.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColorableKitchenCounterTile extends BlockEntity {
    public static final String COLOR_KEY1 = "counter_color";
    public static final String COLOR_KEY2 = "planks_color";
    public int color1 = 0xFFFFFF;
    public int color2 = 0xFFFFFF;

    public ColorableKitchenCounterTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.COLORABLE_KITCHEN_COUNTER, pos, state);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        this.color1 = compound.getInt(COLOR_KEY1);
        this.color2 = compound.getInt(COLOR_KEY2);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        compound.putInt(COLOR_KEY1, this.color1);
        compound.putInt(COLOR_KEY2, this.color2);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putInt(COLOR_KEY1, this.color1);
        tag.putInt(COLOR_KEY2, this.color2);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.load(tag);
        setCounterColor(tag.getInt(COLOR_KEY1));
        setPlanksColor(tag.getInt(COLOR_KEY2));
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        handleUpdateTag(packet.getTag());
    }

    private void notifyBlock() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public int getCounterColor() {
        return this.color1;
    }

    public void setCounterColor(int color) {
        this.color1 = color;
        notifyBlock();
    }

    public int getPlanksColor() {
        return this.color2;
    }

    public void setPlanksColor(int color) {
        this.color2 = color;
        notifyBlock();
    }
}
