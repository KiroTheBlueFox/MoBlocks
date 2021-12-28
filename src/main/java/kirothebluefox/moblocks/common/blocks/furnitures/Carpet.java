package kirothebluefox.moblocks.common.blocks.furnitures;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.common.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class Carpet extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape CARPET = Block.box(0, 0, 0, 16, 1, 16);
    private static final BooleanProperty NORTH = CustomBlockStateProperties.NORTH;
    private static final BooleanProperty SOUTH = CustomBlockStateProperties.SOUTH;
    private static final BooleanProperty EAST = CustomBlockStateProperties.EAST;
    private static final BooleanProperty WEST = CustomBlockStateProperties.WEST;
    private static final BooleanProperty NORTH_WEST = CustomBlockStateProperties.NORTH_WEST;
    private static final BooleanProperty NORTH_EAST = CustomBlockStateProperties.NORTH_EAST;
    private static final BooleanProperty SOUTH_WEST = CustomBlockStateProperties.SOUTH_WEST;
    private static final BooleanProperty SOUTH_EAST = CustomBlockStateProperties.SOUTH_EAST;

    public Carpet(String name, Block baseBlock) {
        super(Block.Properties.copy(baseBlock).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false)
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false)
                .setValue(NORTH_WEST, false)
                .setValue(NORTH_EAST, false)
                .setValue(SOUTH_WEST, false)
                .setValue(SOUTH_EAST, false));
        ModItems.ITEMS.register(name, () -> new BlockItem(this, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return CARPET;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST, NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST, WATERLOGGED);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState ifluidstate = context.getLevel().getFluidState(blockpos);
        LevelAccessor world = context.getLevel();
        BlockState blockstate = this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
        blockstate = forEachDirections(blockstate, world, blockpos);
        return blockstate;
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    /**
     * Test if the block is a table or not
     *
     * @param direction  N, S, E, W, NW, NE, SW or SE
     * @param stateIn
     * @param worldIn
     * @param currentPos
     * @return true or false
     */
    private boolean isBlockAtCarpet(String direction, BlockState stateIn, LevelAccessor worldIn, BlockPos currentPos) {
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
        return block.getTags().contains(new ResourceLocation(MoBlocks.MODID, "carpets"));
    }

    public BlockState forEachDirections(BlockState stateIn, LevelAccessor worldIn, BlockPos currentPos) {
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
            state[0] = state[0].setValue(property, isBlockAtCarpet(direction, stateIn, worldIn, currentPos));
        });
        return state[0];
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

        stateIn = forEachDirections(stateIn, worldIn, currentPos);
        return facing.getAxis().isHorizontal() ? stateIn : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
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
