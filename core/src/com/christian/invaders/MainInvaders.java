package com.christian.invaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainInvaders extends Game {
	PantallaJug ju1;
	Disparo disparo;
	
	Texture fondo;
	
	public static SpriteBatch batch;

	@Override
	public void create () {
		fondo = new Texture("Space.jpg");
		
		ju1 = new PantallaJug(this);
		disparo = new Disparo(this); 
		
		batch = new SpriteBatch();
  
		   setScreen(disparo);
		setScreen(ju1);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(fondo, 0, 0);
		ju1.render(0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			disparo.render(0);
		}
		batch.end();
	}
}	

