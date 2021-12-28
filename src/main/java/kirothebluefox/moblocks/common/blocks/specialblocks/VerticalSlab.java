package kirothebluefox.moblocks.common.blocks.specialblocks;

import kirothebluefox.moblocks.common.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.common.customproperties.VerticalSlabType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class VerticalSlab extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<VerticalSlabType> TYPE = CustomBlockStateProperties.VERTICAL_SLAB_TYPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final double[][] AllCollisions = {{0, 0, 8, 16, 16, 16},   /* North */
            {0, 0, 0, 16, 16, 8},    /* South */
            {0, 0, 0, 8, 16, 16},    /* East  */
            {8, 0, 0, 16, 16, 16}};  /* West  */
    protected static final VoxelShape FacingNorth = Block.box(AllCollisions[0][0], AllCollisions[0][1], AllCollisions[0][2], AllCollisions[0][3], AllCollisions[0][4], AllCollisions[0][5]);
    private static final VoxelShape FULL_FACING_NORTH = Shapes.or(FacingNorth);
    protected static final VoxelShape FacingSouth = Block.box(AllCollisions[1][0], AllCollisions[1][1], AllCollisions[1][2], AllCollisions[1][3], AllCollisions[1][4], AllCollisions[1][5]);
    private static final VoxelShape FULL_FACING_SOUTH = Shapes.or(FacingSouth);
    protected static final VoxelShape FacingEast = Block.box(AllCollisions[2][0], AllCollisions[2][1], AllCollisions[2][2], AllCollisions[2][3], AllCollisions[2][4], AllCollisions[2][5]);
    private static final VoxelShape FULL_FACING_EAST = Shapes.or(FacingEast);
    protected static final VoxelShape FacingWest = Block.box(AllCollisions[3][0], AllCollisions[3][1], AllCollisions[3][2], AllCollisions[3][3], AllCollisions[3][4], AllCollisions[3][5]);
    private static final VoxelShape FULL_FACING_WEST = Shapes.or(FacingWest);

    public VerticalSlab(Block baseBlock) {
        super(Block.Properties.copy(baseBlock));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        if (state.getValue(TYPE) == VerticalSlabType.DOUBLE) {
            return Shapes.block();
        } else {
            if (state.getValue(FACING) == Direction.NORTH) {
                return FULL_FACING_NORTH;
            } else if (state.getValue(FACING) == Direction.SOUTH) {
                return FULL_FACING_SOUTH;
            } else if (state.getValue(FACING) == Direction.EAST) {
                return FULL_FACING_EAST;
            } else if (state.getValue(FACING) == Direction.WEST) {
                return FULL_FACING_WEST;
            } else {
                return null;
            }
        }
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, WATERLOGGED);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        if (blockstate.getBlock() == this) {
            return blockstate.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(WATERLOGGED, Boolean.valueOf(false));
        } else {
            FluidState FluidState = context.getLevel().getFluidState(blockpos);
            BlockState blockstate1 = this.defaultBlockState().setValue(TYPE, VerticalSlabType.SINGLE).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
            Direction direction = context.getHorizontalDirection();
            if (direction == Direction.NORTH) {
                return blockstate1.setValue(FACING, Direction.SOUTH);
            } else if (direction == Direction.WEST) {
                return blockstate1.setValue(FACING, Direction.EAST);
            } else if (direction == Direction.EAST) {
                return blockstate1.setValue(FACING, Direction.WEST);
            } else {
                return blockstate1;
            }
        }
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        ItemStack itemstack = useContext.getItemInHand();
        VerticalSlabType slabtype = state.getValue(TYPE);
        Direction facing = state.getValue(FACING);
        if (slabtype != VerticalSlabType.DOUBLE && itemstack.getItem() == this.asItem()) {
            if (useContext.replacingClickedOnBlock()) {
                Direction direction = useContext.getClickedFace();
                if (direction == Direction.NORTH) {
                    return facing == Direction.NORTH;
                } else if (direction == Direction.WEST) {
                    return facing == Direction.WEST;
                } else if (direction == Direction.EAST) {
                    return facing == Direction.EAST;
                } else {
                    return facing == Direction.SOUTH;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(worldIn, pos, state, fluidStateIn);
    }

    public boolean canPlaceLiquid(BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(worldIn, pos, state, fluidIn);
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        switch (type) {
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
