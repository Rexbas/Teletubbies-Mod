package com.rexbas.teletubbies.block;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum CustardMachinePart implements StringRepresentable {
	BASE("base"),
	BIGBASE("bigbase"),
	SMALLBASE("smallbase"),
	BIG("big"),
	SMALL("small");

	private final String name;
	
	CustardMachinePart(String name) {
		this.name = name;
	}

	@Override
	public @NotNull String getSerializedName() {
		return this.name;
	}
}