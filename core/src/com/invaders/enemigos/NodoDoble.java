package com.invaders.enemigos;

public class NodoDoble  {
	NaveEnemigo enemigo;
	private NodoDoble siguiente, anterior;
	
	public NodoDoble(int vida , int x , int y) {
		this.siguiente = null;
		this.anterior = null;
		enemigo = new NaveEnemigo(vida, x, y);	
	}
	
	public NaveEnemigo getEnemigo() {
		return enemigo;
	}
	public NodoDoble getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
	public NodoDoble getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}

}
