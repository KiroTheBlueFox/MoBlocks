package kirothebluefox.moblocks.common.blocks.furnitures.shelves;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blockentities.ShelfTile;
import kirothebluefox.moblocks.common.init.ModItems;
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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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

public class Shelf extends Block implements SimpleWaterloggedBlock, EntityBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape NORTH = Block.box(0, 3, 0, 16, 4, 8);
    public static final VoxelShape SOUTH = Block.box(0, 3, 8, 16, 4, 16);
    public static final VoxelShape EAST = Block.box(8, 3, 0, 16, 4, 16);
    public static final VoxelShape WEST = Block.box(0, 3, 0, 8, 4, 16);

    public Shelf(String name, Block baseBlock) {
        super(Block.Properties.copy(baseBlock));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
        ModItems.ITEMS.register(name, () -> new BlockItem(this, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)));
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
        return new ShelfTile(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TranslatableComponent("tooltips.moblocks.shelves.place_item").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(new TranslatableComponent("tooltips.moblocks.shelves.info_item").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof ShelfTile) {
                ((ShelfTile) tileentity).dropItems();
            }

            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        Direction direction = state.getValue(FACING);
        int slot;
        switch (direction) {
            case NORTH:
                slot = (int) ((hit.getLocation().x() - pos.getX()) * 4);
                break;
            case SOUTH:
                slot = (int) (4 - (hit.getLocation().x() - pos.getX()) * 4);
                break;
            case EAST:
                slot = (int) ((hit.getLocation().z() - pos.getZ()) * 4);
                break;
            case WEST:
                slot = (int) (4 - (hit.getLocation().z() - pos.getZ()) * 4);
                break;
            default:
                slot = 0;
                break;
        }
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof ShelfTile && slot >= 0 && slot <= 3) {
            ShelfTile shelftileentity = (ShelfTile) tileentity;
            if (!player.isShiftKeyDown()) {
                ItemStack itemstack = player.getItemInHand(handIn);
                shelftileentity.addItem(itemstack, slot, player, handIn);
            }
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
        switch (direction) {
            case NORTH:
                slot = (int) ((hit.x() - pos.getX()) * 4);
                break;
            case SOUTH:
                slot = (int) (4 - (hit.x() - pos.getX()) * 4);
                break;
            case EAST:
                slot = (int) ((hit.z() - pos.getZ()) * 4);
                break;
            case WEST:
                slot = (int) (4 - (hit.z() - pos.getZ()) * 4);
                break;
            default:
                slot = 0;
                break;
        }
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof ShelfTile && slot >= 0 && slot <= 3) {
            ShelfTile shelftileentity = (ShelfTile) tileentity;
            return shelftileentity.getItem(slot);
        }
        return ItemStack.EMPTY;
    }
}
