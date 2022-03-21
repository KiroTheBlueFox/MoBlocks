package kirothebluefox.moblocks.content.furnitures;

import kirothebluefox.moblocks.content.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.List;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.entity.Entity.RemovalReason;

public class SeatChair extends Entity {
	public SeatChair(Level worldIn, BlockPos pos) {
		this(ModEntities.SEAT_CHAIR, worldIn);
		setPos(pos.getX() + 0.5d, pos.getY() + 0.4d, pos.getZ() + 0.5d);
	}

	public SeatChair(EntityType<SeatChair> type, Level worldIn) {
		super(ModEntities.SEAT_CHAIR, worldIn);
	}

	public void tick() {
		super.tick();
		BlockPos pos = blockPosition();
		if (!(getCommandSenderWorld().getBlockState(pos).getBlock() instanceof Chair)) {
			remove(RemovalReason.KILLED);
		} else {
			List<Entity> passengers = getPassengers();
			if (passengers.isEmpty()) {
				remove(RemovalReason.KILLED);
			} else {
				for (Entity entity : passengers) {
					if (entity.isShiftKeyDown()) {
						remove(RemovalReason.KILLED);
					}
				}
			}
		}
	}

	@Override
	protected boolean canRide(Entity entityIn) {
		if (entityIn.getType() == EntityType.PLAYER) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void defineSynchedData() {
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
