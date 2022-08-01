package com.rexbas.teletubbies.block;

import net.minecraft.util.StringRepresentable;

public enum WindowPart implements StringRepresentable {
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
	public String getSerializedName() {
		return this.name;
	}
}