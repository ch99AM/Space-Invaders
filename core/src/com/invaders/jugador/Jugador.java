package com.invaders.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.invaders.main.MainInvaders;

/**
 * Controla lo relacionado con el jugador, contiene los metodos necesarios para
 * el manejo
 * 
 * @author Christian
 *
 */
public class Jugador {
	Texture naveJ;
	private int x;
	public static int puntaje;
	private static int vida;

	public Jugador() {
		this.x = 545;
		naveJ = new Texture("naveJugador.png");
		vida = 3;
		puntaje = 0;
	}

	/**
	 * Actualiza las movimientos de a nave cuando el jugador la acciona
	 */
	public void renderJugador() {
		x = mover();
		MainInvaders.batch.draw(naveJ, x, 0);

	}

	/**
	 * Mueve la nave segun las entradas del jugador
	 * 
	 * @return
	 */
	public int mover() {
		boolean der = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean izq = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		if (der != izq) {
			if (der == true && x < 1072) {
				this.x += 4;
			} else if (izq == true && x > 0) {
				this.x -= 4;
			}
		}
		return x;
	}

	/**
	 * 
	 * Disminuye la vida del jugador
	 */
	public static void perder() {
		vida--;
	}

	public static int getVida() {
		return vida;
	}

	public int getX() {
		return x;
	}

}
