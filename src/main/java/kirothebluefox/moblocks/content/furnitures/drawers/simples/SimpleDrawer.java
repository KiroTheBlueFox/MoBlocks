package kirothebluefox.moblocks.content.furnitures.drawers.simples;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class SimpleDrawer extends Block implements SimpleWaterloggedBlock, EntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape foot1 = Block.box(0, 0, 0, 2, 8, 2);
    private static final VoxelShape foot2 = Block.box(14, 0, 0, 16, 8, 2);
    private static final VoxelShape foot3 = Block.box(0, 0, 14, 2, 8, 16);
    private static final VoxelShape foot4 = Block.box(14, 0, 14, 16, 8, 16);
    private static final VoxelShape container = Block.box(0, 8, 0, 16, 16, 16);
    private static final VoxelShape SHAPE = Shapes.or(foot1, foot2, foot3, foot4, container);
    private final Block baseBlock;

    public SimpleDrawer(Block baseBlock) {
        super(Block.Properties.copy(baseBlock));
        this.baseBlock = baseBlock;
        registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    private static boolean isBlocked(BlockState stateIn, LevelAccessor worldIn, BlockPos pos) {
        return isFrontSolidBlock(worldIn, pos, stateIn);
    }

    private static boolean isFrontSolidBlock(BlockGetter worldIn, BlockPos pos, BlockState stateIn) {
        BlockPos blockpos = pos.relative(stateIn.getValue(FACING).getOpposite());
        return worldIn.getBlockState(blockpos).isRedstoneConductor(worldIn, blockpos);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SimpleDrawerTile(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return (level1, blockPos, blockState, t) -> {
            if (t instanceof SimpleDrawerTile tile) {
                if (level1.isClientSide()) {
                    tile.tick();
                }
            }
        };
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide && handIn.equals(InteractionHand.MAIN_HAND)) {
            worldIn.sendBlockUpdated(pos, state, state, 2);
            if (isBlocked(state, worldIn, pos)) {
                player.displayClientMessage(new TranslatableComponent("status_messages.moblocks.drawers.is_blocked"), true);
            } else {
                BlockEntity tileEntity = worldIn.getBlockEntity(pos);
                if (tileEntity instanceof SimpleDrawerTile) {
                    if (((SimpleDrawerTile) tileEntity).isOpened()) {
                        player.displayClientMessage(new TranslatableComponent("status_messages.moblocks.drawers.already_in_use"), true);
                    } else {
                        NetworkHooks.openGui((ServerPlayer) player, (MenuProvider) tileEntity, tileEntity.getBlockPos());
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof SimpleDrawerTile) {
                ((SimpleDrawerTile) tileentity).dropItems();
            }

            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
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

    public Block getBaseBlock() {
        return this.baseBlock;
    }
}
