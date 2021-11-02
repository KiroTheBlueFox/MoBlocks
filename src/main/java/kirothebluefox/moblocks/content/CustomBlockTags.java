package kirothebluefox.moblocks.content;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollection;
import net.minecraft.world.level.block.Block;

public class CustomBlockTags {
	private static StaticTagHelper<Block> collection = StaticTags.create(Registry.BLOCK_REGISTRY, "tags/blocks"); /*StaticTags.create(new ResourceLocation(MoBlocks.MODID, "block"), TagContainer::getBlocks);*/

	public static final Tag.Named<Block> VERTICAL_SLABS = makeWrapperTag("vertical_slabs");
	public static final Tag.Named<Block> VERTICAL_STAIRS = makeWrapperTag("vertical_stairs");
	public static final Tag.Named<Block> PILLARS = makeWrapperTag("pillars");
	public static final Tag.Named<Block> RAMPS = makeWrapperTag("ramps");
	public static final Tag.Named<Block> ARCHES = makeWrapperTag("arches");
	public static final Tag.Named<Block> INVERTED_ARCHES = makeWrapperTag("inverted_arches");
	public static final Tag.Named<Block> TRIANGLE_RAMPS = makeWrapperTag("triangle_ramps");
	public static final Tag.Named<Block> LOWER_SMALL_ARCHES = makeWrapperTag("lower_small_arches");
	public static final Tag.Named<Block> UPPER_SMALL_ARCHES = makeWrapperTag("upper_small_arches");
	public static final Tag.Named<Block> LOWER_SMALL_INVERTED_ARCHES = makeWrapperTag("lower_small_inverted_arches");
	public static final Tag.Named<Block> UPPER_SMALL_INVERTED_ARCHES = makeWrapperTag("upper_small_inverted_arches");
	public static final Tag.Named<Block> POSTS = makeWrapperTag("posts");
	public static final Tag.Named<Block> TALL_FENCES = makeWrapperTag("tall_fences");
	public static final Tag.Named<Block> TABLES = makeWrapperTag("tables");
	public static final Tag.Named<Block> CHAIRS = makeWrapperTag("chairs");
	public static final Tag.Named<Block> COFFEE_TABLES = makeWrapperTag("coffee_tables");
	public static final Tag.Named<Block> TALL_FENCE_GATES = makeWrapperTag("tall_fence_gates");
	public static final Tag.Named<Block> SOFAS = makeWrapperTag("sofas");
	public static final Tag.Named<Block> CARPETS = makeWrapperTag("carpets");
	public static final Tag.Named<Block> SMALL_LAMPS = makeWrapperTag("small_lamps");
	public static final Tag.Named<Block> SIMPLE_DRAWERS  = makeWrapperTag("simple_drawers");
	public static final Tag.Named<Block> DOUBLE_DRAWERS = makeWrapperTag("double_drawers");
	public static final Tag.Named<Block> SHELVES = makeWrapperTag("shelves");
	public static final Tag.Named<Block> CRATES = makeWrapperTag("crates");
	public static final Tag.Named<Block> BOOKSHELVES = makeWrapperTag("bookshelves");
	public static final Tag.Named<Block> POTIONSHELVES = makeWrapperTag("potionshelves");
	public static final Tag.Named<Block> COLORABLE_BLOCKS = makeWrapperTag("colorable_blocks");
	public static final Tag.Named<Block> CONCRETE = makeWrapperTag("concrete");
	public static final Tag.Named<Block> GLASS_PANE = makeWrapperTag("glass_pane");
	public static final Tag.Named<Block> KITCHEN_COUNTERS = makeWrapperTag("kitchen_counters");

	public static Tag.Named<Block> makeWrapperTag(String id) {
		return collection.bind(id);
   	}

	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(ResourceLocation name) {
		return createOptional(name, null);
	}

	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Block> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Block>> defaults) {
		return collection.createOptional(name, defaults);
	}

	public static TagCollection<Block> getCollection() {
		return collection.getAllTags();
	}

	public static TagCollection<Block> getAllTags() {
		return collection.getAllTags();
	}
}
