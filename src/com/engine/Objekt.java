package com.engine;

public class Objekt {
	private int vaoID;
	private int vertexAnzahl;
	float[] vertecies;
	public int getVaoID() {
		return vaoID;
	}
	public int getVertexAnzahl() {
		return vertexAnzahl;
	}
	public void setVertexAnzahl(int vertexAnzahl) {
		this.vertexAnzahl = vertexAnzahl;
	}
	public Objekt(int vaoID,int vertexAnzahl,float[] vertecies) {
		this.vaoID =vaoID;
		this.vertexAnzahl = vertexAnzahl;
		this.vertecies = vertecies;
	}
	public float[] getVertecies() {
		return vertecies;
	}
}
