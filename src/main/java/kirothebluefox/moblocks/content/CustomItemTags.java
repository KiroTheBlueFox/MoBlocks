package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CustomItemTags {
	protected static final TagKey<Item> collection = ItemTags.create(new ResourceLocation(MoBlocks.MODID, "tags/items"));

	public static final TagKey<Item> LAMP_SHADES = makeWrapperTag("lamp_shades");
	public static final TagKey<Item> BOOK_ITEMS = makeWrapperTag("book_items");
	public static final TagKey<Item> POTION_ITEMS = makeWrapperTag("potion_items");

	public static TagKey<Item> makeWrapperTag(String id) {
	  return ItemTags.create(new ResourceLocation(MoBlocks.MODID, id));
	}
}
