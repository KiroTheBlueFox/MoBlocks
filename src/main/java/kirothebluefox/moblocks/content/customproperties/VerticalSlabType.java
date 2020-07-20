package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.IStringSerializable;

public enum VerticalSlabType implements IStringSerializable {
	SINGLE("single"),
	DOUBLE("double");

	private final String name;

	private VerticalSlabType(String name) {
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