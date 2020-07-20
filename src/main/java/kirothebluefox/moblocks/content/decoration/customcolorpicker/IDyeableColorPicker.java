package kirothebluefox.moblocks.content.decoration.customcolorpicker;

import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public interface IDyeableColorPicker extends IDyeableArmorItem {
	default int getColor(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getChildTag("display");
		return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : 0xFFFFFF;
	}
}
