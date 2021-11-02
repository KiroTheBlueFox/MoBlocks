package kirothebluefox.moblocks.content.furnitures.kitchencounters;

import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlock;
import kirothebluefox.moblocks.utils.VoxelShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
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

public abstract class KitchenCounter extends ColorableBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected VoxelShape SHAPE = Shapes.empty();

	public KitchenCounter(Block block) {
		super(block);
		registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		VoxelShapeUtils.Angle angle = VoxelShapeUtils.Angle.Angle0;
		switch (state.getValue(FACING)) {
		case NORTH:
			angle = VoxelShapeUtils.Angle.Angle180;
			break;
		case WEST:
			angle = VoxelShapeUtils.Angle.Angle90;
			break;
		case EAST:
			angle = VoxelShapeUtils.Angle.Angle270;
			break;
		default:
			break;
		}
		return VoxelShapeUtils.rotateYAngle(SHAPE, angle);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER)).setValue(FACING, context.getHorizontalDirection());
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
			worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return facing.getAxis().isHorizontal() ? stateIn : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		switch(type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).is(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}
}
