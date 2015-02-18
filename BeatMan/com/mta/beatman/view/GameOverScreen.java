package com.mta.beatman.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mta.beatman.controller.OrthoCamera;
import com.mta.beatman.controller.ScreenManager;
import com.mta.beatman.controller.TextureManager;
import com.mta.beatman.model.MainGame;
import com.mta.beatman.model.Screen;
import com.mysql.jdbc.Statement;

public class GameOverScreen extends Screen {

	private OrthoCamera camera;
	private Texture texture;
	
	public GameOverScreen(boolean won,String name, int number) {
		sql(name,number);
		
	}
	public void sql(String name, int number) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "MarinBogdan3");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO datasource(username,point) VALUES (?,?);");
			stmt.setString(1, name);
            stmt.setInt(2, number);
           
            stmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public void create() {
		camera = new OrthoCamera();
		camera.resize();
	}

	@Override
	public void update() {
		camera.update();
		
		if (Gdx.input.isTouched()) {
			Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
			
			if(touch.x>MainGame.WIDTH/2-TextureManager.GAME_RETURN.getWidth()/2 && touch.x<MainGame.WIDTH/2+TextureManager.GAME_RETURN.getWidth()/2)
				if(touch.y>MainGame.HEIGHT-600 && touch.y<MainGame.HEIGHT-600+TextureManager.GAME_RETURN.getHeight())
				{
					ScreenManager.setScreen(new MenuScreen(camera));      			        				
				}
		}
	
	}

	@Override
	public void render(SpriteBatch sb) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		sb.setColor(1, 1, 1, 1);
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		//draw the menu
		sb.draw(TextureManager.GAME_OVER, MainGame.WIDTH/2-TextureManager.GAME_OVER.getWidth()/2,MainGame.HEIGHT-300);
		sb.draw(TextureManager.GAME_RETURN, MainGame.WIDTH/2-TextureManager.GAME_RETURN.getWidth()/2,MainGame.HEIGHT-600);
		
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
