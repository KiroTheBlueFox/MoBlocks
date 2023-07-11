package kirothebluefox.moblocks.content.decoration.customcolorpicker;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraftforge.fml.ModList;

import java.util.List;

import net.minecraft.world.item.Item.Properties;

public class CustomLightColorPicker extends Item implements IDyeableLightColorPicker {
	public CustomLightColorPicker(Properties properties) {
		super(properties);
		if (ModList.get().isLoaded("hypcore")) {
			//ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("tooltips.moblocks.custom_color_picker.change_color").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		tooltip.add(Component.translatable("tooltips.moblocks.custom_color_picker.color_blocks").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		tooltip.add(Component.translatable("tooltips.moblocks.custom_color_picker.pick_color").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean doesSneakBypassUse(ItemStack stack, LevelReader world, BlockPos pos, Player player) {
		return true;
	}

    /*public Light produceColoredLight(Entity entity, ItemStack itemStack) {
		int color = getColor(itemStack);
		return Light.builder().pos(APIUtils.entityPos(entity)).color(color, false).radius(15).build();
    }*/
}
