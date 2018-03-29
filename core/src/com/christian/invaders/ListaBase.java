package com.christian.invaders;


public class ListaBase {
	private NodoSimple inicio;
	private int tamanio;

	public ListaBase() {
		this.inicio = null;
		this.tamanio = 0;
	}

	public void agregarAlfinal() {
		NodoSimple nuevo = new NodoSimple();
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

	public void listar(float a, float b) {
		float x = a;
		float y = b;
		NodoSimple aux = inicio;
		while(aux != null) {
			MainInvaders.batch.draw(aux.getValor(), x, y);
			x += 50;
			y -= 0;
			aux = (aux.getSiguiente());
		}
		System.out.println("Termine de dibujar");
	}	
	
	
	private boolean esVacida() {
		return inicio == null;
	}

	public int getTamanio() {
		return tamanio;
	}
}
