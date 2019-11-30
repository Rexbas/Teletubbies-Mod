package teletubbies.block.properties;

import net.minecraft.util.IStringSerializable;

public enum PropertyPosition implements IStringSerializable {
	BOTTOM(0, "bottom"),
	TOP(1, "top");
	
	private int ID;
	private String name;
	
	private PropertyPosition(int ID, String name) {
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
