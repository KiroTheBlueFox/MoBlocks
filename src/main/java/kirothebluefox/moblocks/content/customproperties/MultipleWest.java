package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.IStringSerializable;

public enum MultipleWest implements IStringSerializable {
	FALSE("false"),
	TRUE("true"),
	LONG("long");

	private final String name;

	private MultipleWest(String name) {
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