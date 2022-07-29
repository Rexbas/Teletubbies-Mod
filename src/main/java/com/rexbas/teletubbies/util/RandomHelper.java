package com.rexbas.teletubbies.util;

public class RandomHelper {

	public static double getRandomNumber (double min, double max) {
	    return Math.random() * (max - min) + min;
	}
}
