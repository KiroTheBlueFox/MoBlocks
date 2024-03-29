package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.StringRepresentable;

public enum VerticalSlabType implements StringRepresentable {
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
	public String getSerializedName() {
		return getName();
	}
}