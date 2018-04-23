package com.invaders.listas;

import com.invaders.enemigos.NaveEnemigo;
import com.invaders.jugador.Jugador;

/**
 * Lista Doble, contiene operaciones para trabajar con los datos almacenados
 * 
 * @author Christian
 *
 */
public class ListaDoble {
	private NodoDoble inicio;
	private int tamano;

	public ListaDoble() {
		this.inicio = null;
		this.tamano = 0;
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
	public void agregarAlfinal(int vida, int x, int y) {
		NodoDoble nuevo = new NodoDoble(vida, x, y);
		if (esVacida()) {
			inicio = nuevo;
		} else {
			NodoDoble aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);
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
		if (posicion == 0) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) {
				Jugador.puntaje += inicio.getEnemigo().getPuntaje();
				if (inicio.getSiguiente() == null) {
					inicio = null;
				} else {
					inicio = inicio.getSiguiente();
					inicio.setAnterior(null);
				}
				tamano--;
				return true;
			}
		} else if (posicion < tamano && posicion > 0) {
			NodoDoble aux = inicio;
			for (int i = 0; i < posicion; i++) {
				aux = aux.getSiguiente();
			}
			aux.getEnemigo().disminuirVida();
			if (aux.getEnemigo().getVida() == 0) {
				Jugador.puntaje += aux.getEnemigo().getPuntaje();
				aux.getAnterior().setSiguiente(aux.getSiguiente());
				if (aux.getSiguiente() != null) {
					aux.getSiguiente().setAnterior(aux.getAnterior());
				}
				tamano--;
				return true;
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
		NodoDoble aux = inicio;
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
	 * @return El ultimo nodo que existe en la lista
	 */
	public NodoDoble ultimo() {
		if (inicio != null) {
			NodoDoble aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux;
		}
		return null;
	}

	/**
	 * Busca un valor de un nodo indicando una posicion
	 * 
	 * @param posicion
	 *            La posicon del nodo que se quiere buscar
	 * @return El valor del nodo
	 */
	public NaveEnemigo buscarNodo(int posicion) {
		NodoDoble aux = inicio;
		for (int i = 0; i < posicion; i++) {
			aux = aux.getSiguiente();
		}
		return aux.getEnemigo();

	}

	/**
	 * Permite agregar un nodo en una posicion indicada
	 * 
	 * @param valor
	 *            El dato a almacenar en el nodo
	 * @param posicion
	 *            La posicion en la que se quiere agregar
	 */
	public void insertar(NodoDoble valor, int posicion) {
		if (posicion < tamano && posicion >= 0) {
			if (posicion == (tamano--)) {
				valor.setAnterior(ultimo());
				valor.setSiguiente(null);
			}
			if (posicion == 0) {
				valor.setSiguiente(inicio);
				inicio.setAnterior(valor);
				inicio = valor;
			} else if (posicion != 0 && posicion != tamano--) {
				int p = 0;
				NodoDoble aux = inicio;
				while (p != posicion) { // llega hasta la posicion donde hay que insertar
					aux = aux.getSiguiente();
					p++;
				}
				aux.getAnterior().setSiguiente(valor);
				valor.setAnterior(aux.getAnterior());
				valor.setSiguiente(aux);
				aux.setAnterior(valor);
			}
		}
	}

	/**
	 * Verifica si la lista esta vacia
	 * 
	 * @return true si esta vacida
	 */
	private boolean esVacida() {
		return tamano == 0;

	}

	/**
	 * @return Entrega el primer nodo que contiene la lista
	 */
	public NodoDoble getInicio() {
		return inicio;
	}

	/**
	 * Elimina la lista
	 */
	public void EliLista() {
		this.inicio = null;
		this.tamano = 0;
	}

	/**
	 * @return El tamano de la lista
	 */
	public int getTamano() {
		return tamano;
	}

}
