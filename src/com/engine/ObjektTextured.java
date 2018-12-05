package com.engine;

public class ObjektTextured {
Objekt obj;
int textureID;
public ObjektTextured(Objekt obj,int texturedID) {
	this.obj = obj;
	this.textureID = texturedID;
}
public Objekt getObj() {
	return obj;
}
public int getTextureID() {
	return textureID;
}
}
