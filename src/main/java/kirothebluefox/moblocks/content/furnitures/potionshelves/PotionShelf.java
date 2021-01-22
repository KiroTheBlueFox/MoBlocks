package kirothebluefox.moblocks.content.furnitures.potionshelves;

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

public class PotionShelf extends Block implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public static final VoxelShape NORTH = Block.makeCuboidShape(0,0,0,16,16,2);
	public static final VoxelShape SOUTH = Block.makeCuboidShape(0,0,14,16,16,16);
	public static final VoxelShape EAST = Block.makeCuboidShape(14,0,0,16,16,16);
	public static final VoxelShape WEST = Block.makeCuboidShape(0,0,0,2,16,16);
	
	public PotionShelf(Block baseBlock) {
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
		return new PotionShelfTile();
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
     		if (tileentity instanceof PotionShelfTile) {
     			((PotionShelfTile) tileentity).dropItems();
     		}

     		super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		Direction direction = state.get(FACING);
		int slot, layer, rows = 3, columns = 3;
		double x = 0, y = hit.getHitVec().getY()-pos.getY();
		switch (direction) {
		case NORTH:
			x = hit.getHitVec().getX()-pos.getX();
			break;
		case SOUTH:
			x = 1-(hit.getHitVec().getX()-pos.getX());
			break;
		case EAST:
			x = hit.getHitVec().getZ()-pos.getZ();
			break;
		case WEST:
			x = 1-(hit.getHitVec().getZ()-pos.getZ());
			break;
		default:
			slot = -1;
			break;
		}
		if (x > 0.0625 && x < 0.9375 && y > 0.0625 && y < 0.9375) {
			slot = (int) ((3*(x-0.0625))/(0.875));
			layer = (int) ((3*(y-0.0625))/(0.875));
		} else {
			slot = -1;
			layer = -1;
		}
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof PotionShelfTile && slot > -1 && slot < rows*columns+columns) {
			PotionShelfTile shelftileentity = (PotionShelfTile)tileentity;
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
		int slot, layer, rows = 3, columns = 3;
		double x = 0, y = hit.getY()-pos.getY();
		switch (direction) {
		case NORTH:
			x = hit.getX()-pos.getX();
			break;
		case SOUTH:
			x = 1-(hit.getX()-pos.getX());
			break;
		case EAST:
			x = hit.getZ()-pos.getZ();
			break;
		case WEST:
			x = 1-(hit.getZ()-pos.getZ());
			break;
		default:
			slot = -1;
			break;
		}
		if (x > 0.0625 && x < 0.9375 && y > 0.0625 && y < 0.9375) {
			slot = (int) ((3*(x-0.0625))/(0.875));
			layer = (int) ((3*(y-0.0625))/(0.875));
		} else {
			slot = -1;
			layer = -1;
		}
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof PotionShelfTile && slot > -1 && slot < rows*columns+columns) {
			PotionShelfTile shelftileentity = (PotionShelfTile)tileentity;
			return shelftileentity.getItem(layer, slot);
		}
		return ItemStack.EMPTY;
	}
}
