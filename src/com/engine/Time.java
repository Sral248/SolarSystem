package com.engine;

public class Time {
	public static double delta;
	public static final long SECOND = 1000000000L;

	public static void setDelta(double delta) {
		Time.delta = delta;
	}

	public static long getTime() {
		return System.nanoTime();
	}

	public static double getDelta() {
		return delta;
	}
}
