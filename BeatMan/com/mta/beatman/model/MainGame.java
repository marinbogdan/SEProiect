package com.mta.beatman.model;

import java.awt.GraphicsDevice;
import java.sql.SQLException;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mta.beatman.controller.OrthoCamera;
import com.mta.beatman.controller.ScreenManager;
import com.mta.beatman.view.GameScreen;
import com.mta.beatman.view.MenuScreen;

public class MainGame implements ApplicationListener {
	
	public static int WIDTH = 900, HEIGHT = 600;
	public static int numbers_of_enemy=5;
	public static int numbers_of_beers=10;
	public static float nr=0;
	public static SpriteBatch batch;
	public static String userName=null;
	private OrthoCamera camera;
	@Override
	public void create() {	
		camera = new OrthoCamera();
		camera.resize();
		batch = new SpriteBatch();
		ScreenManager.setScreen(new MenuScreen(camera));
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
		
		try {
			if (ScreenManager.getCurrentScreen() != null)
				try {
					ScreenManager.getCurrentScreen().update();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
