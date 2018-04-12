package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;
import com.invaders.listas.ListaCircular;
import com.invaders.listas.NodoSimple;

public class EnemigoC extends EnemigoAbstract{
	private ListaCircular listaC;
	
	public EnemigoC(int numE) {
		listaC = new ListaCircular();
		
		int d = 0; // 
		int nJefeC = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeC) {
				listaC.agregarAlFinal(3, d, 680);
			}
			else {
				listaC.agregarAlFinal(1, d, 680);
			}
			d += 70;
		}
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
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 32);
					aux = aux.getSiguiente();
				}
				aux = listaC.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				for (int i = 0; i < listaC.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 32);
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
	public boolean existo() {
		return listaC.getInicio() != null;
	}
}
