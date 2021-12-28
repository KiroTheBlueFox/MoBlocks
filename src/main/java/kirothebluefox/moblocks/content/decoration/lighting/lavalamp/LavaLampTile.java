package kirothebluefox.moblocks.content.decoration.lighting.lavalamp;

import kirothebluefox.moblocks.content.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LavaLampTile extends BlockEntity {
    public static final String COLOR_KEY = "color";
    public int color = 0xFFFFFF;

    public LavaLampTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.LAVA_LAMP, pos, state);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        this.color = compound.getInt(COLOR_KEY);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
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

    private void notifyBlock() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
        notifyBlock();
    }
}
