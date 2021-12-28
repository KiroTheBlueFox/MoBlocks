package kirothebluefox.moblocks.content.specialblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class LowerSmallArch extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    /* NS */
    protected static final double[][] NS = {{0, 0, 0, 1, 16, 16},
            {15, 0, 0, 16, 16, 16},
            {1, 3, 0, 2, 16, 16},
            {14, 3, 0, 15, 16, 16},
            {2, 5, 0, 3, 16, 16},
            {13, 5, 0, 14, 16, 16},
            {3, 6, 0, 5, 16, 16},
            {11, 6, 0, 13, 16, 16},
            {5, 7, 0, 11, 16, 16}};
    protected static final VoxelShape NSPart1 = Block.box(NS[0][0], NS[0][1], NS[0][2], NS[0][3], NS[0][4], NS[0][5]);
    protected static final VoxelShape NSPart2 = Block.box(NS[1][0], NS[1][1], NS[1][2], NS[1][3], NS[1][4], NS[1][5]);
    protected static final VoxelShape NSPart3 = Block.box(NS[2][0], NS[2][1], NS[2][2], NS[2][3], NS[2][4], NS[2][5]);
    protected static final VoxelShape NSPart4 = Block.box(NS[3][0], NS[3][1], NS[3][2], NS[3][3], NS[3][4], NS[3][5]);
    protected static final VoxelShape NSPart5 = Block.box(NS[4][0], NS[4][1], NS[4][2], NS[4][3], NS[4][4], NS[4][5]);
    protected static final VoxelShape NSPart6 = Block.box(NS[5][0], NS[5][1], NS[5][2], NS[5][3], NS[5][4], NS[5][5]);
    protected static final VoxelShape NSPart7 = Block.box(NS[6][0], NS[6][1], NS[6][2], NS[6][3], NS[6][4], NS[6][5]);
    protected static final VoxelShape NSPart8 = Block.box(NS[7][0], NS[7][1], NS[7][2], NS[7][3], NS[7][4], NS[7][5]);
    protected static final VoxelShape NSPart9 = Block.box(NS[8][0], NS[8][1], NS[8][2], NS[8][3], NS[8][4], NS[8][5]);
    private static final VoxelShape FULL_NS_SHAPE = Shapes.or(NSPart1, NSPart2, NSPart3, NSPart4, NSPart5, NSPart6, NSPart7, NSPart8, NSPart9);

    /* EW */
    protected static final double[][] EW = {{0, 0, 0, 16, 16, 1},
            {0, 0, 15, 16, 16, 16},
            {0, 3, 1, 16, 16, 2},
            {0, 3, 14, 16, 16, 15},
            {0, 5, 2, 16, 16, 3},
            {0, 5, 13, 16, 16, 14},
            {0, 6, 3, 16, 16, 5},
            {0, 6, 11, 16, 16, 13},
            {0, 7, 5, 16, 16, 11}};
    protected static final VoxelShape EWPart1 = Block.box(EW[0][0], EW[0][1], EW[0][2], EW[0][3], EW[0][4], EW[0][5]);
    protected static final VoxelShape EWPart2 = Block.box(EW[1][0], EW[1][1], EW[1][2], EW[1][3], EW[1][4], EW[1][5]);
    protected static final VoxelShape EWPart3 = Block.box(EW[2][0], EW[2][1], EW[2][2], EW[2][3], EW[2][4], EW[2][5]);
    protected static final VoxelShape EWPart4 = Block.box(EW[3][0], EW[3][1], EW[3][2], EW[3][3], EW[3][4], EW[3][5]);
    protected static final VoxelShape EWPart5 = Block.box(EW[4][0], EW[4][1], EW[4][2], EW[4][3], EW[4][4], EW[4][5]);
    protected static final VoxelShape EWPart6 = Block.box(EW[5][0], EW[5][1], EW[5][2], EW[5][3], EW[5][4], EW[5][5]);
    protected static final VoxelShape EWPart7 = Block.box(EW[6][0], EW[6][1], EW[6][2], EW[6][3], EW[6][4], EW[6][5]);
    protected static final VoxelShape EWPart8 = Block.box(EW[7][0], EW[7][1], EW[7][2], EW[7][3], EW[7][4], EW[7][5]);
    protected static final VoxelShape EWPart9 = Block.box(EW[8][0], EW[8][1], EW[8][2], EW[8][3], EW[8][4], EW[8][5]);
    private static final VoxelShape FULL_EW_SHAPE = Shapes.or(EWPart1, EWPart2, EWPart3, EWPart4, EWPart5, EWPart6, EWPart7, EWPart8, EWPart9);

    public LowerSmallArch(Block baseBlock) {
        super(Block.Properties.copy(baseBlock));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        if (state.getValue(FACING) == Direction.NORTH || state.getValue(FACING) == Direction.SOUTH) {
            return FULL_NS_SHAPE;
        } else {
            return FULL_EW_SHAPE;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }


    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
        Direction direction = context.getHorizontalDirection();
        if (direction == Direction.NORTH) {
            return blockstate.setValue(FACING, Direction.SOUTH);
        } else if (direction == Direction.WEST) {
            return blockstate.setValue(FACING, Direction.EAST);
        } else if (direction == Direction.EAST) {
            return blockstate.setValue(FACING, Direction.WEST);
        } else {
            return blockstate;
        }
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
