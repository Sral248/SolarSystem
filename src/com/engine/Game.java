package com.engine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import java.awt.Color;

import org.lwjgl.opengl.GL13;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL11.*;

public class Game {
	public Game(StaticShader shader, StaticShaderNoLight shaderNoLight) {
		shaderNoLight.start();
		shaderNoLight.loadStandartMatrix();
		shaderNoLight.stop();
		shader.start();
		shader.loadStandartMatrix();
		shader.stop();

		

		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glFrontFace(GL_CCW);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_BLEND);
		glEnable(GL_NORMALIZE);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glDepthFunc(GL_LESS);
		glDepthRange(0.3f, 1);
		glDepthMask(true);
		glClearColor(0, 0, 0, 0);
		glClearDepth(1);

	}

	public void prepare() {
		glCullFace(GL_BACK);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	}
	public void prepareCullOther() {
		glCullFace(GL_FRONT);
		
	}


	public void render(Entity ent, StaticShader shader, Camera cam, Light light) {

		ObjektTextured obj = ent.getObjTex();
		glBindVertexArray(obj.getObj().getVaoID());
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, obj.getTextureID());
		
		shader.start();
		shader.loadLight(light.getLightPos(), light.getLightColor());
		shader.loadViewMatrix(cam.getCamPos(), cam.getRotX(), cam.getRotY(), cam.getRotZ());
		shader.loadTransMatrix(ent.getBewegen(), ent.getRotX(), ent.getRotY(), ent.getRotZ(), ent.getScale());
		glDrawElements(GL_TRIANGLES, obj.getObj().getVertexAnzahl(), GL_UNSIGNED_INT, 0);
		shader.stop();
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
	}
	public void render(Entity ent, StaticShaderNoLight shader, Camera cam, Light light, Vector3f pos, float scale) {

		ObjektTextured obj = ent.getObjTex();
		glBindVertexArray(obj.getObj().getVaoID());
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, obj.getTextureID());
		
		shader.start();
		shader.loadLight(light.getLightPos(), light.getLightColor());
		shader.loadViewMatrix(cam.getCamPos(), cam.getRotX(), cam.getRotY(), cam.getRotZ());
		shader.loadTransMatrix(pos, ent.getRotX(), ent.getRotY(), ent.getRotZ(), scale);
		glDrawElements(GL_TRIANGLES, obj.getObj().getVertexAnzahl(), GL_UNSIGNED_INT, 0);
		shader.stop();
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
	}

	public void render(Entity ent, StaticShaderNoLight shader, Camera cam, Light light) {

		ObjektTextured obj = ent.getObjTex();
		glBindVertexArray(obj.getObj().getVaoID());
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, obj.getTextureID());
		shader.start();
		shader.loadLight(light.getLightPos(), light.getLightColor());
		shader.loadViewMatrix(cam.getCamPos(), cam.getRotX(), cam.getRotY(), cam.getRotZ());
		shader.loadTransMatrix(ent.getBewegen(), ent.getRotX(), ent.getRotY(), ent.getRotZ(), ent.getScale());
		glDrawElements(GL_TRIANGLES, obj.getObj().getVertexAnzahl(), GL_UNSIGNED_INT, 0);
		shader.stop();
		glDisableVertexAttribArray(2);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
	}

	}
