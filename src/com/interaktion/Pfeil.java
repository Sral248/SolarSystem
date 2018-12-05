package com.interaktion;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.engine.GameLoop;
import com.engine.TileLoader;

public class Pfeil {
GameLoop gameMain;
TileLoader pfeilTile;
Vector2f posAlt;
Vector2f pos;
Vector2f posNorm;
boolean lastClicked;
public Pfeil(GameLoop gameMain) {
	this.gameMain = gameMain;
	pfeilTile = new TileLoader(900, 450, 50, 100, "font", gameMain);
	pos = new Vector2f();
	posAlt = new Vector2f();
	posNorm = new Vector2f(0, 1);
	posAlt.x = 0;
	posAlt.y = 0;
	pos.x = 0;
	pos.y = 0;
	lastClicked = false;
}
public void render() {
	if (!Mouse.isButtonDown(0)) {
		lastClicked = false;
	}
	if (!lastClicked&&Mouse.isButtonDown(0)) {
		posAlt.x =Mouse.getX();
		posAlt.y =Mouse.getY();
		pos.x =Mouse.getX();
		pos.y =Mouse.getY();
		lastClicked = true;
	}
	else if (lastClicked&&Mouse.isButtonDown(0)) {
		pos.x =Mouse.getX();
		pos.y =Mouse.getY();
		lastClicked = true;
		Vector2f sub = new Vector2f();
		Vector2f.sub(posAlt, pos, sub);
		double rot = 0;
		if (pos.x-posAlt.x<0) {
			rot+=180;
			rot+=180-Math.toDegrees(Vector2f.angle(sub, posNorm));
		}
		else {
			rot = Math.toDegrees(Vector2f.angle(sub, posNorm));
		}
		pfeilTile.rotEntZ((float)rot);
		pfeilTile.render();
	}
	
}
}
