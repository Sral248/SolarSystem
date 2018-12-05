package com.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector3f;

public class MenuBuilder {
	private BufferedImage menuButton;
	private Game game;
	private Loader load;
	private StaticShader shader;
	private Entity ent;
	private GameLoop gameMain;
	private String[] kontinente;

	public MenuBuilder(String menuButtonName, String menuBild, Game game, Loader load, StaticShader shader,
			GameLoop gameMain) {
		kontinente = new String[] { "Kontinente", "North America", "South America", "Europe", "Africa", "Asia",
				"Australien" };
		try {
			menuButton = ImageIO.read(new File("res/" + menuButtonName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.game = game;
		this.load = load;
		this.shader = shader;
		this.gameMain = gameMain;
		float[] positions = { -1f, 1f, 0f, -1f, -1f, 0f, 1f, -1f, 0f, 1f, 1f, 0f, };
		float[] texCords = { 0f, 0f, 0f, 1f, 1f, 1f, 1f, 0f };
		int[] indices = { 0, 1, 3, 3, 1, 2 };
		ent = new Entity(new ObjektTextured(load.loadToVAO(positions, texCords, indices, new float[] { 0, 0, 0 }),
				load.texLaden(menuBild)), new Vector3f(0, 0, 1), 0, 0, 0, 1f, false, null);
	}

	public void render() {
		game.render(ent, shader, new Camera(new Vector3f(0, 0, 0), 0, 0, 0), 0,
				new Light(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0)));
	}

	public float getColor(int X, int Y) {
		X = (int) (X * (1600f / Display.getWidth()));
		Y = (int) (Y * (900f / Display.getHeight()));
		if (X <= 0 || X >= menuButton.getWidth() || Y <= 0 || Y >= (menuButton.getHeight())) {
			return 0;
		}
		return menuButton.getRGB(X, Y);

	}

	public void landCheck(int X, int Y, Land[] laender, FontRender font) {
		X = (int) (X * (1600f / Display.getWidth()));
		Y = (int) (Y * (900f / Display.getHeight()));
		if (X <= 0 || X >= menuButton.getWidth() || Y <= 0 || Y >= menuButton.getHeight()) {
		} else {
			boolean render = true;
			float Color = menuButton.getRGB(X, Y);
			laender = gameMain.getLaender();
			for (Land land : laender) {
				if (land.getColorCode() == Color) {

					font.renderFont("Name: " + land.getLandName(), 2100, 1100);
					font.renderFont("Kontinent: " + kontinente[land.getLandKontinent()], 2100, 1200);
					if (gameMain.isFirstPlayer()) {
						if (land.getLandBesitzer() == 0) {
							font.renderFont("Besitzer: " + gameMain.getGegnerName(), 2100, 1300);
						} else if (land.getLandBesitzer() == 1) {
							font.renderFont("Besitzer: " + gameMain.getName(), 2100, 1300);
						}
					} else if (!gameMain.isFirstPlayer()) {
						if (land.getLandBesitzer() == 1) {
							font.renderFont("Besitzer: " + gameMain.getGegnerName(), 2100, 1300);
						} else if (land.getLandBesitzer() == 0) {
							font.renderFont("Besitzer: " + gameMain.getName(), 2100, 1300);
						}
					}

					font.renderFont("Truppenanzahl: " + land.getTruppenInLand(), 2100, 1400);
					render = false;
				}
			}

			if (render) {
				font.renderFont("Name: ", 2100, 1100);
				font.renderFont("Kontinent: ", 2100, 1200);
				font.renderFont("Besitzer: ", 2100, 1300);
				font.renderFont("Truppenanzahl: ", 2100, 1400);
			}
		}
	}

	public void buttonCheck(int X, int Y) {
		X = (int) (X * (1600f / Display.getWidth()));
		Y = (int) (Y * (900f / Display.getHeight()));
		if (X <= 0 || X >= menuButton.getWidth() || Y <= 0 || Y >= menuButton.getHeight()) {
		} else {
			float Color = menuButton.getRGB(X, Y);
			if (Color == -1.6252759E7 && Mouse.isButtonDown(0)) {
				gameMain.setCamMove(false);
				gameMain.setScreenNumber(4);

			}
			if (Color == -1.1195904E7 && Mouse.isButtonDown(0)) {
				gameMain.setCamMove(false);
				gameMain.setScreenNumber(2);
				// gameMain.setHEIGHT(800);
				// gameMain.setWIDTH(800);
				// gameMain.setRestart(true);
				// gameMain.stop();
			}
			if (Color == -1.6768456E7 && Mouse.isButtonDown(0)) {
				gameMain.stop();
			}
			if (Color == -1.2182127E7 && Mouse.isButtonDown(0)) {
				gameMain.setCamMove(false);
				gameMain.setScreenNumber(0);

			}
			if (Color == -7315712.0 && Mouse.isButtonDown(0)) {
				gameMain.setHEIGHT(1080);
				gameMain.setWIDTH(1920);
				gameMain.setFullscreen(false);
				gameMain.setRestart(true);
				gameMain.stop();

			}
			if (Color == -1.282816E7 && Mouse.isButtonDown(0)) {
				gameMain.setHEIGHT(900);
				gameMain.setWIDTH(1600);
				gameMain.setFullscreen(false);
				gameMain.setRestart(true);
				gameMain.stop();

			}
			if (Color == -1.4062848E7 && Mouse.isButtonDown(0)) {
				gameMain.setHEIGHT(900);
				gameMain.setWIDTH(1440);
				gameMain.setFullscreen(false);
				gameMain.setRestart(true);
				gameMain.stop();

			}
			if (Color == -1.576576E7 && Mouse.isButtonDown(0)) {
				gameMain.setHEIGHT(720);
				gameMain.setWIDTH(1280);
				gameMain.setFullscreen(false);
				gameMain.setRestart(true);
				gameMain.stop();

			}
			if (Color == -1.383808E7 && Mouse.isButtonDown(0)) {
				gameMain.setHEIGHT(768);
				gameMain.setWIDTH(1024);
				gameMain.setFullscreen(false);
				gameMain.setRestart(true);
				gameMain.stop();

			}

			if (Color == -1.2185344E7 && Mouse.isButtonDown(0)) {
				gameMain.setHEIGHT(480);
				gameMain.setWIDTH(720);
				gameMain.setFullscreen(false);
				gameMain.setRestart(true);
				gameMain.stop();

			}
			if (Color == -1.2006144E7 && Mouse.isButtonDown(0)) {
				gameMain.setFullscreen(true);
				gameMain.setRestart(true);
				gameMain.stop();

			}
			if (Color == -1.3421569E7 && Mouse.isButtonDown(0)) {
				gameMain.setCamMove(true);
				gameMain.setScreenNumber(1);

			}
		}
	}
}
