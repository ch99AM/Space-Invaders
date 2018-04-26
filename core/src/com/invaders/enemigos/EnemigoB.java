package com.invaders.enemigos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Sound;
import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.listas.ListaDoble;
import com.invaders.listas.NodoDoble;
import com.invaders.main.MainInvaders;
import com.invaders.main.PantallaJuego;

/**
 * Contiene los metodos necesarios para el control del enemigo B
 * 
 * @author Christian
 *
 */
public class EnemigoB extends EnemigoAbstract {

	private ListaDoble listaB;
	private int tiempo;
	private int extremo = 1; // bandera que indica si esta en un extremo
	protected Sound destruido;

	public EnemigoB(ListaDoble lista) {
		tiempo = 0;
		this.listaB = lista;
		destruido = Gdx.audio.newSound(Gdx.files.getFileHandle("Sounds/destruido.ogg", FileType.Internal));
	}

	/**
	 * Permite actualizar la hilera de enemigos cuando se esten mostrando en
	 * pantalla
	 * 
	 * @param x
	 *            Posicion del disparo en x
	 * @param y
	 *            Posicion del disparo en y
	 */
	public void renderLista(int x, int y) {
		destruirEnemeigo(x, y);
		NodoDoble inicio = listaB.getInicio();
		if (inicio != null && verificarJefe()) {
			if (tiempo % 50 == 0) {
				moverJefe((int) (Math.random() * listaB.getTamano()));
			}
			mover();
			perder();
			NodoDoble aux = inicio;
			while (aux != null) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
		tiempo++;
	}

	/**
	 * Mueve la hilera de lado a lado y de hacia abajo cuando se encuentra en un
	 * extremo
	 */
	public void mover() {
		NodoDoble inicio = listaB.getInicio();
		if (inicio != null) {
			NodoDoble aux = inicio;
			if (listaB.ultimo().getEnemigo().getX() >= 1100) {
				extremo = -1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 64);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}
			if (aux.getEnemigo().getX() <= 0) {
				extremo = 1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 64);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}
			while (aux != null) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + extremo * PantallaJuego.getVel());
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * Destruye enemigos cuando las balas los impacta
	 * 
	 * @param x
	 *            Posicion del disparo en x
	 * @param y
	 *            Posicion del disparo en y
	 */
	public void destruirEnemeigo(int x, int y) {
		if (listaB.getInicio() != null) {
			int posicion = listaB.buscarNodo(x, y);
			if (posicion != -2) {
				if (listaB.eliminarNodo(posicion)) {
					agrupar(posicion);
					destruido.play();
				}
				Disparo.y = 720;
			}
			if (!verificarJefe()) {
				listaB.EliLista();
			}
		}
	}

	/**
	 * Permite intercambiar el jefe de posicion
	 * 
	 * @param pJefe
	 *            La nueva posicon del jefe
	 */
	public void moverJefe(int pJefe) {
		if (pJefe < listaB.getTamano()) {
			int vidaJefe = obtenerJefe();
			NodoDoble aux = listaB.getInicio();
			for (int i = 0; i < pJefe; i++) {
				aux = aux.getSiguiente();
			}
			if (pJefe == 0) {
				listaB.getInicio().getEnemigo().coverJefe();
				listaB.getInicio().getEnemigo().setVida(vidaJefe);
			} else {
				aux.getEnemigo().coverJefe();
				aux.getEnemigo().setVida(vidaJefe);
			}
		}
	}

	/**
	 * Busca el jefe y le extrae la vida, y cambia el enemigo a uno normal
	 * 
	 * @return La vida del jefe
	 */
	public int obtenerJefe() {
		NodoDoble aux = listaB.getInicio();
		int vidaJefe = 0;
		while (vidaJefe == 0) {
			if (aux.getEnemigo().jefe == true) {
				vidaJefe = aux.getEnemigo().getVida();
				aux.getEnemigo().coverEne();
			} else {
				aux = aux.getSiguiente();
			}
		}
		return vidaJefe;
	}

	/**
	 * Comprueba si existe el jefe en la hilera
	 * 
	 * @return true si existe jefe
	 */
	public boolean verificarJefe() {
		NodoDoble aux = listaB.getInicio();
		while (aux != null) {
			if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}

	/**
	 * Permite unir las naves de la hilera cuando una es destruida
	 * 
	 * @param posicion
	 *            La posicion del enemigo que se elimino
	 */
	public void agrupar(int posicion) {
		NodoDoble aux = listaB.getInicio();
		for (int i = 0; i < listaB.getTamano(); i++) {
			if (i >= posicion && listaB.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			} else if (listaB.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			aux = aux.getSiguiente();
		}
	}

	/**
	 * Comprueba de la hilera no a sido destruida
	 * 
	 * @return True si no todavia existe
	 */
	public boolean existo() {
		return listaB.getTamano() != 0 || listaB.getInicio() != null;
	}

	/**
	 * Evalua si el jugador pudo destruir todos los enemigos antes de llegar a la
	 * parte superior
	 */
	public void perder() {
		if (listaB.getInicio().getEnemigo().getY() < 100) {
			listaB.EliLista();
			Jugador.perder();
		}
	}
}
