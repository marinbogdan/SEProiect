package com.mta.beatman.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mta.beatman.controller.OrthoCamera;
import com.mta.beatman.controller.ScreenManager;
import com.mta.beatman.controller.TextureManager;
import com.mta.beatman.model.MainGame;
import com.mta.beatman.model.Screen;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class ScoreScreen extends Screen {

	private OrthoCamera camera;
	private Texture texture;
	Stage stage;	
	TextField txtUsername1;
	TextField txtUsername2;
	TextField txtUsername3;
	TextField txtUsername4;
	TextField txtUsername5;
	TextField score1;
	TextField score2;
	TextField score3;
	TextField score4;
	TextField score5;
	List<String> firstVector = new ArrayList<String>();
	List<Integer> myCoords = new ArrayList<Integer>();
	public ScoreScreen() throws Exception {
		for(int i=0;i<5;i++)
			{
			firstVector.add(null);
			myCoords.add(0);
			}
		sql();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
        Gdx.input.setInputProcessor(stage);
        //
        
        Skin skin=new Skin(Gdx.files.internal("uiskin.json"));
        txtUsername1=new TextField("",skin);
        txtUsername1.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-100);
        txtUsername1.setSize(240, 50);
        txtUsername1.setColor(Color.BLUE);
        score1=new TextField("",skin);
        score1.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2+110, MainGame.HEIGHT-125-100);
        score1.setSize(240, 50);
        score1.setColor(Color.BLUE);
        //
        txtUsername2=new TextField("",skin);
        txtUsername2.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-160);
        txtUsername2.setSize(240, 50);
        txtUsername2.setColor(Color.BLUE);
        score2=new TextField("",skin);
        score2.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2+110, MainGame.HEIGHT-125-160);
        score2.setSize(240, 50);
        score2.setColor(Color.BLUE);
        //
        txtUsername3=new TextField("",skin);
        txtUsername3.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-220);
        txtUsername3.setSize(240, 50);
        txtUsername3.setColor(Color.BLUE);
        score3=new TextField("",skin);
        score3.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2+110, MainGame.HEIGHT-125-220);
        score3.setSize(240, 50);
        score3.setColor(Color.BLUE);
        //
        txtUsername4=new TextField("",skin);
        txtUsername4.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-280);
        txtUsername4.setSize(240, 50);
        txtUsername4.setColor(Color.BLUE);
        score4=new TextField("",skin);
        score4.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2+110, MainGame.HEIGHT-125-280);
        score4.setSize(240, 50);
        score4.setColor(Color.BLUE);
        //
        txtUsername5=new TextField("",skin);
        txtUsername5.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-340);
        txtUsername5.setSize(240, 50);
        txtUsername5.setColor(Color.BLUE);
        score5=new TextField("",skin);
        score5.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2+110, MainGame.HEIGHT-125-340);
        score5.setSize(240, 50);
        score5.setColor(Color.BLUE);
     
        if(firstVector.get(0)!=null)
        txtUsername1.setMessageText(firstVector.get(0));
        if(firstVector.get(1)!=null)
        txtUsername2.setMessageText(firstVector.get(1));
        if(firstVector.get(2)!=null)
        txtUsername3.setMessageText(firstVector.get(2));
        if(firstVector.get(3)!=null)
        txtUsername4.setMessageText(firstVector.get(3));
        if(firstVector.get(4)!=null)
        txtUsername5.setMessageText(firstVector.get(4));
       
        	if(myCoords.get(0)!=0)
            score1.setMessageText(myCoords.get(0).toString());
            if(myCoords.get(1)!=0)
            score2.setMessageText(myCoords.get(1).toString());
            if(myCoords.get(2)!=0)
            score3.setMessageText(myCoords.get(2).toString());
            if(myCoords.get(3)!=0)
            score4.setMessageText(myCoords.get(3).toString());
            if(myCoords.get(4)!=0)
            score5.setMessageText(myCoords.get(4).toString());
            
        stage.addActor(txtUsername1);
        stage.addActor(score1);
        stage.addActor(txtUsername2);
        stage.addActor(score2);
        stage.addActor(txtUsername3);
        stage.addActor(score3);
        stage.addActor(txtUsername4);
        stage.addActor(score4);
        stage.addActor(txtUsername5);
        stage.addActor(score5);
	}
	
	public void sql() throws Exception
	{
		System.out.println("\nData tabel results!!\n");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "MarinBogdan3");
		java.sql.PreparedStatement statement = con.prepareStatement("select * from datasource order by point DESC LIMIT 0,5");
		ResultSet result=statement.executeQuery();
		int i=0;
		while(result.next())
			{
			
				firstVector.set(i, result.getString(2));
				myCoords.set(i, result.getInt(3));
				i++;
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
		
		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sb.draw(TextureManager.TOP_5_SCORES, MainGame.WIDTH/2-TextureManager.TOP_5_SCORES.getWidth()/2,MainGame.HEIGHT-150);
		sb.draw(TextureManager.GAME_RETURN, MainGame.WIDTH/2-TextureManager.GAME_RETURN.getWidth()/2,MainGame.HEIGHT-600);
		
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
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
