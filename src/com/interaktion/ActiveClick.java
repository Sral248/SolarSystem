package com.interaktion;
import org.lwjgl.input.Mouse;

public class ActiveClick {
private int xPos;
private int yPos;


public ActiveClick() {

}


public int getxPos() {
	return xPos;
}


public int getyPos() {
	return yPos;
}


public void tester() {
	if(Mouse.isButtonDown(0)) {
		xPos = Mouse.getX();
		yPos = Mouse.getY();
	}
}
}
