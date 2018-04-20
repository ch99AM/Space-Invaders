package com.invaders.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.graphics.Texture;
import com.invaders.main.MainInvaders;

/**
 * Controla todo lo relacionado con los disparos
 * 
 * @author Christian
 *
 */
public class Disparo {

	public static int y; // para poder terner acceso desde los enemigos para quitar el diparo cuando los
							// impacta.
	private int x;
	Texture bala;
	boolean disparado;
	private Sound shoot;

	public Disparo() {
		bala = new Texture("bala.png");
		this.y = 700;
		this.disparado = false;
		shoot = Gdx.audio.newSound(Gdx.files.getFileHandle("Sounds/Shoot.wav", FileType.Internal));
	}

	/**
	 * Detecta cuando el disparo es accionado y realiza todas las modificaciones
	 * para llevarlo a su objetivo
	 */
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			this.disparado = true;
		}

		if (this.disparado) {
			MainInvaders.batch.draw(bala, x, y);
			if (this.y < 725) {
				this.y += 16;
			} else {
				this.disparado = false;
				this.x = 0;
				this.y = 700;
			}
		}
	}

	/**
	 * Actualiza la poasion desde la cual el jugador disparo
	 * 
	 * @param x
	 *            La posicion del jugador cuando disparo
	 */
	public void setX(int x) {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			if (y >= 700) {
				shoot.play();
				this.y = 80;
				this.x = x + 30;
			}
		}
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}