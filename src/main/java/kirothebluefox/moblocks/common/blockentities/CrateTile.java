package kirothebluefox.moblocks.common.blockentities;

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

public class CrateTile extends BlockEntity {
    public String[][] KEYS = new String[4][16];
    public ItemStack[][] inventory = new ItemStack[4][16];
    public int layer = 0;

    public CrateTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.CRATE, pos, state);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                KEYS[i][j] = String.format("item%d_%d", i, j);
                inventory[i][j] = ItemStack.EMPTY;
            }
        }
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                CompoundTag item = compound.getCompound(KEYS[i][j]);
                this.inventory[i][j] = ItemStack.of(item);
            }
        }
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                CompoundTag inventory = new CompoundTag();
                this.inventory[i][j].save(inventory);
                compound.put(KEYS[i][j], inventory);
            }
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                CompoundTag inventory = new CompoundTag();
                this.inventory[i][j].save(inventory);
                tag.put(KEYS[i][j], inventory);
            }
        }
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

    public boolean addItem(ItemStack itemstack, int pos, Player player, InteractionHand hand) {
        if (inventory[this.layer][pos].isEmpty()) {
            inventory[this.layer][pos] = itemstack.copy();
            player.setItemInHand(hand, ItemStack.EMPTY);
        } else {
            if (inventory[this.layer][pos].getItem().equals(itemstack.getItem())) {
                int numberOfItems = inventory[this.layer][pos].getCount();
                int numberOfItemsInHand = itemstack.getCount();
                int numberOfItemsMax = itemstack.getMaxStackSize() - numberOfItems;

                if (numberOfItemsInHand < numberOfItemsMax) {
                    inventory[this.layer][pos].grow(numberOfItemsInHand);
                    player.setItemInHand(hand, ItemStack.EMPTY);
                } else {
                    inventory[this.layer][pos].grow(numberOfItemsMax);
                    itemstack.shrink(numberOfItemsMax);
                }
            } else {
                dropItem(player, hand, pos);
            }
        }
        this.notifyBlock();
        return true;
    }

    public ItemStack getItem(int pos) {
        return inventory[this.layer][pos];
    }

    public ItemStack getItem(int layer, int pos) {
        return inventory[layer][pos];
    }

    public void nextLayer() {
        this.layer = (this.layer + 1) % 4;
        this.notifyBlock();
    }

    private void notifyBlock() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public boolean dropItem(Player player, InteractionHand handIn, int pos) {
        ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), this.inventory[this.layer][pos]);
        this.notifyBlock();
        this.inventory[this.layer][pos] = ItemStack.EMPTY;
        return true;
    }

    public boolean dropItems() {
        int i = 0;
        for (ItemStack[] layer : inventory) {
            for (ItemStack stack : layer) {
                if (!stack.isEmpty()) {
                    ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), stack);
                    i++;
                }
            }
        }
        return i != 0;
    }
}
