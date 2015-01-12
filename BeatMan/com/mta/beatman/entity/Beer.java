package com.mta.beatman.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mta.beatman.MainGame;
import com.mta.beatman.TextureManager;

public class Beer extends Entity {

	public Beer(Vector2 pos, Vector2 direction) {
		super(TextureManager.BEER, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if (pos.y <= -TextureManager.BEER.getHeight()) {
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.BEER.getWidth());
			pos.set(x, MainGame.HEIGHT);
		}
	}
	
}
