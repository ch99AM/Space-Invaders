package com.christian.invaders;

import com.badlogic.gdx.graphics.Texture;

public class NodoSimple {
	Texture nave;
	private NodoSimple siguiente;

	public NodoSimple() {
		this.siguiente = null;
		nave = new Texture("naveEne.png");
	}
	public Texture getValor() {
		return nave;
	}
	public NodoSimple getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoSimple siguiente) {
		this.siguiente = siguiente;
	}

}
