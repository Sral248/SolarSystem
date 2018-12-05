package com.engine;

public class OBJArray {
	float[] vertecis;
	float[] texCords;
	float[] normVecs;
	int[] indecies;
	public OBJArray(float[] vertecis, float[] texCords, float[] normVecs, int[] indecies) {
		this.vertecis = vertecis;
		this.texCords = texCords;
		this.normVecs = normVecs;
		this.indecies = indecies;
	}
	public float[] getVertecis() {
		return vertecis;
	}
	public float[] getTexCords() {
		return texCords;
	}
	public float[] getNormVecs() {
		return normVecs;
	}
	public int[] getIndecies() {
		return indecies;
	}
	
}
