package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;

public class CustomBlockStateProperties {
	public static final EnumProperty<VerticalSlabType> VERTICAL_SLAB_TYPE = EnumProperty.create("type", VerticalSlabType.class);
	public static final BooleanProperty CONNECTED_UP = BooleanProperty.create("connected_up");
	public static final BooleanProperty CONNECTED_DOWN = BooleanProperty.create("connected_down");
	public static final EnumProperty<PillarSize> PILLAR_SIZE = EnumProperty.create("size", PillarSize.class);
	public static final EnumProperty<PillarSide> PILLAR_SIDE = EnumProperty.create("side", PillarSide.class);
	public static final EnumProperty<MultipleNorth> MULTIPLE_NORTH = EnumProperty.create("north", MultipleNorth.class);
	public static final EnumProperty<MultipleSouth> MULTIPLE_SOUTH = EnumProperty.create("south", MultipleSouth.class);
	public static final EnumProperty<MultipleWest> MULTIPLE_WEST = EnumProperty.create("west", MultipleWest.class);
	public static final EnumProperty<MultipleEast> MULTIPLE_EAST = EnumProperty.create("east", MultipleEast.class);
	public static final BooleanProperty CONNECTED_LEFT = BooleanProperty.create("left");
	public static final BooleanProperty CONNECTED_RIGHT = BooleanProperty.create("right");
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	public static final BooleanProperty NORTH_WEST = BooleanProperty.create("north_west");
	public static final BooleanProperty NORTH_EAST = BooleanProperty.create("north_east");
	public static final BooleanProperty SOUTH_WEST = BooleanProperty.create("south_west");
	public static final BooleanProperty SOUTH_EAST = BooleanProperty.create("south_east");
	public static final BooleanProperty ARMREST = BooleanProperty.create("armrest");
	public static final BooleanProperty WALL = BooleanProperty.create("wall");
	public static final BooleanProperty CONTAINS_BLOCK = BooleanProperty.create("contains_block");
	public static final IntegerProperty LIGHT = IntegerProperty.create("light", 0, 2);
}
