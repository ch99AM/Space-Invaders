package com.invaders.listas;

public class ListaSort extends ListaCircular {
	NodoSimple anterior;

	
	public ListaSort () {
		super();
	}
	
	public void bubbleSort() {
		for (int j = 0; j < tamano; j++) {
			NodoSimple aux = inicio;
			anterior = inicio;
			for (int i = 0; i < tamano; i++ ) {
				if (aux.getEnemigo().getVida() < aux.getSiguiente().getEnemigo().getVida()) {		
					if (aux == inicio) {
						ultimo.setSiguiente(inicio.getSiguiente());
						inicio.setSiguiente(inicio.getSiguiente().getSiguiente());
						inicio.getSiguiente().setSiguiente(inicio);
						inicio = inicio.getSiguiente();
					}
					else {
						if (aux.getSiguiente() == ultimo) {
							anterior.setSiguiente(aux.getSiguiente());
							aux.setSiguiente(aux.getSiguiente().getSiguiente());
							aux.getSiguiente().setSiguiente(aux);
							ultimo = aux;
						}
						else {
							anterior.setSiguiente(aux.getSiguiente());
							aux.setSiguiente(aux.getSiguiente().getSiguiente());
							aux.getSiguiente().setSiguiente(aux);
						}
					}
				}
				anterior = aux;
				aux = aux.getSiguiente();
			}
		}
	}
	public void listarvida() {
		NodoSimple aux = inicio;
		for (int i = 0; i < tamano; i++) {
			System.out.println("la vida de "+ i + " es "+aux.getEnemigo().getVida());
			aux = aux.getSiguiente();
		}
	}
	
}
