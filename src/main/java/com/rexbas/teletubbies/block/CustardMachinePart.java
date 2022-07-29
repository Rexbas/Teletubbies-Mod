package com.rexbas.teletubbies.block;

import net.minecraft.util.IStringSerializable;

public enum CustardMachinePart implements IStringSerializable {
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