package com.invaders.enemigos;

import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.listas.ListaSort;
import com.invaders.listas.NodoSimple;
import com.invaders.main.MainInvaders;

/***
 * Contiene los metodos para controlar el enemigo D
 * 
 * @author Christian
 *
 */
public class EnemigoD extends EnemigoAbstract {

	public ListaSort listaSort;
	private int ext = 2;
	private int velocidad;

	public EnemigoD(int numE) {
		listaSort = new ListaSort();
		int d = 0;
		int nJefeD = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			int vida = (int) (Math.random() * 2) + 1;
			if (i == nJefeD) {
				listaSort.agregarAlFinal(4, d, 630);
			} else {
				listaSort.agregarAlFinal(vida, d, 630);
			}
			d += 70;
		}
		listaSort.bubbleSort();

		listaSort.listarvida();
	}

	/**
	 * Actualiza la hilera cuando se muestra en pantalla
	 * 
	 * @param x
	 *            Posicion del disparo en x
	 * @param y
	 *            Posicion del disparo en y
	 */
	public void renderLista(int x, int y) {
		int posicion = listaSort.buscarNodo(x, y);
		if (posicion != -2) {
			if (listaSort.eliminarNodo(posicion)) {
				agrupar(posicion);
				Disparo.y = 720;
			}
		}
		if (listaSort.getTamano() != 0) {
			if (!verificarJefe()) {
				listaSort.editarNodo((int) (Math.random() * (listaSort.getTamano() - 1)));
				// listaSort.bubbleSort();
			}
			mover();
			perder();
			NodoSimple aux = listaSort.getInicio();
			for (int i = 0; i < listaSort.getTamano(); i++) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * Busca si existe un jefe en la hilera
	 * 
	 * @return true si encuentra al jefe
	 */
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

	/**
	 * Mueve la hilera dee lado a lado y hacia abajo
	 */
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

	/**
	 * Agrupa las naves cuando una es destruida
	 * 
	 * @param posicion
	 *            La posicion del la nave destruida
	 */
	public void agrupar(int posicion) {
		NodoSimple aux = listaSort.getInicio();
		for (int i = 0; i < listaSort.getTamano(); i++) {
			if (i >= posicion && listaSort.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			} else if (listaSort.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			aux = aux.getSiguiente();
		}
	}

	/**
	 * Evalua si el enemigo llego hasta abajo sin ser destruido y disminuye la vida
	 * al jugador
	 */
	public void perder() {
		if (listaSort.getInicio().getEnemigo().getY() < 110) {
			listaSort.EliLista();
			Jugador.perder();
		}
	}

	/**
	 * Verifica si el enemigo ha sido eliminado
	 * 
	 * @return true si no ha sido destruido
	 */
	public boolean existo() {
		return listaSort.getTamano() != 0;
	}

}