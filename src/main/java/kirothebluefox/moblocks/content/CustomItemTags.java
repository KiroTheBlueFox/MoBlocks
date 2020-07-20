package kirothebluefox.moblocks.content;

import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollection;
import net.minecraft.tags.TagRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomItemTags {
	private static final TagRegistry<Item> collection = new TagRegistry<>();
	
	public static final ITag.INamedTag<Item> LAMP_SHADES = makeWrapperTag("lamp_shades");
	public static final ITag.INamedTag<Item> BOOK_ITEMS = makeWrapperTag("book_items");
	
	public static ITag.INamedTag<Item> makeWrapperTag(String p_199901_0_) {
		return collection.func_232937_a_(p_199901_0_);
	}

	public static void setCollection(TagCollection<Item> collectionIn) {
		collection.func_232935_a_(collectionIn);
	}

	@OnlyIn(Dist.CLIENT)
	public static void func_232915_a_() {
		collection.func_232932_a_();
	}

	public static TagCollection<Item> getCollection() {
		return collection.func_232939_b_();
   	}

	public static Set<ResourceLocation> func_232917_b_(TagCollection<Item> p_232917_0_) {
		return collection.func_232940_b_(p_232917_0_);
	}
}
