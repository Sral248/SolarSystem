package com.physics;

import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector3f;

import com.engine.Entity;

public class GravitySphere {
public float fMass;
public Entity eBody;
private Vector3f speed;

public GravitySphere(float fMass, Entity eBody) {
	this.fMass = fMass;
	this.eBody = eBody;
	speed = new Vector3f(0,0,0);
}
public float getfMass() {
	return fMass;
}
public Entity geteBody() {
	return eBody;
}
public Vector3f getPos() {
	return eBody.getBewegen();
}
public void update(Vector3f move) {
	eBody.setBewegen(Vector3f.add(getPos(), Vector3f.add(speed, move, speed),new Vector3f()));
}
public Vector3f getSpeed() {
	return speed;
}
public void setSpeed(Vector3f speed) {
	this.speed = speed;
}

}
