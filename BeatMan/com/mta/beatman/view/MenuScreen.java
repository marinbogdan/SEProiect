package com.mta.beatman.view;

import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.mta.beatman.controller.OrthoCamera;
import com.mta.beatman.controller.ScreenManager;
import com.mta.beatman.controller.TextureManager;
import com.mta.beatman.model.MainGame;
import com.mta.beatman.model.Screen;
import com.mysql.jdbc.PreparedStatement;

public class MenuScreen extends Screen {

	public static GameScreen game;
	private OrthoCamera camera;
	BitmapFont font = new BitmapFont();
	Font a=new Font("fsd", 3, 4);
	int ok=0;
	Stage stage;
	TextField txtUsername;
	
	public MenuScreen(OrthoCamera camera2) {
		camera=camera2;
		ok=0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		ok=0;
		camera.resize();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
        Gdx.input.setInputProcessor(stage);
        try {
        	//sql code
        	
			sql();
        	
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	//sql code
	
	public void sql() throws Exception
	{
		System.out.println("\nData tabel results!!\n");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "MarinBogdan3");
		java.sql.PreparedStatement statement = con.prepareStatement("select * from datasource order by point DESC");
		ResultSet result=statement.executeQuery();
		while(result.next())
			{
			 System.out.println(result.getString(2)+ " " + result.getString(3));
			}
	}
	
	@Override
	public void update() throws Exception {
		//set camera
		camera.update();
		ok=0;
		if (Gdx.input.isTouched()) {
			Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
			
			if(touch.x>MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2 && touch.x<MainGame.WIDTH/2+TextureManager.GAME_SINGLE_PLAYER.getWidth()/2)
				if(touch.y>MainGame.HEIGHT-125 && touch.y<MainGame.HEIGHT-125+TextureManager.GAME_SINGLE_PLAYER.getHeight())
				{
					ok=1;
					      			        				
				}
			if(touch.x>MainGame.WIDTH/2-TextureManager.GAME_SETTINGS.getWidth()/2 && touch.x<MainGame.WIDTH/2+TextureManager.GAME_SETTINGS.getWidth()/2)
				if(touch.y>MainGame.HEIGHT-365 && touch.y<MainGame.HEIGHT-365+TextureManager.GAME_SETTINGS.getHeight())
				{
					ok=2;
					      			        				
				}
			if(touch.x>MainGame.WIDTH/2-TextureManager.GAME_EXIT.getWidth()/2 && touch.x<MainGame.WIDTH/2+TextureManager.GAME_EXIT.getWidth()/2)
				if(touch.y>MainGame.HEIGHT-485 && touch.y<MainGame.HEIGHT-485+TextureManager.GAME_EXIT.getHeight())
				{
					 Gdx.app.exit();
					      			        				
				}
		
		}
		
		if(ok==1)
			{
			ScreenManager.setScreen(new SinglePlayer());
			}
		if(ok==2)
		{
			ScreenManager.setScreen(new ScoreScreen());
		}
	}

	@Override
	public void render(SpriteBatch sb) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		sb.setProjectionMatrix(camera.combined);
		sb.setColor(1, 1, 1, 1);
		
		sb.begin();
		//draw the menu
		sb.draw(TextureManager.GAME_SINGLE_PLAYER, MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2,MainGame.HEIGHT-125);
		sb.draw(TextureManager.GAME_MULTIP_PLAYER,  MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2,MainGame.HEIGHT-250);
		sb.draw(TextureManager.GAME_SETTINGS, MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2,MainGame.HEIGHT-365);		
		sb.draw(TextureManager.GAME_EXIT, MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2,MainGame.HEIGHT-485);
		//
		sb.end();
		stage.act();
		stage.draw();
		
		
	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
	}

}
