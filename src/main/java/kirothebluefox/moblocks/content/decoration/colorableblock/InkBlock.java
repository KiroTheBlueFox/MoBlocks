package kirothebluefox.moblocks.content.decoration.colorableblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

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
}
