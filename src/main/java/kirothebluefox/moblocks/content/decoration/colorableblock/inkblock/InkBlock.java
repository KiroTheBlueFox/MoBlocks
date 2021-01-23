package kirothebluefox.moblocks.content.decoration.colorableblock.inkblock;

import java.util.List;
import java.util.Random;

import kirothebluefox.moblocks.content.ModParticles;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class InkBlock extends ColorableBlock {
	private static final String IDEA_BY = "Mysticpasta1";
	
	public InkBlock(Block baseBlock) {
		super(baseBlock);
	}
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.idea_and_texture_by").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY))
				.append(new StringTextComponent(" "+InkBlock.IDEA_BY).setStyle(Style.EMPTY.setFormatting(TextFormatting.BLUE))));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	/**
	 * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
	 * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
	 * of whether the block can receive random update ticks
	 */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		Direction direction = Direction.getRandomDirection(rand);
		if (direction != Direction.UP) {
			BlockPos blockpos = pos.offset(direction);
			BlockState blockstate = worldIn.getBlockState(blockpos);
			if (!stateIn.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, direction.getOpposite())) {
				double d0 = direction.getXOffset() == 0 ? rand.nextDouble() : 0.5D + (double)direction.getXOffset() * 0.6D;
				double d1 = direction.getYOffset() == 0 ? rand.nextDouble() : 0.5D + (double)direction.getYOffset() * 0.6D;
				double d2 = direction.getZOffset() == 0 ? rand.nextDouble() : 0.5D + (double)direction.getZOffset() * 0.6D;
				float red = ((getColor(worldIn, pos) & 0xff0000) >> 16)/255f,
						green = ((getColor(worldIn, pos) & 0xff00) >> 8)/255f,
						blue = (getColor(worldIn, pos) & 0xff)/255f;
				worldIn.addParticle(new InkParticleData(ModParticles.DRIPPING_INK, red, green, blue), (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
        	}
     	}
	}
}
