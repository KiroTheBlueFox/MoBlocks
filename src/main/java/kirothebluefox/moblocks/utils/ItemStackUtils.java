package kirothebluefox.moblocks.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemStackUtils {
	public static void ejectItemStack(Level world, BlockPos from_pos, ItemStack stack) {
		Direction output_dir = Direction.UP;
		double x,y,z,xVel,yVel,zVel, xOff, yOff, zOff;
		BlockPos output_pos;
		if (output_dir != null)
		{
			output_pos = from_pos.relative(output_dir);
			xOff = output_dir.getStepX();
			yOff = output_dir.getStepY();
			zOff = output_dir.getStepZ();
		}
		else
		{
			output_pos = from_pos;
			xOff = 0D;
			yOff = 0D;
			zOff = 0D;
		}
		if (!world.getBlockState(output_pos).canOcclude())
		{
			x = from_pos.getX() + 0.5D + xOff*0.75D;
			y = from_pos.getY() + 0.25D + yOff*0.75D;
			z = from_pos.getZ() + 0.5D + zOff*0.75D;
			xVel = xOff * 0.1D;
			yVel = yOff * 0.1D;
			zVel = zOff * 0.1D;
		}
		else	// otherwise just eject items inside the shunt
		{
			x = from_pos.getX() + 0.5D;
			y = from_pos.getY() + 0.5D;
			z = from_pos.getZ() + 0.5D;
			xVel = 0D;
			yVel = 0D;
			zVel = 0D;
		}
		ItemEntity itementity = new ItemEntity(world, x, y, z, stack);
        itementity.setDefaultPickUpDelay();
        itementity.setDeltaMovement(xVel,yVel,zVel);
        world.addFreshEntity(itementity);
	}
}
