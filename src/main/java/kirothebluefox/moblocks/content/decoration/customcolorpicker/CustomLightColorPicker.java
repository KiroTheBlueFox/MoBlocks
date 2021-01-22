package kirothebluefox.moblocks.content.decoration.customcolorpicker;

import java.util.List;

import net.hypherionmc.hypcore.api.APIUtils;
import net.hypherionmc.hypcore.api.ColoredLightManager;
import net.hypherionmc.hypcore.api.Light;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
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
import net.minecraftforge.fml.ModList;

public class CustomLightColorPicker extends Item implements IDyeableLightColorPicker {
	public CustomLightColorPicker(Properties properties) {
		super(properties);
		if (ModList.get().isLoaded("hypcore")) {
			ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
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
	
    public Light produceColoredLight(Entity entity, ItemStack itemStack) {
		int color = getColor(itemStack);
		return Light.builder().pos(APIUtils.entityPos(entity)).color(color, false).radius(15).build();
    }
}
