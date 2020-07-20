package kirothebluefox.moblocks.content.furnitures;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.customproperties.CustomBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class Table extends Block implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final BooleanProperty NORTH = CustomBlockStateProperties.NORTH;
	private static final BooleanProperty SOUTH = CustomBlockStateProperties.SOUTH;
	private static final BooleanProperty EAST = CustomBlockStateProperties.EAST;
	private static final BooleanProperty WEST = CustomBlockStateProperties.WEST;
	private static final BooleanProperty NORTH_WEST = CustomBlockStateProperties.NORTH_WEST;
	private static final BooleanProperty NORTH_EAST = CustomBlockStateProperties.NORTH_EAST;
	private static final BooleanProperty SOUTH_WEST = CustomBlockStateProperties.SOUTH_WEST;
	private static final BooleanProperty SOUTH_EAST = CustomBlockStateProperties.SOUTH_EAST;
	
	protected static final VoxelShape TOP = Block.makeCuboidShape(0, 14, 0, 16, 16, 16);
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return TOP;
	}
	
	public Table(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
	    this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false)
	    		.with(NORTH, false)
	    		.with(SOUTH, false)
	    		.with(EAST, false)
	    		.with(WEST, false)
	    		.with(NORTH_WEST, false)
	    		.with(NORTH_EAST, false)
	    		.with(SOUTH_WEST, false)
	    		.with(SOUTH_EAST, false));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, SOUTH, EAST, WEST, NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST, WATERLOGGED);
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		IWorld world = context.getWorld();
		BlockState blockstate = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
		blockstate = forEachDirections(blockstate, world, blockpos);
		return blockstate;
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/**
	 * Test if the block is a table or not
	 * 
	 * @param direction N, S, E, W, NW, NE, SW or SE
	 * @param stateIn
	 * @param worldIn
	 * @param currentPos
	 * @return true or false
	 */
	private boolean isBlockAtTable(String direction, BlockState stateIn, IWorld worldIn, BlockPos currentPos) {
		BlockPos blockToTest;
		switch (direction.toLowerCase()) {
		case "n":
			blockToTest = currentPos.north();
			break;
		case "s":
			blockToTest = currentPos.south();
			break;
		case "e":
			blockToTest = currentPos.east();
			break;
		case "w":
			blockToTest = currentPos.west();
			break;
		case "ne":
			blockToTest = currentPos.north().east();
			break;
		case "nw":
			blockToTest = currentPos.north().west();
			break;
		case "se":
			blockToTest = currentPos.south().east();
			break;
		case "sw":
			blockToTest = currentPos.south().west();
			break;
		default:
			return false;
		}
	    Block block = worldIn.getBlockState(blockToTest).getBlock();
	    return block.getTags().contains(new ResourceLocation(MoBlocks.MODID, "tables"));
	}
	
	public BlockState forEachDirections(BlockState stateIn, IWorld worldIn, BlockPos currentPos) {
		Map<String, BooleanProperty> allDirections = new HashMap<String, BooleanProperty>();
		BlockState[] state = {stateIn};
		allDirections.put("N", NORTH);
		allDirections.put("S", SOUTH);
		allDirections.put("E", EAST);
		allDirections.put("W", WEST);
		allDirections.put("NE", NORTH_EAST);
		allDirections.put("NW", NORTH_WEST);
		allDirections.put("SE", SOUTH_EAST);
		allDirections.put("SW", SOUTH_WEST);
		allDirections.forEach((direction, property) -> {
			state[0] = state[0].with(property, isBlockAtTable(direction, stateIn, worldIn, currentPos));
		});
		return state[0];
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
		
		stateIn = forEachDirections(stateIn, worldIn, currentPos);
		return facing.getAxis().isHorizontal() ? stateIn : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
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
