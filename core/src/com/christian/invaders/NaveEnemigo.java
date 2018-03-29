package com.christian.invaders;

import com.badlogic.gdx.graphics.Texture;

public class NaveEnemigo {
	Texture nave;
	private int vida;
	private int x ,y;
	

	public NaveEnemigo(int vida) {
		nave = new Texture("naveEne.png");
		this.vida = vida;
		this.x = x;
		this.y = y;
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
