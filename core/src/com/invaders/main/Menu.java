package com.invaders.main;

import java.util.MissingFormatArgumentException;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
/**
 * Menu que se muestra antes cuando se inicia el juego. Da una bienvenidad al jugador 
 * 
 * @author Christian
 *
 */
public class Menu extends PantallaBase {
	Texture menu;
	MainInvaders invaders;
	
	PantallaJuego juego;
	private Sound start;
	Texture flecha;
	private boolean alternador;

	
	/**
	 * Inicia el menu
	 * @param invaders
	 */
	public Menu(MainInvaders invaders) {
		super(invaders);
		this.invaders = invaders;
		
		juego = new PantallaJuego(invaders);
		start = Gdx.audio.newSound( Gdx.files.getFileHandle("Sounds/StarGame.wav", FileType.Internal) );
		menu = new Texture("menu.jpg");
		flecha = new Texture("flecha.png");
		alternador = true;
	}
	/**
	 * Se ejecuta por defecto en cada nuevo fotograma 
	 */
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
			if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				alternador = false;
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
				alternador = true;
			}
			if (alternador) {
				MainInvaders.batch.draw(flecha, 520, 225);
				if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
					start.play(0.25f);
					invaders.setScreen(juego);
				}
			}
			else {
				MainInvaders.batch.draw(flecha, 520, 127);
				if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
					
					
				}
			}
		}
		
		MainInvaders.batch.end();
	}
	

	@Override
	public void show() {}

	@Override
	public void resize(int width, int height) {
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
	/**
	 * Elimina datos que java no hace
	 */
	@Override
	public void dispose() {
		flecha.dispose();
		start.dispose();

	}

}
