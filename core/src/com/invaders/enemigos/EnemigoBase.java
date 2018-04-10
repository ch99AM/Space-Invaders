package com.invaders.enemigos;


import com.christian.invaders.MainInvaders;
import com.invaders.listas.ListaBase;
import com.invaders.listas.NodoSimple;

public class EnemigoBase {
	
	//protected NodoSimple inicio;
	//protected int tamano;

	public ListaBase listaEnemigos;
	protected float velocidad;

	public EnemigoBase() {
		listaEnemigos = new ListaBase();
		
		//this.inicio = null;
		//this.tamano = 0;
		// velocidad = 0.25; velocidad a la que se va a mover la nave
	}

	/*
	public void agregarAlfinal(int vida, int x, int y) {
		NodoSimple nuevo = new NodoSimple(vida, x, y);
		if (esVacida()) {                                                                                                                                                   
			inicio = nuevo;
		} else {
			NodoSimple aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
		tamano++;
	}
*/
	public void renderLista(int x, int y) {
		if (listaEnemigos.getInicio() != null) {
			destruirEnemeigo(x, y);
			mover();
			NodoSimple aux = listaEnemigos.getInicio();
			while (aux != null) {
				MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
				aux = aux.getSiguiente();
			}
		}
	}
	protected int ext = 1; // bandera que indica si esta en un extremo
	public void mover() {
		if (listaEnemigos.getInicio() != null) {
			NodoSimple aux = listaEnemigos.getInicio();
			if (listaEnemigos.ultimo().getX() >= 1100) {
				ext = -1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = listaEnemigos.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = listaEnemigos.getInicio();
			}  
			while (aux != null) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext);
				aux = aux.getSiguiente();
			}
		}
	}

	public void destruirEnemeigo(int x, int y) {
		listaEnemigos.eliminarNodo(x, y);
		/*
		if (x <= listaEnemigos.getInicio().getEnemigo().getX() && listaEnemigos.getInicio().getEnemigo().getX() <= x + 40 &&
				y <= listaEnemigos.getInicio().getEnemigo().getY() && listaEnemigos.getInicio().getEnemigo().getY() <= y + 10) {
			listaEnemigos.getInicio().getEnemigo().disminuirVida();
			if (listaEnemigos.getInicio().getEnemigo().getVida() == 0) { 
				if (listaEnemigos.getInicio().getSiguiente() == null) {
					listaEnemigos.setInicio(null);
				} else {
					listaEnemigos.setInicio(listaEnemigos.getInicio().getSiguiente());
				}
				listaEnemigos.setTamano(-1);
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		}
		if (tamano != 1) {
			NodoSimple aux = inicio;
			NodoSimple anterior = inicio;
			while (aux != null) {
				if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 && y <= aux.getEnemigo().getY()
						&& aux.getEnemigo().getY() <= y + 10) {
					aux.getEnemigo().disminuirVida();
					if (aux.getEnemigo().getVida() == 0) {
						NodoSimple enlace = aux.getSiguiente();
						anterior.setSiguiente(enlace);
						this.tamano--;
					}
					Disparo.y = 720;
				}
				anterior = aux;
				aux = aux.getSiguiente();
			}
		}
	*/}
/*
	public boolean esVacida() {
		return inicio == null;
	}

	public int getTamano() {
		return tamano;
	}
*/
	/*
	public NaveEnemigo ultimo(){
		if (inicio != null) {
			NodoSimple aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux.getEnemigo();
		}
		return null;
	}*/
}