package kirothebluefox.moblocks.common.init;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableBlockTile;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableLightBlockTile;
import kirothebluefox.moblocks.common.blocks.decoration.colorableflowerpot.ColorableFlowerPotTile;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.eyeballlamp.EyeballLampTile;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.lavalamp.LavaLampTile;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.neonblock.NeonBlockTile;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.rainbowblock.RainbowBlockTile;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.signaltowerlight.SignalTowerLightTile;
import kirothebluefox.moblocks.common.blocks.decoration.lighting.siren.SirenTile;
import kirothebluefox.moblocks.common.blocks.furnitures.bookshelves.BookshelfTile;
import kirothebluefox.moblocks.common.blocks.furnitures.crates.CrateTile;
import kirothebluefox.moblocks.common.blocks.furnitures.drawers.doubles.DoubleDrawerTile;
import kirothebluefox.moblocks.common.blocks.furnitures.drawers.simples.SimpleDrawerTile;
import kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters.colorable.ColorableKitchenCounterTile;
import kirothebluefox.moblocks.common.blocks.furnitures.lamps.LampTile;
import kirothebluefox.moblocks.common.blocks.furnitures.potionshelves.PotionShelfTile;
import kirothebluefox.moblocks.common.blocks.furnitures.shelves.ShelfTile;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoBlocks.MODID)
public class ModTileEntities {
    public static final BlockEntityType<LampTile> SMALL_LAMP = null;
    public static final BlockEntityType<SimpleDrawerTile> SIMPLE_DRAWER = null;
    public static final BlockEntityType<DoubleDrawerTile> DOUBLE_DRAWER = null;
    public static final BlockEntityType<ShelfTile> SHELF = null;
    public static final BlockEntityType<CrateTile> CRATE = null;
    public static final BlockEntityType<BookshelfTile> SMALL_BOOKSHELF = null;
    public static final BlockEntityType<PotionShelfTile> POTION_SHELF = null;
    public static final BlockEntityType<ColorableBlockTile> COLORABLE_BLOCK = null;
    public static final BlockEntityType<ColorableFlowerPotTile> COLORABLE_FLOWER_POT = null;
    public static final BlockEntityType<ColorableKitchenCounterTile> COLORABLE_KITCHEN_COUNTER = null;
    public static final BlockEntityType<ColorableLightBlockTile> COLORABLE_LIGHT_BLOCK = null;
    public static final BlockEntityType<RainbowBlockTile> RAINBOW_BLOCK = null;
    public static final BlockEntityType<LavaLampTile> LAVA_LAMP = null;
    public static final BlockEntityType<SirenTile> SIREN = null;
    public static final BlockEntityType<SignalTowerLightTile> SIGNAL_TOWER_LIGHT = null;
    public static final BlockEntityType<EyeballLampTile> EYEBALL_LAMP = null;
    public static final BlockEntityType<NeonBlockTile> NEON_BLOCK_TILE = null;
}
