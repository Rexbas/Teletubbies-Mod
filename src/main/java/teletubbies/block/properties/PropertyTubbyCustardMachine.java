package teletubbies.block.properties;

import net.minecraft.util.IStringSerializable;

public enum PropertyTubbyCustardMachine implements IStringSerializable {
	BOTTOM_LEFT(0, "bottom_left"),
	BOTTOM_CENTER(1, "bottom_center"),
	BOTTOM_RIGHT(2, "bottom_right"),
	TOP_LEFT(3, "top_left"),
	TOP_RIGHT(4, "top_right");
	
	private int ID;
	private String name;
	
	private PropertyTubbyCustardMachine(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
}
