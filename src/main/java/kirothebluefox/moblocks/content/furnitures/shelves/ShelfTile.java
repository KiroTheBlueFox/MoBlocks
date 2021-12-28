package kirothebluefox.moblocks.content.furnitures.shelves;

import kirothebluefox.moblocks.content.ModTileEntities;
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

public class ShelfTile extends BlockEntity {
    public static final String ITEM1_KEY = "item1";
    public static final String ITEM2_KEY = "item2";
    public static final String ITEM3_KEY = "item3";
    public static final String ITEM4_KEY = "item4";
    public ItemStack[] inventory = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};

    public ShelfTile(BlockPos pos, BlockState state) {
        super(ModTileEntities.SHELF, pos, state);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        CompoundTag item1 = compound.getCompound(ITEM1_KEY);
        CompoundTag item2 = compound.getCompound(ITEM2_KEY);
        CompoundTag item3 = compound.getCompound(ITEM3_KEY);
        CompoundTag item4 = compound.getCompound(ITEM4_KEY);
        this.inventory[0] = ItemStack.of(item1);
        this.inventory[1] = ItemStack.of(item2);
        this.inventory[2] = ItemStack.of(item3);
        this.inventory[3] = ItemStack.of(item4);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        CompoundTag inventory1 = new CompoundTag();
        CompoundTag inventory2 = new CompoundTag();
        CompoundTag inventory3 = new CompoundTag();
        CompoundTag inventory4 = new CompoundTag();
        this.inventory[0].save(inventory1);
        this.inventory[1].save(inventory2);
        this.inventory[2].save(inventory3);
        this.inventory[3].save(inventory4);
        compound.put(ITEM1_KEY, inventory1);
        compound.put(ITEM2_KEY, inventory2);
        compound.put(ITEM3_KEY, inventory3);
        compound.put(ITEM4_KEY, inventory4);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        CompoundTag inventory1 = new CompoundTag();
        CompoundTag inventory2 = new CompoundTag();
        CompoundTag inventory3 = new CompoundTag();
        CompoundTag inventory4 = new CompoundTag();
        this.inventory[0].save(inventory1);
        this.inventory[1].save(inventory2);
        this.inventory[2].save(inventory3);
        this.inventory[3].save(inventory4);
        tag.put(ITEM1_KEY, inventory1);
        tag.put(ITEM2_KEY, inventory2);
        tag.put(ITEM3_KEY, inventory3);
        tag.put(ITEM4_KEY, inventory4);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.load(tag);
        if (!tag.getCompound(ITEM1_KEY).isEmpty()) this.inventory[0] = ItemStack.of(tag.getCompound(ITEM1_KEY));
        if (!tag.getCompound(ITEM2_KEY).isEmpty()) this.inventory[1] = ItemStack.of(tag.getCompound(ITEM2_KEY));
        if (!tag.getCompound(ITEM3_KEY).isEmpty()) this.inventory[2] = ItemStack.of(tag.getCompound(ITEM3_KEY));
        if (!tag.getCompound(ITEM4_KEY).isEmpty()) this.inventory[3] = ItemStack.of(tag.getCompound(ITEM4_KEY));
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
        if (inventory[pos].isEmpty()) {
            inventory[pos] = itemstack.copy();
            player.setItemInHand(hand, ItemStack.EMPTY);
        } else {
            if (inventory[pos].getItem().equals(itemstack.getItem())) {
                int numberOfItems = inventory[pos].getCount();
                int numberOfItemsInHand = itemstack.getCount();
                int numberOfItemsMax = itemstack.getMaxStackSize() - numberOfItems;

                if (numberOfItemsInHand < numberOfItemsMax) {
                    inventory[pos].grow(numberOfItemsInHand);
                    player.setItemInHand(hand, ItemStack.EMPTY);
                } else {
                    inventory[pos].grow(numberOfItemsMax);
                    itemstack.shrink(numberOfItemsMax);
                }
            } else {
                dropItem(player, hand, pos);
            }
        }
        this.notifyBlock();
        return true;
    }

    private void notifyBlock() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public ItemStack getItem(int pos) {
        return inventory[pos];
    }

    public boolean dropItem(Player player, InteractionHand handIn, int pos) {
        ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), this.inventory[pos]);
        this.notifyBlock();
        this.inventory[pos] = ItemStack.EMPTY;
        return true;
    }

    public boolean dropItems() {
        int i = 0;
        for (ItemStack stack : inventory) {
            if (!stack.isEmpty()) {
                ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), stack);
                i++;
            }
        }
        return i != 0;
    }
}
