package com.invaders.listas;

public class ListaSort extends ListaCircular {
	NodoSimple temp;
	NodoSimple anterior;
	float tempX;
	
	public ListaSort () {
		super();
		temp = null;
		anterior = null;
		tempX = 0;
	}
	
	public void bubbleSort() {
		NodoSimple aux = inicio;
		for (int j = 0; j < tamano; j++) {
			for (int i = 0; i < tamano ; i++ ) {
				System.out.println(aux.getEnemigo().getVida());
				System.out.println(aux.getSiguiente().getEnemigo().getVida());
				if (aux.getEnemigo().getVida() < aux.getSiguiente().getEnemigo().getVida()) {
					if (aux == inicio) {
						temp = inicio;
						tempX = inicio.getEnemigo().getX(); //Guardo la primera posicion antes de cambiarla .
						inicio = inicio.getSiguiente(); 
						temp.getEnemigo().setX(inicio.getEnemigo().getX());// Cambio de coordenada para que se dibuje de segundo.
						inicio.getEnemigo().setX(tempX); // Paso la coordenada para que se dibuje de primero.
						ultimo.setSiguiente(inicio); 			 ///	
						temp.setSiguiente(inicio.getSiguiente()); // Actualizo el puntero al nuevo inicio.
						inicio.setSiguiente(temp);				///
					}
					else {
						if (aux.getSiguiente() == ultimo) {
							temp = aux.getSiguiente();
							tempX = temp.getEnemigo().getX(); //Guardo la posicion antes de actualizarla.
							temp.getEnemigo().setX(aux.getEnemigo().getX());// Cambio de coordenada 
							aux.getEnemigo().setX(tempX); // Paso la coordenada para que se dibuje de primero.
							anterior.setSiguiente(temp);
							temp.setSiguiente(aux);
							aux.setSiguiente(inicio);
							ultimo = aux; //Actualizo al nuevo ultimo
						}else {
							temp = aux;
							NodoSimple tempNext = temp.getSiguiente();
							tempX = temp.getEnemigo().getX(); 
							temp.getEnemigo().setX(tempNext.getEnemigo().getX());// Cambio de coordenada para que se dibuje de segundo.
							tempNext.getEnemigo().setX(tempX); // Cambio a su nueva coordenada
							temp.setSiguiente(tempNext.getSiguiente());
							tempNext.setSiguiente(temp);
							anterior.setSiguiente(tempNext);
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
			System.out.println(aux.getEnemigo().getVida());
			aux.getSiguiente();
		}
	}
	
}
