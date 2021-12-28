package kirothebluefox.moblocks.common.blocks.decoration.colorableblock.inkblock;

import kirothebluefox.moblocks.common.init.ModParticles;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Random;

public class InkBlock extends ColorableBlock {
    private static final String IDEA_BY = "Mysticpasta1";

    public InkBlock(String name, Block baseBlock) {
        super(name, baseBlock);
    }

    @Override
    public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TranslatableComponent("tooltips.moblocks.idea_and_texture_by").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY))
                .append(new TextComponent(" " + InkBlock.IDEA_BY).setStyle(Style.EMPTY.withColor(ChatFormatting.BLUE))));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
     * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
     * of whether the block can receive random update ticks
     */
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        Direction direction = Direction.getRandom(rand);
        if (direction != Direction.UP) {
            BlockPos blockpos = pos.relative(direction);
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (!stateIn.canOcclude() || !blockstate.isFaceSturdy(worldIn, blockpos, direction.getOpposite())) {
                double d0 = direction.getStepX() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getStepX() * 0.6D;
                double d1 = direction.getStepY() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getStepY() * 0.6D;
                double d2 = direction.getStepZ() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getStepZ() * 0.6D;
                float red = ((getColor(worldIn, pos) & 0xff0000) >> 16) / 255f,
                        green = ((getColor(worldIn, pos) & 0xff00) >> 8) / 255f,
                        blue = (getColor(worldIn, pos) & 0xff) / 255f;
                worldIn.addParticle(new InkParticleData(ModParticles.DRIPPING_INK, red, green, blue), (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
