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
	PantallaEnemigo enemigo;
	Texture fondo;
	
	public static SpriteBatch batch;

	@Override
	public void create () {
		
		fondo = new Texture("Space.jpg");
		
		ju1 = new PantallaJug(this);
		disparo = new Disparo(this);
		enemigo = new PantallaEnemigo(this, 12);
		
		batch = new SpriteBatch();
  
		setScreen(disparo);
		setScreen(ju1);
		setScreen(enemigo);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		
		batch.draw(fondo, 0, 0);
		ju1.render(0);
		disparo.setX(ju1.getX());
		disparo.render(0);
		enemigo.render(0);
		
		
		batch.end();

	}
}	

