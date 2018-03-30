package com.christian.invaders;

public class NodoSimple {
	NaveEnemigo enemigo;
	private NodoSimple siguiente;

	public NodoSimple(int vida, int x ,int y) {
		this.siguiente = null;
		enemigo = new NaveEnemigo(vida, x, y);
	}
	public NaveEnemigo getValor() {
		return enemigo;
	}
	public NodoSimple getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoSimple siguiente) {
		this.siguiente = siguiente;
	}

}
