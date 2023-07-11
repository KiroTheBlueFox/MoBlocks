package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.StringRepresentable;

public enum PillarShape implements StringRepresentable {
	BOTTOM("bottom"),
	MIDDLE("middle"),
	TOP("top");

	private final String name;

	private PillarShape(String name) {
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