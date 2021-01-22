package kirothebluefox.moblocks.content;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollection;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class CustomItemTags {
	   protected static final TagRegistry<Item> collection = TagRegistryManager.create(new ResourceLocation("item"), ITagCollectionSupplier::getItemTags);
	
	public static final ITag.INamedTag<Item> LAMP_SHADES = makeWrapperTag("lamp_shades");
	public static final ITag.INamedTag<Item> BOOK_ITEMS = makeWrapperTag("book_items");
	public static final ITag.INamedTag<Item> POTION_ITEMS = makeWrapperTag("potion_items");

	   public static ITag.INamedTag<Item> makeWrapperTag(String id) {
	      return collection.createTag(id);
	   }

	   public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name) {
	       return createOptional(name, null);
	   }

	   public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Item>> defaults) {
	      return collection.createOptional(name, defaults);
	   }

	   public static ITagCollection<Item> getCollection() {
	      return collection.getCollection();
	   }

	   public static List<? extends ITag.INamedTag<Item>> getAllTags() {
	      return collection.getTags();
	   }
}
