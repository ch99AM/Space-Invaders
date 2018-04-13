package com.invaders.enemigos;

import com.badlogic.gdx.graphics.Texture;


// Es clase se encarga de crear al enemigo base y al jefe.
public class NaveEnemigo {
	Texture nave;
	protected int vida;
	protected float x ,y;
	protected  boolean jefe;

	public NaveEnemigo(int vida, float x, float y) {
		jefe = false;
		if (vida < 4) {
			nave = new Texture("naveEne.png");
		}
		else {// Con esta vereficacion se puede usar para la lista base y la tipo A
			nave = new Texture("naveJefe.png");
			jefe = true;
		}
		this.vida = vida;
		this.x = x;
		this.y =y;
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
	public void setVida(int vida) {
		this.vida = vida;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void coverJefe() {
		this.nave = new Texture("naveJefe.png");
		this.vida = 4;
		this.jefe = true;
	}
	public void coverEne() {
		this.nave = new Texture("naveEne.png");
		this.vida = 1;
		this.jefe = false;
	}
}
