package com.invaders.enemigos;

import com.christian.invaders.MainInvaders;
import com.invaders.jugador.Jugador;
import com.invaders.listas.ListaSort;
import com.invaders.listas.NodoSimple;

public class EnemigoD extends EnemigoAbstract {
	
	public ListaSort listaSort;
	
	public EnemigoD(int numE) {
		listaSort = new ListaSort();  
		
		int d = 0; // 
		int nJefeD = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			int vida =  (int) (Math.random() * 2) +1;
			if (i == nJefeD) {
				listaSort.agregarAlFinal(4, d, 630);
			}
			else {
				listaSort.agregarAlFinal(vida, d, 630);
			}
			d += 70;
		}
		listaSort.bubbleSort();
		listaSort.listarvida();
	}
	public void renderLista(int x , int y) {
		int posicion = listaSort.buscarNodo(x, y);
		if (posicion != -2) {
			listaSort.eliminarNodo(posicion);
		}
		if (listaSort.getTamano() != 0) {
			if (!verificarJefe()) {
				listaSort.editarNodo((int) (Math.random() * (listaSort.getTamano() - 1)));
				listaSort.bubbleSort();
			}
			mover();
			NodoSimple aux = listaSort.getInicio();
			for (int i = 0; i < listaSort.getTamano(); i++) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}
	
	public boolean verificarJefe() {
			NodoSimple aux = listaSort.getInicio();
			for (int i = 0; i < listaSort.getTamano(); i++) {
				if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
					return true;
				}
				aux = aux.getSiguiente();
			}
			return false;
	}
	
	private int ext = 2;
	public void mover() {
		if (listaSort.getInicio() != null) {
			NodoSimple aux = listaSort.getInicio();
			if (listaSort.getUltimo().getEnemigo().getX() >= 1100) {
				ext = -2;
				for (int i = 0; i < listaSort.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 32);
					aux = aux.getSiguiente();
				}
				aux = listaSort.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 2;
				for (int i = 0; i < listaSort.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 32);
					aux = aux.getSiguiente();
				}
				aux = listaSort.getInicio();
			} 
			for (int i = 0; i < listaSort.getTamano(); i++) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext);
				aux = aux.getSiguiente();
			}
		}
	}
	public void agrupar(int posicion) {
		NodoSimple aux = listaSort.getInicio();
		for (int i = 0; i < listaSort.getTamano(); i++) {
			if (i >= posicion && listaSort.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			}
			else if(listaSort.getTamano() > 1){
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			aux = aux.getSiguiente();
		}
	}
	public void perder() {
		if (listaSort.getInicio().getEnemigo().getY() < 110) {
			listaSort.EliLista();
			Jugador.perder();
		}
	}
}