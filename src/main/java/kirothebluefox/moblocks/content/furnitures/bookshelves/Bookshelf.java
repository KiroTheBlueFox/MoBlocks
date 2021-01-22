package kirothebluefox.moblocks.content.furnitures.bookshelves;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Bookshelf extends Block implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public static final VoxelShape NORTH = Block.makeCuboidShape(0,0,0,16,16,8);
	public static final VoxelShape SOUTH = Block.makeCuboidShape(0,0,8,16,16,16);
	public static final VoxelShape EAST = Block.makeCuboidShape(8,0,0,16,16,16);
	public static final VoxelShape WEST = Block.makeCuboidShape(0,0,0,8,16,16);
	
	public Bookshelf(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return NORTH;
		case SOUTH:
			return SOUTH;
		case EAST:
			return EAST;
		case WEST:
			return WEST;
		default:
			return NORTH;
		}
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new BookshelfTile();
	}
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.shelves.place_item").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
     		if (tileentity instanceof BookshelfTile) {
     			((BookshelfTile) tileentity).dropItems();
     		}

     		super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		Direction direction = state.get(FACING);
		int slot;
		double x = hit.getHitVec().getX()-pos.getX(), y = hit.getHitVec().getY()-pos.getY(), z = hit.getHitVec().getZ()-pos.getZ();
		switch (direction) {
		case NORTH:
			if (x > 0.0625 && x <= 0.1875)
				slot = 6;
			else if (x >= 0.1875 && x <= 0.3125)
				slot = 5;
			else if (x > 0.3125 && x <= 0.4375)
				slot = 4;
			else if (x > 0.4375 && x <= 0.5625)
				slot = 3;
			else if (x > 0.5625 && x <= 0.6875)
				slot = 2;
			else if (x > 0.6875 && x <= 0.8125)
				slot = 1;
			else if (x > 0.8125 && x <= 0.9375)
				slot = 0;
			else
				slot = -1;
			break;
		case SOUTH:
			if (x > 0.0625 && x <= 0.1875)
				slot = 0;
			else if (x >= 0.1875 && x <= 0.3125)
				slot = 1;
			else if (x > 0.3125 && x <= 0.4375)
				slot = 2;
			else if (x > 0.4375 && x <= 0.5625)
				slot = 3;
			else if (x > 0.5625 && x <= 0.6875)
				slot = 4;
			else if (x > 0.6875 && x <= 0.8125)
				slot = 5;
			else if (x > 0.8125 && x <= 0.9375)
				slot = 6;
			else
				slot = -1;
			break;
		case EAST:
			if (z > 0.0625 && z <= 0.1875)
				slot = 0;
			else if (z >= 0.1875 && z <= 0.3125)
				slot = 1;
			else if (z > 0.3125 && z <= 0.4375)
				slot = 2;
			else if (z > 0.4375 && z <= 0.5625)
				slot = 3;
			else if (z > 0.5625 && z <= 0.6875)
				slot = 4;
			else if (z > 0.6875 && z <= 0.8125)
				slot = 5;
			else if (z > 0.8125 && z <= 0.9375)
				slot = 6;
			else
				slot = -1;
			break;
		case WEST:
			if (z > 0.0625 && z <= 0.1875)
				slot = 6;
			else if (z >= 0.1875 && z <= 0.3125)
				slot = 5;
			else if (z > 0.3125 && z <= 0.4375)
				slot = 4;
			else if (z > 0.4375 && z <= 0.5625)
				slot = 3;
			else if (z > 0.5625 && z <= 0.6875)
				slot = 2;
			else if (z > 0.6875 && z <= 0.8125)
				slot = 1;
			else if (z > 0.8125 && z <= 0.9375)
				slot = 0;
			else
				slot = -1;
			break;
		default:
			slot = -1;
			break;
		}
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof BookshelfTile && slot > -1 && slot < 14) {
			int layer = (y > 0.5 ? 0 : 1);
			BookshelfTile shelftileentity = (BookshelfTile)tileentity;
			if (!player.isSneaking()) {
				ItemStack itemstack = player.getHeldItem(handIn);
				shelftileentity.addItem(itemstack, layer, slot, player, handIn);
			}
		} else {
			return ActionResultType.FAIL;
		}
		return ActionResultType.SUCCESS;
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)).with(FACING, context.getPlacementHorizontalFacing());
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

	public ItemStack getItemAtHit(ClientWorld worldIn, BlockState state, Vector3d hit, BlockPos pos) {
		Direction direction = state.get(FACING);
		int slot;
		double x = hit.getX()-pos.getX(), y = hit.getY()-pos.getY(), z = hit.getZ()-pos.getZ();
		switch (direction) {
		case NORTH:
			if (x > 0.0625 && x <= 0.1875)
				slot = 6;
			else if (x >= 0.1875 && x <= 0.3125)
				slot = 5;
			else if (x > 0.3125 && x <= 0.4375)
				slot = 4;
			else if (x > 0.4375 && x <= 0.5625)
				slot = 3;
			else if (x > 0.5625 && x <= 0.6875)
				slot = 2;
			else if (x > 0.6875 && x <= 0.8125)
				slot = 1;
			else if (x > 0.8125 && x <= 0.9375)
				slot = 0;
			else
				slot = -1;
			break;
		case SOUTH:
			if (x > 0.0625 && x <= 0.1875)
				slot = 0;
			else if (x >= 0.1875 && x <= 0.3125)
				slot = 1;
			else if (x > 0.3125 && x <= 0.4375)
				slot = 2;
			else if (x > 0.4375 && x <= 0.5625)
				slot = 3;
			else if (x > 0.5625 && x <= 0.6875)
				slot = 4;
			else if (x > 0.6875 && x <= 0.8125)
				slot = 5;
			else if (x > 0.8125 && x <= 0.9375)
				slot = 6;
			else
				slot = -1;
			break;
		case EAST:
			if (z > 0.0625 && z <= 0.1875)
				slot = 0;
			else if (z >= 0.1875 && z <= 0.3125)
				slot = 1;
			else if (z > 0.3125 && z <= 0.4375)
				slot = 2;
			else if (z > 0.4375 && z <= 0.5625)
				slot = 3;
			else if (z > 0.5625 && z <= 0.6875)
				slot = 4;
			else if (z > 0.6875 && z <= 0.8125)
				slot = 5;
			else if (z > 0.8125 && z <= 0.9375)
				slot = 6;
			else
				slot = -1;
			break;
		case WEST:
			if (z > 0.0625 && z <= 0.1875)
				slot = 6;
			else if (z >= 0.1875 && z <= 0.3125)
				slot = 5;
			else if (z > 0.3125 && z <= 0.4375)
				slot = 4;
			else if (z > 0.4375 && z <= 0.5625)
				slot = 3;
			else if (z > 0.5625 && z <= 0.6875)
				slot = 2;
			else if (z > 0.6875 && z <= 0.8125)
				slot = 1;
			else if (z > 0.8125 && z <= 0.9375)
				slot = 0;
			else
				slot = -1;
			break;
		default:
			slot = -1;
			break;
		}
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof BookshelfTile && slot > -1 && slot < 14) {
			int layer = (y > 0.5 ? 0 : 1);
			BookshelfTile shelftileentity = (BookshelfTile)tileentity;
			return shelftileentity.getItem(layer, slot);
		}
		return ItemStack.EMPTY;
	}
}
