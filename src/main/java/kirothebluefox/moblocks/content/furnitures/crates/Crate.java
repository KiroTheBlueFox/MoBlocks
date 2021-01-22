package kirothebluefox.moblocks.content.furnitures.crates;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Crate extends Block implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public Crate(Block baseBlock) {
		super(Block.Properties.from(baseBlock).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		Direction direction = state.get(FACING);
		int slot;
		double x = hit.getHitVec().getX() - pos.getX();
		double z = hit.getHitVec().getZ() - pos.getZ();
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
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof CrateTile) {
			CrateTile cratetileentity = (CrateTile)tileentity;
			if (slot >= 0 && slot < 16) {
				if (!player.isSneaking()) {
					ItemStack itemstack = player.getHeldItem(handIn);
					cratetileentity.addItem(itemstack, slot, player, handIn);
				}
			} else { 
				if (player.isSneaking()) {
					cratetileentity.nextLayer();
				}
			}
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new CrateTile();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
     		if (tileentity instanceof CrateTile) {
     			((CrateTile) tileentity).dropItems();
     		}

     		super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
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
		double x = hit.getX() - pos.getX();
		double z = hit.getZ() - pos.getZ();
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
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof CrateTile) {
			CrateTile cratetileentity = (CrateTile)tileentity;
			if (slot >= 0 && slot < 16) {
				return cratetileentity.getItem(slot);
			}
		}
		return ItemStack.EMPTY;
	}
}
