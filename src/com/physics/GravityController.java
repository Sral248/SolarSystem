package com.physics;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.engine.Camera;
import com.engine.Entity;
import com.engine.Game;
import com.engine.Light;
import com.engine.Loader;
import com.engine.OBJArray;
import com.engine.OBJLoader;
import com.engine.ObjektTextured;
import com.engine.StaticShader;
import com.engine.StaticShaderNoLight;

public class GravityController {
	public final static double GRAVITYCONSTANT = 6.673 * Math.pow(10, -4);
	private static List<GravitySphere> sphereObjects = new ArrayList<GravitySphere>();
	public static List<Vector3f> tail = new ArrayList<Vector3f>();

	public static double getForce(GravitySphere sphere1, GravitySphere sphere2) {
		return GRAVITYCONSTANT * ((sphere1.getfMass() * sphere2.getfMass())
				/ Math.pow((Vector3f.sub(sphere1.getPos(), sphere2.getPos(), new Vector3f()).length()), 2));
	}

	public static void updateSpeed(GravitySphere sphere1, GravitySphere sphere2) {
		double force = getForce(sphere1, sphere2);
		Vector3f norm = Vector3f.sub(sphere2.getPos(), sphere1.getPos(), new Vector3f()).normalise(new Vector3f());
		sphere1.update(new Vector3f((float) (norm.getX() * (force / sphere1.getfMass())),
				(float) (norm.getY() * (force / sphere1.getfMass())),
				(float) (norm.getZ() * (force / sphere1.getfMass()))));

	}

	public static void updateAllObjects(int speed) {
		for (int i = 0; i < speed; i++) {

			for (GravitySphere gravitySphere1 : sphereObjects) {
				for (GravitySphere gravitySphere2 : sphereObjects) {
					if (gravitySphere1 != gravitySphere2) {
						GravityController.updateSpeed(gravitySphere1, gravitySphere2);
					}
				}
			}
		}
	}

	public static void addOrbit(GravitySphere sphere) {
		tail.add(sphere.getPos());
	}

	public static void addOrbit(GravitySphere sphere, Vector3f center) {
		tail.add(Vector3f.sub(sphere.getPos(), center, null));
	}

	public static void renderTail(Game game, StaticShaderNoLight shader, Camera cam, Light light, Entity ent,
			float scale, int length) {
		for (Vector3f pos : tail) {
			game.render(ent, shader, cam, light, pos, scale);
		}
		while (tail.size() > length) {
			tail.remove(0);
		}
	}

	public static void renderTail(Game game, StaticShaderNoLight shader, Camera cam, Light light, Entity ent,
			float scale, int length, Vector3f center) {
		for (Vector3f pos : tail) {
			game.render(ent, shader, cam, light, Vector3f.add(pos, center, null), scale);
		}
		while (tail.size() > length) {
			tail.remove(0);
		}
	}

	public static void addGravitySphere(GravitySphere sphere) {
		sphereObjects.add(sphere);
	}
}
