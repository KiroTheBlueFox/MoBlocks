package kirothebluefox.moblocks.content.specialblocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class VerticalStairs extends HorizontalBlock implements IWaterLoggable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	/* Facing West */
	protected static final double[][] West = {{8, 0, 0, 16, 16, 16},
	                                          {0, 0, 8, 8, 16, 16}};
	protected static final VoxelShape WestPart1 = Block.makeCuboidShape(West[0][0], West[0][1], West[0][2], West[0][3], West[0][4], West[0][5]);
	protected static final VoxelShape WestPart2 = Block.makeCuboidShape(West[1][0], West[1][1], West[1][2], West[1][3], West[1][4], West[1][5]);
	private static final VoxelShape FULL_WEST_SHAPE = VoxelShapes.or(WestPart1, WestPart2);
	
	/* Facing East */
	protected static final double[][] East = {{0, 0, 0, 8, 16, 16},
	                                          {8, 0, 0, 16, 16, 8}};
	protected static final VoxelShape EastPart1 = Block.makeCuboidShape(East[0][0], East[0][1], East[0][2], East[0][3], East[0][4], East[0][5]);
	protected static final VoxelShape EastPart2 = Block.makeCuboidShape(East[1][0], East[1][1], East[1][2], East[1][3], East[1][4], East[1][5]);
	private static final VoxelShape FULL_EAST_SHAPE = VoxelShapes.or(EastPart1, EastPart2);

	/* Facing North */
	protected static final double[][] North = {{0, 0, 8, 16, 16, 16},
	                                           {0, 0, 0, 8, 16, 8}};
	protected static final VoxelShape NorthPart1 = Block.makeCuboidShape(North[0][0], North[0][1], North[0][2], North[0][3], North[0][4], North[0][5]);
	protected static final VoxelShape NorthPart2 = Block.makeCuboidShape(North[1][0], North[1][1], North[1][2], North[1][3], North[1][4], North[1][5]);
	private static final VoxelShape FULL_NORTH_SHAPE = VoxelShapes.or(NorthPart1, NorthPart2);

	/* Facing South */
	protected static final double[][] South = {{8, 0, 0, 16, 16, 16},
	                                                {0, 0, 0, 8, 16, 8}};
	protected static final VoxelShape SouthPart1 = Block.makeCuboidShape(South[0][0], South[0][1], South[0][2], South[0][3], South[0][4], South[0][5]);
	protected static final VoxelShape SouthPart2 = Block.makeCuboidShape(South[1][0], South[1][1], South[1][2], South[1][3], South[1][4], South[1][5]);
	private static final VoxelShape FULL_SOUTH_SHAPE = VoxelShapes.or(SouthPart1, SouthPart2);
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(FACING) == Direction.WEST) {
		    return FULL_WEST_SHAPE;
		} else if (state.get(FACING) == Direction.EAST) {
		    return FULL_EAST_SHAPE;
		} else if (state.get(FACING) == Direction.SOUTH) {
		    return FULL_SOUTH_SHAPE;
		} else {
		    return FULL_NORTH_SHAPE;
		}
	}
	
	public VerticalStairs(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
	    this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING, WATERLOGGED);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		BlockState blockstate = this.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
		float direction = (context.getPlayer().getYaw(1.0F))%360;
		if (direction < 0) direction += 360.0F;
		if (direction >= 180.0F && direction < 270.0F) {
			return blockstate.with(FACING, Direction.SOUTH);
		} else if (direction >= 90.0F && direction < 180.0F) {
			return blockstate.with(FACING, Direction.EAST);
		} else if (direction >= 270.0F) {
			return blockstate.with(FACING, Direction.WEST);
		} else {
			return blockstate;
		}
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
	   return IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}
}
