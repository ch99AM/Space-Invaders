package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;
import com.invaders.listas.NodoSimple;

public class EnemigoA extends EnemigoBase {

	public EnemigoA() {
		super();
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
}

