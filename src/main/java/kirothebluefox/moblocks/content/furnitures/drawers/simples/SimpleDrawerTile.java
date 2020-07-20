package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.utils.ItemStackUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class SimpleDrawerTile extends TileEntity implements INamedContainerProvider, ITickableTileEntity {
	public static final String INV_KEY = "inventory";
    private IItemHandlerModifiable items = createItemHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> items);
    private boolean isOpened;
	private long animationTime;
	
	public SimpleDrawerTile() {
		super(ModTileEntities.SIMPLE_DRAWER);
		this.isOpened = false;
	}
	
	public boolean getIsOpened() {
		return this.isOpened;
	}
	
	public boolean isOpened() {
		int i = 0;
		for(PlayerEntity playerentity : this.world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB((double)((float)this.pos.getX() - 5.0F), (double)((float)this.pos.getY() - 5.0F), (double)((float)this.pos.getZ() - 5.0F), (double)((float)(this.pos.getX() + 1) + 5.0F), (double)((float)(this.pos.getY() + 1) + 5.0F), (double)((float)(this.pos.getZ() + 1) + 5.0F)))) {
			if (playerentity.openContainer instanceof SimpleDrawerContainer) {
				IItemHandler inventory = ((SimpleDrawerContainer)playerentity.openContainer).getBlockInventory();
				if (inventory == this.items) {
					++i;
				}
			}
		}
		if (i == 0) {
			if (this.isOpened) {
				this.notifyBlock();
				getWorld().playSound(getPos().getX(), getPos().getY(), getPos().getZ(), SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1, 0.1f, true);
				this.animationTime = System.currentTimeMillis();
			}
			return false;
		} else {
			if (!this.isOpened) {
				this.notifyBlock();
				getWorld().playSound(getPos().getX(), getPos().getY(), getPos().getZ(), SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1, 0.1f, true);
				this.animationTime = System.currentTimeMillis();
			}
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void read(BlockState blockstate, CompoundNBT compound) {
	    CompoundNBT inventory = compound.getCompound(INV_KEY);
	    handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(inventory));
		super.read(blockstate, compound);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	    handler.ifPresent(h -> {
	    	CompoundNBT inventory = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
	    	compound.put(INV_KEY, inventory);
	    });
	    return super.write(compound);
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
				ItemStackUtils.ejectItemStack(this.getWorld(), this.getPos(), this.items.getStackInSlot(i));
				isEmpty = false;
			}
		}
		this.notifyBlock();
		return isEmpty ? false : true;
	}

	private void notifyBlock() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
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
	public Container createMenu(int id, PlayerInventory playerInv, PlayerEntity player) {
		return new SimpleDrawerContainer(id, pos, playerInv);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.moblocks.simple_drawer.name");
	}
	
	public long getAnimationTime() {
		return this.animationTime;
	}
	
	@Override
	public void tick() {
		if (world.isRemote()) {
			this.isOpened = isOpened();
		}
	}
}
