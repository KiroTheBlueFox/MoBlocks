package kirothebluefox.moblocks.content.furnitures;

import java.util.List;

import kirothebluefox.moblocks.content.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SeatChair extends Entity {
	public SeatChair(World worldIn, BlockPos pos) {
		this(ModEntities.SEAT_CHAIR, worldIn);
		setPosition(pos.getX() + 0.5d, pos.getY() + 0.4d, pos.getZ() + 0.5d);
	}
	
	public SeatChair(EntityType<SeatChair> entityTypeIn, World worldIn) {
		super(ModEntities.SEAT_CHAIR, worldIn);
	}

	public void tick() {
		super.tick();
		BlockPos pos = func_233580_cy_();
		if (!(getEntityWorld().getBlockState(pos).getBlock() instanceof Chair)) {
			remove();
		} else {
			List<Entity> passengers = getPassengers();
			if (passengers.isEmpty()) {
				remove();
			} else {
				for (Entity entity : passengers) {
					if (entity.isSneaking()) {
						remove();
					}
				}
			}
		}
	}
	
	@Override
	protected boolean canBeRidden(Entity entityIn) {
		if (entityIn.getType() == EntityType.PLAYER) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void registerData() {
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
