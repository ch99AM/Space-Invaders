package com.invaders.enemigos;


import com.christian.invaders.Disparo;
import com.christian.invaders.MainInvaders;
import com.invaders.listas.ListaDoble;
import com.invaders.listas.NodoDoble;

public class EnemigoB extends EnemigoAbstract {
	
	public ListaDoble listaB;
	private int tiempo;
	private float velocidad;
	
	
	public EnemigoB(int numE) {
		tiempo = 0;
		listaB = new ListaDoble();
		int b = 0; // 
		int nJefeB = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeB) {
				listaB.agregarAlfinal(4, b, 680);
			}
			else {
				listaB.agregarAlfinal(1, b, 680);
			}
			b += 70;
		}
		velocidad = (float)1.5;
	}

	public void renderLista(int x, int y) {
		destruirEnemeigo(x, y);
		NodoDoble inicio = listaB.getInicio();
		if (inicio != null && verificarJefe()) {
			if (tiempo % 50 == 0) {
				moverJefe((int) (Math.random() * listaB.getTamano()));
			}
			mover();
			NodoDoble aux = inicio;
			while (aux != null) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
		tiempo++;
	}
	
	protected int ext = 1; // bandera que indica si esta en un extremo
	public void mover() {
		NodoDoble inicio = listaB.getInicio();
		if (inicio != null) {
			NodoDoble aux = inicio;
			if (listaB.ultimo().getEnemigo().getX() >= 1100) {
				ext = -1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 40);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 40);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}  
			while (aux != null) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext*velocidad);
				aux = aux.getSiguiente();
			}
		}
	}

	public void destruirEnemeigo(int x, int y) {
		if (listaB.getInicio() != null) {
			int posicion = listaB.buscarNodo(x, y);
			if (posicion != -2) {
				listaB.eliminarNodo(posicion);;
				Disparo.y = 720;
			}
			if (!verificarJefe()) {
				listaB.setInicio(null);
			}
		}
	}
	
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
			}
			else {
				aux.getEnemigo().coverJefe();
				aux.getEnemigo().setVida(vidaJefe);
			}
		}
	}
	public int obtenerJefe() {
		NodoDoble aux = listaB.getInicio();
		int  vidaJefe = 0;
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
	public boolean existo() {
		return listaB.getTamano() != 0;
	}
}
