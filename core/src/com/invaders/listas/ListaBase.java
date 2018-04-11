package com.invaders.listas;

import com.christian.invaders.Disparo;
import com.invaders.enemigos.NaveEnemigo;

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
	
	//Elimina a un nodo por el valores de posicion que se encuentran ahi
	public void eliminarNodo(int x, int y) {
		//Validacion por si es el primero 
		if (x <= inicio.getEnemigo().getX() && inicio.getEnemigo().getX() <= x + 40 &&
				y <= inicio.getEnemigo().getY() && inicio.getEnemigo().getY() <= y + 10) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) {// Por si el jefe esta de primero y su vida no es cero 
				if (inicio.getSiguiente() == null) {
					inicio = null;;
				} else {
					inicio = inicio.getSiguiente();
				}
				this.tamano --;
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		
		}
		else {
			if (tamano != 1) {
				NodoSimple destruir = buscarNodo(x, y); // Busco el enemgio anterior al que quiero destruir
				if (destruir != null) {
					destruir.getSiguiente().getEnemigo().disminuirVida();
					if (destruir.getSiguiente().getEnemigo().getVida() == 0) {
						destruir.setSiguiente(destruir.getSiguiente().getSiguiente());
						this.tamano--;
					}
					Disparo.y = 720;
				}
			}
		}
	}
	
	/**
	 * @param x  posicion del nave que contiene 
	 * @param y  el nodo
	 * @return La posicion del nodo
	 */
	public NodoSimple buscarNodo(int x , int y) {
		NodoSimple aux = inicio;
		while (aux.getSiguiente() != null) {
			if (x <= aux.getSiguiente().getEnemigo().getX() && aux.getSiguiente().getEnemigo().getX() <= x + 40 &&
					y <= aux.getSiguiente().getEnemigo().getY() && aux.getSiguiente().getEnemigo().getY() <= y + 10) {
			return 	aux;
			}
			aux = aux.getSiguiente();
		}
		return null;
	}
	/*
	// Busca nodo por posicion
	public NodoSimple buscarNumNodo(int numNodo) {
		NodoSimple aux = inicio;
		if (0 >= numNodo && numNodo <= tamano) {
			int cont = 0;
			while(cont != numNodo) {
				cont++;
				aux.getSiguiente();
			}
		}
		return aux;
	}*/
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

	public void setInicio(NodoSimple valor) {
		inicio = valor;
		
	}
	
}
