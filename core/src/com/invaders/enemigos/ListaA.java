package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;

public class ListaA extends ListaBase {

	
	public ListaA() {
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
					MainInvaders.batch.draw(aux.getValor().nave, aux.getValor().x, aux.getValor().y);
					aux = aux.getSiguiente();
				}
			}
		}
		
	}
	public boolean obtenerJefe() {
		NodoSimple aux = inicio;
		while (aux != null) {
			if (aux.getValor().jefe == true && aux.getValor().vida >= 0) {
				System.out.println(aux.getValor().vida);
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}
}

