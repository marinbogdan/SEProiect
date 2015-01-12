package com.mta.beatman.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen {

	public abstract void create() throws Exception;
	
	public abstract void update();
	
	public abstract void render(SpriteBatch sb);
	
	public abstract void resize(int width, int height);
	
	public abstract void dispose();
	
	public abstract void pause();
	
	public abstract void resume();
	
}
