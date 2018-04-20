package com.invaders.listas;

import com.invaders.enemigos.NaveEnemigo;

/**
 * Contiene la estructura para contruir una lista con enlases dobles
 * 
 * @author Christian
 *
 */
public class NodoDoble {
	NaveEnemigo enemigo;
	private NodoDoble siguiente, anterior;

	/**
	 * Crea un nuevo nodo
	 * 
	 * @param vida
	 *            Vida de la nave enemiga que se creara
	 * @param x
	 *            Posicion x en la que se quiere colocar la nave
	 * @param y
	 *            Posicion y en la que se quiere colocar la nave
	 */
	public NodoDoble(int vida, int x, int y) {
		this.siguiente = null;
		this.anterior = null;
		enemigo = new NaveEnemigo(vida, x, y);
	}

	/**
	 * @return El valor que contiene el nodo
	 */
	public NaveEnemigo getEnemigo() {
		return enemigo;
	}

	/**
	 * @return El nodo anterior al que se esta
	 */
	public NodoDoble getAnterior() {
		return anterior;
	}

	/**
	 * Enlaza el nodo con otro nodo anterior
	 * 
	 * @param anterior
	 */
	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}

	/**
	 * @return El nodo siguiente al que se esta
	 */
	public NodoDoble getSiguiente() {
		return siguiente;
	}

	/**
	 * Enlaza en nodo con otro que estaera delante de el
	 * 
	 * @param siguiente
	 */
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}

}
