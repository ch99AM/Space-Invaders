package com.invaders.enemigos;

import org.omg.CORBA.portable.IndirectionException;

import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.listas.ListaCirDoble;
import com.invaders.listas.NodoDoble;
import com.invaders.main.MainInvaders;
import com.invaders.main.PantallaJuego;

/**
 * Contiene los metodos para controlar al enemigo E
 * 
 * @author Christian
 */
public class EnemigoE extends EnemigoAbstract {

	private ListaCirDoble listaEnemigos;
	private int ext = 1; // Indica si la hilera llego a un extremo

	public EnemigoE(ListaCirDoble lista) {
		listaEnemigos = lista;
	}

	/**
	 * Actualiza cualquier cambio en la hilera de enemigos
	 * 
	 * @param x
	 *            Posicion del disparo en x
	 * @param y
	 *            Posicion del disparo en y
	 */
	public void renderLista(int x, int y) {
		int posicion = listaEnemigos.buscarNodo(x, y);
		if (posicion != -2) {
			System.out.println(posicion);
			if (listaEnemigos.eliminarNodo(posicion)) {
				agrupar(posicion);
			}
			Disparo.y = 720;
		}
		if (listaEnemigos.getTamano() != 0) {
			if (!verificarJefe()) {
				listaEnemigos.editarNodo((listaEnemigos.getTamano() / 2) - (listaEnemigos.getTamano() % 2));
			}
			// mover();
			girar();
			perder();
			NodoDoble aux = listaEnemigos.getInicio();
			for (int i = 0; i < listaEnemigos.getTamano(); i++) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * Busca la existencia de un jefe en la hilera
	 * 
	 * @return true si encuentra al jefe
	 */
	public boolean verificarJefe() {
		NodoDoble aux = listaEnemigos.getInicio();
		for (int i = 0; i < listaEnemigos.getTamano(); i++) {
			if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}

	/**
	 * Mueve la hilera de lado a lado y hacia abajo
	 */
	public void mover() {
		if (listaEnemigos.getInicio() != null) {
			NodoDoble aux = listaEnemigos.getInicio();
			if (listaEnemigos.getUltimo().getEnemigo().getX() >= 1100) {
				ext = -2;
				for (int i = 0; i < listaEnemigos.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 64);
					aux = aux.getSiguiente();
				}
				aux = listaEnemigos.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 2;
				for (int i = 0; i < listaEnemigos.getTamano(); i++) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 64);
					aux = aux.getSiguiente();
				}
				aux = listaEnemigos.getInicio();
			}
			for (int i = 0; i < listaEnemigos.getTamano(); i++) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext * PantallaJuego.getVel());
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * Indica si el enemigo no ha sido destruida
	 * 
	 * @return true si el enemigo no ha sido destruido
	 */
	public boolean existo() {
		return listaEnemigos.getTamano() != 0;
	}

	/**
	 * Agrupa los enemigo cuando una nave es destruida
	 * 
	 * @param posicion
	 *            La posicion del enemigo destruido
	 */
	public void agrupar(int posicion) {
		NodoDoble aux = listaEnemigos.getInicio();
		for (int i = 0; i < listaEnemigos.getTamano(); i++) {
			if (i >= posicion && listaEnemigos.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			} else if (listaEnemigos.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			aux = aux.getSiguiente();
		}
	}

	/**
	 * Evaula si el enemigo llega hasta abajo sin ser destruido Disminuye la vida al
	 * jugador cuando el enemigo llega hasta abajo
	 */
	public void perder() {
		if (listaEnemigos.getInicio().getEnemigo().getY() < 110) {
			listaEnemigos.EliLista();
			Jugador.perder();
		}
	}

	/**
	 * "Metodo que permite hacer girar el enemigo"
	 * 
	 * No sirve :(
	 */
	float angulo = 1;

	public void girar() {
		if (listaEnemigos.getInicio() != null) {
			if (angulo < 100) {
				NodoDoble aux = listaEnemigos.getInicio();
				int tempX = 1;
				int tempY = 1;
				float m = 1;
				System.out.println(m);
				for (int i = 0; i < listaEnemigos.getTamano(); i++) {
					if (aux.getEnemigo().jefe != true) {
						if (i < (listaEnemigos.getTamano() / 2)) {
							aux.getEnemigo().setX((aux.getEnemigo().getX() - tempX));
							float r = ((m * aux.getEnemigo().getX()) + 420);
							System.out.println(r);
							aux.getEnemigo().setY(r);
						} else {
							aux.getEnemigo().setX((aux.getEnemigo().getX() + tempX));
							float r = m * (aux.getEnemigo().getX() * -1) + 420;
							System.out.println(r);
							aux.getEnemigo().setY(r);
						}
					}
					aux = aux.getSiguiente();
				}
				tempX += 1;
				m += 1;
				angulo += 1;
			}
		}

	}

}
