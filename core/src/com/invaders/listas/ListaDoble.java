package com.invaders.listas;

import com.christian.invaders.Disparo;


public class ListaDoble {
	private NodoDoble inicio;
	private int tamano;
	
	public ListaDoble() {
		this.inicio = null;
		this.tamano = 0;
	}
	
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
	//Elimina Nodo por posicion de la nave
	public void eliminarNodo(int x, int y) {
		if (x <= inicio.getEnemigo().getX() && inicio.getEnemigo().getX() <= x + 40 && y <= inicio.getEnemigo().getY()
				&& inicio.getEnemigo().getY() <= y + 10) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) { 
				if (inicio.getSiguiente() == null) {
					inicio = null;
				} else {
					inicio = inicio.getSiguiente();
					inicio.setAnterior(null);
				}
				tamano --;
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		}
		else if (tamano != 1) {
			NodoDoble aux = inicio;
			while (aux != null) {
				if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 && y <= aux.getEnemigo().getY()
						&& aux.getEnemigo().getY() <= y + 10) {
					aux.getEnemigo().disminuirVida();
					if (aux.getEnemigo().getVida() == 0) {
						aux.getAnterior().setSiguiente(aux.getSiguiente());
						if (aux.getSiguiente() != null) {
							aux.getSiguiente().setAnterior(aux.getAnterior());
						}
						tamano--;
					}
					Disparo.y = 720;
				}
				aux = aux.getSiguiente();
			}
		}
		
	}
	
	public NodoDoble ultimo(){
		if (inicio != null) {
			NodoDoble aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux;
		}
		return null;
	}
	public void insertar(NodoDoble valor, int posicion) {
		if (posicion < tamano && posicion >= 0) {
			if (posicion == tamano--) {
				valor.setAnterior(ultimo());
				valor.setSiguiente(null);
			}
			if (posicion == 0) {
				valor.setSiguiente(inicio);
				inicio.setAnterior(valor);
			}
			else if (posicion != 0 && posicion != tamano--) {
				int p = 0;
				NodoDoble aux = inicio;
				while(p != posicion) { // llega hasta la posicion donde hay que insertar
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
	
	private boolean esVacida() {
		return tamano == 0;
	
	}

	public NodoDoble getInicio() {
		return inicio;
	}

	public void setInicio(NodoDoble inicio) {
		this.inicio = inicio;
	}
	
	public int getTamano() {
		return tamano;
	}
	
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

}
