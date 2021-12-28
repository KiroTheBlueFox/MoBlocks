package kirothebluefox.moblocks.common.blocks.decoration.lighting.signaltowerlight;

import kirothebluefox.moblocks.common.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SignalTowerLightTile extends BlockEntity {
    public static final String COLOR1_KEY = "color1";
    public static final String COLOR2_KEY = "color2";
    public static final String COLOR3_KEY = "color3";
    public int color1 = 0xFFFFFF, color2 = 0xFFFFFF, color3 = 0xFFFFFF;

    public SignalTowerLightTile(int color1, int color2, int color3, BlockPos pos, BlockState state) {
        super(ModTileEntities.SIGNAL_TOWER_LIGHT, pos, state);
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    public SignalTowerLightTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.SIGNAL_TOWER_LIGHT, pos, state);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        this.color1 = compound.getInt(COLOR1_KEY);
        this.color2 = compound.getInt(COLOR2_KEY);
        this.color3 = compound.getInt(COLOR3_KEY);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        compound.putInt(COLOR1_KEY, this.color1);
        compound.putInt(COLOR2_KEY, this.color2);
        compound.putInt(COLOR3_KEY, this.color3);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putInt(COLOR1_KEY, this.color1);
        tag.putInt(COLOR2_KEY, this.color2);
        tag.putInt(COLOR3_KEY, this.color3);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.load(tag);
        setColor1(tag.getInt(COLOR1_KEY));
        setColor2(tag.getInt(COLOR2_KEY));
        setColor3(tag.getInt(COLOR3_KEY));
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

    public int getColor1() {
        return this.color1;
    }

    public void setColor1(int color) {
        this.color1 = color;
        notifyBlock();
    }

    public int getColor2() {
        return this.color2;
    }

    public void setColor2(int color) {
        this.color2 = color;
        notifyBlock();
    }

    public int getColor3() {
        return this.color3;
    }

    public void setColor3(int color) {
        this.color3 = color;
        notifyBlock();
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
