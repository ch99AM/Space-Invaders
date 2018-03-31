package com.invaders.enemigos;

import com.badlogic.gdx.graphics.Texture;

public class NaveEnemigo {
	Texture nave;
	protected int vida;
	protected float x ,y;
	

	public NaveEnemigo(int vida, float x, float y) {
		nave = new Texture("naveEne.png");
		this.vida = vida;
		this.x = x;
		this.y =y;
	}
	public Texture getNave() {
		return nave;
	}
	public void disminuirVida(int dano) {
		this.vida -= dano;
	}
	public int getVida() {
		return vida;
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
}
