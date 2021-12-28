package kirothebluefox.moblocks.common.items.customcolorpicker;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

import java.util.List;

public class CustomColorPicker extends Item implements IDyeableColorPicker {
    public CustomColorPicker(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TranslatableComponent("tooltips.moblocks.custom_color_picker.change_color").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(new TranslatableComponent("tooltips.moblocks.custom_color_picker.color_blocks").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(new TranslatableComponent("tooltips.moblocks.custom_color_picker.pick_color").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, LevelReader world, BlockPos pos, Player player) {
        return true;
    }
}
