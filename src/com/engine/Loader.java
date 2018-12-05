package com.engine;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Loader {
	
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();
	private List<Integer> texs = new ArrayList<Integer>();

	private int createVAO() {
		int vaoID = GL30.glGenVertexArrays();
		vaos.add(vaoID);
		GL30.glBindVertexArray(vaoID);
		return vaoID;
	}

	public Objekt loadToVAO(float[] positions,float[] texCords,int[] indices,float[] normVecs) {
		int vaoID = createVAO();
		storeDataInAttributeList(0,3,positions);
		storeDataInAttributeList(1,2,texCords);
		storeDataInAttributeList(2, 3, normVecs);
		bindIndicesBuffer(indices);
		unbindVAO();
		return new Objekt(vaoID,indices.length,positions);
	}

	private void unbindVAO() {
		GL30.glBindVertexArray(0);
		
	}

	private void storeDataInAttributeList(int attributeNummer,int size, float[] data) {
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeNummer, size, GL11.GL_FLOAT, false, 0,0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
	}
	private FloatBuffer storeDataInFloatBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	public int texLaden(String name) {
		Texture tex = null;
		try {
			tex = TextureLoader.getTexture("PNG", new FileInputStream("res/"+name+".png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texs.add(tex.getTextureID());
		return tex.getTextureID();
	}
	private void bindIndicesBuffer(int[] indices) {
		int vboID= GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		IntBuffer buffer = storeDatainIntBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	private IntBuffer storeDatainIntBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	public void cleanUp() {
		for(int a:vaos){
			GL30.glDeleteVertexArrays(a);
		}
		for(int b:vbos){
			GL15.glDeleteBuffers(b);
		}
		for(int t:texs){
			GL11.glDeleteTextures(t);
		}
		
	}
}
