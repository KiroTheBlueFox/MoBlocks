package kirothebluefox.moblocks.content.specialblocks;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.content.customproperties.VerticalSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
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

public class VerticalSlab extends HorizontalBlock implements IWaterLoggable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<VerticalSlabType> TYPE = CustomBlockStateProperties.VERTICAL_SLAB_TYPE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	protected static final double[][] AllCollisions = {{0, 0, 8, 16, 16, 16},   /* North */
											           {0, 0, 0, 16, 16, 8},    /* South */
											           {0, 0, 0, 8, 16, 16},    /* East  */
											           {8, 0, 0, 16, 16, 16}};  /* West  */
	protected static final VoxelShape FacingNorth = Block.makeCuboidShape(AllCollisions[0][0], AllCollisions[0][1], AllCollisions[0][2], AllCollisions[0][3], AllCollisions[0][4], AllCollisions[0][5]);
	protected static final VoxelShape FacingSouth = Block.makeCuboidShape(AllCollisions[1][0], AllCollisions[1][1], AllCollisions[1][2], AllCollisions[1][3], AllCollisions[1][4], AllCollisions[1][5]);
	protected static final VoxelShape FacingEast = Block.makeCuboidShape(AllCollisions[2][0], AllCollisions[2][1], AllCollisions[2][2], AllCollisions[2][3], AllCollisions[2][4], AllCollisions[2][5]);
	protected static final VoxelShape FacingWest = Block.makeCuboidShape(AllCollisions[3][0], AllCollisions[3][1], AllCollisions[3][2], AllCollisions[3][3], AllCollisions[3][4], AllCollisions[3][5]);
	private static final VoxelShape FULL_FACING_NORTH = VoxelShapes.or(FacingNorth);
	private static final VoxelShape FULL_FACING_SOUTH = VoxelShapes.or(FacingSouth);
	private static final VoxelShape FULL_FACING_EAST = VoxelShapes.or(FacingEast);
	private static final VoxelShape FULL_FACING_WEST = VoxelShapes.or(FacingWest);
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(TYPE) == VerticalSlabType.DOUBLE) {
			return VoxelShapes.fullCube();
		} else {
			if (state.get(FACING) == Direction.NORTH) {
				return FULL_FACING_NORTH;
			} else if (state.get(FACING) == Direction.SOUTH) {
				return FULL_FACING_SOUTH;
			} else if (state.get(FACING) == Direction.EAST) {
				return FULL_FACING_EAST;
			} else if (state.get(FACING) == Direction.WEST) {
				return FULL_FACING_WEST;
			} else {
				return null;
			}
		}
	}
	
	public VerticalSlab(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
	    this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}


	public boolean func_220074_n(BlockState state) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE;
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING, TYPE, WATERLOGGED);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		BlockState blockstate = context.getWorld().getBlockState(blockpos);
		if (blockstate.getBlock() == this) {
			return blockstate.with(TYPE, VerticalSlabType.DOUBLE).with(WATERLOGGED, Boolean.valueOf(false));
		} else {
			FluidState FluidState = context.getWorld().getFluidState(blockpos);
			BlockState blockstate1 = this.getDefaultState().with(TYPE, VerticalSlabType.SINGLE).with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
			Direction direction = context.getPlacementHorizontalFacing();
			if (direction == Direction.NORTH) {
				return blockstate1.with(FACING, Direction.SOUTH);
			} else if (direction == Direction.WEST) {
				return blockstate1.with(FACING, Direction.EAST);
			} else if (direction == Direction.EAST) {
				return blockstate1.with(FACING, Direction.WEST);
			} else {
				return blockstate1;
			}
		}
	}

	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		ItemStack itemstack = useContext.getItem();
	    VerticalSlabType slabtype = state.get(TYPE);
		Direction facing = state.get(FACING);
		if (slabtype != VerticalSlabType.DOUBLE && itemstack.getItem() == this.asItem()) {
			if (useContext.replacingClickedOnBlock()) {
				Direction direction = useContext.getFace();
				if (direction == Direction.NORTH) {
					return facing == Direction.NORTH;
				} else if (direction == Direction.WEST) {
					return facing == Direction.WEST;
				} else if (direction == Direction.EAST) {
					return facing == Direction.EAST;
				} else {
					return facing == Direction.SOUTH;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE ? IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn) : false;
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
	   return state.get(TYPE) != VerticalSlabType.DOUBLE ? IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn) : false;
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
