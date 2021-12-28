package kirothebluefox.moblocks.content.customproperties;

import net.minecraft.util.StringRepresentable;

public enum MultipleSouth implements StringRepresentable {
    FALSE("false"),
    TRUE("true"),
    LONG("long");

    private final String name;

    MultipleSouth(String name) {
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
