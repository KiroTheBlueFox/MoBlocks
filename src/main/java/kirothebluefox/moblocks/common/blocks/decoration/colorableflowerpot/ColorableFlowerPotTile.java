package kirothebluefox.moblocks.common.blocks.decoration.colorableflowerpot;

import kirothebluefox.moblocks.common.init.ModTileEntities;
import kirothebluefox.moblocks.utils.ItemStackUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColorableFlowerPotTile extends BlockEntity {
    public static final String COLOR_KEY = "color";
    public static final String ITEM_KEY = "flower";
    public int color = 0xFFFFFF;
    public ItemStack item = ItemStack.EMPTY;

    public ColorableFlowerPotTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.COLORABLE_FLOWER_POT, pos, state);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        this.color = compound.getInt(COLOR_KEY);
        CompoundTag inventory = compound.getCompound(ITEM_KEY);
        this.item = ItemStack.of(inventory);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        compound.putInt(COLOR_KEY, this.color);
        CompoundTag inventory = new CompoundTag();
        this.item.save(inventory);
        compound.put(ITEM_KEY, inventory);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.load(tag);
        setColor(tag.getInt(COLOR_KEY));
        if (!tag.getCompound(ITEM_KEY).isEmpty()) this.item = ItemStack.of(tag.getCompound(ITEM_KEY));
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putInt(COLOR_KEY, this.color);
        CompoundTag inventory = new CompoundTag();
        this.item.save(inventory);
        tag.put(ITEM_KEY, inventory);
        return tag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        handleUpdateTag(packet.getTag());
    }

    public boolean addItem(ItemStack itemstack) {
        if (this.item.isEmpty()) {
            this.item = itemstack.split(1);
            this.notifyBlock();
            return true;
        }
        return false;
    }

    private void notifyBlock() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public ItemStack getItem() {
        return this.item;
    }

    public boolean dropItem(Player player, InteractionHand handIn) {
        if (!this.item.isEmpty()) {
            if (player.getUseItem().isEmpty()) {
                player.setItemInHand(handIn, this.item);
            } else if (!player.addItem(this.item)) {
                player.drop(this.item, false);
            }
            this.notifyBlock();
            this.item = ItemStack.EMPTY;
            return true;
        } else {
            return false;
        }
    }

    public boolean dropItem() {
        if (!this.item.isEmpty()) {
            ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), this.item);
            return true;
        } else {
            return false;
        }
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
        notifyBlock();
    }
}
