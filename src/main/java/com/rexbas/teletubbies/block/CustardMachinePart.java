package com.rexbas.teletubbies.block;

import net.minecraft.util.StringRepresentable;

public enum CustardMachinePart implements StringRepresentable {
	BASE("base"),
	BIGBASE("bigbase"),
	SMALLBASE("smallbase"),
	BIG("big"),
	SMALL("small");

	private final String name;
	
	private CustardMachinePart(String name) {
		this.name = name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}