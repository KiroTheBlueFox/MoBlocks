package kirothebluefox.moblocks.content.decoration.customcolorpicker;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public interface IDyeableColorPicker extends DyeableLeatherItem {
	default int getColor(ItemStack stack) {
		CompoundTag compoundnbt = stack.getTagElement("display");
		return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : 0xFFFFFF;
	}
}
