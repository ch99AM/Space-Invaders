package com.invaders.enemigos;

import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.listas.ListaCircular;
import com.invaders.listas.NodoSimple;
import com.invaders.main.MainInvaders;

/**
 * Contiene los metodos para controlar el enemigo C segun sus funciones
 * 
 * @author Christian
 *
 */
public class EnemigoC extends EnemigoAbstract {

	private ListaCircular listaC;
	private float velocidad;
	private int ext = 2; // Bandera para mover hacia abajo la hilera

	public EnemigoC(int numE) {
		listaC = new ListaCircular();

		int d = 0; //
		int nJefeC = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeC) {
				listaC.agregarAlFinal(3, d, 680);
			} else {
				listaC.agregarAlFinal(1, d, 680);
			}
			d += 70;
		}
		velocidad = (float) 1.25;
	}

	/**
	 * Actualiza cualquier cambio que ocurra a la hilera cuando se esta mostrando en
	 * pantalla
	 * 
	 * @param x
	 *            Posicion del disparo en x
	 * @param y
	 *            Posicion del disparo en y
	 */
	public void renderLista(int x, int y) {
		int posicion = listaC.buscarNodo(x, y);
		if (posicion != -2) {
			if (listaC.eliminarNodo(posicion)) {
				agrupar(posicion);
			}
			Disparo.y = 720;
		}
		if (listaC.getTamano() != 0) {
			if (!verificarJefe()) {
				listaC.editarNodo((int) (Math.random() * (listaC.getTamano() - 1)));
			}
			mover();
			perder();
			NodoSimple aux = listaC.getInicio();
			for (int i = 0; i < listaC.getTamano(); i++) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * Busca si existe jefe en la hilera
	 * 
	 * @return true si existe
	 */
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

	/**
	 * Mueve la hilera de enemigos de lado a lado y hacia abajo
	 */
	public void mover() {
		if (listaC.getInicio() != null) {
			NodoSimple aux = listaC.getInicio();
			if (listaC.getUltimo().getEnemigo().getX() >= 1100) {
				ext = -2;
				for (int i = 0; i < listaC.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 64);
					aux = aux.getSiguiente();
				}
				aux = listaC.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 2;
				for (int i = 0; i < listaC.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 64);
					aux = aux.getSiguiente();
				}
				aux = listaC.getInicio();
			}
			for (int i = 0; i < listaC.getTamano(); i++) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext * velocidad);
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * Permite saber si el enemigo no ha sido eliminado
	 * 
	 * @return True si el enemigo existe
	 */
	public boolean existo() {
		return listaC.getTamano() != 0;
	}

	/**
	 * Agrupa los enemigos cuando uno es destruido
	 * 
	 * @param posicion
	 *            La posicion del enemigo destruido
	 */
	public void agrupar(int posicion) {
		NodoSimple aux = listaC.getInicio();
		for (int i = 0; i < listaC.getTamano(); i++) {
			if (i >= posicion && listaC.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			} else if (listaC.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			aux = aux.getSiguiente();
		}
	}

	/**
	 * Evalua si el enemigo llego hasta abajo sin ser desrtuido y disminuye una vida
	 * al jugador
	 */
	public void perder() {
		if (listaC.getInicio().getEnemigo().getY() < 110) {
			listaC.EliLista();
			Jugador.perder();
		}
	}
}
