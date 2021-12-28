package kirothebluefox.moblocks.common.setup;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blockentities.*;
import kirothebluefox.moblocks.common.blocks.furnitures.SeatChair;
import kirothebluefox.moblocks.common.blocks.furnitures.SeatSofa;
import kirothebluefox.moblocks.common.gui.DoubleDrawerContainer;
import kirothebluefox.moblocks.common.gui.SimpleDrawerContainer;
import kirothebluefox.moblocks.common.init.ModBlocks;
import kirothebluefox.moblocks.common.init.ModItems;
import kirothebluefox.moblocks.common.init.ModParticles;
import kirothebluefox.moblocks.common.network.MoBlocksPacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;

@EventBusSubscriber(modid = MoBlocks.MODID, bus = Bus.MOD)
public class RegistrationHandler {

    public static void init(IEventBus bus) {
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void onRegisterTileEntity(RegistryEvent.Register<BlockEntityType<?>> TE) {
        TE.getRegistry().register(BlockEntityType.Builder.of(LampTile::new, ModBlocks.OAK_SMALL_LAMP.get(), ModBlocks.SPRUCE_SMALL_LAMP.get(), ModBlocks.BIRCH_SMALL_LAMP.get(), ModBlocks.JUNGLE_SMALL_LAMP.get(), ModBlocks.ACACIA_SMALL_LAMP.get(), ModBlocks.DARK_OAK_SMALL_LAMP.get(), ModBlocks.NETHER_BRICK_SMALL_LAMP.get(), ModBlocks.CRIMSON_SMALL_LAMP.get(), ModBlocks.WARPED_SMALL_LAMP.get()).build(null).setRegistryName(MoBlocks.MODID, "small_lamp"));
        TE.getRegistry().register(BlockEntityType.Builder.of(SimpleDrawerTile::new, ModBlocks.OAK_SIMPLE_DRAWER.get(), ModBlocks.SPRUCE_SIMPLE_DRAWER.get(), ModBlocks.BIRCH_SIMPLE_DRAWER.get(), ModBlocks.JUNGLE_SIMPLE_DRAWER.get(), ModBlocks.ACACIA_SIMPLE_DRAWER.get(), ModBlocks.DARK_OAK_SIMPLE_DRAWER.get(), ModBlocks.NETHER_BRICK_SIMPLE_DRAWER.get(), ModBlocks.CRIMSON_SIMPLE_DRAWER.get(), ModBlocks.WARPED_SIMPLE_DRAWER.get()).build(null).setRegistryName(MoBlocks.MODID, "simple_drawer"));
        TE.getRegistry().register(BlockEntityType.Builder.of(DoubleDrawerTile::new, ModBlocks.OAK_DOUBLE_DRAWER.get(), ModBlocks.SPRUCE_DOUBLE_DRAWER.get(), ModBlocks.BIRCH_DOUBLE_DRAWER.get(), ModBlocks.JUNGLE_DOUBLE_DRAWER.get(), ModBlocks.ACACIA_DOUBLE_DRAWER.get(), ModBlocks.DARK_OAK_DOUBLE_DRAWER.get(), ModBlocks.NETHER_BRICK_DOUBLE_DRAWER.get(), ModBlocks.CRIMSON_DOUBLE_DRAWER.get(), ModBlocks.WARPED_DOUBLE_DRAWER.get()).build(null).setRegistryName(MoBlocks.MODID, "double_drawer"));
        TE.getRegistry().register(BlockEntityType.Builder.of(ShelfTile::new, ModBlocks.OAK_SHELF.get(),ModBlocks.SPRUCE_SHELF.get(),ModBlocks.BIRCH_SHELF.get(),ModBlocks.JUNGLE_SHELF.get(),ModBlocks.ACACIA_SHELF.get(),ModBlocks.DARK_OAK_SHELF.get(),ModBlocks.NETHER_BRICK_SHELF.get(),ModBlocks.CRIMSON_SHELF.get(),ModBlocks.WARPED_SHELF.get()).build(null).setRegistryName(MoBlocks.MODID, "shelf"));
        TE.getRegistry().register(BlockEntityType.Builder.of(CrateTile::new, ModBlocks.OAK_CRATE.get(),ModBlocks.SPRUCE_CRATE.get(),ModBlocks.BIRCH_CRATE.get(),ModBlocks.JUNGLE_CRATE.get(),ModBlocks.ACACIA_CRATE.get(),ModBlocks.DARK_OAK_CRATE.get(),ModBlocks.NETHER_BRICK_CRATE.get(),ModBlocks.CRIMSON_CRATE.get(),ModBlocks.WARPED_CRATE.get()).build(null).setRegistryName(MoBlocks.MODID, "crate"));
        TE.getRegistry().register(BlockEntityType.Builder.of(BookshelfTile::new, ModBlocks.OAK_BOOKSHELF.get(),ModBlocks.SPRUCE_BOOKSHELF.get(),ModBlocks.BIRCH_BOOKSHELF.get(),ModBlocks.JUNGLE_BOOKSHELF.get(),ModBlocks.ACACIA_BOOKSHELF.get(),ModBlocks.DARK_OAK_BOOKSHELF.get(),ModBlocks.NETHER_BRICK_BOOKSHELF.get(),ModBlocks.CRIMSON_BOOKSHELF.get(),ModBlocks.WARPED_BOOKSHELF.get()).build(null).setRegistryName(MoBlocks.MODID, "small_bookshelf"));
        TE.getRegistry().register(BlockEntityType.Builder.of(PotionShelfTile::new, ModBlocks.OAK_POTION_SHELF.get(), ModBlocks.SPRUCE_POTION_SHELF.get(), ModBlocks.BIRCH_POTION_SHELF.get(), ModBlocks.JUNGLE_POTION_SHELF.get(), ModBlocks.ACACIA_POTION_SHELF.get(), ModBlocks.DARK_OAK_POTION_SHELF.get(),ModBlocks.NETHER_BRICK_POTION_SHELF.get(),ModBlocks.CRIMSON_POTION_SHELF.get(),ModBlocks.WARPED_POTION_SHELF.get()).build(null).setRegistryName(MoBlocks.MODID, "potion_shelf"));
        TE.getRegistry().register(BlockEntityType.Builder.of(ColorableFlowerPotTile::new, ModBlocks.COLORABLE_FLOWER_POT.get()).build(null).setRegistryName(MoBlocks.MODID, "colorable_flower_pot"));
        TE.getRegistry().register(BlockEntityType.Builder.of(ColorableLightBlockTile::new, ModBlocks.CANDLE.get()).build(null).setRegistryName(MoBlocks.MODID, "colorable_light_block"));
        TE.getRegistry().register(BlockEntityType.Builder.of(RainbowBlockTile::new, ModBlocks.RAINBOW_BLOCK.get()).build(null).setRegistryName(MoBlocks.MODID, "rainbow_block"));
        TE.getRegistry().register(BlockEntityType.Builder.of(LavaLampTile::new, ModBlocks.LAVA_LAMP.get()).build(null).setRegistryName(MoBlocks.MODID, "lava_lamp"));
        TE.getRegistry().register(BlockEntityType.Builder.of(SirenTile::new, ModBlocks.SIREN.get()).build(null).setRegistryName(MoBlocks.MODID, "siren"));
        TE.getRegistry().register(BlockEntityType.Builder.of(SignalTowerLightTile::new, ModBlocks.SIGNAL_TOWER_LIGHT.get()).build(null).setRegistryName(MoBlocks.MODID, "signal_tower_light"));
        TE.getRegistry().register(BlockEntityType.Builder.of(EyeballLampTile::new, ModBlocks.EYEBALL_LAMP.get()).build(null).setRegistryName(MoBlocks.MODID, "eyeball_lamp"));

        TE.getRegistry().register(BlockEntityType.Builder.of(ColorableBlockTile::new,
                        ModBlocks.COLORABLE_WOOL.get(), ModBlocks.COLORABLE_PLANKS.get(),
                        ModBlocks.COLORABLE_CONCRETE.get(), ModBlocks.COLORABLE_BRICKS.get(),
                        ModBlocks.COLORABLE_TERRACOTTA.get(), ModBlocks.COLORABLE_STONE_BRICKS.get(),
                        ModBlocks.COLORABLE_STONE.get(), ModBlocks.COLORABLE_COBBLESTONE.get(),

                        ModBlocks.COLORABLE_CARPET.get(), ModBlocks.COLORABLE_ROUND_CARPET.get(),
                        ModBlocks.COLORABLE_SOFA.get(), ModBlocks.COLORABLE_TABLE.get(), ModBlocks.COLORABLE_CHAIR.get(),
                        ModBlocks.COLORABLE_PLANK_COFFEE_TABLE.get(), ModBlocks.COLORABLE_TERRACOTTA_COFFEE_TABLE.get(),

                        ModBlocks.COLORABLE_PLANK_SLAB.get(), ModBlocks.COLORABLE_BRICK_SLAB.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_SLAB.get(), ModBlocks.COLORABLE_STONE_SLAB.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_SLAB.get(),

                        ModBlocks.COLORABLE_PLANK_STAIRS.get(), ModBlocks.COLORABLE_BRICK_STAIRS.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_STAIRS.get(), ModBlocks.COLORABLE_STONE_STAIRS.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_STAIRS.get(),

                        ModBlocks.COLORABLE_PLANK_VERTICAL_SLAB.get(), ModBlocks.COLORABLE_BRICK_VERTICAL_SLAB.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_VERTICAL_SLAB.get(), ModBlocks.COLORABLE_STONE_VERTICAL_SLAB.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_VERTICAL_SLAB.get(),

                        ModBlocks.COLORABLE_PLANK_VERTICAL_STAIRS.get(), ModBlocks.COLORABLE_BRICK_VERTICAL_STAIRS.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_VERTICAL_STAIRS.get(), ModBlocks.COLORABLE_STONE_VERTICAL_STAIRS.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_VERTICAL_STAIRS.get(),

                        ModBlocks.COLORABLE_GLASS.get(), ModBlocks.COLORABLE_GLASS_PANE.get(),

                        ModBlocks.COLORABLE_PLANK_ARCH.get(), ModBlocks.COLORABLE_PLANK_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_PLANK_LOWER_SMALL_ARCH.get(), ModBlocks.COLORABLE_PLANK_LOWER_SMALL_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_PLANK_PILLAR.get(), ModBlocks.COLORABLE_PLANK_POST.get(), ModBlocks.COLORABLE_PLANK_RAMP.get(),
                        ModBlocks.COLORABLE_PLANK_TRIANGLE_RAMP.get(), ModBlocks.COLORABLE_PLANK_UPPER_SMALL_ARCH.get(),
                        ModBlocks.COLORABLE_PLANK_UPPER_SMALL_INVERTED_ARCH.get(),

                        ModBlocks.COLORABLE_BRICK_ARCH.get(), ModBlocks.COLORABLE_BRICK_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_BRICK_LOWER_SMALL_ARCH.get(), ModBlocks.COLORABLE_BRICK_LOWER_SMALL_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_BRICK_PILLAR.get(), ModBlocks.COLORABLE_BRICK_POST.get(), ModBlocks.COLORABLE_BRICK_RAMP.get(),
                        ModBlocks.COLORABLE_BRICK_TRIANGLE_RAMP.get(), ModBlocks.COLORABLE_BRICK_UPPER_SMALL_ARCH.get(),
                        ModBlocks.COLORABLE_BRICK_UPPER_SMALL_INVERTED_ARCH.get(),

                        ModBlocks.COLORABLE_STONE_BRICK_ARCH.get(), ModBlocks.COLORABLE_STONE_BRICK_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_LOWER_SMALL_ARCH.get(), ModBlocks.COLORABLE_STONE_BRICK_LOWER_SMALL_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_PILLAR.get(), ModBlocks.COLORABLE_STONE_BRICK_POST.get(), ModBlocks.COLORABLE_STONE_BRICK_RAMP.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_TRIANGLE_RAMP.get(), ModBlocks.COLORABLE_STONE_BRICK_UPPER_SMALL_ARCH.get(),
                        ModBlocks.COLORABLE_STONE_BRICK_UPPER_SMALL_INVERTED_ARCH.get(),

                        ModBlocks.COLORABLE_STONE_ARCH.get(), ModBlocks.COLORABLE_STONE_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_STONE_LOWER_SMALL_ARCH.get(), ModBlocks.COLORABLE_STONE_LOWER_SMALL_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_STONE_PILLAR.get(), ModBlocks.COLORABLE_STONE_POST.get(), ModBlocks.COLORABLE_STONE_RAMP.get(),
                        ModBlocks.COLORABLE_STONE_TRIANGLE_RAMP.get(), ModBlocks.COLORABLE_STONE_UPPER_SMALL_ARCH.get(),
                        ModBlocks.COLORABLE_STONE_UPPER_SMALL_INVERTED_ARCH.get(),

                        ModBlocks.COLORABLE_COBBLESTONE_ARCH.get(), ModBlocks.COLORABLE_COBBLESTONE_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_LOWER_SMALL_ARCH.get(), ModBlocks.COLORABLE_COBBLESTONE_LOWER_SMALL_INVERTED_ARCH.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_PILLAR.get(), ModBlocks.COLORABLE_COBBLESTONE_POST.get(), ModBlocks.COLORABLE_COBBLESTONE_RAMP.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_TRIANGLE_RAMP.get(), ModBlocks.COLORABLE_COBBLESTONE_UPPER_SMALL_ARCH.get(),
                        ModBlocks.COLORABLE_COBBLESTONE_UPPER_SMALL_INVERTED_ARCH.get(),

                        ModBlocks.OAK_STRAIGHT_KITCHEN_COUNTER.get(), ModBlocks.BIRCH_STRAIGHT_KITCHEN_COUNTER.get(),
                        ModBlocks.SPRUCE_STRAIGHT_KITCHEN_COUNTER.get(), ModBlocks.JUNGLE_STRAIGHT_KITCHEN_COUNTER.get(),
                        ModBlocks.ACACIA_STRAIGHT_KITCHEN_COUNTER.get(), ModBlocks.DARK_OAK_STRAIGHT_KITCHEN_COUNTER.get(),
                        ModBlocks.WARPED_STRAIGHT_KITCHEN_COUNTER.get(), ModBlocks.CRIMSON_STRAIGHT_KITCHEN_COUNTER.get(),

                        ModBlocks.OAK_INNER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.BIRCH_INNER_CORNER_KITCHEN_COUNTER.get(),
                        ModBlocks.SPRUCE_INNER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.JUNGLE_INNER_CORNER_KITCHEN_COUNTER.get(),
                        ModBlocks.ACACIA_INNER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.DARK_OAK_INNER_CORNER_KITCHEN_COUNTER.get(),
                        ModBlocks.WARPED_INNER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.CRIMSON_INNER_CORNER_KITCHEN_COUNTER.get(),

                        ModBlocks.OAK_OUTER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.BIRCH_OUTER_CORNER_KITCHEN_COUNTER.get(),
                        ModBlocks.SPRUCE_OUTER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.JUNGLE_OUTER_CORNER_KITCHEN_COUNTER.get(),
                        ModBlocks.ACACIA_OUTER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.DARK_OAK_OUTER_CORNER_KITCHEN_COUNTER.get(),
                        ModBlocks.WARPED_OUTER_CORNER_KITCHEN_COUNTER.get(), ModBlocks.CRIMSON_OUTER_CORNER_KITCHEN_COUNTER.get(),

                        ModBlocks.INK_BLOCK.get())
                .build(null).setRegistryName(MoBlocks.MODID, "colorable_block"));

        TE.getRegistry().register(BlockEntityType.Builder.of(ColorableKitchenCounterTile::new,
                ModBlocks.COLORABLE_STRAIGHT_KITCHEN_COUNTER.get(), ModBlocks.COLORABLE_INNER_CORNER_KITCHEN_COUNTER.get(),
                ModBlocks.COLORABLE_OUTER_CORNER_KITCHEN_COUNTER.get()).build(null).setRegistryName(MoBlocks.MODID, "colorable_kitchen_counter"));

        TE.getRegistry().register(BlockEntityType.Builder.of(NeonBlockTile::new,
                ModBlocks.NEON_BLOCK.get(), ModBlocks.GLOWING_NEON_BLOCK.get()).build(null).setRegistryName(MoBlocks.MODID, "neon_block_tile"));
    }

    @SubscribeEvent
    public static void onRegisterContainer(RegistryEvent.Register<MenuType<?>> container) {
        container.getRegistry().register(IForgeMenuType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new SimpleDrawerContainer(windowId, pos, inv);
        }).setRegistryName(MoBlocks.MODID, "simple_drawer_container"));
        container.getRegistry().register(IForgeMenuType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new DoubleDrawerContainer(windowId, pos, inv);
        }).setRegistryName(MoBlocks.MODID, "double_drawer_container"));
    }

    @SubscribeEvent
    public static void onRegisterEntity(RegistryEvent.Register<EntityType<?>> entity) {
        entity.getRegistry().register(EntityType.Builder.<SeatChair>of(SeatChair::new, MobCategory.MISC).fireImmune().noSummon().sized(0.0F, 0.0F).build("seat_chair").setRegistryName(MoBlocks.MODID, "seat_chair"));
        entity.getRegistry().register(EntityType.Builder.<SeatSofa>of(SeatSofa::new, MobCategory.MISC).fireImmune().noSummon().sized(0.0F, 0.0F).build("seat_sofa").setRegistryName(MoBlocks.MODID, "seat_sofa"));
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
