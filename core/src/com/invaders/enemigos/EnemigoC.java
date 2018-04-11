package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;
import com.invaders.listas.ListaCircular;
import com.invaders.listas.NodoSimple;

public class EnemigoC {
	public ListaCircular listaC;
	
	public EnemigoC() {
		listaC = new ListaCircular();
	}
	public void renderLista(int x , int y) {
		int posicion = listaC.buscarNodo(x, y);
		if (posicion != -2) {
			listaC.eliminarNodo(posicion);
		}
		if (listaC.getTamano() != 0) {
			if (!verificarJefe()) {
				listaC.editarNodo((int) (Math.random() * (listaC.getTamano() - 1)));
			}
			mover();
			NodoSimple aux = listaC.getInicio();
			for (int i = 0; i < listaC.getTamano(); i++) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}

	public boolean verificarJefe() {
			NodoSimple aux = listaC.getInicio();
			for (int i = 0; i < listaC.getTamano(); i++) {
				if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
					return true;
				}
				aux = aux.getSiguiente();
			}
			return false;
	}
	
	private int ext = 1;
	public void mover() {
		if (listaC.getInicio() != null) {
			NodoSimple aux = listaC.getInicio();
			if (listaC.getUltimo().getEnemigo().getX() >= 1100) {
				ext = -1;
				for (int i = 0; i < listaC.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = listaC.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				for (int i = 0; i < listaC.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = listaC.getInicio();
			} 
			for (int i = 0; i < listaC.getTamano(); i++) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext);
				aux = aux.getSiguiente();
			}
		}
	}
}
