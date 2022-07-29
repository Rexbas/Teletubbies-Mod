package com.rexbas.teletubbies.util;

public class Converter {

	public static long SecondsToTicks(double seconds) {
		return Math.round(seconds * 20);
	}
}
