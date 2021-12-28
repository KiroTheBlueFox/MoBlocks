package kirothebluefox.moblocks.common.init;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum ModCustomModels {
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
    BOOK_PAGES_MODEL(null, new ResourceLocation(MoBlocks.MODID, "block/furnitures/bookshelves/book_pages")),

    OAK_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.OAK_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/oak")),
    SPRUCE_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.SPRUCE_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/spruce")),
    BIRCH_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.BIRCH_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/birch")),
    JUNGLE_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.JUNGLE_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/jungle")),
    ACACIA_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.ACACIA_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/acacia")),
    DARK_OAK_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.DARK_OAK_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/dark_oak")),
    CRIMSON_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.CRIMSON_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/crimson")),
    WARPED_CABINET_KITCHEN_COUNTER_DOOR_MODEL(Blocks.WARPED_PLANKS, new ResourceLocation(MoBlocks.MODID, "block/furnitures/kitchen_counters/cabinet/cabinet_doors/warped")),
    EYEBALL_LAMP(null, new ResourceLocation(MoBlocks.MODID, "block/decoration/eyeball_lamp")),
    NEON_BLOCK(Blocks.WHITE_CONCRETE, new ResourceLocation(MoBlocks.MODID, "block/decoration/neon_block"));

    private final Block baseBlock;
    private final ResourceLocation location;

    ModCustomModels(Block baseBlock, ResourceLocation location) {
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
