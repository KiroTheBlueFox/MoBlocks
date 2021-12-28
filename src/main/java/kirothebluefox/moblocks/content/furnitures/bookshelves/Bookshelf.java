package kirothebluefox.moblocks.content.furnitures.bookshelves;

import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class Bookshelf extends Block implements SimpleWaterloggedBlock, EntityBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape NORTH = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SOUTH = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape EAST = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape WEST = Block.box(0, 0, 0, 8, 16, 16);

    public Bookshelf(Block baseBlock) {
        super(Block.Properties.copy(baseBlock));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
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

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BookshelfTile(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TranslatableComponent("tooltips.moblocks.shelves.place_item").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof BookshelfTile) {
                ((BookshelfTile) tileentity).dropItems();
            }

            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        Direction direction = state.getValue(FACING);
        int slot;
        double x = hit.getLocation().x() - pos.getX(), y = hit.getLocation().y() - pos.getY(), z = hit.getLocation().z() - pos.getZ();
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
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof BookshelfTile && slot > -1 && slot < 14) {
            int layer = (y > 0.5 ? 0 : 1);
            BookshelfTile shelftileentity = (BookshelfTile) tileentity;
            if (!player.isShiftKeyDown()) {
                ItemStack itemstack = player.getItemInHand(handIn);
                shelftileentity.addItem(itemstack, layer, slot, player, handIn);
            }
        } else {
            return InteractionResult.FAIL;
        }
        return InteractionResult.SUCCESS;
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

    public ItemStack getItemAtHit(ClientLevel worldIn, BlockState state, Vec3 hit, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        int slot;
        double x = hit.x() - pos.getX(), y = hit.y() - pos.getY(), z = hit.z() - pos.getZ();
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
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof BookshelfTile && slot > -1 && slot < 14) {
            int layer = (y > 0.5 ? 0 : 1);
            BookshelfTile shelftileentity = (BookshelfTile) tileentity;
            return shelftileentity.getItem(layer, slot);
        }
        return ItemStack.EMPTY;
    }
}
