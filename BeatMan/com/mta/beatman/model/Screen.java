package com.mta.beatman.model;

import java.sql.SQLException;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen {

	public abstract void create() throws Exception;
	
	public abstract void update() throws ClassNotFoundException, SQLException, Exception;
	
	public abstract void render(SpriteBatch sb);
	
	public abstract void resize(int width, int height);
	
	public abstract void dispose();
	
	public abstract void pause();
	
	public abstract void resume();
	
}
