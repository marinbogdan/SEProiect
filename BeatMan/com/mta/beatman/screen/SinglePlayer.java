package com.mta.beatman.screen;

import javax.swing.JTable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mta.beatman.MainGame;
import com.mta.beatman.TextureManager;
import com.mta.beatman.camera.OrthoCamera;

public class SinglePlayer extends Screen {
	Stage stage;
	TextField txtUsername;
	TextButton button;
	private OrthoCamera camera;
	private Texture texture;
	public String user=null;
	
	public SinglePlayer() {
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
        Gdx.input.setInputProcessor(stage);
        //
        
        Skin skin=new Skin(Gdx.files.internal("uiskin.json"));
        //
        //
        button=new TextButton("Start game!!", skin);
        button.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-350);
        button.setSize(500, 100);
        txtUsername=new TextField("",skin);
        txtUsername.setPosition(MainGame.WIDTH/2-TextureManager.GAME_SINGLE_PLAYER.getWidth()/2-150, MainGame.HEIGHT-125-100);
        txtUsername.setSize(500, 100);
        txtUsername.setColor(Color.BLUE);
        txtUsername.setScale(3);
       
        button.addListener(new ClickListener(){
	         
        	@Override
        	public void clicked(InputEvent event, float x, float y)
        	{
        		clickburrton();
        	}
        });
        
      
        stage.addActor(txtUsername);
        stage.addActor(button);
    }
	
	public void clickburrton()
	{
		this.user=txtUsername.getText();
		MainGame.userName=this.user;
		if(this.user.hashCode()!=0)
			ScreenManager.setScreen(new GameScreen(this.user));
	    
	}
	
	@Override
	public void create() {
		camera = new OrthoCamera();
		camera.resize();
		
	}

	@Override
	public void update() {
		camera.update();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		

		sb.setProjectionMatrix(camera.combined);
		//sb.begin();
		//sb.draw(texture, MainGame.WIDTH / 2 - texture.getWidth() / 2, MainGame.HEIGHT / 2 - texture.getHeight() / 2);
		//sb.end();
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
