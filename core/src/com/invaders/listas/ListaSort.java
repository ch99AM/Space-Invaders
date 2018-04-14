package com.invaders.listas;

public class ListaSort extends ListaCircular {
	NodoSimple temp;
	NodoSimple anterior;
	float tempX;
	
	public ListaSort () {
		super();
		temp = null;
		tempX = 0;
	}
	
	public void bubbleSort() {
		for (int j = 0; j < tamano; j++) {
			NodoSimple aux = inicio;
			anterior = inicio;
			for (int i = 0; i < tamano ; i++ ) {
				if (aux.getEnemigo().getVida() < aux.getSiguiente().getEnemigo().getVida()) {
					if (aux == inicio) {
						temp = inicio.getSiguiente();
						tempX = inicio.getEnemigo().getX();
						ultimo.setSiguiente(inicio.getSiguiente());
						temp.getEnemigo().setX(inicio.getEnemigo().getX());
						inicio.setSiguiente(inicio.getSiguiente().getSiguiente());
						inicio.getEnemigo().setX(tempX);
						temp.setSiguiente(inicio);
						inicio = temp;
					}
					else {
						if (aux.getSiguiente() == ultimo) {
							temp = aux.getSiguiente();
							tempX = aux.getSiguiente().getEnemigo().getX();
							anterior.setSiguiente(aux.getSiguiente());
							temp.getEnemigo().setX(aux.getEnemigo().getX());
							aux.setSiguiente(inicio);
							aux.getEnemigo().setX(tempX);
							temp.setSiguiente(aux);
							ultimo = aux;
						}
						else {
							temp = aux.getSiguiente();
							tempX = aux.getSiguiente().getEnemigo().getX();
							anterior.setSiguiente(aux.getSiguiente());
							temp.getEnemigo().setX(aux.getEnemigo().getX());
							aux.setSiguiente(aux.getSiguiente().getSiguiente());
							aux.getEnemigo().setX(tempX);
							temp.setSiguiente(aux);
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
