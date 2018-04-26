package com.invaders.listas;

import com.invaders.enemigos.NaveEnemigo;
import com.invaders.jugador.Jugador;

/**
 * Lista simple, contiene operaciones para administrar los datos contenidos
 * 
 * @author Christian
 *
 */
public class ListaBase {

	protected NodoSimple inicio;
	protected int tamano;

	public ListaBase() {
		this.inicio = null;
		this.tamano = 0;
	}

	/**
	 * Agrega un nuevo valor al final de la lista
	 * 
	 * @param vida
	 *            Vida de la nave a crear
	 * @param x
	 *            Posiciones en las que se desea crear
	 * @param y
	 *            x y y
	 */
	public void agregarAlfinal(int vida, int x, int y) {
		NodoSimple nuevo = new NodoSimple(vida, x, y);
		if (esVacida()) {
			inicio = nuevo;
		} else {
			NodoSimple aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
		tamano++;
	}

	/**
	 * ELimina un nodo indicando una posicion y evaluando la vida de la nave que
	 * contiene
	 * 
	 * @param posicion
	 *            La posicion del nodo que se quiere eliminar
	 * @return Devuelve true si el nodo fue eliminado
	 */
	public boolean eliminarNodo(int posicion) {
		// Validacion por si es el primero
		if (posicion == 0) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) {
				Jugador.puntaje += inicio.getEnemigo().getPuntaje();
				if (inicio.getSiguiente() == null) {
					inicio = null;
					;
				} else {
					inicio = inicio.getSiguiente();
				}
				this.tamano--;
				return true;
			}
		} else {
			if (posicion > 0 && posicion <= tamano) {
				NodoSimple aux = inicio;
				for (int i = 1; i < posicion; i++) {
					aux = aux.getSiguiente();
				}
				aux.getSiguiente().getEnemigo().disminuirVida();
				if (aux.getSiguiente().getEnemigo().getVida() == 0) {
					Jugador.puntaje += aux.getEnemigo().getPuntaje();
					aux.setSiguiente(aux.getSiguiente().getSiguiente());
					this.tamano--;
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Busca un nodo por las posiciones x y y de la nave que contine
	 * 
	 * @param x
	 *            Parametros de busqueda,
	 * @param y
	 *            coordenadas en la pantalla
	 * @return La posicion del nodo
	 */
	public int buscarNodo(int x, int y) {
		int posicion = 0;
		NodoSimple aux = inicio;
		while (aux != null) {
			if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 && y <= aux.getEnemigo().getY()
					&& aux.getEnemigo().getY() <= y + 10) {
				return posicion;
			}
			posicion++;
			aux = aux.getSiguiente();
		}
		return -2;// indica que no hay nadie en esa posicion.
	}

	/**
	 * LLega hasta el ultimo nodo y devuelve su valor
	 * 
	 * @return
	 */
	public NaveEnemigo ultimo() {
		if (inicio != null) {
			NodoSimple aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux.getEnemigo();
		}
		return null;
	}

	/**
	 * Verifica si la lista esta vacia
	 * 
	 * @return true si esta vacida
	 */
	public boolean esVacida() {
		return inicio == null;
	}

	/**
	 * @return El tamano de la lista
	 */
	public int getTamano() {
		return tamano;
	}

	/**
	 * @return Entrega el primer nodo que contiene
	 */
	public NodoSimple getInicio() {
		return inicio;
	}

	/**
	 * Permite borrar la lista
	 */
	public void EliLista() {
		this.inicio = null;
		this.tamano = 0;

	}
}
