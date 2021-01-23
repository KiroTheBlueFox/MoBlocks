package kirothebluefox.moblocks.content;

import java.util.ArrayList;
import java.util.List;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlock;
import kirothebluefox.moblocks.content.decoration.colorableblock.inkblock.InkDripParticle;
import kirothebluefox.moblocks.content.decoration.colorableflowerpot.ColorableFlowerPot;
import kirothebluefox.moblocks.content.decoration.colorableflowerpot.ColorableFlowerPotTileRenderer;
import kirothebluefox.moblocks.content.decoration.colorablefurnitures.Candle;
import kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp.EyeballLampTileRenderer;
import kirothebluefox.moblocks.content.decoration.lighting.lavalamp.LavaLamp;
import kirothebluefox.moblocks.content.decoration.lighting.neonblock.NeonBlockTileRenderer;
import kirothebluefox.moblocks.content.decoration.lighting.rainbowblock.RainbowBlock;
import kirothebluefox.moblocks.content.decoration.lighting.siren.Siren;
import kirothebluefox.moblocks.content.furnitures.bookshelves.BookshelfTileRenderer;
import kirothebluefox.moblocks.content.furnitures.crates.CrateTileRenderer;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawerContainerScreen;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawerTileRenderer;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawerContainerScreen;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawerTileRenderer;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable.ColorableStraightKitchenCounter;
import kirothebluefox.moblocks.content.furnitures.lamps.SmallLampTileRenderer;
import kirothebluefox.moblocks.content.furnitures.potionshelves.PotionShelfTileRenderer;
import kirothebluefox.moblocks.content.furnitures.shelves.ShelfTileRenderer;
import kirothebluefox.moblocks.utils.InvisibleEntityRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = MoBlocks.MODID, value = Dist.CLIENT, bus=Bus.MOD)
public class ClientRegistration {
	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {
		EntityRendererManager entityRendererManager = Minecraft.getInstance().getRenderManager();
		
		ColorableFlowerPotTileRenderer.register();
		BookshelfTileRenderer.register();
		CrateTileRenderer.register();
		SimpleDrawerTileRenderer.register();
		DoubleDrawerTileRenderer.register();
		SmallLampTileRenderer.register();
		ShelfTileRenderer.register();
		PotionShelfTileRenderer.register();
		EyeballLampTileRenderer.register();
		NeonBlockTileRenderer.register();
		
		List<Block> cutoutBlocks = new ArrayList<Block>();
		cutoutBlocks.add(ModBlocks.OAK_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.SPRUCE_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.BIRCH_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.JUNGLE_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.ACACIA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.DARK_OAK_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.NETHER_BRICK_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.CRIMSON_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.WARPED_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.WHITE_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.GRAY_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.BLACK_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.BROWN_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.RED_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.ORANGE_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.YELLOW_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.LIME_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.GREEN_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.CYAN_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.BLUE_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.PURPLE_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.MAGENTA_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.PINK_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.COLORABLE_TERRACOTTA_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.COLORABLE_PLANK_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_OAK_WOOD_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_SPRUCE_WOOD_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_BIRCH_WOOD_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_JUNGLE_WOOD_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_ACACIA_WOOD_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_DARK_OAK_WOOD_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_CRIMSON_STEM_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.STRIPPED_WARPED_STEM_COFFEE_TABLE);
		cutoutBlocks.add(ModBlocks.EYEBALL_LAMP);
		
		
		
		List<Block> translucentBlocks = new ArrayList<Block>();
		translucentBlocks.add(ModBlocks.COLORABLE_GLASS);
		translucentBlocks.add(ModBlocks.COLORABLE_GLASS_PANE);
		
		translucentBlocks.add(ModBlocks.OAK_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.BIRCH_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.SPRUCE_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.JUNGLE_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.ACACIA_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.DARK_OAK_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.NETHER_BRICK_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.CRIMSON_SMALL_LAMP);
		translucentBlocks.add(ModBlocks.WARPED_SMALL_LAMP);
		
		translucentBlocks.add(ModBlocks.LAVA_LAMP);
		translucentBlocks.add(ModBlocks.SIREN);
		
		
		
		ScreenManager.registerFactory(ModContainers.SIMPLE_DRAWER_CONTAINER, SimpleDrawerContainerScreen::new);
		ScreenManager.registerFactory(ModContainers.DOUBLE_DRAWER_CONTAINER, DoubleDrawerContainerScreen::new);
		ModelLoader.addSpecialModel(allCustomModels.OAK_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.SPRUCE_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.BIRCH_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.JUNGLE_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.ACACIA_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.DARK_OAK_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.NETHER_BRICK_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.CRIMSON_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.WARPED_DRAWER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.BOOK_COVER_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.BOOK_PAGES_MODEL.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.EYEBALL_LAMP.getLocation());
		ModelLoader.addSpecialModel(allCustomModels.NEON_BLOCK.getLocation());
		
		cutoutBlocks.forEach((block) -> {
			RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
		});
		
		translucentBlocks.forEach((block) -> {
			RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
		});
		
		
		
		entityRendererManager.register(ModEntities.SEAT_CHAIR, new InvisibleEntityRenderer());
		entityRendererManager.register(ModEntities.SEAT_SOFA, new InvisibleEntityRenderer());
	}
	@SubscribeEvent
	public static void onRegisterParticleFactories(ParticleFactoryRegisterEvent event) {
		ParticleManager particles = Minecraft.getInstance().particles;
		particles.registerFactory(ModParticles.DRIPPING_INK, InkDripParticle.DrippingInkFactory::new);
		particles.registerFactory(ModParticles.FALLING_INK, InkDripParticle.FallingInkFactory::new);
		particles.registerFactory(ModParticles.LANDING_INK, InkDripParticle.LandingInkFactory::new);
	}
	@SubscribeEvent
	public static void onRegisterBlockColors(ColorHandlerEvent.Block color) {
		color.getBlockColors().register((p_210225_0_, p_210225_1_, p_210225_2_, p_210225_3_) -> {
			return ColorableFlowerPot.getColor(p_210225_0_, p_210225_1_, p_210225_2_);
		}, ModBlocks.COLORABLE_FLOWER_POT);
		color.getBlockColors().register((p_210231_0_, p_210231_1_, p_210231_2_, p_210231_3_) -> {
			return RainbowBlock.getColor(p_210231_1_, p_210231_2_);
		}, ModBlocks.RAINBOW_BLOCK);
		color.getBlockColors().register((p_210231_0_, p_210231_1_, p_210231_2_, p_210231_3_) -> {
			return LavaLamp.getColor(p_210231_1_, p_210231_2_);
		}, ModBlocks.LAVA_LAMP);
		color.getBlockColors().register((p_210231_0_, p_210231_1_, p_210231_2_, p_210231_3_) -> {
			return Siren.getMaxColor(p_210231_1_, p_210231_2_);
		}, ModBlocks.SIREN);
		color.getBlockColors().register((p_210231_0_, p_210231_1_, p_210231_2_, p_210231_3_) -> {
			return Candle.getColor(p_210231_0_, p_210231_1_, p_210231_2_);
		}, ModBlocks.CANDLE);
		color.getBlockColors().register((p_210231_0_, p_210231_1_, p_210231_2_, p_210231_3_) -> {
			return ColorableBlock.getColor(p_210231_1_, p_210231_2_);
		},
				ModBlocks.COLORABLE_WOOL, ModBlocks.COLORABLE_PLANKS, ModBlocks.COLORABLE_CONCRETE, ModBlocks.COLORABLE_BRICKS,
				ModBlocks.COLORABLE_CARPET, ModBlocks.COLORABLE_ROUND_CARPET, ModBlocks.COLORABLE_TERRACOTTA,
				ModBlocks.COLORABLE_STONE, ModBlocks.COLORABLE_COBBLESTONE, ModBlocks.COLORABLE_STONE_BRICKS,
				ModBlocks.COLORABLE_GLASS, ModBlocks.COLORABLE_GLASS_PANE,
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
				
				ModBlocks.EYEBALL_LAMP, ModBlocks.NEON_BLOCK, ModBlocks.GLOWING_NEON_BLOCK,
				ModBlocks.INK_BLOCK);
		color.getBlockColors().register((p_210231_0_, p_210231_1_, p_210231_2_, p_210231_3_) -> {
			if (p_210231_3_ == 0)
				return ColorableStraightKitchenCounter.getCounterColor(p_210231_0_, p_210231_1_, p_210231_2_);
			else if (p_210231_3_ == 1)
				return ColorableStraightKitchenCounter.getPlanksColor(p_210231_0_, p_210231_1_, p_210231_2_);
			else
				return 0xffffff;
		}, ModBlocks.COLORABLE_STRAIGHT_KITCHEN_COUNTER, ModBlocks.COLORABLE_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.COLORABLE_OUTER_CORNER_KITCHEN_COUNTER);
	}
	@SubscribeEvent
	public static void onRegisterItemColors(ColorHandlerEvent.Item color) {
		color.getItemColors().register((itemStack, p_210239_1_) -> {
			return (p_210239_1_ > 0 || itemStack.getTag() == null) ? -1 : ((IDyeableArmorItem)itemStack.getItem()).getColor(itemStack);
		}, ModItems.CUSTOM_COLOR_PICKER, ModItems.CUSTOM_LIGHT_COLOR_PICKER);
		color.getItemColors().register((itemStack, p_210239_1_) -> {
			return (p_210239_1_ > 0 || itemStack.getTag() == null) ? -1 : itemStack.getTag().getCompound("BlockEntityTag").getInt("max_color");
		},  ModBlocks.SIREN);
		color.getItemColors().register((itemStack, p_210239_1_) -> {
			return (p_210239_1_ > 0 || itemStack.getTag() == null) ? -1 : itemStack.getTag().getCompound("BlockEntityTag").getInt("color");
		}, ModBlocks.CANDLE, ModBlocks.COLORABLE_WOOL, ModBlocks.COLORABLE_PLANKS,
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
				
				ModBlocks.COLORABLE_FLOWER_POT,

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
				
				ModBlocks.RAINBOW_BLOCK, ModBlocks.LAVA_LAMP, ModBlocks.EYEBALL_LAMP, ModBlocks.NEON_BLOCK, ModBlocks.GLOWING_NEON_BLOCK,
				ModBlocks.INK_BLOCK);
		color.getItemColors().register((itemStack, p_210239_1_) -> {
			return (p_210239_1_ != 0 || itemStack.getTag() == null) ? -1 : itemStack.getTag().getCompound("BlockEntityTag").getInt("counter_color");
		}, ModBlocks.COLORABLE_STRAIGHT_KITCHEN_COUNTER, ModBlocks.COLORABLE_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.COLORABLE_OUTER_CORNER_KITCHEN_COUNTER);
		color.getItemColors().register((itemStack, p_210239_1_) -> {
			return (p_210239_1_ != 1 || itemStack.getTag() == null) ? -1 : itemStack.getTag().getCompound("BlockEntityTag").getInt("planks_color");
		}, ModBlocks.COLORABLE_STRAIGHT_KITCHEN_COUNTER, ModBlocks.COLORABLE_INNER_CORNER_KITCHEN_COUNTER,
				ModBlocks.COLORABLE_OUTER_CORNER_KITCHEN_COUNTER);
	}
}
