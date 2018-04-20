package com.invaders.listas;

/**
 * Lista circular doble, contiene los metodos para manejar los datos en una
 * estructura circular doble
 * 
 * @author Christian
 *
 */
public class ListaCirDoble {

	private NodoDoble inicio;
	private NodoDoble ultimo;
	private int tamano;

	public ListaCirDoble() {

		this.inicio = null;
		this.ultimo = null;
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
	public void agregarAlFinal(int vida, int x, int y) {
		NodoDoble nuevo = new NodoDoble(vida, x, y);
		if (esVacida()) {
			inicio = nuevo;
			ultimo = nuevo;
			ultimo.setSiguiente(nuevo);
			inicio.setAnterior(nuevo);
		} else {
			ultimo.setSiguiente(nuevo);
			inicio.setAnterior(nuevo);
			nuevo.setAnterior(ultimo);
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
		if (posicion == 0) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) {
				ultimo.setSiguiente(inicio.getSiguiente());
				inicio.getSiguiente().setAnterior(ultimo);
				inicio = inicio.getSiguiente();
			}
			tamano--;
			return true;
		} else {
			NodoDoble aux = inicio;
			for (int i = 0; i < posicion; i++) {
				aux = aux.getSiguiente();
			}
			aux.getEnemigo().disminuirVida();
			if (aux.getEnemigo().getVida() == 0) {
				if (aux == ultimo) {
					aux.getAnterior().setSiguiente(aux.getSiguiente());
					aux.getSiguiente().setAnterior(aux.getAnterior());
					ultimo = aux.getAnterior();
				} else {
					aux.getAnterior().setSiguiente(aux.getSiguiente());
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
		if (tamano != 0) {
			NodoDoble aux = inicio;
			for (int i = 0; i < tamano; i++) {
				if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 && y <= aux.getEnemigo().getY()
						&& aux.getEnemigo().getY() <= y + 10) {
					return i;
				}
				aux = aux.getSiguiente();
			}
		}
		return -2;// indica que no hay nadie en esa posicion.
	}

	/**
	 * Busca un nodo y retorna el valor indicando la posicion
	 * 
	 * @param posicion
	 *            La posicion del nodo que busca
	 * @return Valor del nodo
	 */
	public NodoDoble buscarNodo(int posicion) {
		NodoDoble aux = inicio;
		for (int i = 0; i <= posicion; i++) {
			aux = aux.getSiguiente();
		}
		return aux;

	}

	/**
	 * Cambia el valor de un nodo indicando la posicion
	 * 
	 * @param posicion
	 *            La posicion del nodo a editar
	 */
	public void editar(int posicion) {
		buscarNodo(posicion).getEnemigo().coverEne();
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
	 * @return El primer nodo
	 */
	public NodoDoble getInicio() {
		return inicio;
	}

	/**
	 * Permite sustituir el nodo del inicio
	 * 
	 * @param valor
	 */
	public void setInicio(NodoDoble valor) {
		this.inicio = valor;
	}

	/**
	 * @return El tamano de la lista
	 */
	public int getTamano() {
		return tamano;
	}

	/**
	 * Borrar la lista
	 */
	public void EliLista() {
		this.inicio = null;
		this.tamano = 0;
		this.ultimo = null;

	}

	/**
	 * Edita el valor del nodo indicando la posicion
	 * 
	 * @param posicion
	 *            La posicion del nodo que se quiere editar
	 */
	public void editarNodo(int posicion) {
		if (posicion >= 0 && posicion < tamano) {
			if (posicion == 0) {
				inicio.getEnemigo().coverJefe();
			} else {
				NodoDoble aux = inicio;
				for (int i = 0; i <= posicion; i++) {
					aux = aux.getSiguiente();
				}
				aux.getEnemigo().coverJefe();
			}
		}
	}

	/**
	 * @return Devuelve el ultimo valor de la lista
	 */
	public NodoDoble getUltimo() {
		return ultimo;
	}

}
