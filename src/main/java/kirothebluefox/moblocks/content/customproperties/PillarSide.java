package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.IStringSerializable;

public enum PillarSide implements IStringSerializable {
	NONE("none"),
	NORTHWEST("northwest"),
	NORTHEAST("northeast"),
	SOUTHWEST("southwest"),
	SOUTHEAST("southeast");

	private final String name;

	private PillarSide(String name) {
	    this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String getString() {
		return getName();
	}
}