package com.engine;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

public class BuchstabenTileLoader {
	Loader load;
	Entity ent;
	float Coord1;
	float Coord2;
	float Coord3;
	float Coord4;
	float texCoord1;
	float texCoord2;
	float texCoord3;
	float texCoord4;
	GameLoop mainGame;
	public BuchstabenTileLoader(int posX,int posY,float texPosX,float texPosY,int breite,int hoehe,String bild,float size,GameLoop mainGame) {
		this.mainGame = mainGame;
		load = mainGame.getLoad();
		posY = (int) (900 -posY -hoehe*size);
		Coord1 = (posX/800f)-1f;
		Coord2 = ((posX+breite*size)/800f)-1f;
		Coord3 = (posY/450f)-1f;
		Coord4 = ((posY+hoehe*size)/450f)-1f;
		texCoord1 = (texPosX/512f);
		texCoord2 = ((texPosX+breite)/512f);
		texCoord3 = (texPosY/512f);
		texCoord4 = ((texPosY+hoehe)/512f);
		
		float[] positions = {
				Coord1, Coord4, 0f,
				Coord1, Coord3, 0f,
				Coord2, Coord3, 0f,
				Coord2, Coord4, 0f,
	    };
	    float[] texCords= {
	    		texCoord1,texCoord3,
	    		texCoord1,texCoord4,
	    		texCoord2,texCoord4,
	    		texCoord2,texCoord3
	    };
	    int[] indices= {
	    		0,1,3,
	    		3,1,2
	    };
	    System.out.println("Coord1: "+Coord1+" Coord2: "+Coord2);
	    System.out.println("Coord3: "+Coord3+" Coord4: "+Coord4);
	    System.out.println("Coord1: "+breite+" Coord2: "+hoehe);
	    ent = new Entity(new ObjektTextured(load.loadToVAO(positions, texCords, indices, new float[] {0,0,0}), load.texLaden(bild)), new Vector3f(0,0,0), 0, 0, 0, 1f,false,null);
	    System.out.println(ent);
	}
	public void render(float x, float y) {
		ent.setBewegen(new Vector3f(x,y,-1));
		mainGame.getGame().render(ent, mainGame.getShader(), new Camera(new Vector3f(0,0,0), 0, 0, 0), 0, new Light(new Vector3f(0,0,0), new Vector3f(x,y,0)));	}
}
