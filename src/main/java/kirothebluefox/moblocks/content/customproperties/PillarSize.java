package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.StringRepresentable;

public enum PillarSize implements StringRepresentable {
	SMALL("small"),
	BIG("big");

	private final String name;

	private PillarSize(String name) {
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