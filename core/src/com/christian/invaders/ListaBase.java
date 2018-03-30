package com.christian.invaders;


public class ListaBase {
	private NodoSimple inicio;
	private int tamanio;
	
	private double velocidad;
	private int x,y;

	public ListaBase() {
		this.inicio = null;
		this.tamanio = 0;
		this.y = 400;
		velocidad = 0.05;
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
		tamanio++;
	}

	public void renderLista() {
		mover();
		NodoSimple aux = inicio;
		while(aux != null) {
			MainInvaders.batch.draw(aux.getValor().nave, aux.getValor().x, aux.getValor().y);
			aux = aux.getSiguiente();
		}
	}	
	
	private int ext = 1; // bandera que me indica si esta en un extremo
	public void mover() {
		
		NodoSimple aux = inicio;
		if (aux.getValor().getX() >= 468) {
			ext = -1;
			while (aux != null) {
				aux.getValor().setY(aux.getValor().getY() - 15);
				aux = aux.getSiguiente();
			}
			aux = inicio;
		}
		if (aux.getValor().getX() == -20) {
			ext = 1;
			while (aux != null) {
				aux.getValor().setY(aux.getValor().getY() - 15);
				aux = aux.getSiguiente();
			}
			aux = inicio;
		}
		while (aux != null) {
			aux.getValor().setX(aux.getValor().getX() + ext);
			aux = aux.getSiguiente();
		}
	}
	
	
	private boolean esVacida() {
		return inicio == null;
	}

	public int getTamanio() {
		return tamanio;
	}
	
	//Busca el valor de un nodo en una posicion
	public NaveEnemigo buscarNodo(int nNodo) {
		NodoSimple aux = inicio;
		int num = 0;
		while (num != nNodo) {
			aux = aux.getSiguiente();
			num++;
		}
		return aux.getValor();
		
	}
}
