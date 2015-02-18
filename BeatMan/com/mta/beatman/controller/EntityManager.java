package com.mta.beatman.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mta.beatman.model.Beer;
import com.mta.beatman.model.Enemy;
import com.mta.beatman.model.Entity;
import com.mta.beatman.model.MainGame;
import com.mta.beatman.model.Player;
import com.mta.beatman.view.GameOverScreen;
import com.mysql.jdbc.Statement;

public class EntityManager {

	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	public int number;
	public int ok;
	public int contro=0;
	SpriteBatch mybatch;
	String username;
	public EntityManager(int enemey,int beers, OrthoCamera camera,String user) {
		this.username=user;
		ok=0;
		number=0;
		player = new Player(new Vector2(MainGame.WIDTH/2, 15), new Vector2(0, 0), this, camera);
		for (int i = 0; i < beers; i++) {
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.BEER.getWidth());
			float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
			float speed = MathUtils.random(1, 3);
			addEntity(new Beer(new Vector2(x, y), new Vector2(0, -speed)));
		}
		for (int i = 0; i < enemey; i++) {
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
			float speed = MathUtils.random(4, 5);
			addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed)));
		}
	}
	
	public void update() throws ClassNotFoundException, SQLException {
		for (Entity e : entities)
			e.update();
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb) {
		mybatch=sb;
//sb.setColor(1, 1, 1, 1);
		for (Entity e : entities)
			e.render(sb);
		player.render(sb);
		float nr=MainGame.nr/10;
		nr=1-nr;
		
		float r=(float) (1-MainGame.nr/10);
		//System.out.println(MainGame.nr);
		if(contro==1)
			{
			r=0;
			MainGame.nr=0;
			}
		sb.setColor(1, 1, 1, r);
		
		}
	
	private void checkCollisions() {
		contro=0;
		for (Enemy e : getEnemy()) {
			if (e.getBounds().overlaps(player.getBounds())) {
				ScreenManager.setScreen(new GameOverScreen(false,username,ok));
				MainGame.nr=0;
				contro=1;
			}
		}
		for (Beer e : getBeers()) {
				if (e.getBounds().overlaps(player.getBounds())) {
					entities.removeValue(e, false);
					ok++;
					MainGame.nr=ok;
			
					if(ok==10)
					{
						contro=1;
						ScreenManager.setScreen(new GameOverScreen(false,username,ok));
						MainGame.nr=0;
					}
					
				}
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	private Array<Beer> getBeers() {
		Array<Beer> ret = new Array<Beer>();
		for (Entity e : entities)
			if (e instanceof Beer)
				ret.add((Beer)e);
		return ret;
	}
	
	private Array<Enemy> getEnemy() {
		Array<Enemy> ret = new Array<Enemy>();
		for (Entity e : entities)
			if (e instanceof Enemy)
				ret.add((Enemy)e);
		return ret;
	}
	
	
	public boolean gameOver() {
		return getBeers().size <= 0;
	}
	
}
