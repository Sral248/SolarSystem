package com.test;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.engine.Camera;
import com.engine.Entity;
import com.engine.Game;
import com.engine.GameLoop;
import com.engine.Light;
import com.engine.Loader;
import com.engine.Maus;
import com.engine.OBJArray;
import com.engine.OBJLoader;
import com.engine.OBJLoaderTex;
import com.engine.ObjektTextured;
import com.engine.StaticShader;
import com.engine.StaticShaderNoLight;
import com.physics.GravityController;
import com.physics.GravitySphere;

public class Main extends GameLoop {
	public StaticShader shader;
	public StaticShaderNoLight shaderNoLight;
	public Game game;
	public Camera cam;
	public Light light;
	public Loader load;
	public Entity ent;
	public Entity sun;
	public Entity earth;
	public Entity moon;
	public Entity whiteBall;
	public Entity skybox;
	public GravitySphere gsEarth;
	public GravitySphere gsSun;
	public GravitySphere gsMoon;
	public float n;

	public Main() {
		super(1600, 900, "test");
		super.start();
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

	@Override
	public void init() {
		shader = new StaticShader();
		shaderNoLight = new StaticShaderNoLight();
		cam = new Camera(new Vector3f(0, 0, 0), 0, 0, 0);
		light = new Light(new Vector3f(0, 0, 0), new Vector3f(3, 3, 3));
		game = new Game(shader, shaderNoLight);
		load = new Loader();
		ent = new Entity(
				new ObjektTextured(
						load.loadToVAO(
								new float[] { 1.000000f, -1.000000f, -1.000000f, 1.000000f, -1.000000f, 1.000000f,
										-1.000000f, -1.000000f, 1.000000f, -1.000000f, -1.000000f, -1.000000f,
										1.000000f, 1.000000f, -0.999999f, 0.999999f, 1.000000f, 1.000001f, -1.000000f,
										1.000000f, 1.000000f, -1.000000f, 1.000000f, -1.000000f },
								new float[] {0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0},
								new int[] { },
								new float[] { 0, 0, 0 }),
						load.texLaden("Moon/moon")),
				new Vector3f(0, 0, 0), 0, 0, 0, 1);

		OBJArray objArray = OBJLoaderTex.loadOBJFile("Sun/sun");
		sun = new Entity(
				new ObjektTextured(load.loadToVAO(objArray.getVertecis(), objArray.getTexCords(),
						objArray.getIndecies(), objArray.getNormVecs()), load.texLaden("Sun/sun")),
				new Vector3f(0, 0, 0), 0, 0, 0, 5);
		objArray = OBJLoaderTex.loadOBJFile("Earth/earth");
		earth = new Entity(
				new ObjektTextured(load.loadToVAO(objArray.getVertecis(), objArray.getTexCords(),
						objArray.getIndecies(), objArray.getNormVecs()), load.texLaden("Earth/earth")),
				new Vector3f(10000, 0, 0), 0, 180, 0, 0.5f);
		objArray = OBJLoaderTex.loadOBJFile("Moon/moon");
		moon = new Entity(
				new ObjektTextured(load.loadToVAO(objArray.getVertecis(), objArray.getTexCords(),
						objArray.getIndecies(), objArray.getNormVecs()), load.texLaden("Moon/moon")),
				new Vector3f(10500, 0, 0), 0, 0, 180, 0.15f);
		objArray = OBJLoaderTex.loadOBJFile("SkyBox/skybox");
		skybox = new Entity(
				new ObjektTextured(load.loadToVAO(objArray.getVertecis(), objArray.getTexCords(),
						objArray.getIndecies(), objArray.getNormVecs()), load.texLaden("SkyBox/skybox")),
				new Vector3f(0, 0, 0), 0, 0, 0, 2000);
		objArray = OBJLoaderTex.loadOBJFile("white/white");
		whiteBall = new Entity(
				new ObjektTextured(load.loadToVAO(objArray.getVertecis(), objArray.getTexCords(),
						objArray.getIndecies(), objArray.getNormVecs()), load.texLaden("white/white")),
				new Vector3f(0, 0, 0), 0, 0, 0, 1);
		n = 0;
		gsEarth = new GravitySphere(2343000, earth);
		gsSun = new GravitySphere(2030200000, sun);
		gsMoon = new GravitySphere(2430, moon);
		gsEarth.setSpeed(new Vector3f(0,0,8f));
		gsMoon.setSpeed(new Vector3f(0.1f,0,6.65f));
		gsSun.setSpeed(new Vector3f(0,4f,0));
		GravityController.addGravitySphere(gsEarth);
		GravityController.addGravitySphere(gsMoon);
		GravityController.addGravitySphere(gsSun);
		
	}

	@Override
	public void input() {

	}

	@Override
	public void update(double dDelta) {
		cam.updateCam(Maus.getMouseDelta(), true);
		cam.increaseRot(Maus.getMouseDelta(), true);
		GravityController.updateAllObjects(5);
		GravityController.addOrbit(gsMoon);
		GravityController.addOrbit(gsEarth);
		GravityController.addOrbit(gsSun);
		System.out.println(Vector3f.sub(gsMoon.getPos(), gsEarth.getPos(), new Vector3f()).length());
		light.setLightPos(gsSun.getPos());
		cam.setCenter(gsSun.getPos());
	}

	@Override
	public void render() {
		//earth.setRotY(n*100);
		//moon.setRotX(-n/2);
		//sun.setRotY(n/4);
		//earth.setBewegen(new Vector3f((float)(4000*Math.cos(n/500f)),0f,(float)(-4000*Math.sin(n/500f))));
		//moon.setBewegen(new Vector3f((float)(4000*Math.cos(n/500f)),(float)(600f*Math.cos(n/50f)),(float)(-4000*Math.sin(n/500f)-(float)(600*Math.sin(n/50f)))));
		game.prepare();
		game.render(moon, shader, cam, light);
		
		game.render(sun, shaderNoLight, cam, light);
		
		game.render(earth, shaderNoLight, cam, light);
		n++;
		game.render(ent, shaderNoLight, cam, light);

		GravityController.renderTail(game, shaderNoLight, cam, light, whiteBall,0.05f, 3000);

		game.prepareCullOther();
		//game.render(skybox, shaderNoLight, cam, light); 
		

	}

	@Override
	public void cleanUp() {

	}

}
