package com.christian.invaders;

import com.invaders.jugador.Jugador;

public class PantallaJuego extends PantallaBase {	
	MainInvaders invaders;
	
	Jugador ju1;
	Disparo disparo;
	PantallaEnemigo enemigo;

	public PantallaJuego(MainInvaders mainInvaders) {	
		super(mainInvaders);
		this.invaders = mainInvaders; 
		
		ju1 = new Jugador();
		disparo = new Disparo();
		enemigo = new PantallaEnemigo(10);

	}
	
	@Override
	public void render(float delta) {
	
		ju1.renderJugador();
		disparo.setX(ju1.getX());
		disparo.render();
		enemigo.render(disparo.getX(), disparo.getY());

			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
