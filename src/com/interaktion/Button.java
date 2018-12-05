package com.interaktion;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import com.engine.BuchstabenTileLoader;
import com.engine.FontRender;
import com.engine.GameLoop;
import com.engine.TileLoader;

public class Button {
	private int xPos;
	private int yPos;
	private int length;
	private int height;
	private String name;
	private TileLoader field;
	private GameLoop mainGame;
	private FontRender font;
	private String aufschrift;

	public Button(String name, int xPos, int yPos, int length, int height, String bild, String aufschrift, String font,
			GameLoop mainGame) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = length;
		this.height = height;
		this.mainGame = mainGame;
		this.aufschrift = aufschrift;
		field = new TileLoader(xPos, yPos, length, height, bild, this.mainGame);
		this.font = new FontRender(font, 1, mainGame);

	}

	public void render() {
		field.render();
		font.renderFont(aufschrift, xPos * 2, yPos * 2 + (height / 2) - 20);
		if (Mouse.getX() / mainGame.getDisplayWidth() > xPos / 1600f
				&& Mouse.getX() / mainGame.getDisplayWidth() < (xPos + length) / 1600f
				&& (mainGame.getDisplayHeight() - Mouse.getY()) / mainGame.getDisplayHeight() > yPos / 900f
				&& (mainGame.getDisplayHeight() - Mouse.getY()) / mainGame.getDisplayHeight() < (yPos + height) / 900f
				&& Mouse.isButtonDown(0)) {
			List<String> buttons = ButtonManager.getButtons();
			buttons.add(name);
			ButtonManager.setButtons(buttons);
		}
	}
}
