package com.invaders.main;

import java.util.MissingFormatArgumentException;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class Menu extends PantallaBase {
	Texture menu;
	MainInvaders invaders;
	
	PantallaJuego juego;
	private Sound start;
	
	public Menu(MainInvaders invaders) {
		super(invaders);
		this.invaders = invaders;
		
		juego = new PantallaJuego(invaders);
		start = Gdx.audio.newSound( Gdx.files.getFileHandle("Sounds/StarGame.wav", FileType.Internal) );
		menu = new Texture("menu.jpg");

	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0.15f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		MainInvaders.batch.begin();
		
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			start.play(0.25f);
			invaders.setScreen(juego);
		}
		else {
			MainInvaders.batch.draw(menu, 0, 0);
		}
		
		MainInvaders.batch.end();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
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
