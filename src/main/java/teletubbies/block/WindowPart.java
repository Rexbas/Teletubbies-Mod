package teletubbies.block;

import net.minecraft.util.IStringSerializable;

public enum WindowPart implements IStringSerializable {
	HORIZONTAL_A("ha"),
	CENTER("c"),
	HORIZONTAL_B("hb"),
	SLANTED_A("sa"),
	VERTICAL("v"),
	SLANTED_B("sb");

	private final String name;
	
	private WindowPart(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
