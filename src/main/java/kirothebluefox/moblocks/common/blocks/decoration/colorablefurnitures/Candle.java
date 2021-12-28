package kirothebluefox.moblocks.common.blocks.decoration.colorablefurnitures;

import kirothebluefox.moblocks.common.customproperties.IColorableBlock;
import kirothebluefox.moblocks.common.blockentities.ColorableLightBlockTile;
import kirothebluefox.moblocks.common.items.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.common.items.customcolorpicker.IDyeableLightColorPicker;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.Random;


public class Candle extends Block implements IColorableBlock, EntityBlock {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN);

    public static final VoxelShape CANDLE = Block.box(5, 0, 5, 11, 10, 11);
    public static final VoxelShape NORTH = Block.box(6, 2, 0, 10, 13, 10);
    public static final VoxelShape SOUTH = Block.box(6, 2, 6, 10, 13, 16);
    public static final VoxelShape EAST = Block.box(6, 2, 6, 16, 13, 10);
    public static final VoxelShape WEST = Block.box(0, 2, 6, 10, 13, 10);

    public Candle() {
        super(Block.Properties.of(Material.DECORATION).instabreak());
        if (ModList.get().isLoaded("hypcore")) {
            //ColoredLightManager.registerProvider(this, this::produceColoredLight);
        }
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN));
    }

    public static int getColor(BlockState blockState, BlockAndTintGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof ColorableLightBlockTile) {
            ColorableLightBlockTile candleTile = (ColorableLightBlockTile) tileEntity;
            return candleTile.getColor();
        }
        return 0xFFFFFF;
    }

    public static int getLightColor(BlockAndTintGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof ColorableLightBlockTile) {
            ColorableLightBlockTile candleTile = (ColorableLightBlockTile) tileEntity;
            return candleTile.getLightColor();
        }
        return 0xFFFFFF;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (ModList.get().isLoaded("hypcore")) {
            return 0;
        }
        return 7;
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
            case UP:
                return CANDLE;
            default:
                return CANDLE;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (!canSupportCenter(context.getLevel(), context.getClickedPos().relative(context.getClickedFace().getOpposite()), context.getClickedFace())) {
            return null;
        }
        if (context.getClickedFace() != Direction.DOWN) {
            return this.defaultBlockState().setValue(FACING, context.getClickedFace().getOpposite());
        } else {
            return (canSupportCenter(context.getLevel(), context.getClickedPos().below(), Direction.DOWN)) ? this.defaultBlockState().setValue(FACING, Direction.DOWN) : null;
        }
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(FACING) == Direction.DOWN) {
            if (!canSupportCenter(worldIn, currentPos.below(), Direction.DOWN)) {
                worldIn.destroyBlock(currentPos, true);
            }
        } else {
            if (!canSupportCenter(worldIn, currentPos.relative(stateIn.getValue(FACING)), stateIn.getValue(FACING))) {
                worldIn.destroyBlock(currentPos, true);
            }
        }
        return stateIn;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ColorableLightBlockTile(pos, state);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        double d0 = (double) pos.getX() + 0.5D;
        double d1 = (double) pos.getY() + 0.75D;
        double d2 = (double) pos.getZ() + 0.5D;
        worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack itemstack = player.getItemInHand(handIn);
        if (itemstack.isEmpty()) {
            return InteractionResult.SUCCESS;
        } else {
            Item item = itemstack.getItem();
            if (item instanceof IDyeableColorPicker) {
                IDyeableColorPicker colorpicker = (IDyeableColorPicker) item;
                BlockEntity tileentity = worldIn.getBlockEntity(pos);
                if (tileentity instanceof ColorableLightBlockTile) {
                    ColorableLightBlockTile candleTile = (ColorableLightBlockTile) tileentity;
                    candleTile.setColor(colorpicker.getColor(itemstack));
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else if (item instanceof IDyeableLightColorPicker) {
                IDyeableLightColorPicker colorpicker = (IDyeableLightColorPicker) item;
                BlockEntity tileentity = worldIn.getBlockEntity(pos);
                if (tileentity instanceof ColorableLightBlockTile) {
                    ColorableLightBlockTile candleTile = (ColorableLightBlockTile) tileentity;
                    candleTile.setLightColor(colorpicker.getColor(itemstack));
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

	/*public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getLightColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(7).build();
	}*/
}
