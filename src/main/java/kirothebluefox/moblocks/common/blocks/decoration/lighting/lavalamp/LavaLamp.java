package kirothebluefox.moblocks.common.blocks.decoration.lighting.lavalamp;

import kirothebluefox.moblocks.common.blockentities.LavaLampTile;
import kirothebluefox.moblocks.common.customproperties.IColorableBlock;
import kirothebluefox.moblocks.common.items.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.common.items.customcolorpicker.IDyeableLightColorPicker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;

public class LavaLamp extends Block implements IColorableBlock, EntityBlock {
    private final VoxelShape shape1 = Block.box(5, 0, 5, 11, 1, 11);
    private final VoxelShape shape2 = Block.box(7, 1, 7, 9, 3, 9);
    private final VoxelShape shape3 = Block.box(6, 3, 6, 10, 16, 10);
    private final VoxelShape shape = Shapes.or(shape1, shape2, shape3);

    public LavaLamp() {
        super(Block.Properties.of(Material.DECORATION).instabreak());
        if (ModList.get().isLoaded("hypcore")) {
            //ColoredLightManager.registerProvider(this, this::produceColoredLight);
        }
    }

    public static int getColor(BlockGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof LavaLampTile) {
            LavaLampTile lavaLampTile = (LavaLampTile) tileEntity;
            return lavaLampTile.getColor();
        }
        return 0xFFFFFF;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (ModList.get().isLoaded("hypcore"))
            return 1;
        return 15;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return shape;
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
                if (tileentity instanceof LavaLampTile) {
                    LavaLampTile lavaLampTile = (LavaLampTile) tileentity;
                    lavaLampTile.setColor(colorpicker.getColor(itemstack));
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.FAIL;
                }
            } else if (item instanceof IDyeableLightColorPicker) {
                IDyeableLightColorPicker colorpicker = (IDyeableLightColorPicker) item;
                BlockEntity tileentity = worldIn.getBlockEntity(pos);
                if (tileentity instanceof LavaLampTile) {
                    LavaLampTile lavaLampTile = (LavaLampTile) tileentity;
                    lavaLampTile.setColor(colorpicker.getColor(itemstack));
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
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(15).build();
	}*/

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LavaLampTile(pos, state);
    }
}
