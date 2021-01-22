package kirothebluefox.moblocks.content.furnitures.kitchencounters;

import kirothebluefox.moblocks.utils.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class OuterCornerKitchenCounter extends KitchenCounter {
	private static final VoxelShape PLANKS = Block.makeCuboidShape(1, 0, 1, 16, 15, 16);
	private static final VoxelShape COUNTER1 = Block.makeCuboidShape(0, 15, 0, 16, 16, 16);
	private static final VoxelShape COUNTER2 = Block.makeCuboidShape(15, 16, 15, 16, 18, 16);
	
	public OuterCornerKitchenCounter(Block block) {
		super(block);
		super.SHAPE = VoxelShapes.or(PLANKS,COUNTER1,COUNTER2);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		VoxelShapeUtils.Angle angle = VoxelShapeUtils.Angle.Angle0;
		switch (state.get(FACING)) {
		case WEST:
			angle = VoxelShapeUtils.Angle.Angle180;
			break;
		case SOUTH:
			angle = VoxelShapeUtils.Angle.Angle90;
			break;
		case NORTH:
			angle = VoxelShapeUtils.Angle.Angle270;
			break;
		default:
			break;
		}
		return VoxelShapeUtils.rotateYAngle(SHAPE, angle);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		BlockState blockstate = this.getDefaultState().with(FACING, Direction.SOUTH).with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
		float direction = (context.getPlayer().getYaw(1.0F))%360;
		if (direction < 0) direction += 360.0F;
		if (direction >= 180.0F && direction < 270.0F) {
			return blockstate.with(FACING, Direction.NORTH);
		} else if (direction >= 90.0F && direction < 180.0F) {
			return blockstate.with(FACING, Direction.WEST);
		} else if (direction >= 270.0F) {
			return blockstate.with(FACING, Direction.EAST);
		} else {
			return blockstate;
		}
	}
}
