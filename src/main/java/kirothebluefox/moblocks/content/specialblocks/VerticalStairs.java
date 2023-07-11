package kirothebluefox.moblocks.content.specialblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class VerticalStairs extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	/* Facing West */
	protected static final double[][] West = {{8, 0, 0, 16, 16, 16},
	                                          {0, 0, 8, 8, 16, 16}};
	protected static final VoxelShape WestPart1 = Block.box(West[0][0], West[0][1], West[0][2], West[0][3], West[0][4], West[0][5]);
	protected static final VoxelShape WestPart2 = Block.box(West[1][0], West[1][1], West[1][2], West[1][3], West[1][4], West[1][5]);
	private static final VoxelShape FULL_WEST_SHAPE = Shapes.or(WestPart1, WestPart2);

	/* Facing East */
	protected static final double[][] East = {{0, 0, 0, 8, 16, 16},
	                                          {8, 0, 0, 16, 16, 8}};
	protected static final VoxelShape EastPart1 = Block.box(East[0][0], East[0][1], East[0][2], East[0][3], East[0][4], East[0][5]);
	protected static final VoxelShape EastPart2 = Block.box(East[1][0], East[1][1], East[1][2], East[1][3], East[1][4], East[1][5]);
	private static final VoxelShape FULL_EAST_SHAPE = Shapes.or(EastPart1, EastPart2);

	/* Facing North */
	protected static final double[][] North = {{0, 0, 8, 16, 16, 16},
	                                           {0, 0, 0, 8, 16, 8}};
	protected static final VoxelShape NorthPart1 = Block.box(North[0][0], North[0][1], North[0][2], North[0][3], North[0][4], North[0][5]);
	protected static final VoxelShape NorthPart2 = Block.box(North[1][0], North[1][1], North[1][2], North[1][3], North[1][4], North[1][5]);
	private static final VoxelShape FULL_NORTH_SHAPE = Shapes.or(NorthPart1, NorthPart2);

	/* Facing South */
	protected static final double[][] South = {{8, 0, 0, 16, 16, 16},
	                                                {0, 0, 0, 8, 16, 8}};
	protected static final VoxelShape SouthPart1 = Block.box(South[0][0], South[0][1], South[0][2], South[0][3], South[0][4], South[0][5]);
	protected static final VoxelShape SouthPart2 = Block.box(South[1][0], South[1][1], South[1][2], South[1][3], South[1][4], South[1][5]);
	private static final VoxelShape FULL_SOUTH_SHAPE = Shapes.or(SouthPart1, SouthPart2);

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		if (state.getValue(FACING) == Direction.WEST) {
		    return FULL_WEST_SHAPE;
		} else if (state.getValue(FACING) == Direction.EAST) {
		    return FULL_EAST_SHAPE;
		} else if (state.getValue(FACING) == Direction.SOUTH) {
		    return FULL_SOUTH_SHAPE;
		} else {
		    return FULL_NORTH_SHAPE;
		}
	}

	public VerticalStairs(Block baseBlock) {
		super(Block.Properties.copy(baseBlock));
	    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		FluidState FluidState = context.getLevel().getFluidState(blockpos);
		BlockState blockstate = this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
		float direction = (context.getPlayer().getViewYRot(1.0F))%360;
		if (direction < 0) direction += 360.0F;
		if (direction >= 180.0F && direction < 270.0F) {
			return blockstate.setValue(FACING, Direction.SOUTH);
		} else if (direction >= 90.0F && direction < 180.0F) {
			return blockstate.setValue(FACING, Direction.EAST);
		} else if (direction >= 270.0F) {
			return blockstate.setValue(FACING, Direction.WEST);
		} else {
			return blockstate;
		}
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return SimpleWaterloggedBlock.super.placeLiquid(worldIn, pos, state, fluidStateIn);
	}

	public boolean canPlaceLiquid(BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
	   return SimpleWaterloggedBlock.super.canPlaceLiquid(worldIn, pos, state, fluidIn);
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		switch(type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).getValue(WATERLOGGED);
		case AIR:
			return false;
		default:
			return false;
		}
	}
}
