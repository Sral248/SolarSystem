package com.engine;
import org.lwjgl.util.vector.Vector3f;

public class Light {
private Vector3f lightPos;
private Vector3f lightColor;
public Light(Vector3f lightPos, Vector3f lightColor) {
	this.lightPos = lightPos;
	this.lightColor = lightColor;
}
public Vector3f getLightPos() {
	return lightPos;
}
public Vector3f getLightColor() {
	return lightColor;
}
public void setLightPos(Vector3f lightPos) {
	this.lightPos = lightPos;
}

}
