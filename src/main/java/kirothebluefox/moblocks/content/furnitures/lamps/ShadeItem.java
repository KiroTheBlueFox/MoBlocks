package kirothebluefox.moblocks.content.furnitures.lamps;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ShadeItem extends Item {
	private String shape;
	private Color color;
	
	public ShadeItem(Color color, String shape, Properties properties) {
		super(properties);
		this.color = color;
		this.shape = shape;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public String getShape() {
		return this.shape;
	}
	
	@Override
	public String getTranslationKey() {
		return "item.moblocks.shades.name";
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.shades.color", new TranslationTextComponent("item.moblocks.shades.colors."+this.color.getName()).setStyle(Style.EMPTY.setColor(this.color.getColor()))).setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.shades.shape", new TranslationTextComponent("item.moblocks.shades.shapes."+this.shape)).setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.shades.place").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	public enum Color {
		WHITE("white", DyeColor.WHITE.getColorValue()),
		LIGHT_GRAY("light_gray", DyeColor.LIGHT_GRAY.getColorValue()),
		GRAY("gray", DyeColor.GRAY.getColorValue()),
		BLACK("black", DyeColor.BLACK.getColorValue()),
		BROWN("brown", DyeColor.BROWN.getColorValue()),
		PINK("pink", DyeColor.PINK.getColorValue()),
		MAGENTA("magenta", DyeColor.MAGENTA.getColorValue()),
		PURPLE("purple", DyeColor.PURPLE.getColorValue()),
		LIGHT_BLUE("light_blue", DyeColor.LIGHT_BLUE.getColorValue()),
		CYAN("cyan", DyeColor.CYAN.getColorValue()),
		BLUE("blue", DyeColor.BLUE.getColorValue()),
		GREEN("green", DyeColor.GREEN.getColorValue()),
		LIME("lime", DyeColor.LIME.getColorValue()),
		YELLOW("yellow", DyeColor.YELLOW.getColorValue()),
		ORANGE("orange", DyeColor.ORANGE.getColorValue()),
		RED("red", DyeColor.RED.getColorValue());

		String name;
		int color;

		Color(String name, int color) {
			this.name = name;
			this.color = color;
		}
		
		Color(String name) {
			this.name = name;
			this.color = DyeColor.LIGHT_GRAY.getColorValue();
		}

		public String toString() {
			return this.name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public net.minecraft.util.text.Color getColor() {
			return net.minecraft.util.text.Color.fromInt(this.color);
		}
		
		public int getColorValue() {
			return this.color;
		}
	}
}
