package kirothebluefox.moblocks.content.furnitures.potionshelves;

import kirothebluefox.moblocks.content.CustomItemTags;
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

public class PotionShelfTile extends BlockEntity {
	private int layers = 3, stacksPerLayer = 3;
	public String[][] KEYS = new String[layers][stacksPerLayer];
    public ItemStack[][] inventory = new ItemStack[layers][stacksPerLayer];

	public PotionShelfTile(BlockPos pos, BlockState state) {
		super(ModTileEntities.POTION_SHELF, pos, state);
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
				KEYS[i][j] = String.format("item%d_%d",i,j);
				inventory[i][j] = ItemStack.EMPTY;
			}
		}
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
			    CompoundTag item = compound.getCompound(KEYS[i][j]);
			    this.inventory[i][j] = ItemStack.of(item);
			}
		}
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
			    CompoundTag inventory = new CompoundTag();
			    this.inventory[i][j].save(inventory);
			    compound.put(KEYS[i][j], inventory);
			}
		}
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
		for (int i = 0; i < this.layers; i++) {
			for (int j = 0; j < this.stacksPerLayer; j++) {
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

	public boolean addItem(ItemStack itemstack, int layer, int pos, Player player, InteractionHand hand) {
		if (inventory[layer][pos].isEmpty() && itemstack.getTags().anyMatch(tag -> tag.equals(CustomItemTags.POTION_ITEMS))) {
			inventory[layer][pos] = itemstack.split(1);
		} else {
			dropItem(player, hand, layer, pos);
		}
    	this.notifyBlock();
    	return true;
	}

	public ItemStack getItem(int layer, int pos) {
		return inventory[layer][pos];
	}

	public ItemStack[][] getItems() {
		return this.inventory;
	}

	private void notifyBlock() {
		this.setChanged();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	public boolean dropItem(Player player, InteractionHand handIn, int layer, int pos) {
		ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), this.inventory[layer][pos]);
		this.notifyBlock();
		this.inventory[layer][pos] = ItemStack.EMPTY;
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
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getNumberOfLayers() {
		return this.layers;
	}

	public int getStacksPerLayers() {
		return this.stacksPerLayer;
	}
}
