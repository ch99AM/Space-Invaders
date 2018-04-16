package com.christian.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.niveles.NivelUno;

public class PantallaJuego extends PantallaBase {	
	MainInvaders invaders;
	
	Texture fondo;
	private Sound gameOver;
	private BitmapFont font;
	
	Jugador ju1;
	Disparo disparo;
	NivelUno N1;
	
	public PantallaJuego(MainInvaders mainInvaders) {	
		super(mainInvaders);
		this.invaders = mainInvaders; 
		
		font = new BitmapFont();
		
		fondo = new Texture("Space.jpg");
		gameOver =  Gdx.audio.newSound( Gdx.files.getFileHandle("Sounds/GameOver.wav", FileType.Internal));
		
		ju1 = new Jugador();
		disparo = new Disparo();
		N1 = new NivelUno(font);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0.15f);
		
		MainInvaders.batch.begin();
		
		MainInvaders.batch.draw(fondo, 0, 0);
		
		String StrPuntaje = Integer.toString(Jugador.puntaje);
		String StrVida = Integer.toString(Jugador.getVida());
		font.draw(MainInvaders.batch,"Ptns: " + StrPuntaje, 0, 680);
		font.draw(MainInvaders.batch,"Vida: " + StrVida, 100, 680);
		
		if (ju1.getVida() > 0) {
			ju1.renderJugador();
			disparo.setX(ju1.getX());
			disparo.render();
			N1.render(disparo.getX() - 30, disparo.getY());
		}
		else {
				Menu menu = new Menu(invaders);
				invaders.setScreen(menu);
				gameOver.play(50f);
		}
		MainInvaders.batch.end();
		
		System.out.println(ju1.puntaje);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void show() {;
	}

	
	@Override
	public void pause() {
		
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
