package com.youtube.invaders.entity;

import java.awt.Font;
import java.awt.GraphicsDevice;

import javax.print.DocFlavor.STRING;

import sun.tools.jar.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.youtube.invaders.MainGame;

public abstract class Entity {

	protected Texture texture;
	protected Vector2 pos, direction;
	BitmapFont font = new BitmapFont();
	public int number;
	
	public Entity(Texture texture, Vector2 pos, Vector2 direction) {
		number=0;
		this.texture = texture;
		this.pos = pos;
		this.direction = direction;
	}
	
	public abstract void update();
	
	public void render(SpriteBatch sb) {
		sb.draw(texture, pos.x, pos.y);
		font.draw(sb,Float.toString(MainGame.nr), MainGame.WIDTH/2-50,MainGame.HEIGHT-10);
		String aux="Player name: ";
		aux=aux+MainGame.userName;
		font.draw(sb,aux, 50,MainGame.HEIGHT-10);
		//System.out.println(MainGame.nr);
		
	}
	
	public Vector2 getPosition() {
		return pos;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
	}
	
	public void setDirection(float x, float y,int latime) {
		
		direction.set(x, y);
		direction.scl(Gdx.graphics.getDeltaTime());
			
	}
	
}
