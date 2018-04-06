package com.invaders.enemigos;

import com.christian.invaders.Disparo;
import com.christian.invaders.MainInvaders;

public class EnemigoBase {
	protected NodoSimple inicio;
	protected int tamano;

	protected float velocidad;

	public EnemigoBase() {
		this.inicio = null;
		this.tamano = 0;
		// velocidad = 0.25; velocidad a la que se va a mover la nave
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

	public void renderLista(int x, int y) {
		if (inicio != null) {
			destruirEnemeigo(x, y);
			mover();
			NodoSimple aux = inicio;
			while (aux != null) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}
	protected int ext = 1; // bandera que indica si esta en un extremo
	public void mover() {
		if (inicio != null) {
			NodoSimple aux = inicio;
			if (ultimo().getX() >= 1100) {
				ext = -1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}  
			while (aux != null) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext);
				aux = aux.getSiguiente();
			}
		}
	}

	public void destruirEnemeigo(int x, int y) {
		if (x <= inicio.getEnemigo().getX() && inicio.getEnemigo().getX() <= x + 40 && y <= inicio.getEnemigo().getY()
				&& inicio.getEnemigo().getY() <= y + 10) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) { 
				if (inicio.getSiguiente() == null) {
					inicio = null;
				} else {
					inicio = inicio.getSiguiente();
				}
				this.tamano--;
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		}
		if (tamano != 1) {
			NodoSimple aux = inicio;
			NodoSimple anterior = inicio;
			while (aux != null) {
				if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 && y <= aux.getEnemigo().getY()
						&& aux.getEnemigo().getY() <= y + 10) {
					aux.getEnemigo().disminuirVida();
					if (aux.getEnemigo().getVida() == 0) {
						NodoSimple enlace = aux.getSiguiente();
						anterior.setSiguiente(enlace);
						this.tamano--;
					}
					Disparo.y = 720;
				}
				anterior = aux;
				aux = aux.getSiguiente();
			}
		}
	}

	public boolean esVacida() {
		return inicio == null;
	}

	public int getTamano() {
		return tamano;
	}

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
}