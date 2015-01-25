package com.mta.beatman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	public static Texture PLAYER = new Texture(Gdx.files.internal("assets/roger.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("assets/missile.png"));
	public static Texture BEER = new Texture(Gdx.files.internal("assets/beer1.png"));
	public static Texture GAME_SINGLE_PLAYER = new Texture(Gdx.files.internal("assets/single.png"));
	public static Texture GAME_MULTIP_PLAYER = new Texture(Gdx.files.internal("assets/multi.png"));
	public static Texture GAME_SETTINGS=new Texture(Gdx.files.internal("assets/settings.png"));
	public static Texture GAME_EXIT=new Texture(Gdx.files.internal("assets/exit.png"));
	public static Texture ENEMY=new Texture(Gdx.files.internal("assets/enemy.png"));

}
