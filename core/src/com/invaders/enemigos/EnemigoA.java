package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;

public class EnemigoA extends EnemigoBase {

	public EnemigoA() {
		super();
	}
	@Override
	public void renderLista(int x , int y) {
		if (inicio != null) {
			destruirEnemeigo(x, y);
			mover();
			NodoSimple aux = inicio;
			if (obtenerJefe()) {
				while (aux != null) {
					MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
					aux = aux.getSiguiente();
				}
			}
			else {
				inicio = null;
			}
		}
		
	}
	public boolean obtenerJefe() {
		NodoSimple aux = inicio;
		while (aux != null) {
			if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}
}

