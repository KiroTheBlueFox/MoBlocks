package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.StringRepresentable;

public enum PillarSide implements StringRepresentable {
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
	public String getSerializedName() {
		return getName();
	}
}