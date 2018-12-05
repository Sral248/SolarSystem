package com.engine;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

public class Maus {
	private static float dX;
	private static float dY;
	private static float lastdX = Mouse.getX();
	private static float lastdY = Mouse.getY();
	private static float mouseSpeed = 0.2f;
public static Vector2f getMouseDelta() {
	dX += (Mouse.getX()-lastdX)*mouseSpeed;
	dY += (Mouse.getY()-lastdY)*mouseSpeed;
	if(dY>90)
		dY=90;
	if(dY<-90)
		dY=-90;
	lastdX = Display.getWidth()/2;
	lastdY = Display.getHeight()/2;
	return (new Vector2f(-dY,	dX));

	
}
public static float getdX() {
	return dX;
}
public static float getdY() {
	return dY;
}

}
