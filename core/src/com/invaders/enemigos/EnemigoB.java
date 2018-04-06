package com.invaders.enemigos;

import com.christian.invaders.Disparo;
import com.christian.invaders.MainInvaders;

public class EnemigoB {
	private NodoDoble inicio;
	private int tamano;
	
	public EnemigoB() {
		this.inicio = null;
		this.tamano = 0;
	}
	public void agregarAlfinal(int vida, int x, int y) {
		NodoDoble nuevo = new NodoDoble(vida, x, y);
		if (esVacida()) {                                                                                                                                                   
			inicio = nuevo;
		} else {
			NodoDoble aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);
		}
		tamano++;
	}
	public void renderLista(int x, int y) {
		if (inicio != null) {
			destruirEnemeigo(x, y);
			//moverJefe( (int) (Math.random() * getTamano()));
			mover();
			NodoDoble aux = inicio;
			if (obtenerJefe() == true) {
				while (aux != null) {
					MainInvaders.batch.draw(aux.getEnemigo().nave, aux.getEnemigo().x, aux.getEnemigo().y);
					aux = aux.getSiguiente();
				}
			}
			else {
				inicio = null;
			}
		}
	}
	protected int ext = 1; // bandera que indica si esta en un extremo
	public void mover() {
		if (inicio != null) {
			NodoDoble aux = inicio;
			if (ultimo().getX() >= 1100) {
				ext = -1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 24);
					aux = aux.getSiguiente();
				}
				aux = inicio;
			}  
			while (aux != null) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext);
				aux = aux.getSiguiente();
			}
		}
	}

	public void destruirEnemeigo(int x, int y) {
		if (x <= inicio.getEnemigo().getX() && inicio.getEnemigo().getX() <= x + 40 && y <= inicio.getEnemigo().getY()
				&& inicio.getEnemigo().getY() <= y + 10) {
			inicio.getEnemigo().disminuirVida();
			if (inicio.getEnemigo().getVida() == 0) { 
				if (inicio.getSiguiente() == null) {
					inicio = null;
				} else {
					inicio = inicio.getSiguiente();
					inicio.setAnterior(null);
				}
				this.tamano--;
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		}
		if (tamano != 1) {
			NodoDoble aux = inicio;
			while (aux != null) {
				if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 && y <= aux.getEnemigo().getY()
						&& aux.getEnemigo().getY() <= y + 10) {
					aux.getEnemigo().disminuirVida();
					if (aux.getEnemigo().getVida() == 0) {
						aux.getAnterior().setSiguiente(aux.getSiguiente());
						if (aux.getSiguiente() != null) {
							aux.getSiguiente().setAnterior(aux.getAnterior());
						}
						this.tamano--;
					}
					Disparo.y = 720;
				}
				aux = aux.getSiguiente();
			}
		}
	}

	public int getTamano() {
		return tamano;
	}

	public NaveEnemigo ultimo(){
		if (inicio != null) {
			NodoDoble aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			return aux.getEnemigo();
		}
		return null;
	}
	private boolean esVacida() {
		return tamano == 0;
	
	}

	public void moverJefe(int pJefe) {
		System.out.println(pJefe);
		NodoDoble aux = inicio;
		NodoDoble jefe = null;
		while (jefe == null) {
			if (aux.getEnemigo().jefe == true) {
				jefe = aux;
				System.out.println(jefe);
				jefe.setAnterior(null); // Limpio las referencias
				jefe.setSiguiente(null); //
				if (aux.getAnterior() != null) {
					aux.getAnterior().setSiguiente(aux.getSiguiente());
				}
				if (aux.getSiguiente() != null) {
					aux.getSiguiente().setAnterior(aux.getAnterior());
				}
			} else {
				aux = aux.getSiguiente();
			}
		}
		aux = inicio;
		int p = 0; // Posicion en la que va a quedar el jefe
		while (p != pJefe) {
			aux.getSiguiente();
			p++;
		}
		if (p == 0) {
			aux.setAnterior(jefe);
			jefe.setSiguiente(aux);
		}
		if (p == getTamano()) {
			aux.setSiguiente(jefe);
			jefe.setAnterior(aux);
		} else {
			jefe.setAnterior(aux.getAnterior());
			jefe.setSiguiente(aux);
			aux.getAnterior().setSiguiente(jefe);
			aux.setAnterior(jefe);
		}
	}
	
	public boolean obtenerJefe() {
		NodoDoble aux = inicio;
		while (aux != null) {
			if (aux.getEnemigo().jefe == true && aux.getEnemigo().vida >= 0) {
				return true;
			}
			aux = aux.getSiguiente();
		}
		return false;
	}
}
