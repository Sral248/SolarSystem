package com.engine;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
	public static void createWindow(int width, int height, String title, boolean fullscreen) {
		if (fullscreen) {
			try {
				Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode());
				Display.setTitle(title);
				Display.create();
			} catch (LWJGLException e) {
				System.err.println("Display nicht erstellt!");
				e.printStackTrace();
			}
		} else {
			try {
				Display.setDisplayMode(new DisplayMode(width, height));
				Display.setTitle(title);
				Display.create();
			} catch (LWJGLException e) {
				System.err.println("Display nicht erstellt!");
				e.printStackTrace();
			}
		}
	}

	public static void render() {
		Display.update();
	}

	public static int getWidth() {
		return Display.getDisplayMode().getWidth();
	}

	public static int getHeight() {
		return Display.getDisplayMode().getHeight();
	}

	public static String getTitle() {
		return Display.getTitle();
	}

	public static boolean isCloseRequested() {
		return Display.isCloseRequested();
	}

	public static void dispose() {
		Display.destroy();
	}
}
