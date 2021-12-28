package kirothebluefox.moblocks.common.blockentities;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.init.ModTileEntities;
import kirothebluefox.moblocks.utils.ItemStackUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LampTile extends BlockEntity {
    public static final String INV_KEY = "inventory";
    public ItemStack stack = ItemStack.EMPTY;

    public LampTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.SMALL_LAMP, pos, state);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        CompoundTag inventory = compound.getCompound(INV_KEY);
        this.stack = ItemStack.of(inventory);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        CompoundTag inventory = new CompoundTag();
        this.stack.save(inventory);
        compound.put(INV_KEY, inventory);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        CompoundTag inventory = new CompoundTag();
        this.stack.save(inventory);
        tag.put(INV_KEY, inventory);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.load(tag);
        if (!tag.getCompound(INV_KEY).isEmpty()) this.stack = ItemStack.of(tag.getCompound(INV_KEY));
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
        if (itemstack.getItem().getTags().contains(new ResourceLocation(MoBlocks.MODID, "lamp_shades"))) {
            this.stack = itemstack.split(1);
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
        return this.stack;
    }

    public boolean dropItem(Player player, InteractionHand handIn) {
        if (!this.stack.isEmpty()) {
            if (player.getUseItem().isEmpty()) {
                player.setItemInHand(handIn, this.stack);
            } else if (!player.addItem(this.stack)) {
                player.drop(this.stack, false);
            }
            this.notifyBlock();
            this.stack = ItemStack.EMPTY;
            return true;
        } else {
            return false;
        }
    }

    public boolean dropItem() {
        if (!this.stack.isEmpty()) {
            ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), this.stack);
            return true;
        } else {
            return false;
        }
    }
}
