package com.invaders.listas;

import com.invaders.enemigos.NaveEnemigo;

/**
 * Contiene la estrutura para contruir una lista con enlases simples
 * 
 * @author Christian
 *
 */
public class NodoSimple {
	NaveEnemigo enemigo;
	private NodoSimple siguiente;

	/**
	 * Crea un nuevo nodo
	 * 
	 * @param vida
	 *            La vida de la nave que estara en el nodo
	 * @param x
	 *            Las posciones en las que se quiere colocar la nave
	 * @param y
	 */
	public NodoSimple(int vida, float x, float y) {
		this.siguiente = null;
		enemigo = new NaveEnemigo(vida, x, y);
	}

	/**
	 * @return El valor del nodo
	 */
	public NaveEnemigo getEnemigo() {
		return enemigo;
	}

	/**
	 * @return El nodo siguiente del que se esta
	 */
	public NodoSimple getSiguiente() {
		return siguiente;
	}

	/**
	 * Concatena nodo con nodo, forma enlaces simple
	 * 
	 * @param siguiente
	 *            El nodo al que apuntara este nodo
	 */
	public void setSiguiente(NodoSimple siguiente) {
		this.siguiente = siguiente;
	}

}
