package kirothebluefox.moblocks.content.furnitures.kitchencounters;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class InnerCornerKitchenCounter extends KitchenCounter {
	private static final VoxelShape PLANKS1 = Block.makeCuboidShape(0, 0, 1, 16, 15, 16);
	private static final VoxelShape PLANKS2 = Block.makeCuboidShape(1, 0, 0, 16, 15, 1);
	private static final VoxelShape COUNTER1 = Block.makeCuboidShape(0, 15, 0, 16, 16, 16);
	private static final VoxelShape COUNTER2 = Block.makeCuboidShape(0, 16, 15, 16, 18, 16);
	private static final VoxelShape COUNTER3 = Block.makeCuboidShape(15, 16, 0, 16, 18, 15);
	
	public InnerCornerKitchenCounter(Block block) {
		super(block);
		super.SHAPE = VoxelShapes.or(PLANKS1, PLANKS2, COUNTER1, COUNTER2, COUNTER3);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		BlockState blockstate = this.getDefaultState().with(FACING, Direction.WEST).with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
		float direction = (context.getPlayer().getYaw(1.0F))%360;
		if (direction < 0) direction += 360.0F;
		if (direction >= 180.0F && direction < 270.0F) {
			return blockstate.with(FACING, Direction.EAST);
		} else if (direction >= 90.0F && direction < 180.0F) {
			return blockstate.with(FACING, Direction.NORTH);
		} else if (direction >= 270.0F) {
			return blockstate.with(FACING, Direction.SOUTH);
		} else {
			return blockstate;
		}
	}
}
