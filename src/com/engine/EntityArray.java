package com.engine;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class EntityArray {
List<Entity> entityList = new ArrayList<Entity>();
StaticShader shader;
Loader load;
Game game;
Camera cam;
Light light;
String nameTex;
String nameOBJ;
ObjektTextured texOBJ;
public EntityArray(String nameTex,String nameOBJ,StaticShader shader, Loader load, Game game, Camera cam,Light light) {
	this.shader = shader;
	this.load = load;
	this.game = game;
	this.nameTex = nameTex;
	this.nameOBJ = nameOBJ;
	this.cam =cam;
	this.light=light;
	OBJArray objArray = OBJLoaderTex.loadOBJFile(nameOBJ);
	Objekt obj = load.loadToVAO(objArray.getVertecis(), objArray.getTexCords(), objArray.getIndecies(), objArray.getNormVecs());
	texOBJ = new ObjektTextured(obj, load.texLaden(nameTex));
}
public void createEntity(Vector3f pos, float rotX,float rotY,float rotZ,float scale,boolean heightMap,String name_HeightMap) {
	entityList.add(new Entity(texOBJ, pos, rotX, rotY, rotZ, scale,heightMap,name_HeightMap));
}
public void render() {
	for(Entity ent:entityList) {
		game.render(ent, shader, cam, 1, light);
	}
}
public void setPos(int b,Vector3f pos) {
	entityList.get(b).setBewegen(pos);
}
public void increaseRot(int b,Vector3f rot) {
	entityList.get(b).increaseRotation(rot);
}
public void increasePos(int b,Vector3f pos) {
	entityList.get(b).increasePos(pos);
}
public void setPosY(int b, float posY) {
	entityList.get(b).setPosY(posY);
}
public Vector3f getPos(int b) {
	return entityList.get(b).getBewegen();
}
public void moveHeightTerrain(int b,float posX, float posY, Entity terrain) {
	entityList.get(b).moveHeightTerrain(posX, posY, terrain);
}
}
