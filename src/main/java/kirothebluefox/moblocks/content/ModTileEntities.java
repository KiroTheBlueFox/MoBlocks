package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlockTile;
import kirothebluefox.moblocks.content.decoration.colorableflowerpot.ColorableFlowerPotTile;
import kirothebluefox.moblocks.content.furnitures.bookshelves.BookshelfTile;
import kirothebluefox.moblocks.content.furnitures.crates.CrateTile;
import kirothebluefox.moblocks.content.furnitures.drawers.doubles.DoubleDrawerTile;
import kirothebluefox.moblocks.content.furnitures.drawers.simples.SimpleDrawerTile;
import kirothebluefox.moblocks.content.furnitures.lamps.LampTile;
import kirothebluefox.moblocks.content.furnitures.shelves.ShelfTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoBlocks.MODID)
public class ModTileEntities {
	public static final TileEntityType<LampTile> SMALL_LAMP = null;
	public static final TileEntityType<SimpleDrawerTile> SIMPLE_DRAWER = null;
	public static final TileEntityType<DoubleDrawerTile> DOUBLE_DRAWER = null;
	public static final TileEntityType<ShelfTile> SHELF = null;
	public static final TileEntityType<CrateTile> CRATE = null;
	public static final TileEntityType<BookshelfTile> SMALL_BOOKSHELF = null;
	public static final TileEntityType<ColorableBlockTile> COLORABLE_BLOCK = null;
	public static final TileEntityType<ColorableFlowerPotTile> COLORABLE_FLOWER_POT = null;
}
