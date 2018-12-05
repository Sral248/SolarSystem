package com.engine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL11.*;


public abstract class ShaderProgram {

	private int programID;
	private int vertexShaderID;
	private int fragmentShaderID;
	private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);
	

	
	public ShaderProgram(String vertexShader,String fragmentShader) {
		vertexShaderID = loadShader(vertexShader, GL_VERTEX_SHADER);
		fragmentShaderID = loadShader(fragmentShader, GL_FRAGMENT_SHADER);
		programID =glCreateProgram();
		glAttachShader(programID, vertexShaderID);
		glAttachShader(programID, fragmentShaderID);
		bindAttributes();
		glLinkProgram(programID);
		glValidateProgram(programID);
		getUnifromLocation();
	}
	
	public void start() {
		glUseProgram(programID);
	}
	public void stop() {
		glUseProgram(0);
	}
	public void cleanUp() {
		stop();
		glDetachShader(programID, fragmentShaderID);
		glDetachShader(programID, vertexShaderID);
		glDeleteShader(fragmentShaderID);
		glDeleteShader(vertexShaderID);
		glDeleteProgram(programID);
	}
	
	protected abstract void bindAttributes();
	
	protected void bindAttributes(int attribute,String variableName) {
		glBindAttribLocation(programID, attribute, variableName);
	}
	protected abstract void getUnifromLocation();
	
	protected int getUniformLocation(String name) {
		return glGetUniformLocation(programID, name);
	}
	protected void loadFloat(int location, float value) {
		glUniform1f(location, value);
	}
	protected void loadInt(int location, int value) {
		glUniform1i(location, value);
	}
	protected void loadVector3f(int location, Vector3f vec3f) {
		glUniform3f(location, vec3f.x, vec3f.y, vec3f.z);
	}
	protected void loadMatrix4f(int location, Matrix4f mat4f) {
		mat4f.store(matrixBuffer);
		matrixBuffer.flip();
		glUniformMatrix4(location, false, matrixBuffer);
	}
	
	private static int loadShader(String file, int type) {
		StringBuilder shaderSource = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Shader nicht geladen!");
			System.exit(-1);
		}
		int shaderID = glCreateShader(type);
		glShaderSource(shaderID, shaderSource);
		glCompileShader(shaderID);
		if (glGetShaderi(shaderID, GL_COMPILE_STATUS)==GL_FALSE) {
			System.out.println(glGetShaderInfoLog(shaderID, 500));
			System.err.println("Shader nicht compeliert!");
			System.exit(-1);
		}
		return shaderID;
	}
}
