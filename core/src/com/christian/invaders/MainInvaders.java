package com.christian.invaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainInvaders extends Game {

	PantallaJuego juego;
	//Disparo disparo;
	//PantallaEnemigo enemigo;
	Texture fondo;
	
	public static SpriteBatch batch; // Para facilitar el dibujar figuras del juego

	@Override
	public void create () {
		
		fondo = new Texture("Space.jpg");
		
		juego = new PantallaJuego(this);
		//disparo = new Disparo();
		//enemigo = new PantallaEnemigo(this, 10);
		
		batch = new SpriteBatch();
  

		setScreen(juego);
		//setScreen(enemigo);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0.15f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.draw(fondo, 0, 0);
		juego.render(0);
		//disparo.setX(ju1.getX());
		//disparo.render();
		
		
		//enemigo.render1(0, disparo.getX(), disparo.getY());

		batch.end();


	}
}	

