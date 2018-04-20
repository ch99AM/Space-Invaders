package com.invaders.enemigos;

import com.invaders.jugador.Jugador;
import com.invaders.listas.NodoSimple;
import com.invaders.main.MainInvaders;

/**
 * Controla el enemigo tipo A, posee los metodos necesarios para el adecuado
 * uso.
 * 
 * @author Christian
 *
 */
public class EnemigoA extends EnemigoBase {

	public EnemigoA(int numE) {
		super(-50);
		int b = 0; //
		int nJefeA = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeA) {
				listaEnemigos.agregarAlfinal(4, b, 680);
			} else {
				listaEnemigos.agregarAlfinal(1, b, 680);
			}
			b += 70;
		}
	}

	/**
	 * Se encarga de actualizar los movimientos de las naves y hacer cualquier
	 * operacion cuando se esten mostrando en pantalla
	 */
	@Override
	public void renderLista(int x, int y) {
		if (listaEnemigos.getInicio() != null) {
			destruirEnemeigo(x, y);
			mover();
			NodoSimple aux = listaEnemigos.getInicio();
			perder();
			if (obtenerJefe()) {
				while (aux != null) {
					MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
					aux = aux.getSiguiente();
				}
			} else {
				Jugador.puntaje += (listaEnemigos.getTamano() - 1) * 10 + 15;
				listaEnemigos.EliLista();
			}
		}

	}

	/**
	 * Busca si existe el jefe en la hilera
	 * 
	 * @return true si hay un jefe, false si no lo encuentra
	 */
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

	/**
	 * Indica si el enemigo ha sido destruido
	 * 
	 * @return True si no esta destruido, False de los contrario
	 */
	public boolean existo() {
		return listaEnemigos.getInicio() != null;
	}
}
