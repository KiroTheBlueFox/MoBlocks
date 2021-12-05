package kirothebluefox.moblocks.content.furnitures.lamps;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

import net.minecraft.world.item.Item.Properties;

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
	public String getDescriptionId() {
		return "item.moblocks.shades.name";
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(new TranslatableComponent("tooltips.moblocks.shades.color", new TranslatableComponent("item.moblocks.shades.colors."+this.color.getName()).setStyle(Style.EMPTY.withColor(this.color.getColor()))).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		tooltip.add(new TranslatableComponent("tooltips.moblocks.shades.shape", new TranslatableComponent("item.moblocks.shades.shapes."+this.shape)).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		tooltip.add(new TranslatableComponent("tooltips.moblocks.shades.place").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	public enum Color {
		WHITE("white", DyeColor.WHITE.getFireworkColor()),
		LIGHT_GRAY("light_gray", DyeColor.LIGHT_GRAY.getFireworkColor()),
		GRAY("gray", DyeColor.GRAY.getFireworkColor()),
		BLACK("black", DyeColor.BLACK.getFireworkColor()),
		BROWN("brown", DyeColor.BROWN.getFireworkColor()),
		PINK("pink", DyeColor.PINK.getFireworkColor()),
		MAGENTA("magenta", DyeColor.MAGENTA.getFireworkColor()),
		PURPLE("purple", DyeColor.PURPLE.getFireworkColor()),
		LIGHT_BLUE("light_blue", DyeColor.LIGHT_BLUE.getFireworkColor()),
		CYAN("cyan", DyeColor.CYAN.getFireworkColor()),
		BLUE("blue", DyeColor.BLUE.getFireworkColor()),
		GREEN("green", DyeColor.GREEN.getFireworkColor()),
		LIME("lime", DyeColor.LIME.getFireworkColor()),
		YELLOW("yellow", DyeColor.YELLOW.getFireworkColor()),
		ORANGE("orange", DyeColor.ORANGE.getFireworkColor()),
		RED("red", DyeColor.RED.getFireworkColor());

		String name;
		int color;

		Color(String name, int color) {
			this.name = name;
			this.color = color;
		}

		Color(String name) {
			this.name = name;
			this.color = DyeColor.LIGHT_GRAY.getFireworkColor();
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

		public net.minecraft.network.chat.TextColor getColor() {
			return net.minecraft.network.chat.TextColor.fromRgb(this.color);
		}

		public int getFireworkColor() {
			return this.color;
		}
	}
}
