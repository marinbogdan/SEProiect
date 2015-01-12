package com.mta.beatman;

import java.awt.GraphicsDevice;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mta.beatman.screen.GameScreen;
import com.mta.beatman.screen.MenuScreen;
import com.mta.beatman.screen.ScreenManager;

public class MainGame implements ApplicationListener {
	
	public static int WIDTH = 900, HEIGHT = 600;
	public static int numbers_of_enemy=5;
	public static int numbers_of_beers=10;
	public static float nr=0;
	public static SpriteBatch batch;
	public static String userName=null;
	
	@Override
	public void create() {		
		batch = new SpriteBatch();
		ScreenManager.setScreen(new MenuScreen());
	}

	@Override
	public void dispose() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}
}
