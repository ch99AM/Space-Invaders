package com.christian.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.invaders.jugador.Jugador;

public class PantallaJuego extends PantallaBase {	
	MainInvaders invaders;
	
	PantallaJuego juego;
	Texture fondo;
	
	Jugador ju1;
	Disparo disparo;
	NivelUno N1;
	
	public PantallaJuego(MainInvaders mainInvaders) {	
		super(mainInvaders);
		this.invaders = mainInvaders; 
		
		
		fondo = new Texture("Space.jpg");
		
		ju1 = new Jugador();
		disparo = new Disparo();
		N1 = new NivelUno();
 
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0.15f);
		
		MainInvaders.batch.begin();
		
		MainInvaders.batch.draw(fondo, 0, 0);
		

		ju1.renderJugador();
		disparo.setX(ju1.getX());
		disparo.render();
		N1.render(disparo.getX() - 30, disparo.getY());
		
		MainInvaders.batch.end();


	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void show() {
	}

	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {

	}
	

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		fondo .dispose();
		
	}
}
