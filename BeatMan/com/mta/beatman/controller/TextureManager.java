package com.mta.beatman.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	public static Texture PLAYER = new Texture(Gdx.files.internal("roger.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("missile.png"));
	public static Texture BEER = new Texture(Gdx.files.internal("beer1.png"));
	public static Texture GAME_SINGLE_PLAYER = new Texture(Gdx.files.internal("single.png"));
	public static Texture GAME_MULTIP_PLAYER = new Texture(Gdx.files.internal("multi.png"));
	public static Texture GAME_SETTINGS=new Texture(Gdx.files.internal("settings.png"));
	public static Texture GAME_EXIT=new Texture(Gdx.files.internal("exit.png"));
	public static Texture ENEMY=new Texture(Gdx.files.internal("enemy.png"));
	public static Texture GAME_OVER=new Texture(Gdx.files.internal("game_over.png"));
	public static Texture GAME_RETURN=new Texture(Gdx.files.internal("return.png"));
	public static Texture TOP_5_SCORES=new Texture(Gdx.files.internal("score.png"));

}
