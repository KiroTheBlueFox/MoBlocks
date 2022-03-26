package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CustomBlockTags {
	private static TagKey<Block> collection = BlockTags.create(new ResourceLocation(MoBlocks.MODID, "tags/blocks")); /*StaticTags.create(new ResourceLocation(MoBlocks.MODID, "block"), TagContainer::getBlocks);*/

	public static final TagKey<Block> VERTICAL_SLABS = makeWrapperTag("vertical_slabs");
	public static final TagKey<Block> VERTICAL_STAIRS = makeWrapperTag("vertical_stairs");
	public static final TagKey<Block> PILLARS = makeWrapperTag("pillars");
	public static final TagKey<Block> RAMPS = makeWrapperTag("ramps");
	public static final TagKey<Block> ARCHES = makeWrapperTag("arches");
	public static final TagKey<Block> INVERTED_ARCHES = makeWrapperTag("inverted_arches");
	public static final TagKey<Block> TRIANGLE_RAMPS = makeWrapperTag("triangle_ramps");
	public static final TagKey<Block> LOWER_SMALL_ARCHES = makeWrapperTag("lower_small_arches");
	public static final TagKey<Block> UPPER_SMALL_ARCHES = makeWrapperTag("upper_small_arches");
	public static final TagKey<Block> LOWER_SMALL_INVERTED_ARCHES = makeWrapperTag("lower_small_inverted_arches");
	public static final TagKey<Block> UPPER_SMALL_INVERTED_ARCHES = makeWrapperTag("upper_small_inverted_arches");
	public static final TagKey<Block> POSTS = makeWrapperTag("posts");
	public static final TagKey<Block> TALL_FENCES = makeWrapperTag("tall_fences");
	public static final TagKey<Block> TABLES = makeWrapperTag("tables");
	public static final TagKey<Block> CHAIRS = makeWrapperTag("chairs");
	public static final TagKey<Block> COFFEE_TABLES = makeWrapperTag("coffee_tables");
	public static final TagKey<Block> TALL_FENCE_GATES = makeWrapperTag("tall_fence_gates");
	public static final TagKey<Block> SOFAS = makeWrapperTag("sofas");
	public static final TagKey<Block> CARPETS = makeWrapperTag("carpets");
	public static final TagKey<Block> SMALL_LAMPS = makeWrapperTag("small_lamps");
	public static final TagKey<Block> SIMPLE_DRAWERS  = makeWrapperTag("simple_drawers");
	public static final TagKey<Block> DOUBLE_DRAWERS = makeWrapperTag("double_drawers");
	public static final TagKey<Block> SHELVES = makeWrapperTag("shelves");
	public static final TagKey<Block> CRATES = makeWrapperTag("crates");
	public static final TagKey<Block> BOOKSHELVES = makeWrapperTag("bookshelves");
	public static final TagKey<Block> POTIONSHELVES = makeWrapperTag("potionshelves");
	public static final TagKey<Block> COLORABLE_BLOCKS = makeWrapperTag("colorable_blocks");
	public static final TagKey<Block> CONCRETE = makeWrapperTag("concrete");
	public static final TagKey<Block> GLASS_PANE = makeWrapperTag("glass_pane");
	public static final TagKey<Block> KITCHEN_COUNTERS = makeWrapperTag("kitchen_counters");

	public static TagKey<Block> makeWrapperTag(String id) {
		return BlockTags.create(new ResourceLocation(MoBlocks.MODID, id));
   	}
}
