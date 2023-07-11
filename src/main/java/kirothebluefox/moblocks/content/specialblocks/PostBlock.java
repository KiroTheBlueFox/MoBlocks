package kirothebluefox.moblocks.content.specialblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class PostBlock extends Block implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	protected static final VoxelShape Shape = Block.box(5,0,5,11,16,11);

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return Shape;
	}

	public PostBlock(Block baseBlock) {
		super(Block.Properties.copy(baseBlock));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}


	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		FluidState FluidState = context.getLevel().getFluidState(blockpos);
	    BlockState blockstate = this.defaultBlockState();
        return blockstate.setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
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

	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
}
