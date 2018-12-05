package com.interaktion;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.lwjgl.input.Keyboard;

import com.engine.FontRender;
import com.engine.GameLoop;
import com.engine.TileLoader;

public class TextFeld {
	private int xPos;
	private int yPos;
	private int length;
	private int height;
	private boolean isFocused;
	private ActiveClick focus;
	private TileLoader field;
	private GameLoop mainGame;
	private StringBuilder text;
	private boolean[] pressedKeys = new boolean[223];
	private boolean[] lastPressedKeys = new boolean[223];
	private FontRender font;

	public TextFeld(int xPos, int yPos, int length, int height, ActiveClick focus, String font, GameLoop mainGame) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = length;
		this.height = height;
		this.focus = focus;
		isFocused = false;
		this.mainGame = mainGame;
		text = new StringBuilder();
		field = new TileLoader(xPos, yPos, length, height, "TextField", this.mainGame);
		for (boolean b : lastPressedKeys) {
			b = false;
		}
		this.font = new FontRender(font, 1, mainGame);
	}

	public String getText() {
		return text.toString();
	}
	public void setText(String s) {
		text = new StringBuilder(s);
	}

	public TextFeld(int xPos, int yPos, int length, int height, ActiveClick focus, String font, GameLoop mainGame,
			String bild) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.length = length;
		this.height = height;
		this.focus = focus;
		isFocused = false;
		this.mainGame = mainGame;
		text = new StringBuilder();
		field = new TileLoader(xPos, yPos, length, height, bild, this.mainGame);
		for (boolean b : lastPressedKeys) {
			b = false;
		}
		this.font = new FontRender(font, 1, mainGame);
	}

	public void render(boolean render) {
		if (render) {
			field.render();
			font.renderFontTextBox(text.toString(), (xPos), (yPos), (length), height);
			if (focus.getxPos() / mainGame.getDisplayWidth() > xPos / 1600f
					&& focus.getxPos() / mainGame.getDisplayWidth() < (xPos + length) / 1600f
					&& (mainGame.getDisplayHeight() - focus.getyPos()) / mainGame.getDisplayHeight() > yPos/900f
					&& (mainGame.getDisplayHeight() - focus.getyPos())/mainGame.getDisplayHeight() < (yPos + height)/900f) {
				isFocused = true;
			} else {
				isFocused = false;
			}
			if (font.getStopLength() != 0) {
				text = new StringBuilder(text.toString().substring(0, font.getStopLength()));
			}
			if (isFocused) {
				boolean caps = false;
				if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
					caps = true;
				}
				for (int i = 0; i < pressedKeys.length; i++) {
					pressedKeys[i] = Keyboard.isKeyDown(i);
				}

				for (int i = 0; i < pressedKeys.length; i++) {
					if (pressedKeys[i] && !lastPressedKeys[i]) {
						if (i == Keyboard.KEY_BACK) {
							if (text.length() > 0) {
								text = new StringBuilder(text.toString().substring(0, text.toString().length() - 1));
							}
						} else if (i == Keyboard.KEY_SPACE) {
							text.append(" ");
						} else if ((i >= 16 && i <= 25) || (i >= 30 && i <= 38) || (i >= 44 && i <= 50)) {
							if (caps) {
								text.append(Keyboard.getKeyName(i));
							} else {
								text.append(Keyboard.getKeyName(i).toLowerCase());
							}
						}
						else if (i >= 2 && i <= 11) {
							text.append(Keyboard.getKeyName(i));
						}
						
					}
				}
				lastPressedKeys = pressedKeys.clone();

			}
		}
	}

}
