package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SimpleDrawer extends Block implements IWaterLoggable {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private Block baseBlock;

	private static final VoxelShape foot1 = Block.makeCuboidShape(0, 0, 0, 2, 8, 2);
	private static final VoxelShape foot2 = Block.makeCuboidShape(14, 0, 0, 16, 8, 2);
	private static final VoxelShape foot3 = Block.makeCuboidShape(0, 0, 14, 2, 8, 16);
	private static final VoxelShape foot4 = Block.makeCuboidShape(14, 0, 14, 16, 8, 16);
	private static final VoxelShape container = Block.makeCuboidShape(0, 8, 0, 16, 16, 16);
	private static final VoxelShape SHAPE = VoxelShapes.or(foot1, foot2, foot3, foot4, container);
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	public SimpleDrawer(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
		this.baseBlock = baseBlock;
		setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new SimpleDrawerTile();
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote && handIn.equals(Hand.MAIN_HAND)) {
			worldIn.notifyBlockUpdate(pos, state, state, 2);
			if (isBlocked(state, worldIn, pos)) {
				player.sendStatusMessage(new TranslationTextComponent("status_messages.moblocks.drawers.is_blocked"), true);
			} else {
				TileEntity tileEntity = worldIn.getTileEntity(pos);
				if (tileEntity instanceof SimpleDrawerTile) {
					if (((SimpleDrawerTile)tileEntity).isOpened()) {
						player.sendStatusMessage(new TranslationTextComponent("status_messages.moblocks.drawers.already_in_use"), true);
					} else {
						NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
					}
				}
			}
		}
		return ActionResultType.SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
     		if (tileentity instanceof SimpleDrawerTile) {
     			((SimpleDrawerTile) tileentity).dropItems();
     		}

     		super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}
	
	private static boolean isBlocked(BlockState stateIn, IWorld worldIn, BlockPos pos) {
		return isFrontSolidBlock(worldIn, pos, stateIn);
	}

	private static boolean isFrontSolidBlock(IBlockReader worldIn, BlockPos pos, BlockState stateIn) {
		BlockPos blockpos = pos.offset(stateIn.get(FACING).getOpposite());
		return worldIn.getBlockState(blockpos).isNormalCube(worldIn, blockpos);
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

	public Block getBaseBlock() {
		return this.baseBlock;
	}
}
