package com.invaders.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.christian.invaders.Disparo;
import com.christian.invaders.MainInvaders;

public class Jugador {
	Texture naveJ;
	private int x;
	private int puntaje;
	private String nombre;
	private int vida;

	public Jugador() {
		this.x = 545;
		naveJ = new Texture("naveJugador.png");
		this.vida = 3;
		this.nombre = "Christian";
		this.puntaje = 0;
	}

	public void renderJugador() {
		x = mover();
		MainInvaders.batch.draw(naveJ, x, 0);

	}

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

	public int getX() {
		return x;
	}

}
