package com.mta.beatman.screen;

import javax.print.DocFlavor.STRING;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mta.beatman.MainGame;
import com.mta.beatman.camera.OrthoCamera;
import com.mta.beatman.entity.EntityManager;

public class GameScreen extends Screen {

	private OrthoCamera camera;
	private EntityManager entityManager;
	public String user=null;
	public GameScreen(String user2) {
		user=user2;
	}
	@Override
	public void create() {
		camera = new OrthoCamera();
		camera.resize();
		entityManager = new EntityManager(MainGame.numbers_of_enemy,MainGame.numbers_of_beers, camera);
	}

	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
