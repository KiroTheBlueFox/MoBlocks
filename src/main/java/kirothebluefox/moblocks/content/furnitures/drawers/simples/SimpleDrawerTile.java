package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.utils.ItemStackUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SimpleDrawerTile extends BlockEntity implements MenuProvider {
	public static final String INV_KEY = "inventory";
    private IItemHandlerModifiable items = createItemHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> items);
    private boolean isOpened;
	private long animationTime;

	public SimpleDrawerTile(BlockPos pos, BlockState state) {
		super(ModTileEntities.SIMPLE_DRAWER, pos, state);
		this.isOpened = false;
	}

	public boolean getIsOpened() {
		return this.isOpened;
	}

	public boolean isOpened() {
		int i = 0;
		for(Player playerentity : this.level.getEntitiesOfClass(Player.class, new AABB((double)((float)this.worldPosition.getX() - 5.0F), (double)((float)this.worldPosition.getY() - 5.0F), (double)((float)this.worldPosition.getZ() - 5.0F), (double)((float)(this.worldPosition.getX() + 1) + 5.0F), (double)((float)(this.worldPosition.getY() + 1) + 5.0F), (double)((float)(this.worldPosition.getZ() + 1) + 5.0F)))) {
			if (playerentity.containerMenu instanceof SimpleDrawerContainer) {
				IItemHandler inventory = ((SimpleDrawerContainer)playerentity.containerMenu).getBlockInventory();
				if (inventory == this.items) {
					++i;
				}
			}
		}
		if (i == 0) {
			if (this.isOpened) {
				this.notifyBlock();
				getLevel().playLocalSound(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundSource.BLOCKS, 1, 0.1f, true);
				this.animationTime = System.currentTimeMillis();
			}
			return false;
		} else {
			if (!this.isOpened) {
				this.notifyBlock();
				getLevel().playLocalSound(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundSource.BLOCKS, 1, 0.1f, true);
				this.animationTime = System.currentTimeMillis();
			}
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(CompoundTag compound) {
	    CompoundTag inventory = compound.getCompound(INV_KEY);
	    handler.ifPresent(h -> ((INBTSerializable<CompoundTag>)h).deserializeNBT(inventory));
		super.load(compound);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveAdditional(CompoundTag compound) {
	    handler.ifPresent(h -> {
	    	CompoundTag inventory = ((INBTSerializable<CompoundTag>)h).serializeNBT();
	    	compound.put(INV_KEY, inventory);
	    });
	}

	private IItemHandlerModifiable createItemHandler() {
		return new ItemStackHandler(16);
	}

	public IItemHandlerModifiable getItems() {
		return this.items;
	}

	public boolean dropItems() {
		boolean isEmpty = true;
		for (int i = 0; i < this.items.getSlots(); i++) {
			if (this.items.getStackInSlot(i) != ItemStack.EMPTY) {
				ItemStackUtils.ejectItemStack(this.getLevel(), this.getBlockPos(), this.items.getStackInSlot(i));
				isEmpty = false;
			}
		}
		this.notifyBlock();
		return isEmpty ? false : true;
	}

	private void notifyBlock() {
		this.setChanged();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory playerInv, Player player) {
		return new SimpleDrawerContainer(id, worldPosition, playerInv);
	}

	@Override
	public Component getDisplayName() {
		return new TranslatableComponent("container.moblocks.simple_drawer.name");
	}

	public long getAnimationTime() {
		return this.animationTime;
	}

	public void tick() {
		this.isOpened = isOpened();
	}
}
