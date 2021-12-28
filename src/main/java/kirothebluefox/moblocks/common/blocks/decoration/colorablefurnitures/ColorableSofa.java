package kirothebluefox.moblocks.common.blocks.decoration.colorablefurnitures;

import kirothebluefox.moblocks.common.customproperties.IColorableBlock;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableBlockTile;
import kirothebluefox.moblocks.common.blocks.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.common.blocks.furnitures.SeatSofa;
import kirothebluefox.moblocks.common.blocks.furnitures.Sofa;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ColorableSofa extends Sofa implements IColorableBlock, EntityBlock {
    public ColorableSofa(Block baseBlock) {
        super(baseBlock);
    }

    public static int getColor(BlockState blockState, BlockAndTintGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof ColorableBlockTile) {
            ColorableBlockTile colorablewoolentity = (ColorableBlockTile) tileEntity;
            return colorablewoolentity.getColor();
        }
        return 0xFFFFFF;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ColorableBlockTile(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide()) {
            ItemStack itemstack = player.getItemInHand(handIn);
            if (player.isShiftKeyDown()) {
                if (itemstack.isEmpty()) {
                    worldIn.setBlockAndUpdate(pos, state.setValue(ARMREST, !state.getValue(ARMREST)));
                } else {
                    Item item = itemstack.getItem();
                    if (item instanceof IDyeableColorPicker) {
                        IDyeableColorPicker colorpicker = (IDyeableColorPicker) item;
                        BlockEntity tileentity = worldIn.getBlockEntity(pos);
                        if (tileentity instanceof ColorableBlockTile) {
                            ColorableBlockTile colorableblockentity = (ColorableBlockTile) tileentity;
                            colorpicker.setColor(itemstack, colorableblockentity.getColor());
                            return InteractionResult.SUCCESS;
                        } else {
                            return InteractionResult.FAIL;
                        }
                    } else {
                        return InteractionResult.FAIL;
                    }
                }
            } else {
                if (itemstack.isEmpty()) {
                    if (player.getVehicle() != null) {
                        return InteractionResult.SUCCESS;
                    }

                    Vec3 vec = new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                    double maxDist = 2.0d;
                    if ((vec.x - player.getX()) * (vec.x - player.getX()) +
                            (vec.y - player.getY()) * (vec.y - player.getY()) +
                            (vec.z - player.getZ()) * (vec.z - player.getZ()) > maxDist * maxDist) {
                        player.displayClientMessage(new TranslatableComponent("status_messages.moblocks.seats.too_far", new TranslatableComponent("status_messages.moblocks.seats.sofa")), true);
                        return InteractionResult.SUCCESS;
                    }

                    SeatSofa seat = new SeatSofa(worldIn, pos);
                    worldIn.addFreshEntity(seat);
                    player.startRiding(seat);
                    return InteractionResult.SUCCESS;
                } else {
                    Item item = itemstack.getItem();
                    if (item instanceof IDyeableColorPicker) {
                        IDyeableColorPicker colorpicker = (IDyeableColorPicker) item;
                        BlockEntity tileentity = worldIn.getBlockEntity(pos);
                        if (tileentity instanceof ColorableBlockTile) {
                            ColorableBlockTile colorableblockentity = (ColorableBlockTile) tileentity;
                            colorableblockentity.setColor(colorpicker.getColor(itemstack));
                            return InteractionResult.SUCCESS;
                        } else {
                            return InteractionResult.FAIL;
                        }
                    } else {
                        return InteractionResult.FAIL;
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
