package kirothebluefox.moblocks.common.blocks.decoration.lighting.rainbowblock;

import kirothebluefox.moblocks.common.customproperties.IColorableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;

public class RainbowBlock extends Block implements IColorableBlock, EntityBlock {
    public RainbowBlock(Block baseBlock) {
        super(Block.Properties.copy(baseBlock));
        if (ModList.get().isLoaded("hypcore")) {
            //ColoredLightManager.registerProvider(this, this::produceColoredLight);
        }
    }

    public static int getColor(BlockGetter blockReader, BlockPos pos) {
        BlockEntity tileEntity = blockReader.getBlockEntity(pos);
        if (tileEntity instanceof RainbowBlockTile) {
            RainbowBlockTile rainbowBlockTile = (RainbowBlockTile) tileEntity;
            return rainbowBlockTile.getColor();
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
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide && handIn.equals(InteractionHand.MAIN_HAND) && player.getItemInHand(handIn).isEmpty()) {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof RainbowBlockTile) {
                RainbowBlockTile rainbowBlockTile = (RainbowBlockTile) tileEntity;
                int speed = rainbowBlockTile.getSpeed();
                if (player.isShiftKeyDown()) {
                    speed /= 2;
                    if (speed < 1)
                        speed = 128;
                } else {
                    speed *= 2;
                    if (speed > 128)
                        speed = 1;
                }
                rainbowBlockTile.setSpeed(speed);
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RainbowBlockTile(pos, state);
    }

	/*public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(14).build();
	}*/

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return (level1, blockPos, blockState, t) -> {
            if (t instanceof RainbowBlockTile tile) {
                if (!level1.isClientSide()) {
                    tile.tick();
                }
            }
        };
    }
}
