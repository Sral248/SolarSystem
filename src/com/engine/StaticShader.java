package com.engine;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;



public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "shader/vertexShader.txt";
	private static final String FRAGMENT_FILE = "shader/fragmentShader.txt";
	public int location_transMatrix;
	public int location_viewMatrix;
	public int location_standartMatrix;
	public int location_camPos;
	public int location_3D;
	public int location_lightPos;
	public int location_lightColor;
	public static final float FOV = 70;
	public static final float NEAR_PLANE = 35f;
	public static final float FAR_PLANE = 900000f;
	public Matrix4f standMat;
	

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttributes(0, "position");
		super.bindAttributes(1, "texCords");
		super.bindAttributes(2, "normVecs");
	}

	@Override
	protected void getUnifromLocation() {

		location_transMatrix = super.getUniformLocation("transMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_standartMatrix = super.getUniformLocation("standartMatrix");
		location_lightColor = super.getUniformLocation("lightColor");
		location_lightPos = super.getUniformLocation("lightPos");
		
		// super.getUniformLocation("location_camPos");
		System.out.println(location_transMatrix);
	}
	

	public Matrix4f getStandMat() {
		return standMat;
	}

	protected void loadTransMatrix(Vector3f bewegen, float rotX, float rotY, float rotZ, float scale) {

		super.loadMatrix4f(location_transMatrix, Tools.createTransformationMatrix(bewegen, rotX, rotY, rotZ, scale));
	}
	protected void loadViewMatrix(Vector3f bewegen, float rotX, float rotY, float rotZ) {

		super.loadMatrix4f(location_viewMatrix, Tools.createViewMatrix(new Vector3f(-bewegen.x,-bewegen.y,-bewegen.z), rotX, rotY, rotZ, 1));
	}
	protected void setView(int bool) {
		super.loadInt(location_3D, bool);
	}
	protected void loadLight(Vector3f lightPos, Vector3f lightColor) {
		super.loadVector3f(location_lightColor, lightColor);
		super.loadVector3f(location_lightPos, lightPos);
	}
	

	protected void loadStandartMatrix() {
		Matrix4f mat4f = new Matrix4f();
		mat4f.setIdentity();
		float aspectRatio = (float)Window.getWidth()/(float)Window.getHeight();
		float y_scale = (float) ((1f/Math.tan(Math.toRadians(FOV/2f))));
		float x_scale = y_scale /aspectRatio;
		float frustum_length = FAR_PLANE - NEAR_PLANE;

		mat4f.m00 = x_scale;
		mat4f.m11 = y_scale;
		mat4f.m22 = -((FAR_PLANE+NEAR_PLANE)/frustum_length);
		mat4f.m23 = -1;
		mat4f.m32 = -((2*NEAR_PLANE*FAR_PLANE)/frustum_length);
		mat4f.m33 = 0;
		standMat = mat4f;
		super.loadMatrix4f(location_standartMatrix, mat4f);
		
		
		
		
	}

}
