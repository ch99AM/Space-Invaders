package com.invaders.enemigos;

import com.christian.invaders.Disparo;
import com.christian.invaders.MainInvaders;

public class ListaBase {
	protected NodoSimple inicio;
	protected int tamanio;

	protected float velocidad;

	public ListaBase() {
		this.inicio = null;
		this.tamanio = 0;
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
		tamanio++;
	}

	public void renderLista(int x, int y) {
		if (inicio != null) {
			destruirEnemeigo(x, y);
			mover();
			NodoSimple aux = inicio;
			while (aux != null) {
				MainInvaders.batch.draw(aux.getValor().nave, aux.getValor().x, aux.getValor().y);
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
					aux.getValor().setY(aux.getValor().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}
			if (aux.getValor().getX() <= 0) {
				ext = 1;
				while (aux != null) {
					aux.getValor().setY(aux.getValor().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}  
			while (aux != null) {
				aux.getValor().setX(aux.getValor().getX() + ext);
				aux = aux.getSiguiente();
			}
		}
	}

	public void destruirEnemeigo(int x, int y) {
		if (x - 30 <= inicio.getValor().getX() && inicio.getValor().getX() <= x + 30 && y <= inicio.getValor().getY()
				&& inicio.getValor().getY() <= y + 10) {
			inicio.getValor().disminuirVida(1);
			if (inicio.getValor().getVida() == 0) { 
				if (inicio.getSiguiente() == null) {
					inicio = null;
				} else {
					inicio = inicio.getSiguiente();
				}
				this.tamanio--;
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		}
		NodoSimple aux = inicio;
		NodoSimple anterior = inicio;
		while (aux != null) {
			if (x - 30 <= aux.getValor().getX() && aux.getValor().getX() <= x + 30 && y <= aux.getValor().getY()
					&& aux.getValor().getY() <= y + 10) {
				aux.getValor().disminuirVida(1);
				if (aux.getValor().getVida() == 0) { 
					NodoSimple enlace = aux.getSiguiente();
					anterior.setSiguiente(enlace);
					this.tamanio--;
				}
				Disparo.y = 720;
			}
			anterior = aux;
			aux = aux.getSiguiente();
		}
	}

	public boolean esVacida() {
		return inicio == null;
	}

	public int getTamanio() {
		return tamanio;
	}

	public NaveEnemigo ultimo(){
		if (inicio != null) {
			NodoSimple aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux.getValor();
		}
		return null;
	}
}