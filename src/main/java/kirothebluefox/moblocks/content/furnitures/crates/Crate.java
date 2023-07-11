package kirothebluefox.moblocks.content.furnitures.crates;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class Crate extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public Crate(Block baseBlock) {
		super(Block.Properties.copy(baseBlock).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		Direction direction = state.getValue(FACING);
		int slot;
		double x = hit.getLocation().x() - pos.getX();
		double z = hit.getLocation().z() - pos.getZ();
		switch (direction) {
		case NORTH:
			if (x >= 0.125 && x < 0.3125) {
				slot = 0;
			} else if (x >= 0.3125 && x < 0.5) {
				slot = 1;
			} else if (x >= 0.5 && x < 0.6875) {
				slot = 2;
			} else if (x >= 0.6875 && x <= 0.875) {
				slot = 3;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (z >= 0.125 && z < 0.3125) {
				} else if (z >= 0.3125 && z < 0.5) {
					slot += 4;
				} else if (z >= 0.5 && z < 0.6875) {
					slot += 8;
				} else if (z >= 0.6875 && z <= 0.875) {
					slot += 12;
				} else {
					slot = -1;
				}
			}
			break;
		case SOUTH:
			if (x >= 0.125 && x < 0.3125) {
				slot = 3;
			} else if (x >= 0.3125 && x < 0.5) {
				slot = 2;
			} else if (x >= 0.5 && x < 0.6875) {
				slot = 1;
			} else if (x >= 0.6875 && x <= 0.875) {
				slot = 0;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (z >= 0.125 && z < 0.3125) {
					slot += 12;
				} else if (z >= 0.3125 && z < 0.5) {
					slot += 8;
				} else if (z >= 0.5 && z < 0.6875) {
					slot += 4;
				} else if (z >= 0.6875 && z <= 0.875) {
				} else {
					slot = -1;
				}
			}
			break;
		case EAST:
			if (z >= 0.125 && z < 0.3125) {
				slot = 0;
			} else if (z >= 0.3125 && z < 0.5) {
				slot = 1;
			} else if (z >= 0.5 && z < 0.6875) {
				slot = 2;
			} else if (z >= 0.6875 && z <= 0.875) {
				slot = 3;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (x >= 0.125 && x < 0.3125) {
				} else if (x >= 0.3125 && x < 0.5) {
					slot += 4;
				} else if (x >= 0.5 && x < 0.6875) {
					slot += 8;
				} else if (x >= 0.6875 && x <= 0.875) {
					slot += 12;
				} else {
					slot = -1;
				}
			}
			break;
		case WEST:
			if (z >= 0.125 && z < 0.3125) {
				slot = 3;
			} else if (z >= 0.3125 && z < 0.5) {
				slot = 2;
			} else if (z >= 0.5 && z < 0.6875) {
				slot = 1;
			} else if (z >= 0.6875 && z <= 0.875) {
				slot = 0;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (x >= 0.125 && x < 0.3125) {
					slot += 12;
				} else if (x >= 0.3125 && x < 0.5) {
					slot += 8;
				} else if (x >= 0.5 && x < 0.6875) {
					slot += 4;
				} else if (x >= 0.6875 && x <= 0.875) {
				} else {
					slot = -1;
				}
			}
			break;
		default:
			slot = 0;
			break;
		}
		BlockEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof CrateTile) {
			CrateTile cratetileentity = (CrateTile)tileentity;
			if (slot >= 0 && slot < 16) {
				if (!player.isShiftKeyDown()) {
					ItemStack itemstack = player.getItemInHand(handIn);
					cratetileentity.addItem(itemstack, slot, player, handIn);
				}
			} else {
				if (player.isShiftKeyDown()) {
					cratetileentity.nextLayer();
				}
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CrateTile(pos, state);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
     		if (tileentity instanceof CrateTile) {
     			((CrateTile) tileentity).dropItems();
     		}

     		super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

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
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return facing.getAxis().isHorizontal() ? stateIn : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
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

	public ItemStack getItemAtHit(ClientLevel worldIn, BlockState state, Vec3 hit, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		int slot;
		double x = hit.x() - pos.getX();
		double z = hit.z() - pos.getZ();
		switch (direction) {
		case NORTH:
			if (x >= 0.125 && x < 0.3125) {
				slot = 0;
			} else if (x >= 0.3125 && x < 0.5) {
				slot = 1;
			} else if (x >= 0.5 && x < 0.6875) {
				slot = 2;
			} else if (x >= 0.6875 && x <= 0.875) {
				slot = 3;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (z >= 0.125 && z < 0.3125) {
				} else if (z >= 0.3125 && z < 0.5) {
					slot += 4;
				} else if (z >= 0.5 && z < 0.6875) {
					slot += 8;
				} else if (z >= 0.6875 && z <= 0.875) {
					slot += 12;
				} else {
					slot = -1;
				}
			}
			break;
		case SOUTH:
			if (x >= 0.125 && x < 0.3125) {
				slot = 3;
			} else if (x >= 0.3125 && x < 0.5) {
				slot = 2;
			} else if (x >= 0.5 && x < 0.6875) {
				slot = 1;
			} else if (x >= 0.6875 && x <= 0.875) {
				slot = 0;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (z >= 0.125 && z < 0.3125) {
					slot += 12;
				} else if (z >= 0.3125 && z < 0.5) {
					slot += 8;
				} else if (z >= 0.5 && z < 0.6875) {
					slot += 4;
				} else if (z >= 0.6875 && z <= 0.875) {
				} else {
					slot = -1;
				}
			}
			break;
		case EAST:
			if (z >= 0.125 && z < 0.3125) {
				slot = 0;
			} else if (z >= 0.3125 && z < 0.5) {
				slot = 1;
			} else if (z >= 0.5 && z < 0.6875) {
				slot = 2;
			} else if (z >= 0.6875 && z <= 0.875) {
				slot = 3;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (x >= 0.125 && x < 0.3125) {
				} else if (x >= 0.3125 && x < 0.5) {
					slot += 4;
				} else if (x >= 0.5 && x < 0.6875) {
					slot += 8;
				} else if (x >= 0.6875 && x <= 0.875) {
					slot += 12;
				} else {
					slot = -1;
				}
			}
			break;
		case WEST:
			if (z >= 0.125 && z < 0.3125) {
				slot = 3;
			} else if (z >= 0.3125 && z < 0.5) {
				slot = 2;
			} else if (z >= 0.5 && z < 0.6875) {
				slot = 1;
			} else if (z >= 0.6875 && z <= 0.875) {
				slot = 0;
			} else {
				slot = -1;
			}
			if (slot >= 0 && slot < 16) {
				if (x >= 0.125 && x < 0.3125) {
					slot += 12;
				} else if (x >= 0.3125 && x < 0.5) {
					slot += 8;
				} else if (x >= 0.5 && x < 0.6875) {
					slot += 4;
				} else if (x >= 0.6875 && x <= 0.875) {
				} else {
					slot = -1;
				}
			}
			break;
		default:
			slot = 0;
			break;
		}
		BlockEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof CrateTile) {
			CrateTile cratetileentity = (CrateTile)tileentity;
			if (slot >= 0 && slot < 16) {
				return cratetileentity.getItem(slot);
			}
		}
		return ItemStack.EMPTY;
	}
}
