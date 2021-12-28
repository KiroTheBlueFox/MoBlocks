package kirothebluefox.moblocks.common.blocks.furnitures;

import kirothebluefox.moblocks.common.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;


public class SeatSofa extends Entity {
    public SeatSofa(Level worldIn, BlockPos pos) {
        this(ModEntities.SEAT_SOFA, worldIn);
        setPos(pos.getX() + 0.5d, pos.getY() + 0.2d, pos.getZ() + 0.5d);
    }

    public SeatSofa(EntityType<SeatSofa> type, Level worldIn) {
        super(ModEntities.SEAT_SOFA, worldIn);
    }

    public void tick() {
        super.tick();
        BlockPos pos = blockPosition();
        if (!(getCommandSenderWorld().getBlockState(pos).getBlock() instanceof Sofa)) {
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
        return entityIn.getType() == EntityType.PLAYER;
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
