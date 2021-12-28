package kirothebluefox.moblocks.common.init;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.*;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.inkblock.InkBlock;
import kirothebluefox.moblocks.common.blocks.decoration.colorableflowerpot.ColorableFlowerPot;
import kirothebluefox.moblocks.common.blocks.decoration.colorablefurnitures.*;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.eyeballlamp.EyeballLamp;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.lavalamp.LavaLamp;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.neonblock.GlowingNeonBlock;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.neonblock.NeonBlock;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.rainbowblock.RainbowBlock;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.signaltowerlight.SignalTowerLight;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.siren.Siren;
import kirothebluefox.moblocks.common.blocks.furnitures.*;
import kirothebluefox.moblocks.common.blocks.furnitures.bookshelves.Bookshelf;
import kirothebluefox.moblocks.common.blocks.furnitures.crates.Crate;
import kirothebluefox.moblocks.common.blocks.furnitures.drawers.doubles.DoubleDrawer;
import kirothebluefox.moblocks.common.blocks.furnitures.drawers.simples.SimpleDrawer;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.InnerCornerKitchenCounter;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.OuterCornerKitchenCounter;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.StraightKitchenCounter;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.colorable.ColorableInnerCornerKitchenCounter;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.colorable.ColorableOuterCornerKitchenCounter;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.colorable.ColorableStraightKitchenCounter;
import kirothebluefox.moblocks.common.blocks.furnitures.lamps.SmallLamp;
import kirothebluefox.moblocks.common.blocks.furnitures.potionshelves.PotionShelf;
import kirothebluefox.moblocks.common.blocks.furnitures.shelves.Shelf;
import kirothebluefox.moblocks.common.blocks.specialblocks.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoBlocks.MODID);

    /* Special Blocks */
    /*Arches*/
    public static final RegistryObject<Block> OAK_ARCH = BLOCKS.register("oak_arch", () -> new ArchBlock("oak_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_ARCH = BLOCKS.register("spruce_arch", () -> new ArchBlock("spruce_arch", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_ARCH = BLOCKS.register("birch_arch", () -> new ArchBlock("birch_arch", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_ARCH = BLOCKS.register("jungle_arch", () -> new ArchBlock("jungle_arch", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_ARCH = BLOCKS.register("acacia_arch", () -> new ArchBlock("acacia_arch", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_ARCH = BLOCKS.register("dark_oak_arch", () -> new ArchBlock("dark_oak_arch", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> COBBLESTONE_ARCH = BLOCKS.register("cobblestone_arch", () -> new ArchBlock("cobblestone_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> ANDESITE_ARCH = BLOCKS.register("andesite_arch", () -> new ArchBlock("andesite_arch", Blocks.ANDESITE));
    public static final RegistryObject<Block> BRICK_ARCH = BLOCKS.register("brick_arch", () -> new ArchBlock("brick_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_ARCH = BLOCKS.register("dark_prismarine_arch", () -> new ArchBlock("dark_prismarine_arch", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> DIORITE_ARCH = BLOCKS.register("diorite_arch", () -> new ArchBlock("diorite_arch", Blocks.DIORITE));
    public static final RegistryObject<Block> END_STONE_BRICK_ARCH = BLOCKS.register("end_stone_brick_arch", () -> new ArchBlock("end_stone_brick_arch", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> GRANITE_ARCH = BLOCKS.register("granite_arch", () -> new ArchBlock("granite_arch", Blocks.GRANITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_ARCH = BLOCKS.register("mossy_cobblestone_arch", () -> new ArchBlock("mossy_cobblestone_arch", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_ARCH = BLOCKS.register("mossy_stone_brick_arch", () -> new ArchBlock("mossy_stone_brick_arch", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_ARCH = BLOCKS.register("nether_brick_arch", () -> new ArchBlock("nether_brick_arch", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_ARCH = BLOCKS.register("polished_andesite_arch", () -> new ArchBlock("polished_andesite_arch", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> POLISHED_GRANITE_ARCH = BLOCKS.register("polished_granite_arch", () -> new ArchBlock("polished_granite_arch", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> POLISHED_DIORITE_ARCH = BLOCKS.register("polished_diorite_arch", () -> new ArchBlock("polished_diorite_arch", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_ARCH = BLOCKS.register("prismarine_brick_arch", () -> new ArchBlock("prismarine_brick_arch", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> PRISMARINE_ARCH = BLOCKS.register("prismarine_arch", () -> new ArchBlock("prismarine_arch", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PURPUR_ARCH = BLOCKS.register("purpur_arch", () -> new ArchBlock("purpur_arch", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> QUARTZ_ARCH = BLOCKS.register("quartz_arch", () -> new ArchBlock("quartz_arch", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> RED_NETHER_BRICK_ARCH = BLOCKS.register("red_nether_brick_arch", () -> new ArchBlock("red_nether_brick_arch", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> RED_SANDSTONE_ARCH = BLOCKS.register("red_sandstone_arch", () -> new ArchBlock("red_sandstone_arch", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> SANDSTONE_ARCH = BLOCKS.register("sandstone_arch", () -> new ArchBlock("sandstone_arch", Blocks.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_ARCH = BLOCKS.register("smooth_quartz_arch", () -> new ArchBlock("smooth_quartz_arch", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_ARCH = BLOCKS.register("smooth_red_sandstone_arch", () -> new ArchBlock("smooth_red_sandstone_arch", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_ARCH = BLOCKS.register("smooth_sandstone_arch", () -> new ArchBlock("smooth_sandstone_arch", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> STONE_BRICK_ARCH = BLOCKS.register("stone_brick_arch", () -> new ArchBlock("stone_brick_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> STONE_ARCH = BLOCKS.register("stone_arch", () -> new ArchBlock("stone_arch", Blocks.STONE));

    /*Vertical Slabs*/
    public static final RegistryObject<Block> OAK_VERTICAL_SLAB = BLOCKS.register("oak_vertical_slab", () -> new VerticalSlab("oak_vertical_slab", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_VERTICAL_SLAB = BLOCKS.register("spruce_vertical_slab", () -> new VerticalSlab("spruce_vertical_slab", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_VERTICAL_SLAB = BLOCKS.register("birch_vertical_slab", () -> new VerticalSlab("birch_vertical_slab", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_VERTICAL_SLAB = BLOCKS.register("jungle_vertical_slab", () -> new VerticalSlab("jungle_vertical_slab", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_VERTICAL_SLAB = BLOCKS.register("acacia_vertical_slab", () -> new VerticalSlab("acacia_vertical_slab", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_VERTICAL_SLAB = BLOCKS.register("dark_oak_vertical_slab", () -> new VerticalSlab("dark_oak_vertical_slab", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_VERTICAL_SLAB = BLOCKS.register("purpur_vertical_slab", () -> new VerticalSlab("purpur_vertical_slab", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_VERTICAL_SLAB = BLOCKS.register("cobblestone_vertical_slab", () -> new VerticalSlab("cobblestone_vertical_slab", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_VERTICAL_SLAB = BLOCKS.register("brick_vertical_slab", () -> new VerticalSlab("brick_vertical_slab", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_VERTICAL_SLAB = BLOCKS.register("stone_brick_vertical_slab", () -> new VerticalSlab("stone_brick_vertical_slab", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_VERTICAL_SLAB = BLOCKS.register("nether_brick_vertical_slab", () -> new VerticalSlab("nether_brick_vertical_slab", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_VERTICAL_SLAB = BLOCKS.register("sandstone_vertical_slab", () -> new VerticalSlab("sandstone_vertical_slab", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_VERTICAL_SLAB = BLOCKS.register("quartz_vertical_slab", () -> new VerticalSlab("quartz_vertical_slab", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_VERTICAL_SLAB = BLOCKS.register("prismarine_vertical_slab", () -> new VerticalSlab("prismarine_vertical_slab", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_VERTICAL_SLAB = BLOCKS.register("prismarine_brick_vertical_slab", () -> new VerticalSlab("prismarine_brick_vertical_slab", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_VERTICAL_SLAB = BLOCKS.register("dark_prismarine_vertical_slab", () -> new VerticalSlab("dark_prismarine_vertical_slab", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_VERTICAL_SLAB = BLOCKS.register("red_sandstone_vertical_slab", () -> new VerticalSlab("red_sandstone_vertical_slab", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_VERTICAL_SLAB = BLOCKS.register("polished_granite_vertical_slab", () -> new VerticalSlab("polished_granite_vertical_slab", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_VERTICAL_SLAB = BLOCKS.register("smooth_red_sandstone_vertical_slab", () -> new VerticalSlab("smooth_red_sandstone_vertical_slab", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_VERTICAL_SLAB = BLOCKS.register("mossy_stone_brick_vertical_slab", () -> new VerticalSlab("mossy_stone_brick_vertical_slab", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_VERTICAL_SLAB = BLOCKS.register("polished_diorite_vertical_slab", () -> new VerticalSlab("polished_diorite_vertical_slab", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_VERTICAL_SLAB = BLOCKS.register("mossy_cobblestone_vertical_slab", () -> new VerticalSlab("mossy_cobblestone_vertical_slab", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_VERTICAL_SLAB = BLOCKS.register("end_stone_brick_vertical_slab", () -> new VerticalSlab("end_stone_brick_vertical_slab", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_VERTICAL_SLAB = BLOCKS.register("stone_vertical_slab", () -> new VerticalSlab("stone_vertical_slab", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_VERTICAL_SLAB = BLOCKS.register("smooth_sandstone_vertical_slab", () -> new VerticalSlab("smooth_sandstone_vertical_slab", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_VERTICAL_SLAB = BLOCKS.register("smooth_quartz_vertical_slab", () -> new VerticalSlab("smooth_quartz_vertical_slab", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_VERTICAL_SLAB = BLOCKS.register("granite_vertical_slab", () -> new VerticalSlab("granite_vertical_slab", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_VERTICAL_SLAB = BLOCKS.register("andesite_vertical_slab", () -> new VerticalSlab("andesite_vertical_slab", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_VERTICAL_SLAB = BLOCKS.register("red_nether_brick_vertical_slab", () -> new VerticalSlab("red_nether_brick_vertical_slab", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_VERTICAL_SLAB = BLOCKS.register("polished_andesite_vertical_slab", () -> new VerticalSlab("polished_andesite_vertical_slab", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_VERTICAL_SLAB = BLOCKS.register("diorite_vertical_slab", () -> new VerticalSlab("diorite_vertical_slab", Blocks.DIORITE));
    public static final RegistryObject<Block> SMOOTH_STONE_VERTICAL_SLAB = BLOCKS.register("smooth_stone_vertical_slab", () -> new VerticalSlab("smooth_stone_vertical_slab", Blocks.SMOOTH_STONE));

    /*Vertical Stairs*/
    public static final RegistryObject<Block> OAK_VERTICAL_STAIRS = BLOCKS.register("oak_vertical_stairs", () -> new VerticalStairs("oak_vertical_stairs", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_VERTICAL_STAIRS = BLOCKS.register("spruce_vertical_stairs", () -> new VerticalStairs("spruce_vertical_stairs", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_VERTICAL_STAIRS = BLOCKS.register("birch_vertical_stairs", () -> new VerticalStairs("birch_vertical_stairs", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_VERTICAL_STAIRS = BLOCKS.register("jungle_vertical_stairs", () -> new VerticalStairs("jungle_vertical_stairs", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_VERTICAL_STAIRS = BLOCKS.register("acacia_vertical_stairs", () -> new VerticalStairs("acacia_vertical_stairs", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_VERTICAL_STAIRS = BLOCKS.register("dark_oak_vertical_stairs", () -> new VerticalStairs("dark_oak_vertical_stairs", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_VERTICAL_STAIRS = BLOCKS.register("purpur_vertical_stairs", () -> new VerticalStairs("purpur_vertical_stairs", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_VERTICAL_STAIRS = BLOCKS.register("cobblestone_vertical_stairs", () -> new VerticalStairs("cobblestone_vertical_stairs", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_VERTICAL_STAIRS = BLOCKS.register("brick_vertical_stairs", () -> new VerticalStairs("brick_vertical_stairs", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_VERTICAL_STAIRS = BLOCKS.register("stone_brick_vertical_stairs", () -> new VerticalStairs("stone_brick_vertical_stairs", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_VERTICAL_STAIRS = BLOCKS.register("nether_brick_vertical_stairs", () -> new VerticalStairs("nether_brick_vertical_stairs", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_VERTICAL_STAIRS = BLOCKS.register("sandstone_vertical_stairs", () -> new VerticalStairs("sandstone_vertical_stairs", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_VERTICAL_STAIRS = BLOCKS.register("quartz_vertical_stairs", () -> new VerticalStairs("quartz_vertical_stairs", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_VERTICAL_STAIRS = BLOCKS.register("prismarine_vertical_stairs", () -> new VerticalStairs("prismarine_vertical_stairs", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_VERTICAL_STAIRS = BLOCKS.register("prismarine_brick_vertical_stairs", () -> new VerticalStairs("prismarine_brick_vertical_stairs", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_VERTICAL_STAIRS = BLOCKS.register("dark_prismarine_vertical_stairs", () -> new VerticalStairs("dark_prismarine_vertical_stairs", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_VERTICAL_STAIRS = BLOCKS.register("red_sandstone_vertical_stairs", () -> new VerticalStairs("red_sandstone_vertical_stairs", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_VERTICAL_STAIRS = BLOCKS.register("polished_granite_vertical_stairs", () -> new VerticalStairs("polished_granite_vertical_stairs", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS = BLOCKS.register("smooth_red_sandstone_vertical_stairs", () -> new VerticalStairs("smooth_red_sandstone_vertical_stairs", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_VERTICAL_STAIRS = BLOCKS.register("mossy_stone_brick_vertical_stairs", () -> new VerticalStairs("mossy_stone_brick_vertical_stairs", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_VERTICAL_STAIRS = BLOCKS.register("polished_diorite_vertical_stairs", () -> new VerticalStairs("polished_diorite_vertical_stairs", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_VERTICAL_STAIRS = BLOCKS.register("mossy_cobblestone_vertical_stairs", () -> new VerticalStairs("mossy_cobblestone_vertical_stairs", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_VERTICAL_STAIRS = BLOCKS.register("end_stone_brick_vertical_stairs", () -> new VerticalStairs("end_stone_brick_vertical_stairs", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_VERTICAL_STAIRS = BLOCKS.register("stone_vertical_stairs", () -> new VerticalStairs("stone_vertical_stairs", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_VERTICAL_STAIRS = BLOCKS.register("smooth_sandstone_vertical_stairs", () -> new VerticalStairs("smooth_sandstone_vertical_stairs", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_VERTICAL_STAIRS = BLOCKS.register("smooth_quartz_vertical_stairs", () -> new VerticalStairs("smooth_quartz_vertical_stairs", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_VERTICAL_STAIRS = BLOCKS.register("granite_vertical_stairs", () -> new VerticalStairs("granite_vertical_stairs", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_VERTICAL_STAIRS = BLOCKS.register("andesite_vertical_stairs", () -> new VerticalStairs("andesite_vertical_stairs", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_VERTICAL_STAIRS = BLOCKS.register("red_nether_brick_vertical_stairs", () -> new VerticalStairs("red_nether_brick_vertical_stairs", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_VERTICAL_STAIRS = BLOCKS.register("polished_andesite_vertical_stairs", () -> new VerticalStairs("polished_andesite_vertical_stairs", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_VERTICAL_STAIRS = BLOCKS.register("diorite_vertical_stairs", () -> new VerticalStairs("diorite_vertical_stairs", Blocks.DIORITE));

    /*Pillars*/
    public static final RegistryObject<Block> OAK_PILLAR = BLOCKS.register("oak_pillar", () -> new PillarBlock("oak_pillar", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_PILLAR = BLOCKS.register("spruce_pillar", () -> new PillarBlock("spruce_pillar", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_PILLAR = BLOCKS.register("birch_pillar", () -> new PillarBlock("birch_pillar", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_PILLAR = BLOCKS.register("jungle_pillar", () -> new PillarBlock("jungle_pillar", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_PILLAR = BLOCKS.register("acacia_pillar", () -> new PillarBlock("acacia_pillar", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_PILLAR = BLOCKS.register("dark_oak_pillar", () -> new PillarBlock("dark_oak_pillar", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_PILLAR = BLOCKS.register("purpur_pillar", () -> new PillarBlock("purpur_pillar", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_PILLAR = BLOCKS.register("cobblestone_pillar", () -> new PillarBlock("cobblestone_pillar", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_PILLAR = BLOCKS.register("brick_pillar", () -> new PillarBlock("brick_pillar", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_PILLAR = BLOCKS.register("stone_brick_pillar", () -> new PillarBlock("stone_brick_pillar", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_PILLAR = BLOCKS.register("nether_brick_pillar", () -> new PillarBlock("nether_brick_pillar", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_PILLAR = BLOCKS.register("sandstone_pillar", () -> new PillarBlock("sandstone_pillar", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_PILLAR = BLOCKS.register("quartz_pillar", () -> new PillarBlock("quartz_pillar", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_PILLAR = BLOCKS.register("prismarine_pillar", () -> new PillarBlock("prismarine_pillar", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_PILLAR = BLOCKS.register("prismarine_brick_pillar", () -> new PillarBlock("prismarine_brick_pillar", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_PILLAR = BLOCKS.register("dark_prismarine_pillar", () -> new PillarBlock("dark_prismarine_pillar", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_PILLAR = BLOCKS.register("red_sandstone_pillar", () -> new PillarBlock("red_sandstone_pillar", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_PILLAR = BLOCKS.register("polished_granite_pillar", () -> new PillarBlock("polished_granite_pillar", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_PILLAR = BLOCKS.register("smooth_red_sandstone_pillar", () -> new PillarBlock("smooth_red_sandstone_pillar", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_PILLAR = BLOCKS.register("mossy_stone_brick_pillar", () -> new PillarBlock("mossy_stone_brick_pillar", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_PILLAR = BLOCKS.register("polished_diorite_pillar", () -> new PillarBlock("polished_diorite_pillar", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_PILLAR = BLOCKS.register("mossy_cobblestone_pillar", () -> new PillarBlock("mossy_cobblestone_pillar", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_PILLAR = BLOCKS.register("end_stone_brick_pillar", () -> new PillarBlock("end_stone_brick_pillar", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_PILLAR = BLOCKS.register("stone_pillar", () -> new PillarBlock("stone_pillar", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_PILLAR = BLOCKS.register("smooth_sandstone_pillar", () -> new PillarBlock("smooth_sandstone_pillar", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_PILLAR = BLOCKS.register("smooth_quartz_pillar", () -> new PillarBlock("smooth_quartz_pillar", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_PILLAR = BLOCKS.register("granite_pillar", () -> new PillarBlock("granite_pillar", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_PILLAR = BLOCKS.register("andesite_pillar", () -> new PillarBlock("andesite_pillar", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_PILLAR = BLOCKS.register("red_nether_brick_pillar", () -> new PillarBlock("red_nether_brick_pillar", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_PILLAR = BLOCKS.register("polished_andesite_pillar", () -> new PillarBlock("polished_andesite_pillar", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_PILLAR = BLOCKS.register("diorite_pillar", () -> new PillarBlock("diorite_pillar", Blocks.DIORITE));

    /*Ramps*/
    public static final RegistryObject<Block> OAK_RAMP = BLOCKS.register("oak_ramp", () -> new RampBlock("oak_ramp", Blocks.OAK_PLANKS, Blocks.OAK_PLANKS.defaultBlockState()));
    public static final RegistryObject<Block> SPRUCE_RAMP = BLOCKS.register("spruce_ramp", () -> new RampBlock("spruce_ramp", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_PLANKS.defaultBlockState()));
    public static final RegistryObject<Block> BIRCH_RAMP = BLOCKS.register("birch_ramp", () -> new RampBlock("birch_ramp", Blocks.BIRCH_PLANKS, Blocks.BIRCH_PLANKS.defaultBlockState()));
    public static final RegistryObject<Block> JUNGLE_RAMP = BLOCKS.register("jungle_ramp", () -> new RampBlock("jungle_ramp", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_PLANKS.defaultBlockState()));
    public static final RegistryObject<Block> ACACIA_RAMP = BLOCKS.register("acacia_ramp", () -> new RampBlock("acacia_ramp", Blocks.ACACIA_PLANKS, Blocks.ACACIA_PLANKS.defaultBlockState()));
    public static final RegistryObject<Block> DARK_OAK_RAMP = BLOCKS.register("dark_oak_ramp", () -> new RampBlock("dark_oak_ramp", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_PLANKS.defaultBlockState()));
    public static final RegistryObject<Block> PURPUR_RAMP = BLOCKS.register("purpur_ramp", () -> new RampBlock("purpur_ramp", Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK.defaultBlockState()));
    public static final RegistryObject<Block> COBBLESTONE_RAMP = BLOCKS.register("cobblestone_ramp", () -> new RampBlock("cobblestone_ramp", Blocks.COBBLESTONE, Blocks.COBBLESTONE.defaultBlockState()));
    public static final RegistryObject<Block> BRICK_RAMP = BLOCKS.register("brick_ramp", () -> new RampBlock("brick_ramp", Blocks.BRICKS, Blocks.BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> STONE_BRICK_RAMP = BLOCKS.register("stone_brick_ramp", () -> new RampBlock("stone_brick_ramp", Blocks.STONE_BRICKS, Blocks.STONE_BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> NETHER_BRICK_RAMP = BLOCKS.register("nether_brick_ramp", () -> new RampBlock("nether_brick_ramp", Blocks.NETHER_BRICKS, Blocks.NETHER_BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> SANDSTONE_RAMP = BLOCKS.register("sandstone_ramp", () -> new RampBlock("sandstone_ramp", Blocks.SANDSTONE, Blocks.SANDSTONE.defaultBlockState()));
    public static final RegistryObject<Block> QUARTZ_RAMP = BLOCKS.register("quartz_ramp", () -> new RampBlock("quartz_ramp", Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK.defaultBlockState()));
    public static final RegistryObject<Block> PRISMARINE_RAMP = BLOCKS.register("prismarine_ramp", () -> new RampBlock("prismarine_ramp", Blocks.PRISMARINE, Blocks.PRISMARINE.defaultBlockState()));
    public static final RegistryObject<Block> PRISMARINE_BRICK_RAMP = BLOCKS.register("prismarine_brick_ramp", () -> new RampBlock("prismarine_brick_ramp", Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> DARK_PRISMARINE_RAMP = BLOCKS.register("dark_prismarine_ramp", () -> new RampBlock("dark_prismarine_ramp", Blocks.DARK_PRISMARINE, Blocks.DARK_PRISMARINE.defaultBlockState()));
    public static final RegistryObject<Block> RED_SANDSTONE_RAMP = BLOCKS.register("red_sandstone_ramp", () -> new RampBlock("red_sandstone_ramp", Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE.defaultBlockState()));
    public static final RegistryObject<Block> POLISHED_GRANITE_RAMP = BLOCKS.register("polished_granite_ramp", () -> new RampBlock("polished_granite_ramp", Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE.defaultBlockState()));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_RAMP = BLOCKS.register("smooth_red_sandstone_ramp", () -> new RampBlock("smooth_red_sandstone_ramp", Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE.defaultBlockState()));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_RAMP = BLOCKS.register("mossy_stone_brick_ramp", () -> new RampBlock("mossy_stone_brick_ramp", Blocks.MOSSY_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> POLISHED_DIORITE_RAMP = BLOCKS.register("polished_diorite_ramp", () -> new RampBlock("polished_diorite_ramp", Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE.defaultBlockState()));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_RAMP = BLOCKS.register("mossy_cobblestone_ramp", () -> new RampBlock("mossy_cobblestone_ramp", Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE.defaultBlockState()));
    public static final RegistryObject<Block> END_STONE_BRICK_RAMP = BLOCKS.register("end_stone_brick_ramp", () -> new RampBlock("end_stone_brick_ramp", Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> STONE_RAMP = BLOCKS.register("stone_ramp", () -> new RampBlock("stone_ramp", Blocks.STONE, Blocks.STONE.defaultBlockState()));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_RAMP = BLOCKS.register("smooth_sandstone_ramp", () -> new RampBlock("smooth_sandstone_ramp", Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_SANDSTONE.defaultBlockState()));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_RAMP = BLOCKS.register("smooth_quartz_ramp", () -> new RampBlock("smooth_quartz_ramp", Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_QUARTZ.defaultBlockState()));
    public static final RegistryObject<Block> GRANITE_RAMP = BLOCKS.register("granite_ramp", () -> new RampBlock("granite_ramp", Blocks.GRANITE, Blocks.GRANITE.defaultBlockState()));
    public static final RegistryObject<Block> ANDESITE_RAMP = BLOCKS.register("andesite_ramp", () -> new RampBlock("andesite_ramp", Blocks.ANDESITE, Blocks.ANDESITE.defaultBlockState()));
    public static final RegistryObject<Block> RED_NETHER_BRICK_RAMP = BLOCKS.register("red_nether_brick_ramp", () -> new RampBlock("red_nether_brick_ramp", Blocks.RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS.defaultBlockState()));
    public static final RegistryObject<Block> POLISHED_ANDESITE_RAMP = BLOCKS.register("polished_andesite_ramp", () -> new RampBlock("polished_andesite_ramp", Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE.defaultBlockState()));
    public static final RegistryObject<Block> DIORITE_RAMP = BLOCKS.register("diorite_ramp", () -> new RampBlock("diorite_ramp", Blocks.DIORITE, Blocks.DIORITE.defaultBlockState()));

    /*Inverted Arches*/
    public static final RegistryObject<Block> OAK_INVERTED_ARCH = BLOCKS.register("oak_inverted_arch", () -> new InvertedArchBlock("oak_inverted_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_INVERTED_ARCH = BLOCKS.register("spruce_inverted_arch", () -> new InvertedArchBlock("spruce_inverted_arch", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_INVERTED_ARCH = BLOCKS.register("birch_inverted_arch", () -> new InvertedArchBlock("birch_inverted_arch", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_INVERTED_ARCH = BLOCKS.register("jungle_inverted_arch", () -> new InvertedArchBlock("jungle_inverted_arch", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_INVERTED_ARCH = BLOCKS.register("acacia_inverted_arch", () -> new InvertedArchBlock("acacia_inverted_arch", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_INVERTED_ARCH = BLOCKS.register("dark_oak_inverted_arch", () -> new InvertedArchBlock("dark_oak_inverted_arch", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_INVERTED_ARCH = BLOCKS.register("purpur_inverted_arch", () -> new InvertedArchBlock("purpur_inverted_arch", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_INVERTED_ARCH = BLOCKS.register("cobblestone_inverted_arch", () -> new InvertedArchBlock("cobblestone_inverted_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_INVERTED_ARCH = BLOCKS.register("brick_inverted_arch", () -> new InvertedArchBlock("brick_inverted_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_INVERTED_ARCH = BLOCKS.register("stone_brick_inverted_arch", () -> new InvertedArchBlock("stone_brick_inverted_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_INVERTED_ARCH = BLOCKS.register("nether_brick_inverted_arch", () -> new InvertedArchBlock("nether_brick_inverted_arch", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_INVERTED_ARCH = BLOCKS.register("sandstone_inverted_arch", () -> new InvertedArchBlock("sandstone_inverted_arch", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_INVERTED_ARCH = BLOCKS.register("quartz_inverted_arch", () -> new InvertedArchBlock("quartz_inverted_arch", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_INVERTED_ARCH = BLOCKS.register("prismarine_inverted_arch", () -> new InvertedArchBlock("prismarine_inverted_arch", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_INVERTED_ARCH = BLOCKS.register("prismarine_brick_inverted_arch", () -> new InvertedArchBlock("prismarine_brick_inverted_arch", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_INVERTED_ARCH = BLOCKS.register("dark_prismarine_inverted_arch", () -> new InvertedArchBlock("dark_prismarine_inverted_arch", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_INVERTED_ARCH = BLOCKS.register("red_sandstone_inverted_arch", () -> new InvertedArchBlock("red_sandstone_inverted_arch", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_INVERTED_ARCH = BLOCKS.register("polished_granite_inverted_arch", () -> new InvertedArchBlock("polished_granite_inverted_arch", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_INVERTED_ARCH = BLOCKS.register("smooth_red_sandstone_inverted_arch", () -> new InvertedArchBlock("smooth_red_sandstone_inverted_arch", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_INVERTED_ARCH = BLOCKS.register("mossy_stone_brick_inverted_arch", () -> new InvertedArchBlock("mossy_stone_brick_inverted_arch", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_INVERTED_ARCH = BLOCKS.register("polished_diorite_inverted_arch", () -> new InvertedArchBlock("polished_diorite_inverted_arch", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_INVERTED_ARCH = BLOCKS.register("mossy_cobblestone_inverted_arch", () -> new InvertedArchBlock("mossy_cobblestone_inverted_arch", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_INVERTED_ARCH = BLOCKS.register("end_stone_brick_inverted_arch", () -> new InvertedArchBlock("end_stone_brick_inverted_arch", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_INVERTED_ARCH = BLOCKS.register("stone_inverted_arch", () -> new InvertedArchBlock("stone_inverted_arch", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_INVERTED_ARCH = BLOCKS.register("smooth_sandstone_inverted_arch", () -> new InvertedArchBlock("smooth_sandstone_inverted_arch", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_INVERTED_ARCH = BLOCKS.register("smooth_quartz_inverted_arch", () -> new InvertedArchBlock("smooth_quartz_inverted_arch", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_INVERTED_ARCH = BLOCKS.register("granite_inverted_arch", () -> new InvertedArchBlock("granite_inverted_arch", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_INVERTED_ARCH = BLOCKS.register("andesite_inverted_arch", () -> new InvertedArchBlock("andesite_inverted_arch", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_INVERTED_ARCH = BLOCKS.register("red_nether_brick_inverted_arch", () -> new InvertedArchBlock("red_nether_brick_inverted_arch", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_INVERTED_ARCH = BLOCKS.register("polished_andesite_inverted_arch", () -> new InvertedArchBlock("polished_andesite_inverted_arch", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_INVERTED_ARCH = BLOCKS.register("diorite_inverted_arch", () -> new InvertedArchBlock("diorite_inverted_arch", Blocks.DIORITE));

    /*Triangle Ramps*/
    public static final RegistryObject<Block> OAK_TRIANGLE_RAMP = BLOCKS.register("oak_triangle_ramp", () -> new TriangleRamp("oak_triangle_ramp", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_TRIANGLE_RAMP = BLOCKS.register("spruce_triangle_ramp", () -> new TriangleRamp("spruce_triangle_ramp", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_TRIANGLE_RAMP = BLOCKS.register("birch_triangle_ramp", () -> new TriangleRamp("birch_triangle_ramp", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_TRIANGLE_RAMP = BLOCKS.register("jungle_triangle_ramp", () -> new TriangleRamp("jungle_triangle_ramp", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_TRIANGLE_RAMP = BLOCKS.register("acacia_triangle_ramp", () -> new TriangleRamp("acacia_triangle_ramp", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_TRIANGLE_RAMP = BLOCKS.register("dark_oak_triangle_ramp", () -> new TriangleRamp("dark_oak_triangle_ramp", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_TRIANGLE_RAMP = BLOCKS.register("purpur_triangle_ramp", () -> new TriangleRamp("purpur_triangle_ramp", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_TRIANGLE_RAMP = BLOCKS.register("cobblestone_triangle_ramp", () -> new TriangleRamp("cobblestone_triangle_ramp", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_TRIANGLE_RAMP = BLOCKS.register("brick_triangle_ramp", () -> new TriangleRamp("brick_triangle_ramp", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_TRIANGLE_RAMP = BLOCKS.register("stone_brick_triangle_ramp", () -> new TriangleRamp("stone_brick_triangle_ramp", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_TRIANGLE_RAMP = BLOCKS.register("nether_brick_triangle_ramp", () -> new TriangleRamp("nether_brick_triangle_ramp", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_TRIANGLE_RAMP = BLOCKS.register("sandstone_triangle_ramp", () -> new TriangleRamp("sandstone_triangle_ramp", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_TRIANGLE_RAMP = BLOCKS.register("quartz_triangle_ramp", () -> new TriangleRamp("quartz_triangle_ramp", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_TRIANGLE_RAMP = BLOCKS.register("prismarine_triangle_ramp", () -> new TriangleRamp("prismarine_triangle_ramp", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_TRIANGLE_RAMP = BLOCKS.register("prismarine_brick_triangle_ramp", () -> new TriangleRamp("prismarine_brick_triangle_ramp", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_TRIANGLE_RAMP = BLOCKS.register("dark_prismarine_triangle_ramp", () -> new TriangleRamp("dark_prismarine_triangle_ramp", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_TRIANGLE_RAMP = BLOCKS.register("red_sandstone_triangle_ramp", () -> new TriangleRamp("red_sandstone_triangle_ramp", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_TRIANGLE_RAMP = BLOCKS.register("polished_granite_triangle_ramp", () -> new TriangleRamp("polished_granite_triangle_ramp", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_TRIANGLE_RAMP = BLOCKS.register("smooth_red_sandstone_triangle_ramp", () -> new TriangleRamp("smooth_red_sandstone_triangle_ramp", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_TRIANGLE_RAMP = BLOCKS.register("mossy_stone_brick_triangle_ramp", () -> new TriangleRamp("mossy_stone_brick_triangle_ramp", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_TRIANGLE_RAMP = BLOCKS.register("polished_diorite_triangle_ramp", () -> new TriangleRamp("polished_diorite_triangle_ramp", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_TRIANGLE_RAMP = BLOCKS.register("mossy_cobblestone_triangle_ramp", () -> new TriangleRamp("mossy_cobblestone_triangle_ramp", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_TRIANGLE_RAMP = BLOCKS.register("end_stone_brick_triangle_ramp", () -> new TriangleRamp("end_stone_brick_triangle_ramp", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_TRIANGLE_RAMP = BLOCKS.register("stone_triangle_ramp", () -> new TriangleRamp("stone_triangle_ramp", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_TRIANGLE_RAMP = BLOCKS.register("smooth_sandstone_triangle_ramp", () -> new TriangleRamp("smooth_sandstone_triangle_ramp", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_TRIANGLE_RAMP = BLOCKS.register("smooth_quartz_triangle_ramp", () -> new TriangleRamp("smooth_quartz_triangle_ramp", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_TRIANGLE_RAMP = BLOCKS.register("granite_triangle_ramp", () -> new TriangleRamp("granite_triangle_ramp", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_TRIANGLE_RAMP = BLOCKS.register("andesite_triangle_ramp", () -> new TriangleRamp("andesite_triangle_ramp", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_TRIANGLE_RAMP = BLOCKS.register("red_nether_brick_triangle_ramp", () -> new TriangleRamp("red_nether_brick_triangle_ramp", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_TRIANGLE_RAMP = BLOCKS.register("polished_andesite_triangle_ramp", () -> new TriangleRamp("polished_andesite_triangle_ramp", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_TRIANGLE_RAMP = BLOCKS.register("diorite_triangle_ramp", () -> new TriangleRamp("diorite_triangle_ramp", Blocks.DIORITE));

    /* Upper Small Arches */
    public static final RegistryObject<Block> OAK_UPPER_SMALL_ARCH = BLOCKS.register("oak_upper_small_arch", () -> new UpperSmallArch("oak_upper_small_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_UPPER_SMALL_ARCH = BLOCKS.register("spruce_upper_small_arch", () -> new UpperSmallArch("spruce_upper_small_arch", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_UPPER_SMALL_ARCH = BLOCKS.register("birch_upper_small_arch", () -> new UpperSmallArch("birch_upper_small_arch", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_UPPER_SMALL_ARCH = BLOCKS.register("jungle_upper_small_arch", () -> new UpperSmallArch("jungle_upper_small_arch", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_UPPER_SMALL_ARCH = BLOCKS.register("acacia_upper_small_arch", () -> new UpperSmallArch("acacia_upper_small_arch", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_UPPER_SMALL_ARCH = BLOCKS.register("dark_oak_upper_small_arch", () -> new UpperSmallArch("dark_oak_upper_small_arch", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_UPPER_SMALL_ARCH = BLOCKS.register("purpur_upper_small_arch", () -> new UpperSmallArch("purpur_upper_small_arch", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_UPPER_SMALL_ARCH = BLOCKS.register("cobblestone_upper_small_arch", () -> new UpperSmallArch("cobblestone_upper_small_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_UPPER_SMALL_ARCH = BLOCKS.register("brick_upper_small_arch", () -> new UpperSmallArch("brick_upper_small_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("stone_brick_upper_small_arch", () -> new UpperSmallArch("stone_brick_upper_small_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("nether_brick_upper_small_arch", () -> new UpperSmallArch("nether_brick_upper_small_arch", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_UPPER_SMALL_ARCH = BLOCKS.register("sandstone_upper_small_arch", () -> new UpperSmallArch("sandstone_upper_small_arch", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_UPPER_SMALL_ARCH = BLOCKS.register("quartz_upper_small_arch", () -> new UpperSmallArch("quartz_upper_small_arch", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_UPPER_SMALL_ARCH = BLOCKS.register("prismarine_upper_small_arch", () -> new UpperSmallArch("prismarine_upper_small_arch", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("prismarine_brick_upper_small_arch", () -> new UpperSmallArch("prismarine_brick_upper_small_arch", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_UPPER_SMALL_ARCH = BLOCKS.register("dark_prismarine_upper_small_arch", () -> new UpperSmallArch("dark_prismarine_upper_small_arch", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_UPPER_SMALL_ARCH = BLOCKS.register("red_sandstone_upper_small_arch", () -> new UpperSmallArch("red_sandstone_upper_small_arch", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_UPPER_SMALL_ARCH = BLOCKS.register("polished_granite_upper_small_arch", () -> new UpperSmallArch("polished_granite_upper_small_arch", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_UPPER_SMALL_ARCH = BLOCKS.register("smooth_red_sandstone_upper_small_arch", () -> new UpperSmallArch("smooth_red_sandstone_upper_small_arch", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("mossy_stone_brick_upper_small_arch", () -> new UpperSmallArch("mossy_stone_brick_upper_small_arch", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_UPPER_SMALL_ARCH = BLOCKS.register("polished_diorite_upper_small_arch", () -> new UpperSmallArch("polished_diorite_upper_small_arch", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_UPPER_SMALL_ARCH = BLOCKS.register("mossy_cobblestone_upper_small_arch", () -> new UpperSmallArch("mossy_cobblestone_upper_small_arch", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("end_stone_brick_upper_small_arch", () -> new UpperSmallArch("end_stone_brick_upper_small_arch", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_UPPER_SMALL_ARCH = BLOCKS.register("stone_upper_small_arch", () -> new UpperSmallArch("stone_upper_small_arch", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_UPPER_SMALL_ARCH = BLOCKS.register("smooth_sandstone_upper_small_arch", () -> new UpperSmallArch("smooth_sandstone_upper_small_arch", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_UPPER_SMALL_ARCH = BLOCKS.register("smooth_quartz_upper_small_arch", () -> new UpperSmallArch("smooth_quartz_upper_small_arch", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_UPPER_SMALL_ARCH = BLOCKS.register("granite_upper_small_arch", () -> new UpperSmallArch("granite_upper_small_arch", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_UPPER_SMALL_ARCH = BLOCKS.register("andesite_upper_small_arch", () -> new UpperSmallArch("andesite_upper_small_arch", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("red_nether_brick_upper_small_arch", () -> new UpperSmallArch("red_nether_brick_upper_small_arch", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_UPPER_SMALL_ARCH = BLOCKS.register("polished_andesite_upper_small_arch", () -> new UpperSmallArch("polished_andesite_upper_small_arch", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_UPPER_SMALL_ARCH = BLOCKS.register("diorite_upper_small_arch", () -> new UpperSmallArch("diorite_upper_small_arch", Blocks.DIORITE));

    /* Lower Small Arches */
    public static final RegistryObject<Block> OAK_LOWER_SMALL_ARCH = BLOCKS.register("oak_lower_small_arch", () -> new LowerSmallArch("oak_lower_small_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_LOWER_SMALL_ARCH = BLOCKS.register("spruce_lower_small_arch", () -> new LowerSmallArch("spruce_lower_small_arch", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_LOWER_SMALL_ARCH = BLOCKS.register("birch_lower_small_arch", () -> new LowerSmallArch("birch_lower_small_arch", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_LOWER_SMALL_ARCH = BLOCKS.register("jungle_lower_small_arch", () -> new LowerSmallArch("jungle_lower_small_arch", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_LOWER_SMALL_ARCH = BLOCKS.register("acacia_lower_small_arch", () -> new LowerSmallArch("acacia_lower_small_arch", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_LOWER_SMALL_ARCH = BLOCKS.register("dark_oak_lower_small_arch", () -> new LowerSmallArch("dark_oak_lower_small_arch", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_LOWER_SMALL_ARCH = BLOCKS.register("purpur_lower_small_arch", () -> new LowerSmallArch("purpur_lower_small_arch", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_LOWER_SMALL_ARCH = BLOCKS.register("cobblestone_lower_small_arch", () -> new LowerSmallArch("cobblestone_lower_small_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_LOWER_SMALL_ARCH = BLOCKS.register("brick_lower_small_arch", () -> new LowerSmallArch("brick_lower_small_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("stone_brick_lower_small_arch", () -> new LowerSmallArch("stone_brick_lower_small_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("nether_brick_lower_small_arch", () -> new LowerSmallArch("nether_brick_lower_small_arch", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_LOWER_SMALL_ARCH = BLOCKS.register("sandstone_lower_small_arch", () -> new LowerSmallArch("sandstone_lower_small_arch", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_LOWER_SMALL_ARCH = BLOCKS.register("quartz_lower_small_arch", () -> new LowerSmallArch("quartz_lower_small_arch", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_LOWER_SMALL_ARCH = BLOCKS.register("prismarine_lower_small_arch", () -> new LowerSmallArch("prismarine_lower_small_arch", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("prismarine_brick_lower_small_arch", () -> new LowerSmallArch("prismarine_brick_lower_small_arch", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_LOWER_SMALL_ARCH = BLOCKS.register("dark_prismarine_lower_small_arch", () -> new LowerSmallArch("dark_prismarine_lower_small_arch", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_LOWER_SMALL_ARCH = BLOCKS.register("red_sandstone_lower_small_arch", () -> new LowerSmallArch("red_sandstone_lower_small_arch", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_LOWER_SMALL_ARCH = BLOCKS.register("polished_granite_lower_small_arch", () -> new LowerSmallArch("polished_granite_lower_small_arch", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_LOWER_SMALL_ARCH = BLOCKS.register("smooth_red_sandstone_lower_small_arch", () -> new LowerSmallArch("smooth_red_sandstone_lower_small_arch", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("mossy_stone_brick_lower_small_arch", () -> new LowerSmallArch("mossy_stone_brick_lower_small_arch", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_LOWER_SMALL_ARCH = BLOCKS.register("polished_diorite_lower_small_arch", () -> new LowerSmallArch("polished_diorite_lower_small_arch", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_LOWER_SMALL_ARCH = BLOCKS.register("mossy_cobblestone_lower_small_arch", () -> new LowerSmallArch("mossy_cobblestone_lower_small_arch", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("end_stone_brick_lower_small_arch", () -> new LowerSmallArch("end_stone_brick_lower_small_arch", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_LOWER_SMALL_ARCH = BLOCKS.register("stone_lower_small_arch", () -> new LowerSmallArch("stone_lower_small_arch", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_LOWER_SMALL_ARCH = BLOCKS.register("smooth_sandstone_lower_small_arch", () -> new LowerSmallArch("smooth_sandstone_lower_small_arch", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_LOWER_SMALL_ARCH = BLOCKS.register("smooth_quartz_lower_small_arch", () -> new LowerSmallArch("smooth_quartz_lower_small_arch", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_LOWER_SMALL_ARCH = BLOCKS.register("granite_lower_small_arch", () -> new LowerSmallArch("granite_lower_small_arch", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_LOWER_SMALL_ARCH = BLOCKS.register("andesite_lower_small_arch", () -> new LowerSmallArch("andesite_lower_small_arch", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("red_nether_brick_lower_small_arch", () -> new LowerSmallArch("red_nether_brick_lower_small_arch", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_LOWER_SMALL_ARCH = BLOCKS.register("polished_andesite_lower_small_arch", () -> new LowerSmallArch("polished_andesite_lower_small_arch", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_LOWER_SMALL_ARCH = BLOCKS.register("diorite_lower_small_arch", () -> new LowerSmallArch("diorite_lower_small_arch", Blocks.DIORITE));

    /* Upper Small Inverted Arches */
    public static final RegistryObject<Block> OAK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("oak_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("oak_upper_small_inverted_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("spruce_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("spruce_upper_small_inverted_arch", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("birch_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("birch_upper_small_inverted_arch", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("jungle_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("jungle_upper_small_inverted_arch", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("acacia_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("acacia_upper_small_inverted_arch", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("dark_oak_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("dark_oak_upper_small_inverted_arch", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("purpur_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("purpur_upper_small_inverted_arch", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("cobblestone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("cobblestone_upper_small_inverted_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("brick_upper_small_inverted_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("stone_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("stone_brick_upper_small_inverted_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("nether_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("nether_brick_upper_small_inverted_arch", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("sandstone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("sandstone_upper_small_inverted_arch", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("quartz_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("quartz_upper_small_inverted_arch", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("prismarine_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("prismarine_upper_small_inverted_arch", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("prismarine_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("prismarine_brick_upper_small_inverted_arch", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("dark_prismarine_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("dark_prismarine_upper_small_inverted_arch", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("red_sandstone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("red_sandstone_upper_small_inverted_arch", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_granite_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("polished_granite_upper_small_inverted_arch", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("smooth_red_sandstone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("smooth_red_sandstone_upper_small_inverted_arch", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("mossy_stone_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("mossy_stone_brick_upper_small_inverted_arch", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_diorite_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("polished_diorite_upper_small_inverted_arch", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("mossy_cobblestone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("mossy_cobblestone_upper_small_inverted_arch", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("end_stone_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("end_stone_brick_upper_small_inverted_arch", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("stone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("stone_upper_small_inverted_arch", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("smooth_sandstone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("smooth_sandstone_upper_small_inverted_arch", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("smooth_quartz_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("smooth_quartz_upper_small_inverted_arch", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("granite_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("granite_upper_small_inverted_arch", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("andesite_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("andesite_upper_small_inverted_arch", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("red_nether_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("red_nether_brick_upper_small_inverted_arch", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_andesite_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("polished_andesite_upper_small_inverted_arch", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("diorite_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("diorite_upper_small_inverted_arch", Blocks.DIORITE));

    /* Lower Small Inverted Arches */
    public static final RegistryObject<Block> OAK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("oak_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("oak_lower_small_inverted_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("spruce_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("spruce_lower_small_inverted_arch", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("birch_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("birch_lower_small_inverted_arch", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("jungle_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("jungle_lower_small_inverted_arch", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("acacia_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("acacia_lower_small_inverted_arch", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("dark_oak_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("dark_oak_lower_small_inverted_arch", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("purpur_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("purpur_lower_small_inverted_arch", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("cobblestone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("cobblestone_lower_small_inverted_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("brick_lower_small_inverted_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("stone_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("stone_brick_lower_small_inverted_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("nether_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("nether_brick_lower_small_inverted_arch", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("sandstone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("sandstone_lower_small_inverted_arch", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("quartz_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("quartz_lower_small_inverted_arch", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("prismarine_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("prismarine_lower_small_inverted_arch", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("prismarine_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("prismarine_brick_lower_small_inverted_arch", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("dark_prismarine_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("dark_prismarine_lower_small_inverted_arch", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("red_sandstone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("red_sandstone_lower_small_inverted_arch", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_granite_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("polished_granite_lower_small_inverted_arch", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("smooth_red_sandstone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("smooth_red_sandstone_lower_small_inverted_arch", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("mossy_stone_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("mossy_stone_brick_lower_small_inverted_arch", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_diorite_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("polished_diorite_lower_small_inverted_arch", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("mossy_cobblestone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("mossy_cobblestone_lower_small_inverted_arch", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("end_stone_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("end_stone_brick_lower_small_inverted_arch", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("stone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("stone_lower_small_inverted_arch", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("smooth_sandstone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("smooth_sandstone_lower_small_inverted_arch", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("smooth_quartz_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("smooth_quartz_lower_small_inverted_arch", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("granite_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("granite_lower_small_inverted_arch", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("andesite_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("andesite_lower_small_inverted_arch", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("red_nether_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("red_nether_brick_lower_small_inverted_arch", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_andesite_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("polished_andesite_lower_small_inverted_arch", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("diorite_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("diorite_lower_small_inverted_arch", Blocks.DIORITE));

    /* Posts */
    public static final RegistryObject<Block> OAK_POST = BLOCKS.register("oak_post", () -> new PostBlock("oak_post", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_POST = BLOCKS.register("spruce_post", () -> new PostBlock("spruce_post", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_POST = BLOCKS.register("birch_post", () -> new PostBlock("birch_post", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_POST = BLOCKS.register("jungle_post", () -> new PostBlock("jungle_post", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_POST = BLOCKS.register("acacia_post", () -> new PostBlock("acacia_post", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_POST = BLOCKS.register("dark_oak_post", () -> new PostBlock("dark_oak_post", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> PURPUR_POST = BLOCKS.register("purpur_post", () -> new PostBlock("purpur_post", Blocks.PURPUR_BLOCK));
    public static final RegistryObject<Block> COBBLESTONE_POST = BLOCKS.register("cobblestone_post", () -> new PostBlock("cobblestone_post", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> BRICK_POST = BLOCKS.register("brick_post", () -> new PostBlock("brick_post", Blocks.BRICKS));
    public static final RegistryObject<Block> STONE_BRICK_POST = BLOCKS.register("stone_brick_post", () -> new PostBlock("stone_brick_post", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> NETHER_BRICK_POST = BLOCKS.register("nether_brick_post", () -> new PostBlock("nether_brick_post", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> SANDSTONE_POST = BLOCKS.register("sandstone_post", () -> new PostBlock("sandstone_post", Blocks.SANDSTONE));
    public static final RegistryObject<Block> QUARTZ_POST = BLOCKS.register("quartz_post", () -> new PostBlock("quartz_post", Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<Block> PRISMARINE_POST = BLOCKS.register("prismarine_post", () -> new PostBlock("prismarine_post", Blocks.PRISMARINE));
    public static final RegistryObject<Block> PRISMARINE_BRICK_POST = BLOCKS.register("prismarine_brick_post", () -> new PostBlock("prismarine_brick_post", Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<Block> DARK_PRISMARINE_POST = BLOCKS.register("dark_prismarine_post", () -> new PostBlock("dark_prismarine_post", Blocks.DARK_PRISMARINE));
    public static final RegistryObject<Block> RED_SANDSTONE_POST = BLOCKS.register("red_sandstone_post", () -> new PostBlock("red_sandstone_post", Blocks.RED_SANDSTONE));
    public static final RegistryObject<Block> POLISHED_GRANITE_POST = BLOCKS.register("polished_granite_post", () -> new PostBlock("polished_granite_post", Blocks.POLISHED_GRANITE));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_POST = BLOCKS.register("smooth_red_sandstone_post", () -> new PostBlock("smooth_red_sandstone_post", Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<Block> MOSSY_STONE_BRICK_POST = BLOCKS.register("mossy_stone_brick_post", () -> new PostBlock("mossy_stone_brick_post", Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_DIORITE_POST = BLOCKS.register("polished_diorite_post", () -> new PostBlock("polished_diorite_post", Blocks.POLISHED_DIORITE));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_POST = BLOCKS.register("mossy_cobblestone_post", () -> new PostBlock("mossy_cobblestone_post", Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<Block> END_STONE_BRICK_POST = BLOCKS.register("end_stone_brick_post", () -> new PostBlock("end_stone_brick_post", Blocks.END_STONE_BRICKS));
    public static final RegistryObject<Block> STONE_POST = BLOCKS.register("stone_post", () -> new PostBlock("stone_post", Blocks.STONE));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_POST = BLOCKS.register("smooth_sandstone_post", () -> new PostBlock("smooth_sandstone_post", Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_POST = BLOCKS.register("smooth_quartz_post", () -> new PostBlock("smooth_quartz_post", Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<Block> GRANITE_POST = BLOCKS.register("granite_post", () -> new PostBlock("granite_post", Blocks.GRANITE));
    public static final RegistryObject<Block> ANDESITE_POST = BLOCKS.register("andesite_post", () -> new PostBlock("andesite_post", Blocks.ANDESITE));
    public static final RegistryObject<Block> RED_NETHER_BRICK_POST = BLOCKS.register("red_nether_brick_post", () -> new PostBlock("red_nether_brick_post", Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<Block> POLISHED_ANDESITE_POST = BLOCKS.register("polished_andesite_post", () -> new PostBlock("polished_andesite_post", Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<Block> DIORITE_POST = BLOCKS.register("diorite_post", () -> new PostBlock("diorite_post", Blocks.DIORITE));

    /*** Decorations ***/
    public static final RegistryObject<Block> COLORABLE_FLOWER_POT = BLOCKS.register("colorable_flower_pot", () -> new ColorableFlowerPot("colorable_flower_pot", Block.Properties.of(Material.DECORATION).strength(0)));

    /* Tall Fences */
    public static final RegistryObject<Block> OAK_TALL_FENCE = BLOCKS.register("oak_tall_fence", () -> new TallFence("oak_tall_fence", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_TALL_FENCE = BLOCKS.register("spruce_tall_fence", () -> new TallFence("spruce_tall_fence", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_TALL_FENCE = BLOCKS.register("birch_tall_fence", () -> new TallFence("birch_tall_fence", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_TALL_FENCE = BLOCKS.register("jungle_tall_fence", () -> new TallFence("jungle_tall_fence", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_TALL_FENCE = BLOCKS.register("acacia_tall_fence", () -> new TallFence("acacia_tall_fence", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_TALL_FENCE = BLOCKS.register("dark_oak_tall_fence", () -> new TallFence("dark_oak_tall_fence", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_TALL_FENCE = BLOCKS.register("nether_brick_tall_fence", () -> new TallFence("nether_brick_tall_fence", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_TALL_FENCE = BLOCKS.register("crimson_tall_fence", () -> new TallFence("crimson_tall_fence", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_TALL_FENCE = BLOCKS.register("warped_tall_fence", () -> new TallFence("warped_tall_fence", Blocks.WARPED_PLANKS));

    /* Tall Fence Gates */
    public static final RegistryObject<Block> OAK_TALL_FENCE_GATE = BLOCKS.register("oak_tall_fence_gate", () -> new TallFenceGate("oak_tall_fence_gate", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_TALL_FENCE_GATE = BLOCKS.register("spruce_tall_fence_gate", () -> new TallFenceGate("spruce_tall_fence_gate", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_TALL_FENCE_GATE = BLOCKS.register("birch_tall_fence_gate", () -> new TallFenceGate("birch_tall_fence_gate", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_TALL_FENCE_GATE = BLOCKS.register("jungle_tall_fence_gate", () -> new TallFenceGate("jungle_tall_fence_gate", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_TALL_FENCE_GATE = BLOCKS.register("acacia_tall_fence_gate", () -> new TallFenceGate("acacia_tall_fence_gate", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_TALL_FENCE_GATE = BLOCKS.register("dark_oak_tall_fence_gate", () -> new TallFenceGate("dark_oak_tall_fence_gate", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_TALL_FENCE_GATE = BLOCKS.register("nether_brick_tall_fence_gate", () -> new TallFenceGate("nether_brick_tall_fence_gate", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_TALL_FENCE_GATE = BLOCKS.register("crimson_tall_fence_gate", () -> new TallFenceGate("crimson_tall_fence_gate", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_TALL_FENCE_GATE = BLOCKS.register("warped_tall_fence_gate", () -> new TallFenceGate("warped_tall_fence_gate", Blocks.WARPED_PLANKS));

    /*** FurnitureGroup ***/
    /* Tables */
    public static final RegistryObject<Block> OAK_TABLE = BLOCKS.register("oak_table", () -> new Table("oak_table", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_TABLE = BLOCKS.register("spruce_table", () -> new Table("spruce_table", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_TABLE = BLOCKS.register("birch_table", () -> new Table("birch_table", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_TABLE = BLOCKS.register("jungle_table", () -> new Table("jungle_table", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_TABLE = BLOCKS.register("acacia_table", () -> new Table("acacia_table", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_TABLE = BLOCKS.register("dark_oak_table", () -> new Table("dark_oak_table", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_TABLE = BLOCKS.register("nether_brick_table", () -> new Table("nether_brick_table", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_TABLE = BLOCKS.register("crimson_table", () -> new Table("crimson_table", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_TABLE = BLOCKS.register("warped_table", () -> new Table("warped_table", Blocks.WARPED_PLANKS));

    /* Chairs */
    public static final RegistryObject<Block> OAK_CHAIR = BLOCKS.register("oak_chair", () -> new Chair("oak_chair", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_CHAIR = BLOCKS.register("spruce_chair", () -> new Chair("spruce_chair", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_CHAIR = BLOCKS.register("birch_chair", () -> new Chair("birch_chair", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_CHAIR = BLOCKS.register("jungle_chair", () -> new Chair("jungle_chair", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_CHAIR = BLOCKS.register("acacia_chair", () -> new Chair("acacia_chair", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair", () -> new Chair("dark_oak_chair", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_CHAIR = BLOCKS.register("nether_brick_chair", () -> new Chair("nether_brick_chair", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_CHAIR = BLOCKS.register("crimson_chair", () -> new Chair("crimson_chair", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_CHAIR = BLOCKS.register("warped_chair", () -> new Chair("warped_chair", Blocks.WARPED_PLANKS));

    /* Coffee Tables */
    public static final RegistryObject<Block> OAK_COFFEE_TABLE = BLOCKS.register("oak_coffee_table", () -> new CoffeeTable("oak_coffee_table", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_COFFEE_TABLE = BLOCKS.register("spruce_coffee_table", () -> new CoffeeTable("spruce_coffee_table", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_COFFEE_TABLE = BLOCKS.register("birch_coffee_table", () -> new CoffeeTable("birch_coffee_table", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_COFFEE_TABLE = BLOCKS.register("jungle_coffee_table", () -> new CoffeeTable("jungle_coffee_table", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_COFFEE_TABLE = BLOCKS.register("acacia_coffee_table", () -> new CoffeeTable("acacia_coffee_table", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_COFFEE_TABLE = BLOCKS.register("dark_oak_coffee_table", () -> new CoffeeTable("dark_oak_coffee_table", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_COFFEE_TABLE = BLOCKS.register("nether_brick_coffee_table", () -> new CoffeeTable("nether_brick_coffee_table", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_COFFEE_TABLE = BLOCKS.register("crimson_coffee_table", () -> new CoffeeTable("crimson_coffee_table", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_COFFEE_TABLE = BLOCKS.register("warped_coffee_table", () -> new CoffeeTable("warped_coffee_table", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> TERRACOTTA_COFFEE_TABLE = BLOCKS.register("terracotta_coffee_table", () -> new CoffeeTable("terracotta_coffee_table", Blocks.TERRACOTTA));
    public static final RegistryObject<Block> WHITE_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("white_terracotta_coffee_table", () -> new CoffeeTable("white_terracotta_coffee_table", Blocks.WHITE_TERRACOTTA));
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("orange_terracotta_coffee_table", () -> new CoffeeTable("orange_terracotta_coffee_table", Blocks.ORANGE_TERRACOTTA));
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("magenta_terracotta_coffee_table", () -> new CoffeeTable("magenta_terracotta_coffee_table", Blocks.MAGENTA_TERRACOTTA));
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("light_blue_terracotta_coffee_table", () -> new CoffeeTable("light_blue_terracotta_coffee_table", Blocks.LIGHT_BLUE_TERRACOTTA));
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("yellow_terracotta_coffee_table", () -> new CoffeeTable("yellow_terracotta_coffee_table", Blocks.YELLOW_TERRACOTTA));
    public static final RegistryObject<Block> LIME_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("lime_terracotta_coffee_table", () -> new CoffeeTable("lime_terracotta_coffee_table", Blocks.LIME_TERRACOTTA));
    public static final RegistryObject<Block> PINK_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("pink_terracotta_coffee_table", () -> new CoffeeTable("pink_terracotta_coffee_table", Blocks.PINK_TERRACOTTA));
    public static final RegistryObject<Block> GRAY_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("gray_terracotta_coffee_table", () -> new CoffeeTable("gray_terracotta_coffee_table", Blocks.GRAY_TERRACOTTA));
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("light_gray_terracotta_coffee_table", () -> new CoffeeTable("light_gray_terracotta_coffee_table", Blocks.LIGHT_GRAY_TERRACOTTA));
    public static final RegistryObject<Block> CYAN_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("cyan_terracotta_coffee_table", () -> new CoffeeTable("cyan_terracotta_coffee_table", Blocks.CYAN_TERRACOTTA));
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("purple_terracotta_coffee_table", () -> new CoffeeTable("purple_terracotta_coffee_table", Blocks.PURPLE_TERRACOTTA));
    public static final RegistryObject<Block> BLUE_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("blue_terracotta_coffee_table", () -> new CoffeeTable("blue_terracotta_coffee_table", Blocks.BLUE_TERRACOTTA));
    public static final RegistryObject<Block> BROWN_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("brown_terracotta_coffee_table", () -> new CoffeeTable("brown_terracotta_coffee_table", Blocks.BROWN_TERRACOTTA));
    public static final RegistryObject<Block> GREEN_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("green_terracotta_coffee_table", () -> new CoffeeTable("green_terracotta_coffee_table", Blocks.GREEN_TERRACOTTA));
    public static final RegistryObject<Block> RED_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("red_terracotta_coffee_table", () -> new CoffeeTable("red_terracotta_coffee_table", Blocks.RED_TERRACOTTA));
    public static final RegistryObject<Block> BLACK_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("black_terracotta_coffee_table", () -> new CoffeeTable("black_terracotta_coffee_table", Blocks.BLACK_TERRACOTTA));
    public static final RegistryObject<Block> STRIPPED_OAK_WOOD_COFFEE_TABLE = BLOCKS.register("stripped_oak_wood_coffee_table", () -> new CoffeeTable("stripped_oak_wood_coffee_table", Blocks.STRIPPED_OAK_WOOD));
    public static final RegistryObject<Block> STRIPPED_ACACIA_WOOD_COFFEE_TABLE = BLOCKS.register("stripped_acacia_wood_coffee_table", () -> new CoffeeTable("stripped_acacia_wood_coffee_table", Blocks.STRIPPED_ACACIA_WOOD));
    public static final RegistryObject<Block> STRIPPED_BIRCH_WOOD_COFFEE_TABLE = BLOCKS.register("stripped_birch_wood_coffee_table", () -> new CoffeeTable("stripped_birch_wood_coffee_table", Blocks.STRIPPED_BIRCH_WOOD));
    public static final RegistryObject<Block> STRIPPED_SPRUCE_WOOD_COFFEE_TABLE = BLOCKS.register("stripped_spruce_wood_coffee_table", () -> new CoffeeTable("stripped_spruce_wood_coffee_table", Blocks.STRIPPED_SPRUCE_WOOD));
    public static final RegistryObject<Block> STRIPPED_DARK_OAK_WOOD_COFFEE_TABLE = BLOCKS.register("stripped_dark_oak_wood_coffee_table", () -> new CoffeeTable("stripped_dark_oak_wood_coffee_table", Blocks.STRIPPED_DARK_OAK_WOOD));
    public static final RegistryObject<Block> STRIPPED_JUNGLE_WOOD_COFFEE_TABLE = BLOCKS.register("stripped_jungle_wood_coffee_table", () -> new CoffeeTable("stripped_jungle_wood_coffee_table", Blocks.STRIPPED_JUNGLE_WOOD));
    public static final RegistryObject<Block> STRIPPED_CRIMSON_STEM_COFFEE_TABLE = BLOCKS.register("stripped_crimson_stem_coffee_table", () -> new CoffeeTable("stripped_crimson_stem_coffee_table", Blocks.STRIPPED_CRIMSON_STEM));
    public static final RegistryObject<Block> STRIPPED_WARPED_STEM_COFFEE_TABLE = BLOCKS.register("stripped_warped_stem_coffee_table", () -> new CoffeeTable("stripped_warped_stem_coffee_table", Blocks.STRIPPED_WARPED_STEM));

    /* Sofas */
    public static final RegistryObject<Block> WHITE_SOFA = BLOCKS.register("white_sofa", () -> new Sofa("white_sofa", Blocks.WHITE_WOOL));
    public static final RegistryObject<Block> ORANGE_SOFA = BLOCKS.register("orange_sofa", () -> new Sofa("orange_sofa", Blocks.ORANGE_WOOL));
    public static final RegistryObject<Block> MAGENTA_SOFA = BLOCKS.register("magenta_sofa", () -> new Sofa("magenta_sofa", Blocks.MAGENTA_WOOL));
    public static final RegistryObject<Block> LIGHT_BLUE_SOFA = BLOCKS.register("light_blue_sofa", () -> new Sofa("light_blue_sofa", Blocks.LIGHT_BLUE_WOOL));
    public static final RegistryObject<Block> YELLOW_SOFA = BLOCKS.register("yellow_sofa", () -> new Sofa("yellow_sofa", Blocks.YELLOW_WOOL));
    public static final RegistryObject<Block> LIME_SOFA = BLOCKS.register("lime_sofa", () -> new Sofa("lime_sofa", Blocks.LIME_WOOL));
    public static final RegistryObject<Block> PINK_SOFA = BLOCKS.register("pink_sofa", () -> new Sofa("pink_sofa", Blocks.PINK_WOOL));
    public static final RegistryObject<Block> GRAY_SOFA = BLOCKS.register("gray_sofa", () -> new Sofa("gray_sofa", Blocks.GRAY_WOOL));
    public static final RegistryObject<Block> LIGHT_GRAY_SOFA = BLOCKS.register("light_gray_sofa", () -> new Sofa("light_gray_sofa", Blocks.LIGHT_GRAY_WOOL));
    public static final RegistryObject<Block> CYAN_SOFA = BLOCKS.register("cyan_sofa", () -> new Sofa("cyan_sofa", Blocks.CYAN_WOOL));
    public static final RegistryObject<Block> PURPLE_SOFA = BLOCKS.register("purple_sofa", () -> new Sofa("purple_sofa", Blocks.PURPLE_WOOL));
    public static final RegistryObject<Block> BLUE_SOFA = BLOCKS.register("blue_sofa", () -> new Sofa("blue_sofa", Blocks.BLUE_WOOL));
    public static final RegistryObject<Block> BROWN_SOFA = BLOCKS.register("brown_sofa", () -> new Sofa("brown_sofa", Blocks.BROWN_WOOL));
    public static final RegistryObject<Block> GREEN_SOFA = BLOCKS.register("green_sofa", () -> new Sofa("green_sofa", Blocks.GREEN_WOOL));
    public static final RegistryObject<Block> RED_SOFA = BLOCKS.register("red_sofa", () -> new Sofa("red_sofa", Blocks.RED_WOOL));
    public static final RegistryObject<Block> BLACK_SOFA = BLOCKS.register("black_sofa", () -> new Sofa("black_sofa", Blocks.BLACK_WOOL));

    /* Carpets */
    public static final RegistryObject<Block> WHITE_CARPET = BLOCKS.register("white_carpet", () -> new Carpet("white_carpet", Blocks.WHITE_WOOL));
    public static final RegistryObject<Block> ORANGE_CARPET = BLOCKS.register("orange_carpet", () -> new Carpet("orange_carpet", Blocks.ORANGE_WOOL));
    public static final RegistryObject<Block> MAGENTA_CARPET = BLOCKS.register("magenta_carpet", () -> new Carpet("magenta_carpet", Blocks.MAGENTA_WOOL));
    public static final RegistryObject<Block> LIGHT_BLUE_CARPET = BLOCKS.register("light_blue_carpet", () -> new Carpet("light_blue_carpet", Blocks.LIGHT_BLUE_WOOL));
    public static final RegistryObject<Block> YELLOW_CARPET = BLOCKS.register("yellow_carpet", () -> new Carpet("yellow_carpet", Blocks.YELLOW_WOOL));
    public static final RegistryObject<Block> LIME_CARPET = BLOCKS.register("lime_carpet", () -> new Carpet("lime_carpet", Blocks.LIME_WOOL));
    public static final RegistryObject<Block> PINK_CARPET = BLOCKS.register("pink_carpet", () -> new Carpet("pink_carpet", Blocks.PINK_WOOL));
    public static final RegistryObject<Block> GRAY_CARPET = BLOCKS.register("gray_carpet", () -> new Carpet("gray_carpet", Blocks.GRAY_WOOL));
    public static final RegistryObject<Block> LIGHT_GRAY_CARPET = BLOCKS.register("light_gray_carpet", () -> new Carpet("light_gray_carpet", Blocks.LIGHT_GRAY_WOOL));
    public static final RegistryObject<Block> CYAN_CARPET = BLOCKS.register("cyan_carpet", () -> new Carpet("cyan_carpet", Blocks.CYAN_WOOL));
    public static final RegistryObject<Block> PURPLE_CARPET = BLOCKS.register("purple_carpet", () -> new Carpet("purple_carpet", Blocks.PURPLE_WOOL));
    public static final RegistryObject<Block> BLUE_CARPET = BLOCKS.register("blue_carpet", () -> new Carpet("blue_carpet", Blocks.BLUE_WOOL));
    public static final RegistryObject<Block> BROWN_CARPET = BLOCKS.register("brown_carpet", () -> new Carpet("brown_carpet", Blocks.BROWN_WOOL));
    public static final RegistryObject<Block> GREEN_CARPET = BLOCKS.register("green_carpet", () -> new Carpet("green_carpet", Blocks.GREEN_WOOL));
    public static final RegistryObject<Block> RED_CARPET = BLOCKS.register("red_carpet", () -> new Carpet("red_carpet", Blocks.RED_WOOL));
    public static final RegistryObject<Block> BLACK_CARPET = BLOCKS.register("black_carpet", () -> new Carpet("black_carpet", Blocks.BLACK_WOOL));

    /* Lamps */
    public static final RegistryObject<Block> OAK_SMALL_LAMP = BLOCKS.register("oak_small_lamp", () -> new SmallLamp("oak_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_SMALL_LAMP = BLOCKS.register("spruce_small_lamp", () -> new SmallLamp("spruce_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_SMALL_LAMP = BLOCKS.register("acacia_small_lamp", () -> new SmallLamp("acacia_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_SMALL_LAMP = BLOCKS.register("jungle_small_lamp", () -> new SmallLamp("jungle_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_SMALL_LAMP = BLOCKS.register("birch_small_lamp", () -> new SmallLamp("birch_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_SMALL_LAMP = BLOCKS.register("dark_oak_small_lamp", () -> new SmallLamp("dark_oak_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NETHER_BRICK_SMALL_LAMP = BLOCKS.register("nether_brick_small_lamp", () -> new SmallLamp("nether_brick_small_lamp", Block.Properties.of(Material.STONE).strength(1.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRIMSON_SMALL_LAMP = BLOCKS.register("crimson_small_lamp", () -> new SmallLamp("crimson_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_SMALL_LAMP = BLOCKS.register("warped_small_lamp", () -> new SmallLamp("warped_small_lamp", Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)));

    /* Drawers */
    /* Simple Drawers */
    public static final RegistryObject<Block> OAK_SIMPLE_DRAWER = BLOCKS.register("oak_simple_drawer", () -> new SimpleDrawer("oak_simple_drawer", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_SIMPLE_DRAWER = BLOCKS.register("spruce_simple_drawer", () -> new SimpleDrawer("spruce_simple_drawer", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_SIMPLE_DRAWER = BLOCKS.register("birch_simple_drawer", () -> new SimpleDrawer("birch_simple_drawer", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_SIMPLE_DRAWER = BLOCKS.register("jungle_simple_drawer", () -> new SimpleDrawer("jungle_simple_drawer", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_SIMPLE_DRAWER = BLOCKS.register("acacia_simple_drawer", () -> new SimpleDrawer("acacia_simple_drawer", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_SIMPLE_DRAWER = BLOCKS.register("dark_oak_simple_drawer", () -> new SimpleDrawer("dark_oak_simple_drawer", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_SIMPLE_DRAWER = BLOCKS.register("nether_brick_simple_drawer", () -> new SimpleDrawer("nether_brick_simple_drawer", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_SIMPLE_DRAWER = BLOCKS.register("crimson_simple_drawer", () -> new SimpleDrawer("crimson_simple_drawer", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_SIMPLE_DRAWER = BLOCKS.register("warped_simple_drawer", () -> new SimpleDrawer("warped_simple_drawer", Blocks.WARPED_PLANKS));

    /* Double Drawers */
    public static final RegistryObject<Block> OAK_DOUBLE_DRAWER = BLOCKS.register("oak_double_drawer", () -> new DoubleDrawer("oak_double_drawer", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_DOUBLE_DRAWER = BLOCKS.register("spruce_double_drawer", () -> new DoubleDrawer("spruce_double_drawer", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_DOUBLE_DRAWER = BLOCKS.register("birch_double_drawer", () -> new DoubleDrawer("birch_double_drawer", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_DOUBLE_DRAWER = BLOCKS.register("jungle_double_drawer", () -> new DoubleDrawer("jungle_double_drawer", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_DOUBLE_DRAWER = BLOCKS.register("acacia_double_drawer", () -> new DoubleDrawer("acacia_double_drawer", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_DOUBLE_DRAWER = BLOCKS.register("dark_oak_double_drawer", () -> new DoubleDrawer("dark_oak_double_drawer", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_DOUBLE_DRAWER = BLOCKS.register("nether_brick_double_drawer", () -> new DoubleDrawer("nether_brick_double_drawer", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_DOUBLE_DRAWER = BLOCKS.register("crimson_double_drawer", () -> new DoubleDrawer("crimson_double_drawer", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_DOUBLE_DRAWER = BLOCKS.register("warped_double_drawer", () -> new DoubleDrawer("warped_double_drawer", Blocks.WARPED_PLANKS));

    /* Shelves */
    public static final RegistryObject<Block> OAK_SHELF = BLOCKS.register("oak_shelf", () -> new Shelf("oak_shelf", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_SHELF = BLOCKS.register("spruce_shelf", () -> new Shelf("spruce_shelf", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_SHELF = BLOCKS.register("birch_shelf", () -> new Shelf("birch_shelf", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_SHELF = BLOCKS.register("jungle_shelf", () -> new Shelf("jungle_shelf", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_SHELF = BLOCKS.register("acacia_shelf", () -> new Shelf("acacia_shelf", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_SHELF = BLOCKS.register("dark_oak_shelf", () -> new Shelf("dark_oak_shelf", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_SHELF = BLOCKS.register("nether_brick_shelf", () -> new Shelf("nether_brick_shelf", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_SHELF = BLOCKS.register("crimson_shelf", () -> new Shelf("crimson_shelf", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_SHELF = BLOCKS.register("warped_shelf", () -> new Shelf("warped_shelf", Blocks.WARPED_PLANKS));

    /* Crate */
    public static final RegistryObject<Block> OAK_CRATE = BLOCKS.register("oak_crate", () -> new Crate("oak_crate", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_CRATE = BLOCKS.register("spruce_crate", () -> new Crate("spruce_crate", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_CRATE = BLOCKS.register("birch_crate", () -> new Crate("birch_crate", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_CRATE = BLOCKS.register("jungle_crate", () -> new Crate("jungle_crate", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_CRATE = BLOCKS.register("acacia_crate", () -> new Crate("acacia_crate", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_CRATE = BLOCKS.register("dark_oak_crate", () -> new Crate("dark_oak_crate", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_CRATE = BLOCKS.register("nether_brick_crate", () -> new Crate("nether_brick_crate", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_CRATE = BLOCKS.register("crimson_crate", () -> new Crate("crimson_crate", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_CRATE = BLOCKS.register("warped_crate", () -> new Crate("warped_crate", Blocks.WARPED_PLANKS));

    /* Small Bookshelves */
    public static final RegistryObject<Block> OAK_BOOKSHELF = BLOCKS.register("oak_bookshelf", () -> new Bookshelf("oak_bookshelf", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_BOOKSHELF = BLOCKS.register("spruce_bookshelf", () -> new Bookshelf("spruce_bookshelf", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_BOOKSHELF = BLOCKS.register("birch_bookshelf", () -> new Bookshelf("birch_bookshelf", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF = BLOCKS.register("jungle_bookshelf", () -> new Bookshelf("jungle_bookshelf", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_BOOKSHELF = BLOCKS.register("acacia_bookshelf", () -> new Bookshelf("acacia_bookshelf", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = BLOCKS.register("dark_oak_bookshelf", () -> new Bookshelf("dark_oak_bookshelf", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_BOOKSHELF = BLOCKS.register("nether_brick_bookshelf", () -> new Bookshelf("nether_brick_bookshelf", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF = BLOCKS.register("crimson_bookshelf", () -> new Bookshelf("crimson_bookshelf", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_BOOKSHELF = BLOCKS.register("warped_bookshelf", () -> new Bookshelf("warped_bookshelf", Blocks.WARPED_PLANKS));

    /* Potion Shelves */
    public static final RegistryObject<Block> OAK_POTION_SHELF = BLOCKS.register("oak_potion_shelf", () -> new PotionShelf("oak_potion_shelf", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_POTION_SHELF = BLOCKS.register("spruce_potion_shelf", () -> new PotionShelf("spruce_potion_shelf", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_POTION_SHELF = BLOCKS.register("birch_potion_shelf", () -> new PotionShelf("birch_potion_shelf", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_POTION_SHELF = BLOCKS.register("jungle_potion_shelf", () -> new PotionShelf("jungle_potion_shelf", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_POTION_SHELF = BLOCKS.register("acacia_potion_shelf", () -> new PotionShelf("acacia_potion_shelf", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_POTION_SHELF = BLOCKS.register("dark_oak_potion_shelf", () -> new PotionShelf("dark_oak_potion_shelf", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> NETHER_BRICK_POTION_SHELF = BLOCKS.register("nether_brick_potion_shelf", () -> new PotionShelf("nether_brick_potion_shelf", Blocks.NETHER_BRICKS));
    public static final RegistryObject<Block> CRIMSON_POTION_SHELF = BLOCKS.register("crimson_potion_shelf", () -> new PotionShelf("crimson_potion_shelf", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_POTION_SHELF = BLOCKS.register("warped_potion_shelf", () -> new PotionShelf("warped_potion_shelf", Blocks.WARPED_PLANKS));

    /* Straight Kitchen Counters */
    public static final RegistryObject<Block> OAK_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("oak_straight_kitchen_counter", () -> new StraightKitchenCounter("oak_straight_kitchen_counter", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("spruce_straight_kitchen_counter", () -> new StraightKitchenCounter("spruce_straight_kitchen_counter", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("birch_straight_kitchen_counter", () -> new StraightKitchenCounter("birch_straight_kitchen_counter", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("jungle_straight_kitchen_counter", () -> new StraightKitchenCounter("jungle_straight_kitchen_counter", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("acacia_straight_kitchen_counter", () -> new StraightKitchenCounter("acacia_straight_kitchen_counter", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("dark_oak_straight_kitchen_counter", () -> new StraightKitchenCounter("dark_oak_straight_kitchen_counter", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> CRIMSON_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("crimson_straight_kitchen_counter", () -> new StraightKitchenCounter("crimson_straight_kitchen_counter", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("warped_straight_kitchen_counter", () -> new StraightKitchenCounter("warped_straight_kitchen_counter", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> COLORABLE_STRAIGHT_KITCHEN_COUNTER = BLOCKS.register("colorable_straight_kitchen_counter", () -> new ColorableStraightKitchenCounter("colorable_straight_kitchen_counter", Blocks.OAK_PLANKS));

    /* Inner Corner Kitchen Counters */
    public static final RegistryObject<Block> OAK_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("oak_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("oak_inner_corner_kitchen_counter", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("spruce_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("spruce_inner_corner_kitchen_counter", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("birch_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("birch_inner_corner_kitchen_counter", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("jungle_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("jungle_inner_corner_kitchen_counter", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("acacia_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("acacia_inner_corner_kitchen_counter", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("dark_oak_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("dark_oak_inner_corner_kitchen_counter", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> CRIMSON_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("crimson_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("crimson_inner_corner_kitchen_counter", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("warped_inner_corner_kitchen_counter", () -> new InnerCornerKitchenCounter("warped_inner_corner_kitchen_counter", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> COLORABLE_INNER_CORNER_KITCHEN_COUNTER = BLOCKS.register("colorable_inner_corner_kitchen_counter", () -> new ColorableInnerCornerKitchenCounter("colorable_inner_corner_kitchen_counter", Blocks.OAK_PLANKS));

    /* Outer Corner Kitchen Counters */
    public static final RegistryObject<Block> OAK_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("oak_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("oak_outer_corner_kitchen_counter", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> SPRUCE_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("spruce_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("spruce_outer_corner_kitchen_counter", Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> BIRCH_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("birch_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("birch_outer_corner_kitchen_counter", Blocks.BIRCH_PLANKS));
    public static final RegistryObject<Block> JUNGLE_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("jungle_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("jungle_outer_corner_kitchen_counter", Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<Block> ACACIA_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("acacia_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("acacia_outer_corner_kitchen_counter", Blocks.ACACIA_PLANKS));
    public static final RegistryObject<Block> DARK_OAK_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("dark_oak_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("dark_oak_outer_corner_kitchen_counter", Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<Block> CRIMSON_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("crimson_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("crimson_outer_corner_kitchen_counter", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("warped_outer_corner_kitchen_counter", () -> new OuterCornerKitchenCounter("warped_outer_corner_kitchen_counter", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> COLORABLE_OUTER_CORNER_KITCHEN_COUNTER = BLOCKS.register("colorable_outer_corner_kitchen_counter", () -> new ColorableOuterCornerKitchenCounter("colorable_outer_corner_kitchen_counter", Blocks.OAK_PLANKS));

    /* Candles */
    public static final RegistryObject<Block> CANDLE = BLOCKS.register("candle", () -> new Candle("candle"));

    /* Colorable Blocks */
    public static final RegistryObject<Block> COLORABLE_WOOL = BLOCKS.register("colorable_wool", () -> new ColorableBlock("colorable_wool", Blocks.WHITE_WOOL));
    public static final RegistryObject<Block> COLORABLE_PLANKS = BLOCKS.register("colorable_planks", () -> new ColorableBlock("colorable_planks", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_CONCRETE = BLOCKS.register("colorable_concrete", () -> new ColorableBlock("colorable_concrete", Blocks.WHITE_CONCRETE));
    public static final RegistryObject<Block> COLORABLE_BRICKS = BLOCKS.register("colorable_bricks", () -> new ColorableBlock("colorable_bricks", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_TERRACOTTA = BLOCKS.register("colorable_terracotta", () -> new ColorableBlock("colorable_terracotta", Blocks.WHITE_TERRACOTTA));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICKS = BLOCKS.register("colorable_stone_bricks", () -> new ColorableBlock("colorable_stone_bricks", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE = BLOCKS.register("colorable_stone", () -> new ColorableBlock("colorable_stone", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE = BLOCKS.register("colorable_cobblestone", () -> new ColorableBlock("colorable_cobblestone", Blocks.COBBLESTONE));

    public static final RegistryObject<Block> COLORABLE_BRICK_SLAB = BLOCKS.register("colorable_brick_slab", () -> new ColorableSlab("colorable_brick_slab", Blocks.BRICK_SLAB));
    public static final RegistryObject<Block> COLORABLE_PLANK_SLAB = BLOCKS.register("colorable_plank_slab", () -> new ColorableSlab("colorable_plank_slab", Blocks.OAK_SLAB));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_SLAB = BLOCKS.register("colorable_stone_brick_slab", () -> new ColorableSlab("colorable_stone_brick_slab", Blocks.STONE_BRICK_SLAB));
    public static final RegistryObject<Block> COLORABLE_STONE_SLAB = BLOCKS.register("colorable_stone_slab", () -> new ColorableSlab("colorable_stone_slab", Blocks.STONE_SLAB));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_SLAB = BLOCKS.register("colorable_cobblestone_slab", () -> new ColorableSlab("colorable_cobblestone_slab", Blocks.COBBLESTONE_SLAB));

    public static final RegistryObject<Block> COLORABLE_BRICK_STAIRS = BLOCKS.register("colorable_brick_stairs", () -> new ColorableStairs("colorable_brick_stairs", Blocks.BRICKS::defaultBlockState, Blocks.BRICK_STAIRS));
    public static final RegistryObject<Block> COLORABLE_PLANK_STAIRS = BLOCKS.register("colorable_plank_stairs", () -> new ColorableStairs("colorable_plank_stairs", Blocks.OAK_PLANKS::defaultBlockState, Blocks.OAK_STAIRS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_STAIRS = BLOCKS.register("colorable_stone_brick_stairs", () -> new ColorableStairs("colorable_stone_brick_stairs", Blocks.STONE_BRICKS::defaultBlockState, Blocks.STONE_BRICK_STAIRS));
    public static final RegistryObject<Block> COLORABLE_STONE_STAIRS = BLOCKS.register("colorable_stone_stairs", () -> new ColorableStairs("colorable_stone_stairs", Blocks.STONE::defaultBlockState, Blocks.STONE_STAIRS));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_STAIRS = BLOCKS.register("colorable_cobblestone_stairs", () -> new ColorableStairs("colorable_cobblestone_stairs", Blocks.COBBLESTONE::defaultBlockState, Blocks.COBBLESTONE_STAIRS));

    public static final RegistryObject<Block> COLORABLE_CARPET = BLOCKS.register("colorable_carpet", () -> new ColorableCarpet("colorable_carpet"));
    public static final RegistryObject<Block> COLORABLE_SOFA = BLOCKS.register("colorable_sofa", () -> new ColorableSofa("colorable_sofa", Blocks.WHITE_CARPET));
    public static final RegistryObject<Block> COLORABLE_ROUND_CARPET = BLOCKS.register("colorable_round_carpet", () -> new ColorableRoundCarpet("colorable_round_carpet", Blocks.WHITE_CARPET));
    public static final RegistryObject<Block> COLORABLE_TABLE = BLOCKS.register("colorable_table", () -> new ColorableTable("colorable_table", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_COFFEE_TABLE = BLOCKS.register("colorable_plank_coffee_table", () -> new ColorableCoffeeTable("colorable_plank_coffee_table", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_TERRACOTTA_COFFEE_TABLE = BLOCKS.register("colorable_terracotta_coffee_table", () -> new ColorableCoffeeTable("colorable_terracotta_coffee_table", Blocks.WHITE_TERRACOTTA));
    public static final RegistryObject<Block> COLORABLE_CHAIR = BLOCKS.register("colorable_chair", () -> new ColorableChair("colorable_chair", Blocks.OAK_PLANKS));

    public static final RegistryObject<Block> COLORABLE_PLANK_VERTICAL_SLAB = BLOCKS.register("colorable_plank_vertical_slab", () -> new ColorableVerticalSlab("colorable_plank_vertical_slab", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_VERTICAL_SLAB = BLOCKS.register("colorable_brick_vertical_slab", () -> new ColorableVerticalSlab("colorable_brick_vertical_slab", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_VERTICAL_SLAB = BLOCKS.register("colorable_stone_brick_vertical_slab", () -> new ColorableVerticalSlab("colorable_stone_brick_vertical_slab", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_VERTICAL_SLAB = BLOCKS.register("colorable_stone_vertical_slab", () -> new ColorableVerticalSlab("colorable_stone_vertical_slab", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_VERTICAL_SLAB = BLOCKS.register("colorable_cobblestone_vertical_slab", () -> new ColorableVerticalSlab("colorable_cobblestone_vertical_slab", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> CRIMSON_VERTICAL_SLAB = BLOCKS.register("crimson_vertical_slab", () -> new ColorableVerticalSlab("crimson_vertical_slab", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_VERTICAL_SLAB = BLOCKS.register("warped_vertical_slab", () -> new ColorableVerticalSlab("warped_vertical_slab", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> BLACKSTONE_VERTICAL_SLAB = BLOCKS.register("blackstone_vertical_slab", () -> new ColorableVerticalSlab("blackstone_vertical_slab", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_VERTICAL_SLAB = BLOCKS.register("polished_blackstone_vertical_slab", () -> new ColorableVerticalSlab("polished_blackstone_vertical_slab", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB = BLOCKS.register("polished_blackstone_brick_vertical_slab", () -> new ColorableVerticalSlab("polished_blackstone_brick_vertical_slab", Blocks.POLISHED_BLACKSTONE_BRICKS));

    public static final RegistryObject<Block> COLORABLE_PLANK_VERTICAL_STAIRS = BLOCKS.register("colorable_plank_vertical_stairs", () -> new ColorableVerticalStairs("colorable_plank_vertical_stairs", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_VERTICAL_STAIRS = BLOCKS.register("colorable_brick_vertical_stairs", () -> new ColorableVerticalStairs("colorable_brick_vertical_stairs", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_VERTICAL_STAIRS = BLOCKS.register("colorable_stone_brick_vertical_stairs", () -> new ColorableVerticalStairs("colorable_stone_brick_vertical_stairs", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_VERTICAL_STAIRS = BLOCKS.register("colorable_stone_vertical_stairs", () -> new ColorableVerticalStairs("colorable_stone_vertical_stairs", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_VERTICAL_STAIRS = BLOCKS.register("colorable_cobblestone_vertical_stairs", () -> new ColorableVerticalStairs("colorable_cobblestone_vertical_stairs", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> CRIMSON_VERTICAL_STAIRS = BLOCKS.register("crimson_vertical_stairs", () -> new ColorableVerticalStairs("crimson_vertical_stairs", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> WARPED_VERTICAL_STAIRS = BLOCKS.register("warped_vertical_stairs", () -> new ColorableVerticalStairs("warped_vertical_stairs", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> BLACKSTONE_VERTICAL_STAIRS = BLOCKS.register("blackstone_vertical_stairs", () -> new ColorableVerticalStairs("blackstone_vertical_stairs", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_VERTICAL_STAIRS = BLOCKS.register("polished_blackstone_vertical_stairs", () -> new ColorableVerticalStairs("polished_blackstone_vertical_stairs", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS = BLOCKS.register("polished_blackstone_brick_vertical_stairs", () -> new ColorableVerticalStairs("polished_blackstone_brick_vertical_stairs", Blocks.POLISHED_BLACKSTONE_BRICKS));

    public static final RegistryObject<Block> COLORABLE_GLASS = BLOCKS.register("colorable_glass", () -> new ColorableGlass("colorable_glass"));
    public static final RegistryObject<Block> COLORABLE_GLASS_PANE = BLOCKS.register("colorable_glass_pane", () -> new ColorableGlassPane("colorable_glass_pane"));

    public static final RegistryObject<Block> COLORABLE_PLANK_ARCH = BLOCKS.register("colorable_plank_arch", () -> new ColorableArch("colorable_plank_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_INVERTED_ARCH = BLOCKS.register("colorable_plank_inverted_arch", () -> new ColorableInvertedArch("colorable_plank_inverted_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_UPPER_SMALL_ARCH = BLOCKS.register("colorable_plank_upper_small_arch", () -> new ColorableUpperSmallArch("colorable_plank_upper_small_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_LOWER_SMALL_ARCH = BLOCKS.register("colorable_plank_lower_small_arch", () -> new ColorableLowerSmallArch("colorable_plank_lower_small_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_plank_upper_small_inverted_arch", () -> new ColorableUpperSmallInvertedArch("colorable_plank_upper_small_inverted_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_plank_lower_small_inverted_arch", () -> new ColorableLowerSmallInvertedArch("colorable_plank_lower_small_inverted_arch", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_POST = BLOCKS.register("colorable_plank_post", () -> new ColorablePost("colorable_plank_post", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_PILLAR = BLOCKS.register("colorable_plank_pillar", () -> new ColorablePillar("colorable_plank_pillar", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_TRIANGLE_RAMP = BLOCKS.register("colorable_plank_triangle_ramp", () -> new ColorableTriangleRamp("colorable_plank_triangle_ramp", Blocks.OAK_PLANKS));
    public static final RegistryObject<Block> COLORABLE_PLANK_RAMP = BLOCKS.register("colorable_plank_ramp", () -> new ColorableRamp("colorable_plank_ramp", Blocks.OAK_PLANKS, Blocks.OAK_PLANKS.defaultBlockState()));

    public static final RegistryObject<Block> COLORABLE_BRICK_ARCH = BLOCKS.register("colorable_brick_arch", () -> new ColorableArch("colorable_brick_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_INVERTED_ARCH = BLOCKS.register("colorable_brick_inverted_arch", () -> new ColorableInvertedArch("colorable_brick_inverted_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("colorable_brick_upper_small_arch", () -> new ColorableUpperSmallArch("colorable_brick_upper_small_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("colorable_brick_lower_small_arch", () -> new ColorableLowerSmallArch("colorable_brick_lower_small_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_brick_upper_small_inverted_arch", () -> new ColorableUpperSmallInvertedArch("colorable_brick_upper_small_inverted_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_brick_lower_small_inverted_arch", () -> new ColorableLowerSmallInvertedArch("colorable_brick_lower_small_inverted_arch", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_POST = BLOCKS.register("colorable_brick_post", () -> new ColorablePost("colorable_brick_post", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_PILLAR = BLOCKS.register("colorable_brick_pillar", () -> new ColorablePillar("colorable_brick_pillar", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_TRIANGLE_RAMP = BLOCKS.register("colorable_brick_triangle_ramp", () -> new ColorableTriangleRamp("colorable_brick_triangle_ramp", Blocks.BRICKS));
    public static final RegistryObject<Block> COLORABLE_BRICK_RAMP = BLOCKS.register("colorable_brick_ramp", () -> new ColorableRamp("colorable_brick_ramp", Blocks.BRICKS, Blocks.BRICKS.defaultBlockState()));

    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_ARCH = BLOCKS.register("colorable_stone_brick_arch", () -> new ColorableArch("colorable_stone_brick_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_INVERTED_ARCH = BLOCKS.register("colorable_stone_brick_inverted_arch", () -> new ColorableInvertedArch("colorable_stone_brick_inverted_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("colorable_stone_brick_upper_small_arch", () -> new ColorableUpperSmallArch("colorable_stone_brick_upper_small_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("colorable_stone_brick_lower_small_arch", () -> new ColorableLowerSmallArch("colorable_stone_brick_lower_small_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_stone_brick_upper_small_inverted_arch", () -> new ColorableUpperSmallInvertedArch("colorable_stone_brick_upper_small_inverted_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_stone_brick_lower_small_inverted_arch", () -> new ColorableLowerSmallInvertedArch("colorable_stone_brick_lower_small_inverted_arch", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_POST = BLOCKS.register("colorable_stone_brick_post", () -> new ColorablePost("colorable_stone_brick_post", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_PILLAR = BLOCKS.register("colorable_stone_brick_pillar", () -> new ColorablePillar("colorable_stone_brick_pillar", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_TRIANGLE_RAMP = BLOCKS.register("colorable_stone_brick_triangle_ramp", () -> new ColorableTriangleRamp("colorable_stone_brick_triangle_ramp", Blocks.STONE_BRICKS));
    public static final RegistryObject<Block> COLORABLE_STONE_BRICK_RAMP = BLOCKS.register("colorable_stone_brick_ramp", () -> new ColorableRamp("colorable_stone_brick_ramp", Blocks.STONE_BRICKS, Blocks.STONE_BRICKS.defaultBlockState()));

    public static final RegistryObject<Block> COLORABLE_STONE_ARCH = BLOCKS.register("colorable_stone_arch", () -> new ColorableArch("colorable_stone_arch", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_INVERTED_ARCH = BLOCKS.register("colorable_stone_inverted_arch", () -> new ColorableInvertedArch("colorable_stone_inverted_arch", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_UPPER_SMALL_ARCH = BLOCKS.register("colorable_stone_upper_small_arch", () -> new ColorableUpperSmallArch("colorable_stone_upper_small_arch", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_LOWER_SMALL_ARCH = BLOCKS.register("colorable_stone_lower_small_arch", () -> new ColorableLowerSmallArch("colorable_stone_lower_small_arch", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_stone_upper_small_inverted_arch", () -> new ColorableUpperSmallInvertedArch("colorable_stone_upper_small_inverted_arch", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_stone_lower_small_inverted_arch", () -> new ColorableLowerSmallInvertedArch("colorable_stone_lower_small_inverted_arch", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_POST = BLOCKS.register("colorable_stone_post", () -> new ColorablePost("colorable_stone_post", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_PILLAR = BLOCKS.register("colorable_stone_pillar", () -> new ColorablePillar("colorable_stone_pillar", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_TRIANGLE_RAMP = BLOCKS.register("colorable_stone_triangle_ramp", () -> new ColorableTriangleRamp("colorable_stone_triangle_ramp", Blocks.STONE));
    public static final RegistryObject<Block> COLORABLE_STONE_RAMP = BLOCKS.register("colorable_stone_ramp", () -> new ColorableRamp("colorable_stone_ramp", Blocks.STONE, Blocks.STONE.defaultBlockState()));

    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_ARCH = BLOCKS.register("colorable_cobblestone_arch", () -> new ColorableArch("colorable_cobblestone_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_INVERTED_ARCH = BLOCKS.register("colorable_cobblestone_inverted_arch", () -> new ColorableInvertedArch("colorable_cobblestone_inverted_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_UPPER_SMALL_ARCH = BLOCKS.register("colorable_cobblestone_upper_small_arch", () -> new ColorableUpperSmallArch("colorable_cobblestone_upper_small_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_LOWER_SMALL_ARCH = BLOCKS.register("colorable_cobblestone_lower_small_arch", () -> new ColorableLowerSmallArch("colorable_cobblestone_lower_small_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_cobblestone_upper_small_inverted_arch", () -> new ColorableUpperSmallInvertedArch("colorable_cobblestone_upper_small_inverted_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("colorable_cobblestone_lower_small_inverted_arch", () -> new ColorableLowerSmallInvertedArch("colorable_cobblestone_lower_small_inverted_arch", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_POST = BLOCKS.register("colorable_cobblestone_post", () -> new ColorablePost("colorable_cobblestone_post", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_PILLAR = BLOCKS.register("colorable_cobblestone_pillar", () -> new ColorablePillar("colorable_cobblestone_pillar", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_TRIANGLE_RAMP = BLOCKS.register("colorable_cobblestone_triangle_ramp", () -> new ColorableTriangleRamp("colorable_cobblestone_triangle_ramp", Blocks.COBBLESTONE));
    public static final RegistryObject<Block> COLORABLE_COBBLESTONE_RAMP = BLOCKS.register("colorable_cobblestone_ramp", () -> new ColorableRamp("colorable_cobblestone_ramp", Blocks.COBBLESTONE, Blocks.COBBLESTONE.defaultBlockState()));

    public static final RegistryObject<Block> NEON_BLOCK = BLOCKS.register("neon_block", () -> new NeonBlock("neon_block", Blocks.WHITE_CONCRETE));
    public static final RegistryObject<Block> GLOWING_NEON_BLOCK = BLOCKS.register("glowing_neon_block", () -> new GlowingNeonBlock("glowing_neon_block", Blocks.WHITE_CONCRETE));
    public static final RegistryObject<Block> RAINBOW_BLOCK = BLOCKS.register("rainbow_block", () -> new RainbowBlock("rainbow_block", Blocks.WHITE_CONCRETE));
    public static final RegistryObject<Block> LAVA_LAMP = BLOCKS.register("lava_lamp", () -> new LavaLamp("lava_lamp"));
    public static final RegistryObject<Block> SIREN = BLOCKS.register("siren", () -> new Siren("siren"));
    public static final RegistryObject<Block> SIGNAL_TOWER_LIGHT = BLOCKS.register("signal_tower_light", () -> new SignalTowerLight("signal_tower_light", 0xFF0000, 0xFF7F00, 0x00FF00));
    public static final RegistryObject<Block> EYEBALL_LAMP = BLOCKS.register("eyeball_lamp", () -> new EyeballLamp("eyeball_lamp", Blocks.SKELETON_SKULL));
    public static final RegistryObject<Block> INK_BLOCK = BLOCKS.register("ink_block", () -> new InkBlock("ink_block", Blocks.HONEY_BLOCK));

    /* 1.16 */

    /* 1.16 */

    public static final RegistryObject<Block> CRIMSON_ARCH = BLOCKS.register("crimson_arch", () -> new ArchBlock("crimson_arch", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_INVERTED_ARCH = BLOCKS.register("crimson_inverted_arch", () -> new InvertedArchBlock("crimson_inverted_arch", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_UPPER_SMALL_ARCH = BLOCKS.register("crimson_upper_small_arch", () -> new UpperSmallArch("crimson_upper_small_arch", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_LOWER_SMALL_ARCH = BLOCKS.register("crimson_lower_small_arch", () -> new LowerSmallArch("crimson_lower_small_arch", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("crimson_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("crimson_upper_small_inverted_arch", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("crimson_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("crimson_lower_small_inverted_arch", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_POST = BLOCKS.register("crimson_post", () -> new PostBlock("crimson_post", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_PILLAR = BLOCKS.register("crimson_pillar", () -> new PillarBlock("crimson_pillar", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_TRIANGLE_RAMP = BLOCKS.register("crimson_triangle_ramp", () -> new TriangleRamp("crimson_triangle_ramp", Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<Block> CRIMSON_RAMP = BLOCKS.register("crimson_ramp", () -> new RampBlock("crimson_ramp", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_PLANKS.defaultBlockState()));

    public static final RegistryObject<Block> WARPED_ARCH = BLOCKS.register("warped_arch", () -> new ArchBlock("warped_arch", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_INVERTED_ARCH = BLOCKS.register("warped_inverted_arch", () -> new InvertedArchBlock("warped_inverted_arch", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_UPPER_SMALL_ARCH = BLOCKS.register("warped_upper_small_arch", () -> new UpperSmallArch("warped_upper_small_arch", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_LOWER_SMALL_ARCH = BLOCKS.register("warped_lower_small_arch", () -> new LowerSmallArch("warped_lower_small_arch", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("warped_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("warped_upper_small_inverted_arch", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("warped_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("warped_lower_small_inverted_arch", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_POST = BLOCKS.register("warped_post", () -> new PostBlock("warped_post", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_PILLAR = BLOCKS.register("warped_pillar", () -> new PillarBlock("warped_pillar", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_TRIANGLE_RAMP = BLOCKS.register("warped_triangle_ramp", () -> new TriangleRamp("warped_triangle_ramp", Blocks.WARPED_PLANKS));
    public static final RegistryObject<Block> WARPED_RAMP = BLOCKS.register("warped_ramp", () -> new RampBlock("warped_ramp", Blocks.WARPED_PLANKS, Blocks.WARPED_PLANKS.defaultBlockState()));

    public static final RegistryObject<Block> BLACKSTONE_ARCH = BLOCKS.register("blackstone_arch", () -> new ArchBlock("blackstone_arch", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_INVERTED_ARCH = BLOCKS.register("blackstone_inverted_arch", () -> new InvertedArchBlock("blackstone_inverted_arch", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_UPPER_SMALL_ARCH = BLOCKS.register("blackstone_upper_small_arch", () -> new UpperSmallArch("blackstone_upper_small_arch", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_LOWER_SMALL_ARCH = BLOCKS.register("blackstone_lower_small_arch", () -> new LowerSmallArch("blackstone_lower_small_arch", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("blackstone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("blackstone_upper_small_inverted_arch", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("blackstone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("blackstone_lower_small_inverted_arch", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_POST = BLOCKS.register("blackstone_post", () -> new PostBlock("blackstone_post", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_PILLAR = BLOCKS.register("blackstone_pillar", () -> new PillarBlock("blackstone_pillar", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_TRIANGLE_RAMP = BLOCKS.register("blackstone_triangle_ramp", () -> new TriangleRamp("blackstone_triangle_ramp", Blocks.BLACKSTONE));
    public static final RegistryObject<Block> BLACKSTONE_RAMP = BLOCKS.register("blackstone_ramp", () -> new RampBlock("blackstone_ramp", Blocks.BLACKSTONE, Blocks.BLACKSTONE.defaultBlockState()));

    public static final RegistryObject<Block> POLISHED_BLACKSTONE_ARCH = BLOCKS.register("polished_blackstone_arch", () -> new ArchBlock("polished_blackstone_arch", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_INVERTED_ARCH = BLOCKS.register("polished_blackstone_inverted_arch", () -> new InvertedArchBlock("polished_blackstone_inverted_arch", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_UPPER_SMALL_ARCH = BLOCKS.register("polished_blackstone_upper_small_arch", () -> new UpperSmallArch("polished_blackstone_upper_small_arch", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_LOWER_SMALL_ARCH = BLOCKS.register("polished_blackstone_lower_small_arch", () -> new LowerSmallArch("polished_blackstone_lower_small_arch", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_blackstone_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("polished_blackstone_upper_small_inverted_arch", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_blackstone_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("polished_blackstone_lower_small_inverted_arch", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_POST = BLOCKS.register("polished_blackstone_post", () -> new PostBlock("polished_blackstone_post", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_PILLAR = BLOCKS.register("polished_blackstone_pillar", () -> new PillarBlock("polished_blackstone_pillar", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_TRIANGLE_RAMP = BLOCKS.register("polished_blackstone_triangle_ramp", () -> new TriangleRamp("polished_blackstone_triangle_ramp", Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_RAMP = BLOCKS.register("polished_blackstone_ramp", () -> new RampBlock("polished_blackstone_ramp", Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE.defaultBlockState()));

    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_ARCH = BLOCKS.register("polished_blackstone_brick_arch", () -> new ArchBlock("polished_blackstone_brick_arch", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_INVERTED_ARCH = BLOCKS.register("polished_blackstone_brick_inverted_arch", () -> new InvertedArchBlock("polished_blackstone_brick_inverted_arch", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_UPPER_SMALL_ARCH = BLOCKS.register("polished_blackstone_brick_upper_small_arch", () -> new UpperSmallArch("polished_blackstone_brick_upper_small_arch", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_LOWER_SMALL_ARCH = BLOCKS.register("polished_blackstone_brick_lower_small_arch", () -> new LowerSmallArch("polished_blackstone_brick_lower_small_arch", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_UPPER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_blackstone_brick_upper_small_inverted_arch", () -> new UpperSmallInvertedArch("polished_blackstone_brick_upper_small_inverted_arch", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_LOWER_SMALL_INVERTED_ARCH = BLOCKS.register("polished_blackstone_brick_lower_small_inverted_arch", () -> new LowerSmallInvertedArch("polished_blackstone_brick_lower_small_inverted_arch", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_POST = BLOCKS.register("polished_blackstone_brick_post", () -> new PostBlock("polished_blackstone_brick_post", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_PILLAR = BLOCKS.register("polished_blackstone_brick_pillar", () -> new PillarBlock("polished_blackstone_brick_pillar", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_TRIANGLE_RAMP = BLOCKS.register("polished_blackstone_brick_triangle_ramp", () -> new TriangleRamp("polished_blackstone_brick_triangle_ramp", Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_RAMP = BLOCKS.register("polished_blackstone_brick_ramp", () -> new RampBlock("polished_blackstone_brick_ramp", Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState()));

}
