package kirothebluefox.moblocks.content.specialblocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TallFenceGate extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
	public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	private static final VoxelShape CLOSED_NS = Block.makeCuboidShape(0, 0, 6, 16, 24, 10);
	private static final VoxelShape CLOSED_EW = Block.makeCuboidShape(6, 0, 0, 10, 24, 16);
	
	private static final VoxelShape OPEN_LEFT_N = Block.makeCuboidShape(12, 0, 6, 16, 24, 22);
	private static final VoxelShape OPEN_RIGHT_N = Block.makeCuboidShape(0, 0, 6, 4, 24, 22);
	
	private static final VoxelShape OPEN_LEFT_S = Block.makeCuboidShape(0, 0, -6, 4, 24, 10);
	private static final VoxelShape OPEN_RIGHT_S = Block.makeCuboidShape(12, 0, -6, 16, 24, 10);
	
	private static final VoxelShape OPEN_LEFT_E = Block.makeCuboidShape(-6, 0, 12, 10, 24, 16);
	private static final VoxelShape OPEN_RIGHT_E = Block.makeCuboidShape(-6, 0, 0, 10, 24, 4);
	
	private static final VoxelShape OPEN_LEFT_W = Block.makeCuboidShape(6, 0, 0, 22, 24, 4);
	private static final VoxelShape OPEN_RIGHT_W = Block.makeCuboidShape(6, 0, 12, 22, 24, 16);
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);
		boolean opened = state.get(OPEN) == true;
		DoorHingeSide hinge = state.get(HINGE);
		if (direction == Direction.NORTH) {
			if (opened) {
				if (hinge == DoorHingeSide.LEFT) {
					return OPEN_LEFT_N;
				} else {
					return OPEN_RIGHT_N;
				}
			} else {
				return CLOSED_NS;
			}
		} else if (direction == Direction.SOUTH) {
			if (opened) {
				if (hinge == DoorHingeSide.LEFT) {
					return OPEN_LEFT_S;
				} else {
					return OPEN_RIGHT_S;
				}
			} else {
				return CLOSED_NS;
			}
		} else if (direction == Direction.EAST) {
			if (opened) {
				if (hinge == DoorHingeSide.LEFT) {
					return OPEN_LEFT_E;
				} else {
					return OPEN_RIGHT_E;
				}
			} else {
				return CLOSED_EW;
			}
		} else {
			if (opened) {
				if (hinge == DoorHingeSide.LEFT) {
					return OPEN_LEFT_W;
				} else {
					return OPEN_RIGHT_W;
				}
			} else {
				return CLOSED_EW;
			}
		}
	}
	
	public TallFenceGate(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
	      this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(OPEN, Boolean.valueOf(false)).with(HINGE, DoorHingeSide.LEFT).with(POWERED, Boolean.valueOf(false)));
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (facing.getAxis() == Direction.Axis.Y) {
			return facingState.getBlock() == this ? stateIn.with(FACING, facingState.get(FACING)).with(OPEN, facingState.get(OPEN)).with(HINGE, facingState.get(HINGE)).with(POWERED, facingState.get(POWERED)) : Blocks.AIR.getDefaultState();
 	    } else {
 	    	return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
 	    }
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			World world = context.getWorld();
			boolean flag = world.isBlockPowered(blockpos) || world.isBlockPowered(blockpos.up());
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(HINGE, this.getHingeSide(context)).with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag));
		} else {
    	  return null;
		}
	}
	
	private DoorHingeSide getHingeSide(BlockItemUseContext p_208073_1_) {
		IBlockReader iblockreader = p_208073_1_.getWorld();
		BlockPos blockpos = p_208073_1_.getPos();
		Direction direction = p_208073_1_.getPlacementHorizontalFacing();
		Direction direction1 = direction.rotateYCCW();
		BlockPos blockpos2 = blockpos.offset(direction1);
		BlockState blockstate = iblockreader.getBlockState(blockpos2);
		Direction direction2 = direction.rotateY();
		BlockPos blockpos4 = blockpos.offset(direction2);
		BlockState blockstate2 = iblockreader.getBlockState(blockpos4);
		int i = (blockstate.hasOpaqueCollisionShape(iblockreader, blockpos2) ? -1 : 0) + (blockstate2.hasOpaqueCollisionShape(iblockreader, blockpos4) ? 1 : 0);
		boolean flag = blockstate.getBlock() == this;
		boolean flag1 = blockstate2.getBlock() == this;
		if ((!flag || flag1) && i <= 0) {
			if ((!flag1 || flag) && i >= 0) {
				int j = direction.getXOffset();
            	int k = direction.getZOffset();
            	Vector3d vec3d = p_208073_1_.getHitVec();
            	double d0 = vec3d.x - (double)blockpos.getX();
	            double d1 = vec3d.z - (double)blockpos.getZ();
	            return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
			} else {
				return DoorHingeSide.LEFT;
			}
		} else {
			return DoorHingeSide.RIGHT;
		}
	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (this.material == Material.IRON) {
			return ActionResultType.FAIL;
		} else {
			state = state.func_235896_a_(OPEN);
			worldIn.setBlockState(pos, state, 10);
         	worldIn.playEvent(player, state.get(OPEN) ? 1008 : 1014, pos, 0);
         	return ActionResultType.SUCCESS;
		}
	}

	public void toggleDoor(World worldIn, BlockPos pos, boolean open) {
		BlockState blockstate = worldIn.getBlockState(pos);
		if (blockstate.getBlock() == this && blockstate.get(OPEN) != open) {
			worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(open)), 10);
			this.playSound(worldIn, pos, open);
		}
	}
	
	private void playSound(World p_196426_1_, BlockPos p_196426_2_, boolean p_196426_3_) {
		p_196426_1_.playEvent((PlayerEntity)null, p_196426_3_ ? 1008 : 1014, p_196426_2_, 0);
	}

	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.isBlockPowered(pos);
		if (blockIn != this && flag != state.get(POWERED)) {
			if (flag != state.get(OPEN)) {
				this.playSound(worldIn, pos, flag);
			}

			worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)), 2);
		}

	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return state.get(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.get(OPEN);
		default:
			return false;
		}
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.toRotation(state.get(FACING))).func_235896_a_(HINGE);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, OPEN, HINGE, POWERED);
	}
}
