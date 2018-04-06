package com.invaders.enemigos;

public class NodoSimple {
	NaveEnemigo enemigo;
	private NodoSimple siguiente;

	public NodoSimple(int vida, float x , float y) {
		this.siguiente = null;
		enemigo = new NaveEnemigo(vida, x, y);
	}
	public NaveEnemigo getEnemigo() {
		return enemigo;
	}
	public NodoSimple getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoSimple siguiente) {
		this.siguiente = siguiente;
	}

}
