package com.invaders.enemigos;

import com.badlogic.gdx.graphics.Texture;

/**
 * Contiene las caracteristicas de la nave de la enemiga Esta misma clase
 * fabrica los naves normales y las de los jefes
 * 
 * @author Christian
 *
 */
public class NaveEnemigo {
	Texture nave;
	protected int vida;
	protected float x, y;
	protected boolean jefe;
	protected int puntaje;

	public NaveEnemigo(int vida, float x, float y) {
		jefe = false;
		if (vida < 4) {
			nave = new Texture("naveEne.png");
			this.puntaje = 10;
		} else {// Con esta vereficacion se puede usar para la lista base y todas las demas
			nave = new Texture("naveJefe.png");
			jefe = true;
			this.puntaje = 30;
		}
		this.vida = vida;
		this.x = x;
		this.y = y;
	}

	public Texture getNave() {
		return nave;
	}

	public void disminuirVida() {
		this.vida -= 1;
	}

	public int getVida() {
		return vida;
	}

	/**
	 * Complementa el cambio de una nave a jefe
	 * 
	 * @param vida
	 *            Nueva vida para la nave
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	public float getX() {
		return x;
	}

	public void setX(float d) {
		this.x = d;
	}

	public float getY() {
		return y;
	}

	public void setY(float b) {
		this.y = b;
	}

	/**
	 * Permite cambiar la nave por una nave de jefe
	 */
	public void coverJefe() {
		this.nave = new Texture("naveJefe.png");
		this.vida = 4;
		this.jefe = true;
		this.puntaje = 30;
	}

	/**
	 * Convierte la nave del jefe en una normal
	 */
	public void coverEne() {
		this.nave = new Texture("naveEne.png");
		this.vida = 1;
		this.jefe = false;
		this.puntaje = 10;
	}

	/**
	 * Estrae el puntaje por la destrucion de una nave
	 * 
	 * @return
	 */
	public int getPuntaje() {
		return puntaje;
	}
}
