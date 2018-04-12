package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;
import com.invaders.listas.NodoSimple;

public class EnemigoA extends EnemigoBase {
	
	
	public EnemigoA(int numE) {
		super(-10);
		int b = 0; // 
		int nJefeA = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeA) {
				listaEnemigos.agregarAlfinal(4, b, 680);
			}
			else {
				listaEnemigos.agregarAlfinal(1, b, 680);
			}
			b +=70;
		}
	}
	
	@Override
	public void renderLista(int x , int y) {
		if (listaEnemigos.getInicio() != null) {
			destruirEnemeigo(x, y);
			mover();
			NodoSimple aux = listaEnemigos.getInicio();
			if (obtenerJefe()) {
				while (aux != null) {
					MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
					aux = aux.getSiguiente();
				}
			}
			else {
				listaEnemigos.setInicio(null);
			}
		}
		
	}
	public boolean obtenerJefe() {
		NodoSimple aux = listaEnemigos.getInicio();
		while (aux != null) {
			if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}
	public boolean existo() {
		return listaEnemigos.getInicio() != null;
	}
}

