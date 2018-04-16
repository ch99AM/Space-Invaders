package com.invaders.listas;

import com.invaders.enemigos.NaveEnemigo;
import com.invaders.jugador.Jugador;

public class ListaBase {
	
	protected NodoSimple inicio;
	protected int tamano;
	
	public ListaBase() {
		this.inicio = null;
		this.tamano = 0;
	}
	
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
	
	//Elimina un nodo por la posicion en la que se encuentra.
	public boolean eliminarNodo(int posicion) {
		//Validacion por si es el primero 
		if (posicion == 0) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) {
				Jugador.puntaje += inicio.getEnemigo().getPuntaje();
				if (inicio.getSiguiente() == null) {
					inicio = null;;
				} else {
					inicio = inicio.getSiguiente();
				}
				this.tamano --;
				return true;
			}
		}
		else {
			if (posicion > 0 && posicion <= tamano) {
				NodoSimple aux = inicio;
				for (int i = 1; i < posicion; i++ ) {
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
	 * @param x   Parametros de busqueda,
	 * @param y    coordenadas en la pantalla
	 * @return  La posicion del nodo
	 */
	public int  buscarNodo(int x , int y) {
		int posicion = 0;
		NodoSimple aux = inicio;
		while (aux != null) {
			if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 &&
					y <= aux.getEnemigo().getY() && aux.getEnemigo().getY() <= y + 10) {
			return 	posicion;
			}
			posicion ++;
			aux = aux.getSiguiente();
		}
		return -2;// indica que no hay nadie en esa posicion.
	}
	
	// Devuelve la nave en la ultima posicion
	public NaveEnemigo ultimo(){
		if (inicio != null) {
			NodoSimple aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux.getEnemigo();
		}
		return null;
	}
	
	public boolean esVacida() {
		return inicio == null;
	}

	public int getTamano() {
		return tamano;
	}
	
	public NodoSimple getInicio() {
		return inicio;
	}

	public void EliLista() {
		this.inicio = null;
		
	}
}
