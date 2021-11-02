package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.decoration.BlockColorer;
import kirothebluefox.moblocks.content.decoration.colorableblock.*;
import kirothebluefox.moblocks.content.decoration.colorableblock.inkblock.InkBlock;
import kirothebluefox.moblocks.content.decoration.colorableflowerpot.ColorableFlowerPot;
import kirothebluefox.moblocks.content.decoration.colorableflowerpot.ColorableFlowerPotTile;
import kirothebluefox.moblocks.content.decoration.colorablefurnitures.*;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.CustomColorPicker;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.CustomLightColorPicker;
import kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp.EyeballLamp;
import kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp.EyeballLampTile;
import kirothebluefox.moblocks.content.decoration.lighting.lavalamp.LavaLamp;
import kirothebluefox.moblocks.content.decoration.lighting.lavalamp.LavaLampTile;
import kirothebluefox.moblocks.content.decoration.lighting.neonblock.GlowingNeonBlock;
import kirothebluefox.moblocks.content.decoration.lighting.neonblock.NeonBlock;
import kirothebluefox.moblocks.content.decoration.lighting.neonblock.NeonBlockTile;
import kirothebluefox.moblocks.content.decoration.lighting.rainbowblock.RainbowBlock;
import kirothebluefox.moblocks.content.decoration.lighting.rainbowblock.RainbowBlockTile;
import kirothebluefox.moblocks.content.decoration.lighting.signaltowerlight.SignalTowerLight;
import kirothebluefox.moblocks.content.decoration.lighting.signaltowerlight.SignalTowerLightTile;
import kirothebluefox.moblocks.content.decoration.lighting.siren.Siren;
import kirothebluefox.moblocks.content.decoration.lighting.siren.SirenTile;
import kirothebluefox.moblocks.content.furnitures.*;
import kirothebluefox.moblocks.content.furnitures.bookshelves.Bookshelf;
import kirothebluefox.moblocks.content.furnitures.bookshelves.BookshelfTile;
import kirothebluefox.moblocks.content.furnitures.crates.Crate;
import kirothebluefox.moblocks.content.furnitures.crates.CrateTile;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawer;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawerContainer;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawerTile;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawer;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawerContainer;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawerTile;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.InnerCornerKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.OuterCornerKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.StraightKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable.ColorableInnerCornerKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable.ColorableKitchenCounterTile;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable.ColorableOuterCornerKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable.ColorableStraightKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.lamps.LampTile;
import kirothebluefox.moblocks.content.furnitures.lamps.ShadeItem;
import kirothebluefox.moblocks.content.furnitures.lamps.SmallLamp;
import kirothebluefox.moblocks.content.furnitures.potionshelves.PotionShelf;
import kirothebluefox.moblocks.content.furnitures.potionshelves.PotionShelfTile;
import kirothebluefox.moblocks.content.furnitures.shelves.Shelf;
import kirothebluefox.moblocks.content.furnitures.shelves.ShelfTile;
import kirothebluefox.moblocks.content.specialblocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = MoBlocks.MODID, bus=Bus.MOD)
public class RegistrationHandler {
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> block) {
		/* Special Blocks */
		/*Arches*/
		block.getRegistry().register(new ArchBlock(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_arch"));
		block.getRegistry().register(new ArchBlock(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_arch"));

		/*Vertical Slabs*/
		block.getRegistry().register(new VerticalSlab(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_vertical_slab"));
		block.getRegistry().register(new VerticalSlab(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_vertical_slab"));
        block.getRegistry().register(new VerticalSlab(Blocks.SMOOTH_STONE).setRegistryName(MoBlocks.MODID, "smooth_stone_vertical_slab"));

		/*Vertical Stairs*/
		block.getRegistry().register(new VerticalStairs(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_vertical_stairs"));
        block.getRegistry().register(new VerticalStairs(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_vertical_stairs"));


		/*Pillars*/
        block.getRegistry().register(new PillarBlock(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_pillar"));
        block.getRegistry().register(new PillarBlock(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_pillar"));

		/*Ramps*/
        block.getRegistry().register(new RampBlock(Blocks.OAK_PLANKS, Blocks.OAK_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "oak_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "spruce_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.BIRCH_PLANKS, Blocks.BIRCH_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "birch_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "jungle_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.ACACIA_PLANKS, Blocks.ACACIA_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "acacia_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "dark_oak_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK.defaultBlockState()).setRegistryName(MoBlocks.MODID, "purpur_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.COBBLESTONE, Blocks.COBBLESTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "cobblestone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.BRICKS, Blocks.BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.STONE_BRICKS, Blocks.STONE_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "stone_brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.NETHER_BRICKS, Blocks.NETHER_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "nether_brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.SANDSTONE, Blocks.SANDSTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "sandstone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK.defaultBlockState()).setRegistryName(MoBlocks.MODID, "quartz_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.PRISMARINE, Blocks.PRISMARINE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "prismarine_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "prismarine_brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.DARK_PRISMARINE, Blocks.DARK_PRISMARINE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "dark_prismarine_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "red_sandstone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "polished_granite_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.MOSSY_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "polished_diorite_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "end_stone_brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.STONE, Blocks.STONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "stone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_SANDSTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "smooth_sandstone_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_QUARTZ.defaultBlockState()).setRegistryName(MoBlocks.MODID, "smooth_quartz_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.GRANITE, Blocks.GRANITE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "granite_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.ANDESITE, Blocks.ANDESITE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "andesite_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "red_nether_brick_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "polished_andesite_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.DIORITE, Blocks.DIORITE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "diorite_ramp"));

		/*Inverted Arches*/
        block.getRegistry().register(new InvertedArchBlock(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_inverted_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_inverted_arch"));

		/*Triangle Ramps*/
        block.getRegistry().register(new TriangleRamp(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_triangle_ramp"));
        block.getRegistry().register(new TriangleRamp(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_triangle_ramp"));

		/* Upper Small Arches */
        block.getRegistry().register(new UpperSmallArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_upper_small_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_upper_small_arch"));

		/* Lower Small Arches */
        block.getRegistry().register(new LowerSmallArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_lower_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_lower_small_arch"));

		/* Upper Small Inverted Arches */
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_upper_small_inverted_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_upper_small_inverted_arch"));

		/* Lower Small Inverted Arches */
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_lower_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_lower_small_inverted_arch"));

		/* Posts */
        block.getRegistry().register(new PostBlock(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_post"));
        block.getRegistry().register(new PostBlock(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_post"));
        block.getRegistry().register(new PostBlock(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_post"));
        block.getRegistry().register(new PostBlock(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_post"));
        block.getRegistry().register(new PostBlock(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_post"));
        block.getRegistry().register(new PostBlock(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_post"));
        block.getRegistry().register(new PostBlock(Blocks.PURPUR_BLOCK).setRegistryName(MoBlocks.MODID, "purpur_post"));
        block.getRegistry().register(new PostBlock(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "cobblestone_post"));
        block.getRegistry().register(new PostBlock(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "stone_brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.SANDSTONE).setRegistryName(MoBlocks.MODID, "sandstone_post"));
        block.getRegistry().register(new PostBlock(Blocks.QUARTZ_BLOCK).setRegistryName(MoBlocks.MODID, "quartz_post"));
        block.getRegistry().register(new PostBlock(Blocks.PRISMARINE).setRegistryName(MoBlocks.MODID, "prismarine_post"));
        block.getRegistry().register(new PostBlock(Blocks.PRISMARINE_BRICKS).setRegistryName(MoBlocks.MODID, "prismarine_brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.DARK_PRISMARINE).setRegistryName(MoBlocks.MODID, "dark_prismarine_post"));
        block.getRegistry().register(new PostBlock(Blocks.RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "red_sandstone_post"));
        block.getRegistry().register(new PostBlock(Blocks.POLISHED_GRANITE).setRegistryName(MoBlocks.MODID, "polished_granite_post"));
        block.getRegistry().register(new PostBlock(Blocks.SMOOTH_RED_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_post"));
        block.getRegistry().register(new PostBlock(Blocks.MOSSY_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.POLISHED_DIORITE).setRegistryName(MoBlocks.MODID, "polished_diorite_post"));
        block.getRegistry().register(new PostBlock(Blocks.MOSSY_COBBLESTONE).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_post"));
        block.getRegistry().register(new PostBlock(Blocks.END_STONE_BRICKS).setRegistryName(MoBlocks.MODID, "end_stone_brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.STONE).setRegistryName(MoBlocks.MODID, "stone_post"));
        block.getRegistry().register(new PostBlock(Blocks.SMOOTH_SANDSTONE).setRegistryName(MoBlocks.MODID, "smooth_sandstone_post"));
        block.getRegistry().register(new PostBlock(Blocks.SMOOTH_QUARTZ).setRegistryName(MoBlocks.MODID, "smooth_quartz_post"));
        block.getRegistry().register(new PostBlock(Blocks.GRANITE).setRegistryName(MoBlocks.MODID, "granite_post"));
        block.getRegistry().register(new PostBlock(Blocks.ANDESITE).setRegistryName(MoBlocks.MODID, "andesite_post"));
        block.getRegistry().register(new PostBlock(Blocks.RED_NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "red_nether_brick_post"));
        block.getRegistry().register(new PostBlock(Blocks.POLISHED_ANDESITE).setRegistryName(MoBlocks.MODID, "polished_andesite_post"));
        block.getRegistry().register(new PostBlock(Blocks.DIORITE).setRegistryName(MoBlocks.MODID, "diorite_post"));

		/*** Decoration ***/
		/* Dyeable Flower Pot */
        block.getRegistry().register(new ColorableFlowerPot(Block.Properties.of(Material.DECORATION).strength(0)).setRegistryName("colorable_flower_pot"));

		/* Tall Fences */
        block.getRegistry().register(new TallFence(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_tall_fence"));
        block.getRegistry().register(new TallFence(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_tall_fence"));

		/* Tall Fence Gates */
        block.getRegistry().register(new TallFenceGate(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_tall_fence_gate"));
        block.getRegistry().register(new TallFenceGate(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_tall_fence_gate"));


		/*** Furnitures ***/
		/* Tables */
        block.getRegistry().register(new Table(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_table"));
        block.getRegistry().register(new Table(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_table"));
        block.getRegistry().register(new Table(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_table"));
        block.getRegistry().register(new Table(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_table"));
        block.getRegistry().register(new Table(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_table"));
        block.getRegistry().register(new Table(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_table"));
        block.getRegistry().register(new Table(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_table"));
        block.getRegistry().register(new Table(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_table"));
        block.getRegistry().register(new Table(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_table"));

		/* Chairs */
        block.getRegistry().register(new Chair(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_chair"));
        block.getRegistry().register(new Chair(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_chair"));
        block.getRegistry().register(new Chair(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_chair"));
        block.getRegistry().register(new Chair(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_chair"));
        block.getRegistry().register(new Chair(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_chair"));
        block.getRegistry().register(new Chair(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_chair"));
        block.getRegistry().register(new Chair(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_chair"));
        block.getRegistry().register(new Chair(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_chair"));
        block.getRegistry().register(new Chair(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_chair"));

		/* Coffee Tables */
        block.getRegistry().register(new CoffeeTable(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.TERRACOTTA).setRegistryName(MoBlocks.MODID, "terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.WHITE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "white_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.ORANGE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "orange_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.MAGENTA_TERRACOTTA).setRegistryName(MoBlocks.MODID, "magenta_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.LIGHT_BLUE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "light_blue_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.YELLOW_TERRACOTTA).setRegistryName(MoBlocks.MODID, "yellow_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.LIME_TERRACOTTA).setRegistryName(MoBlocks.MODID, "lime_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.PINK_TERRACOTTA).setRegistryName(MoBlocks.MODID, "pink_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.GRAY_TERRACOTTA).setRegistryName(MoBlocks.MODID, "gray_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.LIGHT_GRAY_TERRACOTTA).setRegistryName(MoBlocks.MODID, "light_gray_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.CYAN_TERRACOTTA).setRegistryName(MoBlocks.MODID, "cyan_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.PURPLE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "purple_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.BLUE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "blue_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.BROWN_TERRACOTTA).setRegistryName(MoBlocks.MODID, "brown_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.GREEN_TERRACOTTA).setRegistryName(MoBlocks.MODID, "green_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.RED_TERRACOTTA).setRegistryName(MoBlocks.MODID, "red_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.BLACK_TERRACOTTA).setRegistryName(MoBlocks.MODID, "black_terracotta_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_OAK_WOOD).setRegistryName(MoBlocks.MODID, "stripped_oak_wood_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_ACACIA_WOOD).setRegistryName(MoBlocks.MODID, "stripped_acacia_wood_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_BIRCH_WOOD).setRegistryName(MoBlocks.MODID, "stripped_birch_wood_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_SPRUCE_WOOD).setRegistryName(MoBlocks.MODID, "stripped_spruce_wood_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_DARK_OAK_WOOD).setRegistryName(MoBlocks.MODID, "stripped_dark_oak_wood_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_JUNGLE_WOOD).setRegistryName(MoBlocks.MODID, "stripped_jungle_wood_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_CRIMSON_STEM).setRegistryName(MoBlocks.MODID, "stripped_crimson_stem_coffee_table"));
        block.getRegistry().register(new CoffeeTable(Blocks.STRIPPED_WARPED_STEM).setRegistryName(MoBlocks.MODID, "stripped_warped_stem_coffee_table"));

        /* Sofas */
        block.getRegistry().register(new Sofa(Blocks.WHITE_WOOL).setRegistryName(MoBlocks.MODID, "white_sofa"));
        block.getRegistry().register(new Sofa(Blocks.ORANGE_WOOL).setRegistryName(MoBlocks.MODID, "orange_sofa"));
        block.getRegistry().register(new Sofa(Blocks.MAGENTA_WOOL).setRegistryName(MoBlocks.MODID, "magenta_sofa"));
        block.getRegistry().register(new Sofa(Blocks.LIGHT_BLUE_WOOL).setRegistryName(MoBlocks.MODID, "light_blue_sofa"));
        block.getRegistry().register(new Sofa(Blocks.YELLOW_WOOL).setRegistryName(MoBlocks.MODID, "yellow_sofa"));
        block.getRegistry().register(new Sofa(Blocks.LIME_WOOL).setRegistryName(MoBlocks.MODID, "lime_sofa"));
        block.getRegistry().register(new Sofa(Blocks.PINK_WOOL).setRegistryName(MoBlocks.MODID, "pink_sofa"));
        block.getRegistry().register(new Sofa(Blocks.GRAY_WOOL).setRegistryName(MoBlocks.MODID, "gray_sofa"));
        block.getRegistry().register(new Sofa(Blocks.LIGHT_GRAY_WOOL).setRegistryName(MoBlocks.MODID, "light_gray_sofa"));
        block.getRegistry().register(new Sofa(Blocks.CYAN_WOOL).setRegistryName(MoBlocks.MODID, "cyan_sofa"));
        block.getRegistry().register(new Sofa(Blocks.PURPLE_WOOL).setRegistryName(MoBlocks.MODID, "purple_sofa"));
        block.getRegistry().register(new Sofa(Blocks.BLUE_WOOL).setRegistryName(MoBlocks.MODID, "blue_sofa"));
        block.getRegistry().register(new Sofa(Blocks.BROWN_WOOL).setRegistryName(MoBlocks.MODID, "brown_sofa"));
        block.getRegistry().register(new Sofa(Blocks.GREEN_WOOL).setRegistryName(MoBlocks.MODID, "green_sofa"));
        block.getRegistry().register(new Sofa(Blocks.RED_WOOL).setRegistryName(MoBlocks.MODID, "red_sofa"));
        block.getRegistry().register(new Sofa(Blocks.BLACK_WOOL).setRegistryName(MoBlocks.MODID, "black_sofa"));

        /* Carpets */
        block.getRegistry().register(new Carpet(Blocks.WHITE_WOOL).setRegistryName(MoBlocks.MODID, "white_carpet"));
        block.getRegistry().register(new Carpet(Blocks.ORANGE_WOOL).setRegistryName(MoBlocks.MODID, "orange_carpet"));
        block.getRegistry().register(new Carpet(Blocks.MAGENTA_WOOL).setRegistryName(MoBlocks.MODID, "magenta_carpet"));
        block.getRegistry().register(new Carpet(Blocks.LIGHT_BLUE_WOOL).setRegistryName(MoBlocks.MODID, "light_blue_carpet"));
        block.getRegistry().register(new Carpet(Blocks.YELLOW_WOOL).setRegistryName(MoBlocks.MODID, "yellow_carpet"));
        block.getRegistry().register(new Carpet(Blocks.LIME_WOOL).setRegistryName(MoBlocks.MODID, "lime_carpet"));
        block.getRegistry().register(new Carpet(Blocks.PINK_WOOL).setRegistryName(MoBlocks.MODID, "pink_carpet"));
        block.getRegistry().register(new Carpet(Blocks.GRAY_WOOL).setRegistryName(MoBlocks.MODID, "gray_carpet"));
        block.getRegistry().register(new Carpet(Blocks.LIGHT_GRAY_WOOL).setRegistryName(MoBlocks.MODID, "light_gray_carpet"));
        block.getRegistry().register(new Carpet(Blocks.CYAN_WOOL).setRegistryName(MoBlocks.MODID, "cyan_carpet"));
        block.getRegistry().register(new Carpet(Blocks.PURPLE_WOOL).setRegistryName(MoBlocks.MODID, "purple_carpet"));
        block.getRegistry().register(new Carpet(Blocks.BLUE_WOOL).setRegistryName(MoBlocks.MODID, "blue_carpet"));
        block.getRegistry().register(new Carpet(Blocks.BROWN_WOOL).setRegistryName(MoBlocks.MODID, "brown_carpet"));
        block.getRegistry().register(new Carpet(Blocks.GREEN_WOOL).setRegistryName(MoBlocks.MODID, "green_carpet"));
        block.getRegistry().register(new Carpet(Blocks.RED_WOOL).setRegistryName(MoBlocks.MODID, "red_carpet"));
        block.getRegistry().register(new Carpet(Blocks.BLACK_WOOL).setRegistryName(MoBlocks.MODID, "black_carpet"));

        /* Lamps */
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "oak_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "spruce_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "acacia_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "jungle_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "birch_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "dark_oak_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.STONE).strength(1.0F).sound(SoundType.STONE)).setRegistryName(MoBlocks.MODID, "nether_brick_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "crimson_small_lamp"));
        block.getRegistry().register(new SmallLamp(Block.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.WOOD)).setRegistryName(MoBlocks.MODID, "warped_small_lamp"));

        /* Drawers */
        /* Simple Drawers */
        block.getRegistry().register(new SimpleDrawer(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_simple_drawer"));
        block.getRegistry().register(new SimpleDrawer(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_simple_drawer"));

        /* Double Drawers */
        block.getRegistry().register(new DoubleDrawer(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_double_drawer"));
        block.getRegistry().register(new DoubleDrawer(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_double_drawer"));

        /* Shelves */
        block.getRegistry().register(new Shelf(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_shelf"));
        block.getRegistry().register(new Shelf(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_shelf"));
        block.getRegistry().register(new Shelf(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_shelf"));
        block.getRegistry().register(new Shelf(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_shelf"));
        block.getRegistry().register(new Shelf(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_shelf"));
        block.getRegistry().register(new Shelf(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_shelf"));
        block.getRegistry().register(new Shelf(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_shelf"));
        block.getRegistry().register(new Shelf(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_shelf"));
        block.getRegistry().register(new Shelf(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_shelf"));

        /* Crate */
        block.getRegistry().register(new Crate(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_crate"));
        block.getRegistry().register(new Crate(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_crate"));
        block.getRegistry().register(new Crate(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_crate"));
        block.getRegistry().register(new Crate(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_crate"));
        block.getRegistry().register(new Crate(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_crate"));
        block.getRegistry().register(new Crate(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_crate"));
        block.getRegistry().register(new Crate(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_crate"));
        block.getRegistry().register(new Crate(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_crate"));
        block.getRegistry().register(new Crate(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_crate"));

        /* Small Bookshelves */
        block.getRegistry().register(new Bookshelf(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_bookshelf"));
        block.getRegistry().register(new Bookshelf(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_bookshelf"));

        /* Potion Shelves */
        block.getRegistry().register(new PotionShelf(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.NETHER_BRICKS).setRegistryName(MoBlocks.MODID, "nether_brick_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_potion_shelf"));
        block.getRegistry().register(new PotionShelf(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_potion_shelf"));

        /* Straight Kitchen Counters */
        block.getRegistry().register(new StraightKitchenCounter(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_straight_kitchen_counter"));
        block.getRegistry().register(new StraightKitchenCounter(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_straight_kitchen_counter"));
        block.getRegistry().register(new ColorableStraightKitchenCounter(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_straight_kitchen_counter"));

        /* Inner Corner Kitchen Counters */
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_inner_corner_kitchen_counter"));
        block.getRegistry().register(new InnerCornerKitchenCounter(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_inner_corner_kitchen_counter"));
        block.getRegistry().register(new ColorableInnerCornerKitchenCounter(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_inner_corner_kitchen_counter"));

        /* Outer Corner Kitchen Counters */
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "oak_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.SPRUCE_PLANKS).setRegistryName(MoBlocks.MODID, "spruce_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.BIRCH_PLANKS).setRegistryName(MoBlocks.MODID, "birch_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.JUNGLE_PLANKS).setRegistryName(MoBlocks.MODID, "jungle_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.ACACIA_PLANKS).setRegistryName(MoBlocks.MODID, "acacia_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.DARK_OAK_PLANKS).setRegistryName(MoBlocks.MODID, "dark_oak_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_outer_corner_kitchen_counter"));
        block.getRegistry().register(new OuterCornerKitchenCounter(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_outer_corner_kitchen_counter"));
        block.getRegistry().register(new ColorableOuterCornerKitchenCounter(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_outer_corner_kitchen_counter"));



        /* Candles */
        block.getRegistry().register(new Candle().setRegistryName(MoBlocks.MODID, "candle"));

        /* Colorable Blocks */
        block.getRegistry().register(new ColorableBlock(Blocks.WHITE_WOOL).setRegistryName(MoBlocks.MODID, "colorable_wool"));
        block.getRegistry().register(new ColorableBlock(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_planks"));
        block.getRegistry().register(new ColorableBlock(Blocks.WHITE_CONCRETE).setRegistryName(MoBlocks.MODID, "colorable_concrete"));
        block.getRegistry().register(new ColorableBlock(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_bricks"));
        block.getRegistry().register(new ColorableBlock(Blocks.WHITE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "colorable_terracotta"));
        block.getRegistry().register(new ColorableBlock(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_bricks"));
        block.getRegistry().register(new ColorableBlock(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone"));
        block.getRegistry().register(new ColorableBlock(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone"));

        block.getRegistry().register(new ColorableSlab(Blocks.BRICK_SLAB).setRegistryName(MoBlocks.MODID, "colorable_brick_slab"));
        block.getRegistry().register(new ColorableSlab(Blocks.OAK_SLAB).setRegistryName(MoBlocks.MODID, "colorable_plank_slab"));
        block.getRegistry().register(new ColorableSlab(Blocks.STONE_BRICK_SLAB).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_slab"));
        block.getRegistry().register(new ColorableSlab(Blocks.STONE_SLAB).setRegistryName(MoBlocks.MODID, "colorable_stone_slab"));
        block.getRegistry().register(new ColorableSlab(Blocks.COBBLESTONE_SLAB).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_slab"));

        block.getRegistry().register(new ColorableStairs(Blocks.BRICKS::defaultBlockState, Blocks.BRICK_STAIRS).setRegistryName(MoBlocks.MODID, "colorable_brick_stairs"));
        block.getRegistry().register(new ColorableStairs(Blocks.OAK_PLANKS::defaultBlockState, Blocks.OAK_STAIRS).setRegistryName(MoBlocks.MODID, "colorable_plank_stairs"));
        block.getRegistry().register(new ColorableStairs(Blocks.STONE_BRICKS::defaultBlockState, Blocks.STONE_BRICK_STAIRS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_stairs"));
        block.getRegistry().register(new ColorableStairs(Blocks.STONE::defaultBlockState, Blocks.STONE_STAIRS).setRegistryName(MoBlocks.MODID, "colorable_stone_stairs"));
        block.getRegistry().register(new ColorableStairs(Blocks.COBBLESTONE::defaultBlockState, Blocks.COBBLESTONE_STAIRS).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_stairs"));

        block.getRegistry().register(new ColorableCarpet().setRegistryName(MoBlocks.MODID, "colorable_carpet"));
        block.getRegistry().register(new ColorableSofa(Blocks.WHITE_CARPET).setRegistryName(MoBlocks.MODID, "colorable_sofa"));
        block.getRegistry().register(new ColorableRoundCarpet(Blocks.WHITE_CARPET).setRegistryName(MoBlocks.MODID, "colorable_round_carpet"));
        block.getRegistry().register(new ColorableTable(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_table"));
        block.getRegistry().register(new ColorableCoffeeTable(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_coffee_table"));
        block.getRegistry().register(new ColorableCoffeeTable(Blocks.WHITE_TERRACOTTA).setRegistryName(MoBlocks.MODID, "colorable_terracotta_coffee_table"));
        block.getRegistry().register(new ColorableChair(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_chair"));

        block.getRegistry().register(new ColorableVerticalSlab(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_vertical_slab"));
        block.getRegistry().register(new ColorableVerticalSlab(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_vertical_slab"));

        block.getRegistry().register(new ColorableVerticalStairs(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_vertical_stairs"));
        block.getRegistry().register(new ColorableVerticalStairs(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_vertical_stairs"));

        block.getRegistry().register(new ColorableGlass().setRegistryName(MoBlocks.MODID, "colorable_glass"));
        block.getRegistry().register(new ColorableGlassPane().setRegistryName(MoBlocks.MODID, "colorable_glass_pane"));

        block.getRegistry().register(new ColorableArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_arch"));
        block.getRegistry().register(new ColorableInvertedArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_inverted_arch"));
        block.getRegistry().register(new ColorableUpperSmallArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_upper_small_arch"));
        block.getRegistry().register(new ColorableLowerSmallArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_lower_small_arch"));
        block.getRegistry().register(new ColorableUpperSmallInvertedArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_upper_small_inverted_arch"));
        block.getRegistry().register(new ColorableLowerSmallInvertedArch(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_lower_small_inverted_arch"));
        block.getRegistry().register(new ColorablePost(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_post"));
        block.getRegistry().register(new ColorablePillar(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_pillar"));
        block.getRegistry().register(new ColorableTriangleRamp(Blocks.OAK_PLANKS).setRegistryName(MoBlocks.MODID, "colorable_plank_triangle_ramp"));
        block.getRegistry().register(new ColorableRamp(Blocks.OAK_PLANKS, Blocks.OAK_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "colorable_plank_ramp"));

        block.getRegistry().register(new ColorableArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_arch"));
        block.getRegistry().register(new ColorableInvertedArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_inverted_arch"));
        block.getRegistry().register(new ColorableUpperSmallArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_upper_small_arch"));
        block.getRegistry().register(new ColorableLowerSmallArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_lower_small_arch"));
        block.getRegistry().register(new ColorableUpperSmallInvertedArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new ColorableLowerSmallInvertedArch(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new ColorablePost(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_post"));
        block.getRegistry().register(new ColorablePillar(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_pillar"));
        block.getRegistry().register(new ColorableTriangleRamp(Blocks.BRICKS).setRegistryName(MoBlocks.MODID, "colorable_brick_triangle_ramp"));
        block.getRegistry().register(new ColorableRamp(Blocks.BRICKS, Blocks.BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "colorable_brick_ramp"));

        block.getRegistry().register(new ColorableArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_arch"));
        block.getRegistry().register(new ColorableInvertedArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_inverted_arch"));
        block.getRegistry().register(new ColorableUpperSmallArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_upper_small_arch"));
        block.getRegistry().register(new ColorableLowerSmallArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_lower_small_arch"));
        block.getRegistry().register(new ColorableUpperSmallInvertedArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new ColorableLowerSmallInvertedArch(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new ColorablePost(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_post"));
        block.getRegistry().register(new ColorablePillar(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_pillar"));
        block.getRegistry().register(new ColorableTriangleRamp(Blocks.STONE_BRICKS).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_triangle_ramp"));
        block.getRegistry().register(new ColorableRamp(Blocks.STONE_BRICKS, Blocks.STONE_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_ramp"));

        block.getRegistry().register(new ColorableArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_arch"));
        block.getRegistry().register(new ColorableInvertedArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_inverted_arch"));
        block.getRegistry().register(new ColorableUpperSmallArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_upper_small_arch"));
        block.getRegistry().register(new ColorableLowerSmallArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_lower_small_arch"));
        block.getRegistry().register(new ColorableUpperSmallInvertedArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_upper_small_inverted_arch"));
        block.getRegistry().register(new ColorableLowerSmallInvertedArch(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_lower_small_inverted_arch"));
        block.getRegistry().register(new ColorablePost(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_post"));
        block.getRegistry().register(new ColorablePillar(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_pillar"));
        block.getRegistry().register(new ColorableTriangleRamp(Blocks.STONE).setRegistryName(MoBlocks.MODID, "colorable_stone_triangle_ramp"));
        block.getRegistry().register(new ColorableRamp(Blocks.STONE, Blocks.STONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "colorable_stone_ramp"));

        block.getRegistry().register(new ColorableArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_arch"));
        block.getRegistry().register(new ColorableInvertedArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_inverted_arch"));
        block.getRegistry().register(new ColorableUpperSmallArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_upper_small_arch"));
        block.getRegistry().register(new ColorableLowerSmallArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_lower_small_arch"));
        block.getRegistry().register(new ColorableUpperSmallInvertedArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_upper_small_inverted_arch"));
        block.getRegistry().register(new ColorableLowerSmallInvertedArch(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_lower_small_inverted_arch"));
        block.getRegistry().register(new ColorablePost(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_post"));
        block.getRegistry().register(new ColorablePillar(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_pillar"));
        block.getRegistry().register(new ColorableTriangleRamp(Blocks.COBBLESTONE).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_triangle_ramp"));
        block.getRegistry().register(new ColorableRamp(Blocks.COBBLESTONE, Blocks.COBBLESTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_ramp"));

        block.getRegistry().register(new NeonBlock(Blocks.WHITE_CONCRETE).setRegistryName(MoBlocks.MODID, "neon_block"));
        block.getRegistry().register(new GlowingNeonBlock(Blocks.WHITE_CONCRETE).setRegistryName(MoBlocks.MODID, "glowing_neon_block"));
        block.getRegistry().register(new RainbowBlock(Blocks.WHITE_CONCRETE).setRegistryName(MoBlocks.MODID, "rainbow_block"));
        block.getRegistry().register(new LavaLamp().setRegistryName(MoBlocks.MODID, "lava_lamp"));
        block.getRegistry().register(new Siren().setRegistryName(MoBlocks.MODID, "siren"));
        block.getRegistry().register(new SignalTowerLight(0xFF0000, 0xFF7F00, 0x00FF00).setRegistryName(MoBlocks.MODID, "signal_tower_light"));
        block.getRegistry().register(new EyeballLamp(Blocks.SKELETON_SKULL).setRegistryName(MoBlocks.MODID, "eyeball_lamp"));
        block.getRegistry().register(new InkBlock(Blocks.HONEY_BLOCK).setRegistryName(MoBlocks.MODID, "ink_block"));



        /* 1.16 */

        block.getRegistry().register(new ArchBlock(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_inverted_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_upper_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_lower_small_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_upper_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_lower_small_inverted_arch"));
        block.getRegistry().register(new PostBlock(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_post"));
        block.getRegistry().register(new PillarBlock(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_pillar"));
        block.getRegistry().register(new TriangleRamp(Blocks.CRIMSON_PLANKS).setRegistryName(MoBlocks.MODID, "crimson_triangle_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "crimson_ramp"));

        block.getRegistry().register(new ArchBlock(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_inverted_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_upper_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_lower_small_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_upper_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_lower_small_inverted_arch"));
        block.getRegistry().register(new PostBlock(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_post"));
        block.getRegistry().register(new PillarBlock(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_pillar"));
        block.getRegistry().register(new TriangleRamp(Blocks.WARPED_PLANKS).setRegistryName(MoBlocks.MODID, "warped_triangle_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.WARPED_PLANKS, Blocks.WARPED_PLANKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "warped_ramp"));

        block.getRegistry().register(new ArchBlock(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_inverted_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_upper_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_lower_small_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_upper_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_lower_small_inverted_arch"));
        block.getRegistry().register(new PostBlock(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_post"));
        block.getRegistry().register(new PillarBlock(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_pillar"));
        block.getRegistry().register(new TriangleRamp(Blocks.BLACKSTONE).setRegistryName(MoBlocks.MODID, "blackstone_triangle_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.BLACKSTONE, Blocks.BLACKSTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "blackstone_ramp"));

        block.getRegistry().register(new ArchBlock(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_inverted_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_upper_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_lower_small_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_upper_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_lower_small_inverted_arch"));
        block.getRegistry().register(new PostBlock(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_post"));
        block.getRegistry().register(new PillarBlock(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_pillar"));
        block.getRegistry().register(new TriangleRamp(Blocks.POLISHED_BLACKSTONE).setRegistryName(MoBlocks.MODID, "polished_blackstone_triangle_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE.defaultBlockState()).setRegistryName(MoBlocks.MODID, "polished_blackstone_ramp"));

        block.getRegistry().register(new ArchBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_arch"));
        block.getRegistry().register(new InvertedArchBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_inverted_arch"));
        block.getRegistry().register(new UpperSmallArch(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_upper_small_arch"));
        block.getRegistry().register(new LowerSmallArch(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_lower_small_arch"));
        block.getRegistry().register(new UpperSmallInvertedArch(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_upper_small_inverted_arch"));
        block.getRegistry().register(new LowerSmallInvertedArch(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_lower_small_inverted_arch"));
        block.getRegistry().register(new PostBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_post"));
        block.getRegistry().register(new PillarBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_pillar"));
        block.getRegistry().register(new TriangleRamp(Blocks.POLISHED_BLACKSTONE_BRICKS).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_triangle_ramp"));
        block.getRegistry().register(new RampBlock(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState()).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_ramp"));
	}
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> item) {
		/* Arches*/
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_arch"));
		item.getRegistry().register(new BlockItem(ModBlocks.STONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_arch"));

		/* Vertical Slab*/
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_vertical_slab"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_STONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_stone_vertical_slab"));

		/* Vertical Stairs*/
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_vertical_stairs"));

		/* Pillars*/
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_pillar"));

		/* Ramps*/
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_ramp"));

		/* Inverted Arches*/
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_inverted_arch"));

		/* Triangle Ramps*/
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_triangle_ramp"));

        /** Small Arches **/
        /* Upper */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_upper_small_arch"));

        /* Lower */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_lower_small_arch"));

        /* Upper Inverted */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_upper_small_inverted_arch"));

        /* Lower Inverted */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_lower_small_inverted_arch"));

        /* Posts */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPUR_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "purpur_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.COBBLESTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "cobblestone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.SANDSTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "sandstone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.QUARTZ_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "quartz_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.PRISMARINE_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "prismarine_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_PRISMARINE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_prismarine_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SANDSTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sandstone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_GRANITE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_granite_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_RED_SANDSTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_red_sandstone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_STONE_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_stone_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_DIORITE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_diorite_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.MOSSY_COBBLESTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "mossy_cobblestone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.END_STONE_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "end_stone_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.STONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "stone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_SANDSTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_sandstone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.SMOOTH_QUARTZ_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "smooth_quartz_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRANITE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "granite_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.ANDESITE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "andesite_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_NETHER_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "red_nether_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_ANDESITE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_andesite_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.DIORITE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "diorite_post"));

        /*** Decoration ***/
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_FLOWER_POT, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_flower_pot"));

		/* Tall Fence */
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_tall_fence"));
		item.getRegistry().register(new BlockItem(ModBlocks.WARPED_TALL_FENCE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_tall_fence"));

		/* Tall Fence */
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_tall_fence_gate"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_tall_fence_gate"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_TALL_FENCE_GATE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_tall_fence_gate"));

		/*** Furnitures ***/
		/* Tables */
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_table"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_table"));

		/* Chairs */
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_chair"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_CHAIR, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_chair"));

		/* Coffee Tables */
		item.getRegistry().register(new BlockItem(ModBlocks.OAK_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_coffee_table"));
		item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.WHITE_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.ORANGE_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.MAGENTA_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIGHT_BLUE_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.YELLOW_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIME_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.PINK_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRAY_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIGHT_GRAY_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.CYAN_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPLE_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLUE_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.BROWN_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.GREEN_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACK_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_terracotta_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_OAK_WOOD_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_oak_wood_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_ACACIA_WOOD_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_acacia_wood_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_BIRCH_WOOD_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_birch_wood_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_SPRUCE_WOOD_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_spruce_wood_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_DARK_OAK_WOOD_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_dark_oak_wood_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_JUNGLE_WOOD_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_jungle_wood_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_CRIMSON_STEM_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_crimson_stem_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.STRIPPED_WARPED_STEM_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "stripped_warped_stem_coffee_table"));

        /* Sofas */
        item.getRegistry().register(new BlockItem(ModBlocks.WHITE_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.ORANGE_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.MAGENTA_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIGHT_BLUE_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.YELLOW_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIME_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.PINK_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRAY_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIGHT_GRAY_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.CYAN_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPLE_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLUE_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.BROWN_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.GREEN_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACK_SOFA, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_sofa"));

        /* Carpets */
        item.getRegistry().register(new BlockItem(ModBlocks.WHITE_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.ORANGE_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.MAGENTA_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIGHT_BLUE_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.YELLOW_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIME_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.PINK_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.GRAY_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.LIGHT_GRAY_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.CYAN_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.PURPLE_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLUE_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.BROWN_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.GREEN_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.RED_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACK_CARPET, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_carpet"));

        /* Lamps */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_small_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_SMALL_LAMP, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_small_lamp"));

        /* Lamp Shades */
        /* Square Cones */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_square_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_square_cone_shade"));

        /* Cylinders */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_cylinder_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_cylinder_shade"));

        /* Cube */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_cube_shade"));

        /* Cone */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_cone_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_cone_shade"));

        /* Tube Cube */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_tube_cube_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_tube_cube_shade"));

        /* Lozenge Tube */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_tube_lozenge_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_tube_lozenge_shade"));

        /* Pyramid */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_pyramid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_pyramid_shade"));

        /* Sphere */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_sphere_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_sphere_shade"));

        /* Tube Cuboid */
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.WHITE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "white_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.ORANGE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "orange_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.MAGENTA, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "magenta_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_blue_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.YELLOW, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "yellow_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIME, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "lime_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PINK, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "pink_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GRAY, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "gray_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "light_gray_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.CYAN, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "cyan_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.PURPLE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "purple_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLUE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "blue_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BROWN, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "brown_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.GREEN, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "green_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.RED, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "red_tube_cuboid_shade"));
        item.getRegistry().register(new ShadeItem(ShadeItem.Color.BLACK, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "black_tube_cuboid_shade"));

        /* Drawers */
        /* Simple Drawers */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_simple_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_SIMPLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_simple_drawer"));

        /* Simple Drawers */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_double_drawer"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_DOUBLE_DRAWER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_double_drawer"));

        /* Shelves */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_shelf"));

        /* Crates */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_crate"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_CRATE, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_crate"));

        /* Bookshelves */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_bookshelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_BOOKSHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_bookshelf"));

        /* Potion Shelves */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.NETHER_BRICK_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "nether_brick_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_potion_shelf"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_POTION_SHELF, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_potion_shelf"));

        /* Straight Kitchen Counter */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_straight_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STRAIGHT_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_straight_kitchen_counter"));

        /* Inner Corner Kitchen Counter */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_inner_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_INNER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_inner_corner_kitchen_counter"));

        /* Outer Corner Kitchen Counter */
        item.getRegistry().register(new BlockItem(ModBlocks.OAK_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "oak_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.SPRUCE_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "spruce_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.BIRCH_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "birch_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.JUNGLE_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "jungle_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.ACACIA_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "acacia_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.DARK_OAK_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "dark_oak_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_outer_corner_kitchen_counter"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_OUTER_CORNER_KITCHEN_COUNTER, new Item.Properties().tab(MoBlocks.furnitures_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_outer_corner_kitchen_counter"));



        /* Candles */
        item.getRegistry().register(new BlockItem(ModBlocks.CANDLE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "candle"));

        /* Colorable Blocks */
        item.getRegistry().register(new CustomColorPicker((new Item.Properties()).tab(MoBlocks.decoration_creative_tab).stacksTo(1)).setRegistryName(MoBlocks.MODID, "custom_color_picker"));
        item.getRegistry().register(new CustomLightColorPicker((new Item.Properties()).tab(MoBlocks.decoration_creative_tab).stacksTo(1)).setRegistryName(MoBlocks.MODID, "custom_light_color_picker"));
        item.getRegistry().register(new BlockColorer((new Item.Properties()).tab(MoBlocks.decoration_creative_tab).craftRemainder(ModItems.BLOCK_COLORER).stacksTo(1)).setRegistryName(MoBlocks.MODID, "block_colorer"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_WOOL, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_wool"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANKS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_planks"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_CONCRETE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_concrete"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICKS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_bricks"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICKS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_bricks"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_TERRACOTTA, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_terracotta"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_slab"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_stairs"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_CARPET, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_SOFA, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_sofa"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_ROUND_CARPET, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_round_carpet"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_TABLE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_CHAIR, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_chair"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_coffee_table"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_TERRACOTTA_COFFEE_TABLE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_terracotta_coffee_table"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_vertical_slab"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_vertical_stairs"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_GLASS, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_glass"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_GLASS_PANE, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_glass_pane"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_POST, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_POST, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_POST, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_POST, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_POST, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_post"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_PILLAR, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_PILLAR, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_PILLAR, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_pillar"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_upper_small_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_lower_small_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_upper_small_inverted_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_lower_small_inverted_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_ramp"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_triangle_ramp"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_PLANK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_plank_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_brick_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_STONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_stone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.COLORABLE_COBBLESTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "colorable_cobblestone_inverted_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.NEON_BLOCK, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "neon_block"));
        item.getRegistry().register(new BlockItem(ModBlocks.GLOWING_NEON_BLOCK, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "glowing_neon_block"));
        item.getRegistry().register(new BlockItem(ModBlocks.RAINBOW_BLOCK, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "rainbow_block"));
        item.getRegistry().register(new BlockItem(ModBlocks.LAVA_LAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "lava_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.SIREN, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "siren"));
        item.getRegistry().register(new BlockItem(ModBlocks.SIGNAL_TOWER_LIGHT, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "signal_tower_light"));
        item.getRegistry().register(new BlockItem(ModBlocks.EYEBALL_LAMP, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "eyeball_lamp"));
        item.getRegistry().register(new BlockItem(ModBlocks.INK_BLOCK, new Item.Properties().tab(MoBlocks.decoration_creative_tab)).setRegistryName(MoBlocks.MODID, "ink_block"));



        /* 1.16 */

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_post"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_POST, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_post"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_pillar"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_PILLAR, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_pillar"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_upper_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_UPPER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_upper_small_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_lower_small_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_LOWER_SMALL_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_lower_small_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_upper_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_UPPER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_upper_small_inverted_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_lower_small_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_LOWER_SMALL_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_lower_small_inverted_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_ramp"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_triangle_ramp"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_TRIANGLE_RAMP, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_triangle_ramp"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_inverted_arch"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_INVERTED_ARCH, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_inverted_arch"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_vertical_slab"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_vertical_slab"));

        item.getRegistry().register(new BlockItem(ModBlocks.CRIMSON_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "crimson_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.WARPED_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "warped_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.BLACKSTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "blackstone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_vertical_stairs"));
        item.getRegistry().register(new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS, new Item.Properties().tab(MoBlocks.special_blocks_creative_tab)).setRegistryName(MoBlocks.MODID, "polished_blackstone_brick_vertical_stairs"));
	}
	@SubscribeEvent
	public static void onRegisterTileEntity(RegistryEvent.Register<BlockEntityType<?>> TE) {
		TE.getRegistry().register(BlockEntityType.Builder.of(LampTile::new, ModBlocks.OAK_SMALL_LAMP, ModBlocks.SPRUCE_SMALL_LAMP, ModBlocks.BIRCH_SMALL_LAMP, ModBlocks.JUNGLE_SMALL_LAMP, ModBlocks.ACACIA_SMALL_LAMP, ModBlocks.DARK_OAK_SMALL_LAMP, ModBlocks.NETHER_BRICK_SMALL_LAMP, ModBlocks.CRIMSON_SMALL_LAMP, ModBlocks.WARPED_SMALL_LAMP).build(null).setRegistryName(MoBlocks.MODID, "small_lamp"));
		TE.getRegistry().register(BlockEntityType.Builder.of(SimpleDrawerTile::new, ModBlocks.OAK_SIMPLE_DRAWER, ModBlocks.SPRUCE_SIMPLE_DRAWER, ModBlocks.BIRCH_SIMPLE_DRAWER, ModBlocks.JUNGLE_SIMPLE_DRAWER, ModBlocks.ACACIA_SIMPLE_DRAWER, ModBlocks.DARK_OAK_SIMPLE_DRAWER, ModBlocks.NETHER_BRICK_SIMPLE_DRAWER, ModBlocks.CRIMSON_SIMPLE_DRAWER, ModBlocks.WARPED_SIMPLE_DRAWER).build(null).setRegistryName(MoBlocks.MODID, "simple_drawer"));
		TE.getRegistry().register(BlockEntityType.Builder.of(DoubleDrawerTile::new, ModBlocks.OAK_DOUBLE_DRAWER, ModBlocks.SPRUCE_DOUBLE_DRAWER, ModBlocks.BIRCH_DOUBLE_DRAWER, ModBlocks.JUNGLE_DOUBLE_DRAWER, ModBlocks.ACACIA_DOUBLE_DRAWER, ModBlocks.DARK_OAK_DOUBLE_DRAWER, ModBlocks.NETHER_BRICK_DOUBLE_DRAWER, ModBlocks.CRIMSON_DOUBLE_DRAWER, ModBlocks.WARPED_DOUBLE_DRAWER).build(null).setRegistryName(MoBlocks.MODID, "double_drawer"));
		TE.getRegistry().register(BlockEntityType.Builder.of(ShelfTile::new, ModBlocks.OAK_SHELF, ModBlocks.SPRUCE_SHELF, ModBlocks.BIRCH_SHELF, ModBlocks.JUNGLE_SHELF, ModBlocks.ACACIA_SHELF, ModBlocks.DARK_OAK_SHELF, ModBlocks.NETHER_BRICK_SHELF, ModBlocks.CRIMSON_SHELF, ModBlocks.WARPED_SHELF).build(null).setRegistryName(MoBlocks.MODID, "shelf"));
		TE.getRegistry().register(BlockEntityType.Builder.of(CrateTile::new, ModBlocks.OAK_CRATE, ModBlocks.SPRUCE_CRATE, ModBlocks.BIRCH_CRATE, ModBlocks.JUNGLE_CRATE, ModBlocks.ACACIA_CRATE, ModBlocks.DARK_OAK_CRATE, ModBlocks.NETHER_BRICK_CRATE, ModBlocks.CRIMSON_CRATE, ModBlocks.WARPED_CRATE).build(null).setRegistryName(MoBlocks.MODID, "crate"));
		TE.getRegistry().register(BlockEntityType.Builder.of(BookshelfTile::new, ModBlocks.OAK_BOOKSHELF, ModBlocks.SPRUCE_BOOKSHELF, ModBlocks.BIRCH_BOOKSHELF, ModBlocks.JUNGLE_BOOKSHELF, ModBlocks.ACACIA_BOOKSHELF, ModBlocks.DARK_OAK_BOOKSHELF, ModBlocks.NETHER_BRICK_BOOKSHELF, ModBlocks.CRIMSON_BOOKSHELF, ModBlocks.WARPED_BOOKSHELF).build(null).setRegistryName(MoBlocks.MODID, "small_bookshelf"));
		TE.getRegistry().register(BlockEntityType.Builder.of(PotionShelfTile::new, ModBlocks.OAK_POTION_SHELF, ModBlocks.SPRUCE_POTION_SHELF, ModBlocks.BIRCH_POTION_SHELF, ModBlocks.JUNGLE_POTION_SHELF, ModBlocks.ACACIA_POTION_SHELF, ModBlocks.DARK_OAK_POTION_SHELF, ModBlocks.NETHER_BRICK_POTION_SHELF, ModBlocks.CRIMSON_POTION_SHELF, ModBlocks.WARPED_POTION_SHELF).build(null).setRegistryName(MoBlocks.MODID, "potion_shelf"));
		TE.getRegistry().register(BlockEntityType.Builder.of(ColorableFlowerPotTile::new, ModBlocks.COLORABLE_FLOWER_POT).build(null).setRegistryName(MoBlocks.MODID, "colorable_flower_pot"));
		TE.getRegistry().register(BlockEntityType.Builder.of(ColorableLightBlockTile::new, ModBlocks.CANDLE).build(null).setRegistryName(MoBlocks.MODID, "colorable_light_block"));
		TE.getRegistry().register(BlockEntityType.Builder.of(RainbowBlockTile::new, ModBlocks.RAINBOW_BLOCK).build(null).setRegistryName(MoBlocks.MODID, "rainbow_block"));
		TE.getRegistry().register(BlockEntityType.Builder.of(LavaLampTile::new, ModBlocks.LAVA_LAMP).build(null).setRegistryName(MoBlocks.MODID, "lava_lamp"));
		TE.getRegistry().register(BlockEntityType.Builder.of(SirenTile::new, ModBlocks.SIREN).build(null).setRegistryName(MoBlocks.MODID, "siren"));
		TE.getRegistry().register(BlockEntityType.Builder.of(SignalTowerLightTile::new, ModBlocks.SIGNAL_TOWER_LIGHT).build(null).setRegistryName(MoBlocks.MODID, "signal_tower_light"));
		TE.getRegistry().register(BlockEntityType.Builder.of(EyeballLampTile::new, ModBlocks.EYEBALL_LAMP).build(null).setRegistryName(MoBlocks.MODID, "eyeball_lamp"));
		TE.getRegistry().register(BlockEntityType.Builder.of(ColorableBlockTile::new,
				ModBlocks.COLORABLE_WOOL, ModBlocks.COLORABLE_PLANKS,
				ModBlocks.COLORABLE_CONCRETE, ModBlocks.COLORABLE_BRICKS,
				ModBlocks.COLORABLE_TERRACOTTA, ModBlocks.COLORABLE_STONE_BRICKS,
				ModBlocks.COLORABLE_STONE, ModBlocks.COLORABLE_COBBLESTONE,

				ModBlocks.COLORABLE_CARPET, ModBlocks.COLORABLE_ROUND_CARPET,
				ModBlocks.COLORABLE_SOFA, ModBlocks.COLORABLE_TABLE, ModBlocks.COLORABLE_CHAIR,
				ModBlocks.COLORABLE_PLANK_COFFEE_TABLE, ModBlocks.COLORABLE_TERRACOTTA_COFFEE_TABLE,

				ModBlocks.COLORABLE_PLANK_SLAB, ModBlocks.COLORABLE_BRICK_SLAB,
				ModBlocks.COLORABLE_STONE_BRICK_SLAB, ModBlocks.COLORABLE_STONE_SLAB,
				ModBlocks.COLORABLE_COBBLESTONE_SLAB,

				ModBlocks.COLORABLE_PLANK_STAIRS, ModBlocks.COLORABLE_BRICK_STAIRS,
				ModBlocks.COLORABLE_STONE_BRICK_STAIRS, ModBlocks.COLORABLE_STONE_STAIRS,
				ModBlocks.COLORABLE_COBBLESTONE_STAIRS,

				ModBlocks.COLORABLE_PLANK_VERTICAL_SLAB, ModBlocks.COLORABLE_BRICK_VERTICAL_SLAB,
				ModBlocks.COLORABLE_STONE_BRICK_VERTICAL_SLAB, ModBlocks.COLORABLE_STONE_VERTICAL_SLAB,
				ModBlocks.COLORABLE_COBBLESTONE_VERTICAL_SLAB,

				ModBlocks.COLORABLE_PLANK_VERTICAL_STAIRS, ModBlocks.COLORABLE_BRICK_VERTICAL_STAIRS,
				ModBlocks.COLORABLE_STONE_BRICK_VERTICAL_STAIRS, ModBlocks.COLORABLE_STONE_VERTICAL_STAIRS,
				ModBlocks.COLORABLE_COBBLESTONE_VERTICAL_STAIRS,

				ModBlocks.COLORABLE_GLASS, ModBlocks.COLORABLE_GLASS_PANE,

				ModBlocks.COLORABLE_PLANK_ARCH, ModBlocks.COLORABLE_PLANK_INVERTED_ARCH,
				ModBlocks.COLORABLE_PLANK_LOWER_SMALL_ARCH, ModBlocks.COLORABLE_PLANK_LOWER_SMALL_INVERTED_ARCH,
				ModBlocks.COLORABLE_PLANK_PILLAR, ModBlocks.COLORABLE_PLANK_POST, ModBlocks.COLORABLE_PLANK_RAMP,
				ModBlocks.COLORABLE_PLANK_TRIANGLE_RAMP, ModBlocks.COLORABLE_PLANK_UPPER_SMALL_ARCH,
				ModBlocks.COLORABLE_PLANK_UPPER_SMALL_INVERTED_ARCH,

				ModBlocks.COLORABLE_BRICK_ARCH, ModBlocks.COLORABLE_BRICK_INVERTED_ARCH,
				ModBlocks.COLORABLE_BRICK_LOWER_SMALL_ARCH, ModBlocks.COLORABLE_BRICK_LOWER_SMALL_INVERTED_ARCH,
				ModBlocks.COLORABLE_BRICK_PILLAR, ModBlocks.COLORABLE_BRICK_POST, ModBlocks.COLORABLE_BRICK_RAMP,
				ModBlocks.COLORABLE_BRICK_TRIANGLE_RAMP, ModBlocks.COLORABLE_BRICK_UPPER_SMALL_ARCH,
				ModBlocks.COLORABLE_BRICK_UPPER_SMALL_INVERTED_ARCH,

				ModBlocks.COLORABLE_STONE_BRICK_ARCH, ModBlocks.COLORABLE_STONE_BRICK_INVERTED_ARCH,
				ModBlocks.COLORABLE_STONE_BRICK_LOWER_SMALL_ARCH, ModBlocks.COLORABLE_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH,
				ModBlocks.COLORABLE_STONE_BRICK_PILLAR, ModBlocks.COLORABLE_STONE_BRICK_POST, ModBlocks.COLORABLE_STONE_BRICK_RAMP,
				ModBlocks.COLORABLE_STONE_BRICK_TRIANGLE_RAMP, ModBlocks.COLORABLE_STONE_BRICK_UPPER_SMALL_ARCH,
				ModBlocks.COLORABLE_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH,

				ModBlocks.COLORABLE_STONE_ARCH, ModBlocks.COLORABLE_STONE_INVERTED_ARCH,
				ModBlocks.COLORABLE_STONE_LOWER_SMALL_ARCH, ModBlocks.COLORABLE_STONE_LOWER_SMALL_INVERTED_ARCH,
				ModBlocks.COLORABLE_STONE_PILLAR, ModBlocks.COLORABLE_STONE_POST, ModBlocks.COLORABLE_STONE_RAMP,
				ModBlocks.COLORABLE_STONE_TRIANGLE_RAMP, ModBlocks.COLORABLE_STONE_UPPER_SMALL_ARCH,
				ModBlocks.COLORABLE_STONE_UPPER_SMALL_INVERTED_ARCH,

				ModBlocks.COLORABLE_COBBLESTONE_ARCH, ModBlocks.COLORABLE_COBBLESTONE_INVERTED_ARCH,
				ModBlocks.COLORABLE_COBBLESTONE_LOWER_SMALL_ARCH, ModBlocks.COLORABLE_COBBLESTONE_LOWER_SMALL_INVERTED_ARCH,
				ModBlocks.COLORABLE_COBBLESTONE_PILLAR, ModBlocks.COLORABLE_COBBLESTONE_POST, ModBlocks.COLORABLE_COBBLESTONE_RAMP,
				ModBlocks.COLORABLE_COBBLESTONE_TRIANGLE_RAMP, ModBlocks.COLORABLE_COBBLESTONE_UPPER_SMALL_ARCH,
				ModBlocks.COLORABLE_COBBLESTONE_UPPER_SMALL_INVERTED_ARCH,

				ModBlocks.OAK_STRAIGHT_KITCHEN_COUNTER, ModBlocks.BIRCH_STRAIGHT_KITCHEN_COUNTER,
				ModBlocks.SPRUCE_STRAIGHT_KITCHEN_COUNTER, ModBlocks.JUNGLE_STRAIGHT_KITCHEN_COUNTER,
				ModBlocks.ACACIA_STRAIGHT_KITCHEN_COUNTER, ModBlocks.DARK_OAK_STRAIGHT_KITCHEN_COUNTER,
				ModBlocks.WARPED_STRAIGHT_KITCHEN_COUNTER, ModBlocks.CRIMSON_STRAIGHT_KITCHEN_COUNTER,

				ModBlocks.OAK_INNER_CORNER_KITCHEN_COUNTER, ModBlocks.BIRCH_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.SPRUCE_INNER_CORNER_KITCHEN_COUNTER, ModBlocks.JUNGLE_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.ACACIA_INNER_CORNER_KITCHEN_COUNTER, ModBlocks.DARK_OAK_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.WARPED_INNER_CORNER_KITCHEN_COUNTER, ModBlocks.CRIMSON_INNER_CORNER_KITCHEN_COUNTER,

				ModBlocks.OAK_OUTER_CORNER_KITCHEN_COUNTER, ModBlocks.BIRCH_OUTER_CORNER_KITCHEN_COUNTER,
				ModBlocks.SPRUCE_OUTER_CORNER_KITCHEN_COUNTER, ModBlocks.JUNGLE_OUTER_CORNER_KITCHEN_COUNTER,
				ModBlocks.ACACIA_OUTER_CORNER_KITCHEN_COUNTER, ModBlocks.DARK_OAK_OUTER_CORNER_KITCHEN_COUNTER,
				ModBlocks.WARPED_OUTER_CORNER_KITCHEN_COUNTER, ModBlocks.CRIMSON_OUTER_CORNER_KITCHEN_COUNTER,

				ModBlocks.INK_BLOCK)
				.build(null).setRegistryName(MoBlocks.MODID, "colorable_block"));
		TE.getRegistry().register(BlockEntityType.Builder.of(ColorableKitchenCounterTile::new,
				ModBlocks.COLORABLE_STRAIGHT_KITCHEN_COUNTER, ModBlocks.COLORABLE_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.COLORABLE_OUTER_CORNER_KITCHEN_COUNTER).build(null).setRegistryName(MoBlocks.MODID, "colorable_kitchen_counter"));
		TE.getRegistry().register(BlockEntityType.Builder.of(NeonBlockTile::new,
				ModBlocks.NEON_BLOCK, ModBlocks.GLOWING_NEON_BLOCK).build(null).setRegistryName(MoBlocks.MODID, "neon_block_tile"));
	}
	@SubscribeEvent
	public static void onRegisterContainer(RegistryEvent.Register<MenuType<?>> container) {
		container.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
			BlockPos pos = data.readBlockPos();
			return new SimpleDrawerContainer(windowId, pos, inv);
		}).setRegistryName(MoBlocks.MODID, "simple_drawer_container"));
		container.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
			BlockPos pos = data.readBlockPos();
			return new DoubleDrawerContainer(windowId, pos, inv);
		}).setRegistryName(MoBlocks.MODID, "double_drawer_container"));
	}
	@SubscribeEvent
	public static void onRegisterEntity(RegistryEvent.Register<EntityType<?>> entity) {
		entity.getRegistry().register(EntityType.Builder.<SeatChair>of(SeatChair::new,MobCategory.MISC).fireImmune().noSummon().sized(0.0F, 0.0F).build("seat_chair").setRegistryName(MoBlocks.MODID, "seat_chair"));
		entity.getRegistry().register(EntityType.Builder.<SeatSofa>of(SeatSofa::new,MobCategory.MISC).fireImmune().noSummon().sized(0.0F, 0.0F).build("seat_sofa").setRegistryName(MoBlocks.MODID, "seat_sofa"));
	}
	@SubscribeEvent
	public static void onRegisterParticleTypes(RegistryEvent.Register<ParticleType<?>> particles) {
		particles.getRegistry().register(ModParticles.DRIPPING_INK.setRegistryName(MoBlocks.MODID, "dripping_ink"));
		particles.getRegistry().register(ModParticles.FALLING_INK.setRegistryName(MoBlocks.MODID, "falling_ink"));
		particles.getRegistry().register(ModParticles.LANDING_INK.setRegistryName(MoBlocks.MODID, "landing_ink"));
	}
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
        MoBlocksPacketHandler.registerMessages();
	}
}
