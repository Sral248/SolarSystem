package com.engine;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class Tools {
	public static Matrix4f createTransformationMatrix(Vector3f bewegen, float rotX,float rotY, float rotZ,float scale) {
		Matrix4f mat4f = new Matrix4f();
		mat4f.setIdentity();
		Matrix4f.translate(bewegen, mat4f, mat4f);
		Matrix4f.rotate((float) Math.toRadians(rotX), new Vector3f(1,0,0),mat4f,mat4f);
		Matrix4f.rotate((float) Math.toRadians(rotY), new Vector3f(0,1,0),mat4f,mat4f);
		Matrix4f.rotate((float) Math.toRadians(rotZ), new Vector3f(0,0,1),mat4f,mat4f);
		
		Matrix4f.scale(new Vector3f(scale,scale,scale),mat4f,mat4f);
		return mat4f;
	}
	public static Matrix4f createViewMatrix(Vector3f bewegen, float rotX,float rotY, float rotZ,float scale) {
		Matrix4f mat4f = new Matrix4f();
		mat4f.setIdentity();
		
		Matrix4f.rotate((float) Math.toRadians(rotX), new Vector3f(1,0,0),mat4f,mat4f);
		Matrix4f.rotate((float) Math.toRadians(rotY), new Vector3f(0,1,0),mat4f,mat4f);
		Matrix4f.rotate((float) Math.toRadians(rotZ), new Vector3f(0,0,1),mat4f,mat4f);
		Matrix4f.translate(bewegen, mat4f, mat4f);
		Matrix4f.scale(new Vector3f(scale,scale,scale),mat4f,mat4f);
		return mat4f;
	}
}
