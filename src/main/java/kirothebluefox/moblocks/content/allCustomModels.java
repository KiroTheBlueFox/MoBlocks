package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;

public enum allCustomModels {
	OAK_DRAWER_MODEL(Blocks.OAK_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/oak/drawer")),
	SPRUCE_DRAWER_MODEL(Blocks.SPRUCE_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/spruce/drawer")),
	BIRCH_DRAWER_MODEL(Blocks.BIRCH_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/birch/drawer")),
	JUNGLE_DRAWER_MODEL(Blocks.JUNGLE_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/jungle/drawer")),
	ACACIA_DRAWER_MODEL(Blocks.ACACIA_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/acacia/drawer")),
	DARK_OAK_DRAWER_MODEL(Blocks.DARK_OAK_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/dark_oak/drawer")),
	NETHER_BRICK_DRAWER_MODEL(Blocks.NETHER_BRICKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/nether_brick/drawer")),
	CRIMSON_DRAWER_MODEL(Blocks.CRIMSON_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/crimson/drawer")),
	WARPED_DRAWER_MODEL(Blocks.WARPED_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/drawers/simple/warped/drawer")),
	BOOK_COVER_MODEL(null, new ResourceLocation(MoBlocks.MODID, "block/furnitures/bookshelves/book_cover")),
	BOOK_PAGES_MODEL(null, new ResourceLocation(MoBlocks.MODID, "block/furnitures/bookshelves/book_pages")),;
	
	private Block baseBlock;
	private ResourceLocation location;
	
	private allCustomModels(Block baseBlock, ResourceLocation location) {
		this.baseBlock = baseBlock;
		this.location = location;
	}
	
	public ResourceLocation getLocation() {
		return this.location;
	}
	
	public Block getBaseBlock() {
		return this.baseBlock;
	}
}
