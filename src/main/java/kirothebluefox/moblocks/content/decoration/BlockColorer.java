package kirothebluefox.moblocks.content.decoration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class BlockColorer extends Item {
	public BlockColorer(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("tooltips.moblocks.block_colorer.description").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}
}
