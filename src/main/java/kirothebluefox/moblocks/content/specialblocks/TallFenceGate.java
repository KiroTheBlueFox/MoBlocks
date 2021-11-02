package kirothebluefox.moblocks.content.specialblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class TallFenceGate extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
	public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	private static final VoxelShape CLOSED_NS = Block.box(0, 0, 6, 16, 24, 10);
	private static final VoxelShape CLOSED_EW = Block.box(6, 0, 0, 10, 24, 16);

	private static final VoxelShape OPEN_LEFT_N = Block.box(12, 0, 6, 16, 24, 22);
	private static final VoxelShape OPEN_RIGHT_N = Block.box(0, 0, 6, 4, 24, 22);

	private static final VoxelShape OPEN_LEFT_S = Block.box(0, 0, -6, 4, 24, 10);
	private static final VoxelShape OPEN_RIGHT_S = Block.box(12, 0, -6, 16, 24, 10);

	private static final VoxelShape OPEN_LEFT_E = Block.box(-6, 0, 12, 10, 24, 16);
	private static final VoxelShape OPEN_RIGHT_E = Block.box(-6, 0, 0, 10, 24, 4);

	private static final VoxelShape OPEN_LEFT_W = Block.box(6, 0, 0, 22, 24, 4);
	private static final VoxelShape OPEN_RIGHT_W = Block.box(6, 0, 12, 22, 24, 16);

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);
		boolean opened = state.getValue(OPEN) == true;
		DoorHingeSide hinge = state.getValue(HINGE);
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
		super(Block.Properties.copy(baseBlock));
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.valueOf(false)));
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (facing.getAxis() == Direction.Axis.Y) {
			return facingState.getBlock() == this ? stateIn.setValue(FACING, facingState.getValue(FACING)).setValue(OPEN, facingState.getValue(OPEN)).setValue(HINGE, facingState.getValue(HINGE)).setValue(POWERED, facingState.getValue(POWERED)) : Blocks.AIR.defaultBlockState();
 	    } else {
 	    	return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
 	    }
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
			Level world = context.getLevel();
			boolean flag = world.hasNeighborSignal(blockpos) || world.hasNeighborSignal(blockpos.above());
			return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(HINGE, this.getHingeSide(context)).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag));
		} else {
    	  return null;
		}
	}

	private DoorHingeSide getHingeSide(BlockPlaceContext p_208073_1_) {
		BlockGetter iblockreader = p_208073_1_.getLevel();
		BlockPos blockpos = p_208073_1_.getClickedPos();
		Direction direction = p_208073_1_.getHorizontalDirection();
		Direction direction1 = direction.getCounterClockWise();
		BlockPos blockpos2 = blockpos.relative(direction1);
		BlockState blockstate = iblockreader.getBlockState(blockpos2);
		Direction direction2 = direction.getClockWise();
		BlockPos blockpos4 = blockpos.relative(direction2);
		BlockState blockstate2 = iblockreader.getBlockState(blockpos4);
		int i = (blockstate.isCollisionShapeFullBlock(iblockreader, blockpos2) ? -1 : 0) + (blockstate2.isCollisionShapeFullBlock(iblockreader, blockpos4) ? 1 : 0);
		boolean flag = blockstate.getBlock() == this;
		boolean flag1 = blockstate2.getBlock() == this;
		if ((!flag || flag1) && i <= 0) {
			if ((!flag1 || flag) && i >= 0) {
				int j = direction.getStepX();
            	int k = direction.getStepZ();
            	Vec3 vec3d = p_208073_1_.getClickLocation();
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

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (this.material == Material.METAL) {
			return InteractionResult.FAIL;
		} else {
			state = state.cycle(OPEN);
			worldIn.setBlock(pos, state, 10);
         	worldIn.levelEvent(player, state.getValue(OPEN) ? 1008 : 1014, pos, 0);
         	return InteractionResult.SUCCESS;
		}
	}

	public void toggleDoor(Level worldIn, BlockPos pos, boolean open) {
		BlockState blockstate = worldIn.getBlockState(pos);
		if (blockstate.getBlock() == this && blockstate.getValue(OPEN) != open) {
			worldIn.setBlock(pos, blockstate.setValue(OPEN, Boolean.valueOf(open)), 10);
			this.playSound(worldIn, pos, open);
		}
	}

	private void playSound(Level p_196426_1_, BlockPos p_196426_2_, boolean p_196426_3_) {
		p_196426_1_.levelEvent((Player)null, p_196426_3_ ? 1008 : 1014, p_196426_2_, 0);
	}

	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.hasNeighborSignal(pos);
		if (blockIn != this && flag != state.getValue(POWERED)) {
			if (flag != state.getValue(OPEN)) {
				this.playSound(worldIn, pos, flag);
			}

			worldIn.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
		}

	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		switch(type) {
		case LAND:
			return state.getValue(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.getValue(OPEN);
		default:
			return false;
		}
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.getRotation(state.getValue(FACING))).cycle(HINGE);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, OPEN, HINGE, POWERED);
	}
}
