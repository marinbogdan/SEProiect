package com.mta.beatman.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mta.beatman.controller.EntityManager;
import com.mta.beatman.controller.OrthoCamera;
import com.mta.beatman.controller.TextureManager;
import com.mta.beatman.view.MenuScreen;

public class Player extends Entity {

	private final EntityManager entityManager;
	private final OrthoCamera camera;
	private long lastFire;
	
	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager, OrthoCamera camera) {
		super(TextureManager.PLAYER, pos, direction);
		this.entityManager = entityManager;
		this.camera = camera;
	}

	@Override
	public void update() {
		pos.add(direction);
		int dir = 0;
		if (Gdx.input.isTouched()) {
			Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
			if (touch.x > MainGame.WIDTH / 2)
				dir = 2;
			else
				dir = 1;
		}
		
		
		if (Gdx.input.isKeyPressed(Keys.LEFT) && this.pos.x>0) //left
			{
			setDirection(-200, 0,MainGame.WIDTH);
			}
		else if (Gdx.input.isKeyPressed(Keys.RIGHT ) && this.pos.x<(MainGame.WIDTH-TextureManager.PLAYER.getHeight()/2)) //right
			setDirection(200, 0,MainGame.WIDTH);
		else 
			setDirection(0, 0,MainGame.WIDTH);
	
		
			if (Gdx.input.isKeyPressed(Keys.P)) {
				//ScreenManager.setScreen(new MenuScreen());
		}
	}

}
