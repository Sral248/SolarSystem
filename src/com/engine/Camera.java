package com.engine;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	Vector3f camPos;
	Vector3f center;
	float rotX;
	float rotY;
	float rotZ;
	public static float SPEED = 30f;
	private boolean isGrabbed = true;
	private boolean escapePressed = false;

	public Camera(Vector3f camPos, float rotX, float rotY, float rotZ) {
		this.camPos = camPos;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		center = new Vector3f(0,0,0);
	}

	public boolean isGrabbed() {
		return isGrabbed;
	}

	public void updateCam(Vector2f vec2f,boolean move) {
		if (move) {
			
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			camPos.z -= Math.cos(Math.toRadians(vec2f.y))*SPEED;
			camPos.x += Math.sin(Math.toRadians(vec2f.y))*SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			camPos.z += Math.cos(Math.toRadians(vec2f.y))*SPEED;
			camPos.x -= Math.sin(Math.toRadians(vec2f.y))*SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			camPos.z -= Math.sin(Math.toRadians(vec2f.y))*SPEED;
			camPos.x -= Math.cos(Math.toRadians(vec2f.y))*SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			camPos.z += Math.sin(Math.toRadians(vec2f.y))*SPEED;
			camPos.x += Math.cos(Math.toRadians(vec2f.y))*SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			camPos.y -= SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			camPos.y += SPEED;
		}
		Mouse.setCursorPosition(Display.getWidth()/2, Display.getHeight()/2);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)&&!escapePressed) {
			isGrabbed = !isGrabbed;
			Mouse.setCursorPosition(Display.getWidth()/2, Display.getHeight()/2);
		}
		else if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			escapePressed = false;
		}
		Mouse.setGrabbed(isGrabbed);
		
	}
	public void setCamPosY(float posY) {
		this.camPos.y = posY;
	}

	public void increaseRot(Vector2f vec2f,boolean move) {
		if (move) {
		rotX = vec2f.x;
		rotY = vec2f.y;
		}
	}

	public Vector3f getCamPos() {
		return Vector3f.add(camPos, center, null);
	}

	public float getRotX() {
		return rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public float getRotZ() {
		return rotZ;
	}

	public Vector3f getCenter() {
		return center;
	}

	public void setCenter(Vector3f center) {
		this.center = center;
	}
	

}
