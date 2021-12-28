package kirothebluefox.moblocks.content.decoration.lighting.siren;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableLightColorPicker;
import kirothebluefox.moblocks.utils.VoxelShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;

public class Siren extends Block implements IColorableBlock, EntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private final VoxelShape shape = Block.box(5, 0, 5, 11, 8, 11);

    public Siren() {
        super(Block.Properties.of(Material.DECORATION).instabreak());
        if (ModList.get().isLoaded("hypcore")) {
            //ColoredLightManager.registerProvider(this, this::produceColoredLight);
        }
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false).setValue(FACING, Direction.UP));
    }

    public static int getColor(BlockGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof SirenTile) {
            SirenTile rainbowBlockTile = (SirenTile) tileEntity;
            return rainbowBlockTile.getColor();
        }
        return 0xFFFFFF;
    }

    public static int getMaxColor(BlockGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof SirenTile) {
            SirenTile rainbowBlockTile = (SirenTile) tileEntity;
            return rainbowBlockTile.getMaxColor();
        }
        return 0xFFFFFF;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.getValue(POWERED))
            if (ModList.get().isLoaded("hypcore"))
                return 1;
            else
                return 15;
        return 0;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case UP:
                return shape;
            case DOWN:
                return VoxelShapeUtils.mirrorY(shape);
            case EAST:
                return VoxelShapeUtils.switchXY(shape);
            case WEST:
                return VoxelShapeUtils.rotateYAngle(VoxelShapeUtils.switchXY(shape), VoxelShapeUtils.Angle.Angle180);
            case SOUTH:
                return VoxelShapeUtils.rotateY(VoxelShapeUtils.switchXY(shape));
            case NORTH:
                return VoxelShapeUtils.rotateYAngle(VoxelShapeUtils.switchXY(shape), VoxelShapeUtils.Angle.Angle270);
        }
        return shape;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack itemstack = player.getItemInHand(handIn);
        if (itemstack.isEmpty() || state.getValue(POWERED)) {
            return InteractionResult.SUCCESS;
        } else {
            Item item = itemstack.getItem();
            if (item instanceof IDyeableColorPicker) {
                IDyeableColorPicker colorpicker = (IDyeableColorPicker) item;
                BlockEntity tileentity = worldIn.getBlockEntity(pos);
                if (tileentity instanceof SirenTile) {
                    SirenTile sirenTile = (SirenTile) tileentity;
                    sirenTile.setMaxColor(colorpicker.getColor(itemstack));
                    sirenTile.setColor(colorpicker.getColor(itemstack));
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else if (item instanceof IDyeableLightColorPicker) {
                IDyeableLightColorPicker colorpicker = (IDyeableLightColorPicker) item;
                BlockEntity tileentity = worldIn.getBlockEntity(pos);
                if (tileentity instanceof SirenTile) {
                    SirenTile sirenTile = (SirenTile) tileentity;
                    sirenTile.setMaxColor(colorpicker.getColor(itemstack));
                    sirenTile.setColor(colorpicker.getColor(itemstack));
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos()))).setValue(FACING, context.getClickedFace());
    }

    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = worldIn.hasNeighborSignal(pos);
        if (blockIn != this && flag != state.getValue(POWERED)) {
            worldIn.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)), 2);
        }
    }

	/*public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(state.get(POWERED) ? 14 : 0).build();
	}*/

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SirenTile(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return (level1, blockPos, blockState, t) -> {
            if (t instanceof SirenTile tile) {
                if (!level1.isClientSide()) {
                    tile.tick();
                }
            }
        };
    }
}
