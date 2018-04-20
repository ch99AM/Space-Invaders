package com.invaders.listas;

import com.invaders.jugador.Jugador;

/**
 * Lista Circular, contiene operaciones para el manejo del almacenaje de datos
 * en esta estructura.
 * 
 * @author Christian
 *
 */
public class ListaCircular {

	protected NodoSimple inicio;
	protected NodoSimple ultimo;
	protected int tamano;

	public ListaCircular() {
		inicio = null;
		ultimo = null;
		tamano = 0;
	}

	/**
	 * Agrega un nuevo nodo al final de lista
	 * 
	 * @param vida
	 *            Vida de la nave que se quiere crear
	 * @param x
	 *            Posiciones en las que se quiere crear
	 * @param y
	 *            x y y
	 */
	public void agregarAlFinal(int vida, int x, int y) {
		NodoSimple nuevo = new NodoSimple(vida, x, y);
		if (esVacia()) {
			inicio = nuevo;
			ultimo = nuevo;
			ultimo.setSiguiente(inicio);
		} else {
			ultimo.setSiguiente(nuevo);
			nuevo.setSiguiente(inicio);
			ultimo = nuevo;
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
		if (0 <= posicion && posicion < tamano) {
			if (posicion == 0) {
				inicio.getEnemigo().disminuirVida();
				if (inicio.getEnemigo().getVida() == 0) {
					Jugador.puntaje += inicio.getEnemigo().getPuntaje();
					inicio = inicio.getSiguiente();
					ultimo.setSiguiente(inicio);
					tamano--;
					return true;
				}
			} else {
				NodoSimple aux = inicio;
				for (int i = 0; i < posicion - 1; i++) {// Llego hasta la posicion antes del que queiero eliminar
					aux = aux.getSiguiente();
				}
				aux.getSiguiente().getEnemigo().disminuirVida();
				if (aux.getSiguiente().getEnemigo().getVida() == 0) {
					Jugador.puntaje += aux.getEnemigo().getPuntaje();
					if (aux.getSiguiente() == ultimo) {
						aux.setSiguiente(inicio);
						ultimo = aux;
					} else {
						NodoSimple siguiente = aux.getSiguiente();
						aux.setSiguiente(siguiente.getSiguiente());
					}
					tamano--;
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
		if (tamano != 0) {
			if (x <= inicio.getEnemigo().getX() && inicio.getEnemigo().getX() <= x + 40
					&& y <= inicio.getEnemigo().getY() && inicio.getEnemigo().getY() <= y + 10) {

				return 0;
			} else {
				int posicion = 1;
				NodoSimple aux = inicio.getSiguiente();
				while (aux != inicio) {
					if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40
							&& y <= aux.getEnemigo().getY() && aux.getEnemigo().getY() <= y + 10) {
						return posicion;
					}
					posicion++;
					aux = aux.getSiguiente();
				}
			}
		}
		return -2; // me indica que no hay nadie en esas coordenadas
	}

	/**
	 * Cambia el valor de un nodo indicando la posicion
	 * 
	 * @param posicion
	 *            La posicion del nodo a editar
	 */
	public void editarNodo(int posicion) {
		if (posicion >= 0 && posicion < tamano) {
			if (posicion == 0) {
				inicio.getEnemigo().coverJefe();
			} else {
				NodoSimple aux = inicio;
				for (int i = 0; i <= posicion; i++) {
					aux = aux.getSiguiente();
				}
				aux.getEnemigo().coverJefe();
			}
		}
	}

	/**
	 * Verifica si la lista esta vacia
	 * 
	 * @return true si esta vacida
	 */
	public boolean esVacia() {
		return inicio == null;
	}

	/**
	 * @return El tamano de la lista
	 */
	public int getTamano() {
		return tamano;
	}

	/**
	 * @return Entrega el primer nodo que contiene la lista
	 */
	public NodoSimple getInicio() {
		return inicio;
	}

	/**
	 * @return Da el ultimo nodo de la lista
	 */
	public NodoSimple getUltimo() {
		return ultimo;
	}

	/**
	 * Elimina la lista
	 */
	public void EliLista() {
		this.inicio = null;
		this.tamano = 0;

	}

}
