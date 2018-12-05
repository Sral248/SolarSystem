package com.engine;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

public class TileLoader {
	Loader load;
	Entity ent;
	float Coord1;
	float Coord2;
	float Coord3;
	float Coord4;
	GameLoop mainGame;

	public TileLoader(int posX, int posY, int breite, int hoehe, String bild, GameLoop mainGame) {
		this.mainGame = mainGame;
		load = mainGame.getLoad();
		posY = 900 - posY - hoehe;
		Coord1 = (posX / 800f) - 1f;
		Coord2 = ((posX + breite) / 800f) - 1f;
		Coord3 = (posY / 450f) - 1f;
		Coord4 = ((posY + hoehe) / 450f) - 1f;
		float[] positions = { Coord1, Coord4, -1f, Coord1, Coord3, -1f, Coord2, Coord3, -1f, Coord2, Coord4, -1f, };
		float[] texCords = { 0f, 0f, 0f, 1f, 1f, 1f, 1f, 0f };
		int[] indices = { 0, 1, 3, 3, 1, 2 };
		System.out.println("Coord1: " + Coord1 + " Coord2: " + Coord2);
		System.out.println("Coord3: " + Coord3 + " Coord4: " + Coord4);
		System.out.println("Coord1: " + breite + " Coord2: " + hoehe);
		ent = new Entity(new ObjektTextured(load.loadToVAO(positions, texCords, indices, new float[] { 0, 0, 0 }),
				load.texLaden(bild)), new Vector3f(0, 0, 0), 0, 0, 0, 1f, false, null);
		System.out.println(ent);
	}

	public void render() {

		mainGame.getGame().render(ent, mainGame.getShader(), new Camera(new Vector3f(0, 0, 0), 0, 0, 0), 0,
				new Light(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0)));
	}
	public void rotEntZ(float rotZ) {
		ent.setRotZ(rotZ);
	}
	public void setPos(Vector3f vec3f) {
		ent.setBewegen(vec3f);
	}

}
