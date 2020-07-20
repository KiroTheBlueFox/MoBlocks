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

public class LowerSmallArch extends HorizontalBlock implements IWaterLoggable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	/* NS */
	protected static final double[][] NS = {{0, 0, 0, 1, 16, 16},
	                                        {15, 0, 0, 16, 16, 16},
	                                        {1, 3, 0, 2, 16, 16},
	                                        {14, 3, 0, 15, 16, 16},
	                                        {2, 5, 0, 3, 16, 16},
	                                        {13, 5, 0, 14, 16, 16},
	                                        {3, 6, 0, 5, 16, 16},
	                                        {11, 6, 0, 13, 16, 16},
	                                        {5, 7, 0, 11, 16, 16}};
	protected static final VoxelShape NSPart1 = Block.makeCuboidShape(NS[0][0], NS[0][1], NS[0][2], NS[0][3], NS[0][4], NS[0][5]);
	protected static final VoxelShape NSPart2 = Block.makeCuboidShape(NS[1][0], NS[1][1], NS[1][2], NS[1][3], NS[1][4], NS[1][5]);
	protected static final VoxelShape NSPart3 = Block.makeCuboidShape(NS[2][0], NS[2][1], NS[2][2], NS[2][3], NS[2][4], NS[2][5]);
	protected static final VoxelShape NSPart4 = Block.makeCuboidShape(NS[3][0], NS[3][1], NS[3][2], NS[3][3], NS[3][4], NS[3][5]);
	protected static final VoxelShape NSPart5 = Block.makeCuboidShape(NS[4][0], NS[4][1], NS[4][2], NS[4][3], NS[4][4], NS[4][5]);
	protected static final VoxelShape NSPart6 = Block.makeCuboidShape(NS[5][0], NS[5][1], NS[5][2], NS[5][3], NS[5][4], NS[5][5]);
	protected static final VoxelShape NSPart7 = Block.makeCuboidShape(NS[6][0], NS[6][1], NS[6][2], NS[6][3], NS[6][4], NS[6][5]);
	protected static final VoxelShape NSPart8 = Block.makeCuboidShape(NS[7][0], NS[7][1], NS[7][2], NS[7][3], NS[7][4], NS[7][5]);
	protected static final VoxelShape NSPart9 = Block.makeCuboidShape(NS[8][0], NS[8][1], NS[8][2], NS[8][3], NS[8][4], NS[8][5]);
	private static final VoxelShape FULL_NS_SHAPE = VoxelShapes.or(NSPart1, NSPart2, NSPart3, NSPart4, NSPart5, NSPart6, NSPart7, NSPart8, NSPart9);

	/* EW */
	protected static final double[][] EW = {{0, 0, 0, 16, 16, 1},
	                                        {0, 0, 15, 16, 16, 16},
	                                        {0, 3, 1, 16, 16, 2},
	                                        {0, 3, 14, 16, 16, 15},
	                                        {0, 5, 2, 16, 16, 3},
	                                        {0, 5, 13, 16, 16, 14},
	                                        {0, 6, 3, 16, 16, 5},
	                                        {0, 6, 11, 16, 16, 13},
	                                        {0, 7, 5, 16, 16, 11}};
	protected static final VoxelShape EWPart1 = Block.makeCuboidShape(EW[0][0], EW[0][1], EW[0][2], EW[0][3], EW[0][4], EW[0][5]);
	protected static final VoxelShape EWPart2 = Block.makeCuboidShape(EW[1][0], EW[1][1], EW[1][2], EW[1][3], EW[1][4], EW[1][5]);
	protected static final VoxelShape EWPart3 = Block.makeCuboidShape(EW[2][0], EW[2][1], EW[2][2], EW[2][3], EW[2][4], EW[2][5]);
	protected static final VoxelShape EWPart4 = Block.makeCuboidShape(EW[3][0], EW[3][1], EW[3][2], EW[3][3], EW[3][4], EW[3][5]);
	protected static final VoxelShape EWPart5 = Block.makeCuboidShape(EW[4][0], EW[4][1], EW[4][2], EW[4][3], EW[4][4], EW[4][5]);
	protected static final VoxelShape EWPart6 = Block.makeCuboidShape(EW[5][0], EW[5][1], EW[5][2], EW[5][3], EW[5][4], EW[5][5]);
	protected static final VoxelShape EWPart7 = Block.makeCuboidShape(EW[6][0], EW[6][1], EW[6][2], EW[6][3], EW[6][4], EW[6][5]);
	protected static final VoxelShape EWPart8 = Block.makeCuboidShape(EW[7][0], EW[7][1], EW[7][2], EW[7][3], EW[7][4], EW[7][5]);
	protected static final VoxelShape EWPart9 = Block.makeCuboidShape(EW[8][0], EW[8][1], EW[8][2], EW[8][3], EW[8][4], EW[8][5]);
	private static final VoxelShape FULL_EW_SHAPE = VoxelShapes.or(EWPart1, EWPart2, EWPart3, EWPart4, EWPart5, EWPart6, EWPart7, EWPart8, EWPart9);
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	    if (state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH) {
	    	return FULL_NS_SHAPE;
	    } else {
	    	return FULL_EW_SHAPE;
	    }
	}
	
	public LowerSmallArch(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
	    this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, FACING);
	}
	


	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		BlockState blockstate = this.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
		Direction direction = context.getPlacementHorizontalFacing();
		if (direction == Direction.NORTH) {
			return blockstate.with(FACING, Direction.SOUTH);
		} else if (direction == Direction.WEST) {
			return blockstate.with(FACING, Direction.EAST);
		} else if (direction == Direction.EAST) {
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
