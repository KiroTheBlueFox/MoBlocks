package kirothebluefox.moblocks.content;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.world.item.Item;

public class CustomItemTags {
	   protected static final StaticTagHelper<Item> collection = StaticTags.m_144351_(Registry.ITEM_REGISTRY, "tags/items");

	public static final Tag.Named<Item> LAMP_SHADES = makeWrapperTag("lamp_shades");
	public static final Tag.Named<Item> BOOK_ITEMS = makeWrapperTag("book_items");
	public static final Tag.Named<Item> POTION_ITEMS = makeWrapperTag("potion_items");

	   public static Tag.Named<Item> makeWrapperTag(String id) {
	      return collection.m_13244_(id);
	   }

	   public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name) {
	       return createOptional(name, null);
	   }

	   public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Item>> defaults) {
	      return collection.createOptional(name, defaults);
	   }

	   public static TagCollection<Item> getCollection() {
	      return collection.m_13246_();
	   }

	   public static TagCollection<Item> getAllTags() {
	      return collection.m_13246_();
	   }
}
