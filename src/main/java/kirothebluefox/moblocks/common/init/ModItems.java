package kirothebluefox.moblocks.common.init;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blocks.furnitures.lamps.ShadeItem;
import kirothebluefox.moblocks.common.items.BlockColorer;
import kirothebluefox.moblocks.common.items.customcolorpicker.CustomColorPicker;
import kirothebluefox.moblocks.common.items.customcolorpicker.CustomLightColorPicker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoBlocks.MODID);

    /* Lamp Shades */
    /* Square Cones */
    public static final RegistryObject<Item> WHITE_SQUARE_CONE_SHADE = ITEMS.register("white_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_SQUARE_CONE_SHADE = ITEMS.register("orange_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_SQUARE_CONE_SHADE = ITEMS.register("magenta_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_SQUARE_CONE_SHADE = ITEMS.register("light_blue_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_SQUARE_CONE_SHADE = ITEMS.register("yellow_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_SQUARE_CONE_SHADE = ITEMS.register("lime_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_SQUARE_CONE_SHADE = ITEMS.register("pink_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_SQUARE_CONE_SHADE = ITEMS.register("gray_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_SQUARE_CONE_SHADE = ITEMS.register("light_gray_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_SQUARE_CONE_SHADE = ITEMS.register("cyan_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_SQUARE_CONE_SHADE = ITEMS.register("purple_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_SQUARE_CONE_SHADE = ITEMS.register("blue_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_SQUARE_CONE_SHADE = ITEMS.register("brown_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_SQUARE_CONE_SHADE = ITEMS.register("green_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_SQUARE_CONE_SHADE = ITEMS.register("red_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.RED, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_SQUARE_CONE_SHADE = ITEMS.register("black_square_cone_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "square_cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Cylinders */
    public static final RegistryObject<Item> WHITE_CYLINDER_SHADE = ITEMS.register("white_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_CYLINDER_SHADE = ITEMS.register("orange_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_CYLINDER_SHADE = ITEMS.register("magenta_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_CYLINDER_SHADE = ITEMS.register("light_blue_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_CYLINDER_SHADE = ITEMS.register("yellow_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_CYLINDER_SHADE = ITEMS.register("lime_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_CYLINDER_SHADE = ITEMS.register("pink_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_CYLINDER_SHADE = ITEMS.register("gray_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_CYLINDER_SHADE = ITEMS.register("light_gray_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_CYLINDER_SHADE = ITEMS.register("cyan_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_CYLINDER_SHADE = ITEMS.register("purple_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_CYLINDER_SHADE = ITEMS.register("blue_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_CYLINDER_SHADE = ITEMS.register("brown_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_CYLINDER_SHADE = ITEMS.register("green_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_CYLINDER_SHADE = ITEMS.register("red_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.RED, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_CYLINDER_SHADE = ITEMS.register("black_cylinder_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "cylinder", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Cube */
    public static final RegistryObject<Item> WHITE_CUBE_SHADE = ITEMS.register("white_cube_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_CUBE_SHADE = ITEMS.register("orange_cube_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_CUBE_SHADE = ITEMS.register("magenta_cube_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_CUBE_SHADE = ITEMS.register("light_blue_cube_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_CUBE_SHADE = ITEMS.register("yellow_cube_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_CUBE_SHADE = ITEMS.register("lime_cube_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_CUBE_SHADE = ITEMS.register("pink_cube_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_CUBE_SHADE = ITEMS.register("gray_cube_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_CUBE_SHADE = ITEMS.register("light_gray_cube_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_CUBE_SHADE = ITEMS.register("cyan_cube_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_CUBE_SHADE = ITEMS.register("purple_cube_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_CUBE_SHADE = ITEMS.register("blue_cube_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_CUBE_SHADE = ITEMS.register("brown_cube_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_CUBE_SHADE = ITEMS.register("green_cube_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_CUBE_SHADE = ITEMS.register("red_cube_shade", () -> new ShadeItem(ShadeItem.Color.RED, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_CUBE_SHADE = ITEMS.register("black_cube_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Cone */
    public static final RegistryObject<Item> WHITE_CONE_SHADE = ITEMS.register("white_cone_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_CONE_SHADE = ITEMS.register("orange_cone_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_CONE_SHADE = ITEMS.register("magenta_cone_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_CONE_SHADE = ITEMS.register("light_blue_cone_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_CONE_SHADE = ITEMS.register("yellow_cone_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_CONE_SHADE = ITEMS.register("lime_cone_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_CONE_SHADE = ITEMS.register("pink_cone_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_CONE_SHADE = ITEMS.register("gray_cone_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_CONE_SHADE = ITEMS.register("light_gray_cone_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_CONE_SHADE = ITEMS.register("cyan_cone_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_CONE_SHADE = ITEMS.register("purple_cone_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_CONE_SHADE = ITEMS.register("blue_cone_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_CONE_SHADE = ITEMS.register("brown_cone_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_CONE_SHADE = ITEMS.register("green_cone_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_CONE_SHADE = ITEMS.register("red_cone_shade", () -> new ShadeItem(ShadeItem.Color.RED, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_CONE_SHADE = ITEMS.register("black_cone_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "cone", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Tube Cube */
    public static final RegistryObject<Item> WHITE_TUBE_CUBE_SHADE = ITEMS.register("white_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_TUBE_CUBE_SHADE = ITEMS.register("orange_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_TUBE_CUBE_SHADE = ITEMS.register("magenta_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_TUBE_CUBE_SHADE = ITEMS.register("light_blue_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_TUBE_CUBE_SHADE = ITEMS.register("yellow_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_TUBE_CUBE_SHADE = ITEMS.register("lime_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_TUBE_CUBE_SHADE = ITEMS.register("pink_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_TUBE_CUBE_SHADE = ITEMS.register("gray_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_TUBE_CUBE_SHADE = ITEMS.register("light_gray_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_TUBE_CUBE_SHADE = ITEMS.register("cyan_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_TUBE_CUBE_SHADE = ITEMS.register("purple_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_TUBE_CUBE_SHADE = ITEMS.register("blue_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_TUBE_CUBE_SHADE = ITEMS.register("brown_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_TUBE_CUBE_SHADE = ITEMS.register("green_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_TUBE_CUBE_SHADE = ITEMS.register("red_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.RED, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_TUBE_CUBE_SHADE = ITEMS.register("black_tube_cube_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "tube_cube", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Lozenge Tube */
    public static final RegistryObject<Item> WHITE_TUBE_LOZENGE_SHADE = ITEMS.register("white_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_TUBE_LOZENGE_SHADE = ITEMS.register("orange_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_TUBE_LOZENGE_SHADE = ITEMS.register("magenta_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_TUBE_LOZENGE_SHADE = ITEMS.register("light_blue_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_TUBE_LOZENGE_SHADE = ITEMS.register("yellow_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_TUBE_LOZENGE_SHADE = ITEMS.register("lime_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_TUBE_LOZENGE_SHADE = ITEMS.register("pink_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_TUBE_LOZENGE_SHADE = ITEMS.register("gray_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_TUBE_LOZENGE_SHADE = ITEMS.register("light_gray_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_TUBE_LOZENGE_SHADE = ITEMS.register("cyan_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_TUBE_LOZENGE_SHADE = ITEMS.register("purple_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_TUBE_LOZENGE_SHADE = ITEMS.register("blue_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_TUBE_LOZENGE_SHADE = ITEMS.register("brown_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_TUBE_LOZENGE_SHADE = ITEMS.register("green_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_TUBE_LOZENGE_SHADE = ITEMS.register("red_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.RED, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_TUBE_LOZENGE_SHADE = ITEMS.register("black_tube_lozenge_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "tube_lozenge", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Pyramid */
    public static final RegistryObject<Item> WHITE_PYRAMID_SHADE = ITEMS.register("white_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_PYRAMID_SHADE = ITEMS.register("orange_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_PYRAMID_SHADE = ITEMS.register("magenta_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_PYRAMID_SHADE = ITEMS.register("light_blue_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_PYRAMID_SHADE = ITEMS.register("yellow_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_PYRAMID_SHADE = ITEMS.register("lime_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_PYRAMID_SHADE = ITEMS.register("pink_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_PYRAMID_SHADE = ITEMS.register("gray_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_PYRAMID_SHADE = ITEMS.register("light_gray_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_PYRAMID_SHADE = ITEMS.register("cyan_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_PYRAMID_SHADE = ITEMS.register("purple_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_PYRAMID_SHADE = ITEMS.register("blue_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_PYRAMID_SHADE = ITEMS.register("brown_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_PYRAMID_SHADE = ITEMS.register("green_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_PYRAMID_SHADE = ITEMS.register("red_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.RED, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_PYRAMID_SHADE = ITEMS.register("black_pyramid_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "pyramid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Sphere */
    public static final RegistryObject<Item> WHITE_SPHERE_SHADE = ITEMS.register("white_sphere_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_SPHERE_SHADE = ITEMS.register("orange_sphere_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_SPHERE_SHADE = ITEMS.register("magenta_sphere_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_SPHERE_SHADE = ITEMS.register("light_blue_sphere_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_SPHERE_SHADE = ITEMS.register("yellow_sphere_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_SPHERE_SHADE = ITEMS.register("lime_sphere_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_SPHERE_SHADE = ITEMS.register("pink_sphere_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_SPHERE_SHADE = ITEMS.register("gray_sphere_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_SPHERE_SHADE = ITEMS.register("light_gray_sphere_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_SPHERE_SHADE = ITEMS.register("cyan_sphere_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_SPHERE_SHADE = ITEMS.register("purple_sphere_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_SPHERE_SHADE = ITEMS.register("blue_sphere_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_SPHERE_SHADE = ITEMS.register("brown_sphere_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_SPHERE_SHADE = ITEMS.register("green_sphere_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_SPHERE_SHADE = ITEMS.register("red_sphere_shade", () -> new ShadeItem(ShadeItem.Color.RED, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_SPHERE_SHADE = ITEMS.register("black_sphere_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "sphere", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Tube Cuboid */
    public static final RegistryObject<Item> WHITE_TUBE_CUBOID_SHADE = ITEMS.register("white_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.WHITE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> ORANGE_TUBE_CUBOID_SHADE = ITEMS.register("orange_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.ORANGE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> MAGENTA_TUBE_CUBOID_SHADE = ITEMS.register("magenta_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.MAGENTA, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_BLUE_TUBE_CUBOID_SHADE = ITEMS.register("light_blue_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_BLUE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> YELLOW_TUBE_CUBOID_SHADE = ITEMS.register("yellow_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.YELLOW, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIME_TUBE_CUBOID_SHADE = ITEMS.register("lime_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.LIME, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PINK_TUBE_CUBOID_SHADE = ITEMS.register("pink_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.PINK, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GRAY_TUBE_CUBOID_SHADE = ITEMS.register("gray_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.GRAY, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> LIGHT_GRAY_TUBE_CUBOID_SHADE = ITEMS.register("light_gray_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.LIGHT_GRAY, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> CYAN_TUBE_CUBOID_SHADE = ITEMS.register("cyan_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.CYAN, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> PURPLE_TUBE_CUBOID_SHADE = ITEMS.register("purple_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.PURPLE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLUE_TUBE_CUBOID_SHADE = ITEMS.register("blue_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.BLUE, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BROWN_TUBE_CUBOID_SHADE = ITEMS.register("brown_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.BROWN, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> GREEN_TUBE_CUBOID_SHADE = ITEMS.register("green_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.GREEN, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> RED_TUBE_CUBOID_SHADE = ITEMS.register("red_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.RED, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));
    public static final RegistryObject<Item> BLACK_TUBE_CUBOID_SHADE = ITEMS.register("black_tube_cuboid_shade", () -> new ShadeItem(ShadeItem.Color.BLACK, "tube_cuboid", (new Item.Properties()).tab(MoBlocks.furnitures_creative_tab)));

    /* Others */
    public static final RegistryObject<Item> CUSTOM_COLOR_PICKER = ITEMS.register("custom_color_picker", () -> new CustomColorPicker((new Item.Properties()).tab(MoBlocks.decoration_creative_tab).stacksTo(1)));
    public static final RegistryObject<Item> CUSTOM_LIGHT_COLOR_PICKER = ITEMS.register("custom_light_color_picker", () -> new CustomLightColorPicker((new Item.Properties()).tab(MoBlocks.decoration_creative_tab).stacksTo(1)));
    public static final RegistryObject<Item> BLOCK_COLORER = ITEMS.register("block_colorer", () -> new BlockColorer((new Item.Properties()).tab(MoBlocks.decoration_creative_tab).stacksTo(1)));

}
