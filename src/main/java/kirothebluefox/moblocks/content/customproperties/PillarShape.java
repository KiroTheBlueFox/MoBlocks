package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.IStringSerializable;

public enum PillarShape implements IStringSerializable {
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
	public String getString() {
		return getName();
	}
}