package com.engine;

public abstract class GameLoop {
	public static int WIDTH = 1600;
	public static int HEIGHT = 900;
	public static final String TITLE = "Display";
	public static final double FRAME_CAP = 120.0;

	private boolean isRunning;
	private static boolean fullscreen;

	public GameLoop(int width, int height, String title) {
		Window.createWindow(width, height, title, fullscreen);
		init();
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public static boolean isFullscreen() {
		return fullscreen;
	}

	public static void setFullscreen(boolean fullscreen) {
		GameLoop.fullscreen = fullscreen;
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static String getTitle() {
		return TITLE;
	}

	public static double getFrameCap() {
		return FRAME_CAP;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public float getDisplayHeight() {
		return Window.getHeight();
	}

	public float getDisplayWidth() {
		return Window.getWidth();
	}

	public void start() {
		if (isRunning)
			return;
		run();
	}

	public void stop() {
		if (!isRunning)
			return;
		isRunning = false;
	}

	private void run() {
		isRunning = true;

		int frames = 0;
		int frameCounter = 0;

		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		final double frameTime = 1 / FRAME_CAP;

		while (isRunning) {
			boolean render = false;
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;

			lastTime = startTime;
			unprocessedTime += passedTime / (double) Time.SECOND;
			frameCounter += passedTime;

			while (unprocessedTime > frameTime) {
				render = true;
				unprocessedTime -= frameTime;

				if (Window.isCloseRequested())
					stop();

				Time.setDelta(frameTime);
				input();
				update(Time.getDelta());
				if (frameCounter >= Time.SECOND) {
					System.out.println(frames);
					frames = 0;
					frameCounter = 0;
				}
			}

			if (render) {
				frames++;
				render();
				Window.render();

			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		cleanUp();
		Window.dispose();

	}

	public abstract void init();

	public abstract void input();

	public abstract void update(double dDelta);

	public abstract void render();

	public abstract void cleanUp();

}