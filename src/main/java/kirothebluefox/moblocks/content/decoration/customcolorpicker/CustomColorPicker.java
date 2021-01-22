package kirothebluefox.moblocks.content.decoration.customcolorpicker;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CustomColorPicker extends Item implements IDyeableColorPicker {
	public CustomColorPicker(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.custom_color_picker.change_color").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.custom_color_picker.color_blocks").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.custom_color_picker.pick_color").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public boolean doesSneakBypassUse(ItemStack stack, IWorldReader world, BlockPos pos, PlayerEntity player) {
		return true;
	}
}
