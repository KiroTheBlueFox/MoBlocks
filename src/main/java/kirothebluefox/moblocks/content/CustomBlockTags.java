package kirothebluefox.moblocks.content;

import java.util.List;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollection;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class CustomBlockTags {
	private static TagRegistry<Block> collection = TagRegistryManager.create(new ResourceLocation(MoBlocks.MODID, "block"), ITagCollectionSupplier::getBlockTags);
	public static final ITag.INamedTag<Block> VERTICAL_SLABS = makeWrapperTag("vertical_slabs");
	public static final ITag.INamedTag<Block> VERTICAL_STAIRS = makeWrapperTag("vertical_stairs");
	public static final ITag.INamedTag<Block> PILLARS = makeWrapperTag("pillars");
	public static final ITag.INamedTag<Block> RAMPS = makeWrapperTag("ramps");
	public static final ITag.INamedTag<Block> ARCHES = makeWrapperTag("arches");
	public static final ITag.INamedTag<Block> INVERTED_ARCHES = makeWrapperTag("inverted_arches");
	public static final ITag.INamedTag<Block> TRIANGLE_RAMPS = makeWrapperTag("triangle_ramps");
	public static final ITag.INamedTag<Block> LOWER_SMALL_ARCHES = makeWrapperTag("lower_small_arches");
	public static final ITag.INamedTag<Block> UPPER_SMALL_ARCHES = makeWrapperTag("upper_small_arches");
	public static final ITag.INamedTag<Block> LOWER_SMALL_INVERTED_ARCHES = makeWrapperTag("lower_small_inverted_arches");
	public static final ITag.INamedTag<Block> UPPER_SMALL_INVERTED_ARCHES = makeWrapperTag("upper_small_inverted_arches");
	public static final ITag.INamedTag<Block> POSTS = makeWrapperTag("posts");
	public static final ITag.INamedTag<Block> TALL_FENCES = makeWrapperTag("tall_fences");
	public static final ITag.INamedTag<Block> TABLES = makeWrapperTag("tables");
	public static final ITag.INamedTag<Block> CHAIRS = makeWrapperTag("chairs");
	public static final ITag.INamedTag<Block> COFFEE_TABLES = makeWrapperTag("coffee_tables");
	public static final ITag.INamedTag<Block> TALL_FENCE_GATES = makeWrapperTag("tall_fence_gates");
	public static final ITag.INamedTag<Block> SOFAS = makeWrapperTag("sofas");
	public static final ITag.INamedTag<Block> CARPETS = makeWrapperTag("carpets");
	public static final ITag.INamedTag<Block> SMALL_LAMPS = makeWrapperTag("small_lamps");
	public static final ITag.INamedTag<Block> SIMPLE_DRAWERS  = makeWrapperTag("simple_drawers");
	public static final ITag.INamedTag<Block> DOUBLE_DRAWERS = makeWrapperTag("double_drawers");
	public static final ITag.INamedTag<Block> SHELVES = makeWrapperTag("shelves");
	public static final ITag.INamedTag<Block> CRATES = makeWrapperTag("crates");
	public static final ITag.INamedTag<Block> BOOKSHELVES = makeWrapperTag("bookshelves");
	public static final ITag.INamedTag<Block> POTIONSHELVES = makeWrapperTag("potionshelves");
	public static final ITag.INamedTag<Block> COLORABLE_BLOCKS = makeWrapperTag("colorable_blocks");
	public static final ITag.INamedTag<Block> CONCRETE = makeWrapperTag("concrete");
	public static final ITag.INamedTag<Block> GLASS_PANE = makeWrapperTag("glass_pane");
	public static final ITag.INamedTag<Block> KITCHEN_COUNTERS = makeWrapperTag("kitchen_counters");

	public static ITag.INamedTag<Block> makeWrapperTag(String id) {
		return collection.createTag(id);
   	}

	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(ResourceLocation name) {
		return createOptional(name, null);
	}

	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Block>> defaults) {
		return collection.createOptional(name, defaults);
	}

	public static ITagCollection<Block> getCollection() {
		return collection.getCollection();
	}

	public static List<? extends ITag.INamedTag<Block>> getAllTags() {
		return collection.getTags();
	}
}
