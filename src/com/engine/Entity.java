package com.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Entity {
	Vector3f bewegen;
	float rotX;
	float rotY;
	float rotZ;
	float scale;
	float moveSpeed;
	float wegLänge;
	float posX;
	float posY;
	int steps;
	float zielZehntelHöhe;
	Vector2f zielZehntel;
	Vector2f richtung;
	ObjektTextured objTex;
	BufferedImage heightMapImg;
	List<Float> reihe = new ArrayList<Float>();
	List<Vector3f> coords = new ArrayList<Vector3f>();
	List<Vector2f> change = new ArrayList<Vector2f>();

	public Entity(ObjektTextured objTex, Vector3f bewegen, float rotX, float rotY, float rotZ, float scale,
			String name_HeightMap) {
		this.bewegen = bewegen;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.objTex = objTex;
		posX = bewegen.x;
		posY = bewegen.z;
		moveSpeed = 1;
		steps = 10;
		wegLänge = 0;
		for (int i = 0; i < objTex.getObj().getVertecies().length; i += 3) {
			coords.add(new Vector3f(objTex.getObj().getVertecies()[i], objTex.getObj().getVertecies()[i + 1],
					objTex.getObj().getVertecies()[i + 2]));

		}

		try {
			heightMapImg = ImageIO.read(new File("res/" + name_HeightMap + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Entity(ObjektTextured objTex, Vector3f bewegen, float rotX, float rotY, float rotZ, float scale) {
		this.bewegen = bewegen;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.objTex = objTex;
		posX = bewegen.x;
		posY = bewegen.z;
		moveSpeed = 1;
		steps = 10;
		wegLänge = 0;
		for (int i = 0; i < objTex.getObj().getVertecies().length; i += 3) {
			coords.add(new Vector3f(objTex.getObj().getVertecies()[i], objTex.getObj().getVertecies()[i + 1],
					objTex.getObj().getVertecies()[i + 2]));

		}

	}

	public ObjektTextured getObjTex() {
		return objTex;
	}

	public Objekt getObj() {
		return objTex.getObj();
	}

	public Vector3f getBewegen() {
		return bewegen;
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

	public float getScale() {
		return scale;
	}

	public void increaseRotation(Vector3f rot) {
		this.rotX += rot.x;
		this.rotY += rot.y;
		this.rotZ += rot.z;
	}

	public void increasePos(Vector3f pos) {
		this.bewegen.x += pos.x;
		this.bewegen.y += pos.y;
		this.bewegen.z += pos.z;
	}

	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	public void setPosY(float posY) {
		this.bewegen.y = posY;
	}

	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	public void setBewegen(Vector3f bewegen) {
		this.bewegen = bewegen;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public float getHeight(float posX, float posY) {

		if (posX < 0 || posX > 360 || posY < 0 || posY > 360)
			return 5;
		System.out.println("X: " + posX * 10 + " Y: " + posY * 10);
		float height = heightMapImg.getRGB((int) posX * 10, (int) posY * 10);
		height += (255 * 255 * 255) / 2;
		height /= 255 * 255 * 255;
		height++;
		return height * 53.4f;
	}

	public float getHeightTest(float posX, float posY) {
		float range = 0.8f;
		if (posX < -360 || posX > 360 || posY < -360 || posY > 360)
			return 5;
		for (Vector3f coord : coords) {
			if (coord.x * scale - posX < range && coord.x * scale - posX > -range && coord.z * scale - posY < range
					&& coord.z * scale - posY > -range) {
				return (coord.y * scale);
			}
			// System.out.println(coord.x*scale-posX);
		}
		return 0;
	}

	public void moveHeightTerrain(float posXIn, float posYIn, Entity terrain) {

		if (wegLänge <= 0 || posXIn != posX) {
			posX = posXIn;
			posY = posYIn;
			richtung = new Vector2f(posX - bewegen.x, posY - bewegen.z);
			wegLänge = richtung.length();
			richtung.normalise();
			// System.out.println(wegLänge);
		}
		if (wegLänge > 1) {
			if (steps < 10) {
				steps++;
				bewegen.x += richtung.x / 10f;
				bewegen.z += richtung.y / 10f;
				bewegen.y += zielZehntelHöhe / 10f;

			} else {
				System.out.println("lul");
				wegLänge--;
				steps = 0;
				zielZehntel = new Vector2f(bewegen.x + richtung.x, bewegen.z + richtung.y);
				bewegen.y = terrain.getHeightTest(bewegen.x, bewegen.z);
				zielZehntelHöhe = terrain.getHeightTest((zielZehntel.x), zielZehntel.y) - bewegen.y;

			}
			System.out.println(terrain.getHeightTest(bewegen.x, bewegen.z));
			// System.out.println(steps);
			// System.out.println(bewegen.x);
		}

	}
}
