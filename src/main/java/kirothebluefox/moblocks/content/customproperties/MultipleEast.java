package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.IStringSerializable;

public enum MultipleEast implements IStringSerializable {
	FALSE("false"),
	TRUE("true"),
	LONG("long");

	private final String name;

	private MultipleEast(String name) {
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