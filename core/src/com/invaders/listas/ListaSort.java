package com.invaders.listas;

/**
 * Permite ordenar una lista lista, con el algoritmi bubble sort
 * 
 * @author Christian
 *
 */
public class ListaSort extends ListaCircular {

	public ListaSort() {
		super();
	}

	/**
	 * Ordena la lista por la vida de las naves que estan en cada nodo
	 */
	public void bubbleSort() {
		float x = inicio.getEnemigo().getX();
		for (int j = 0; j < tamano; j++) {
			NodoSimple aux = inicio;
			NodoSimple anterior = null;
			;
			for (int i = 0; i < tamano; i++) {
				if (aux.getEnemigo().getVida() < aux.getSiguiente().getEnemigo().getVida()) {
					if (aux == inicio) {
						NodoSimple temp = sacarNodo(i);
						insertar(temp, i + 1);
						inicio = inicio.getSiguiente();
					} else {
						if (aux.getSiguiente() == ultimo) {
							NodoSimple temp = sacarNodo(i);
							insertar(temp, i + 1);
							inicio = inicio.getSiguiente();

						} else {

						}
					}
				}
				anterior = aux;
				aux = aux.getSiguiente();
			}
		}
		setterX(x);
	}

	/**
	 * Crea una lista con la vida de las naves
	 */
	public void listarvida() {
		NodoSimple aux = inicio;
		for (int i = 0; i < tamano; i++) {
			System.out.println("la vida de " + i + " es " + aux.getEnemigo().getVida());
			aux = aux.getSiguiente();
		}
	}

	/**
	 * @param x
	 */
	public void setterX(float x) {
		NodoSimple aux = inicio;
		for (int i = 0; i < tamano; i++) {
			aux.getEnemigo().setX(x);
			aux = aux.getSiguiente();
		}
	}

	/**
	 * Inserta un nodo indicando el valor y la posicion
	 * 
	 * @param valor
	 * @param posicion
	 */
	public void insertar(NodoSimple valor, int posicion) {
		NodoSimple aux = inicio;
		for (int i = 0; i < posicion; i++) {
			aux = aux.getSiguiente();
		}
		valor.setSiguiente(aux.getSiguiente());
		aux.setSiguiente(valor);
	}

	/**
	 * Saca el nodo de la posicon indicada
	 * 
	 * @param posicion
	 *            Posicion la que se quiere extrar el nodo
	 * @return El valor del nodo
	 */
	public NodoSimple sacarNodo(int posicion) {
		NodoSimple aux = inicio;
		for (int i = 0; i < posicion; i++) {
			aux = aux.getSiguiente();
		}
		aux.setSiguiente(aux.getSiguiente().getSiguiente());
		return aux.getSiguiente();
	}
}
