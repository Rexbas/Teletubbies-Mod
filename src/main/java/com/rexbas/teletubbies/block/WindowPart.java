package com.rexbas.teletubbies.block;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum WindowPart implements StringRepresentable {
	HORIZONTAL_A("ha"),
	CENTER("c"),
	HORIZONTAL_B("hb"),
	SLANTED_A("sa"),
	VERTICAL("v"),
	SLANTED_B("sb");

	private final String name;
	
	WindowPart(String name) {
		this.name = name;
	}

	@Override
	public @NotNull String getSerializedName() {
		return this.name;
	}
}