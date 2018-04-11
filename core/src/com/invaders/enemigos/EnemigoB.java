package com.invaders.enemigos;


import com.christian.invaders.MainInvaders;
import com.invaders.listas.ListaDoble;
import com.invaders.listas.NodoDoble;

public class EnemigoB {
	public ListaDoble listaB;
	
	/*
	private NodoDoble inicio;
	private int tamano;
	*/
	public EnemigoB() {
		listaB = new ListaDoble();
		/*
		this.inicio = null;
		this.tamano = 0;*/
	}/*
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
	}*/
	
	public void renderLista(int x, int y) {
		NodoDoble inicio = listaB.getInicio();
		if (inicio != null && verificarJefe()) {
			//moverJefe( (int) (Math.random() * (listaB.getTamano() - 1)));
			destruirEnemeigo(x, y);
			mover();
			NodoDoble aux = inicio;
			if (verificarJefe() == true) {
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
		NodoDoble inicio = listaB.getInicio();
		if (inicio != null) {
			NodoDoble aux = inicio;
			if (listaB.ultimo().getEnemigo().getX() >= 1100) {
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
		listaB.eliminarNodo(x, y);
		/*
		NodoDoble inicio = listaB.getInicio();
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
				listaB.setTamano(-1);
			}
			Disparo.y = 720;// Banderilla para hacer que el disparo desaparesca
		}
		if (listaB.getTamano() != 1) {
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
						listaB.setTamano(-1);
					}
					Disparo.y = 720;
				}
				aux = aux.getSiguiente();
			}
		}*/
	}
	
	public void moverJefe(int pJefe) {
		NodoDoble jefe = obtenerJefe(); 
		NodoDoble aux = listaB.getInicio();
		int p = 0; // Posicion en la que va a quedar el jefe
		while (p != pJefe) {
			p++;
			aux.getSiguiente();
		}
		if (p == 0) {
			aux.setAnterior(jefe);
			jefe.setSiguiente(aux);
		}
		if (p == (listaB.getTamano() - 1)) {
			aux.setSiguiente(jefe);
			jefe.setAnterior(aux);
		} /*
		else if  (p < listaB.getTamano() && p > 0){
			jefe.setAnterior(aux.getAnterior());
			jefe.setSiguiente(aux);
			aux.getAnterior().setSiguiente(jefe);
			aux.setAnterior(jefe);
		}*/
	}
	public NodoDoble obtenerJefe() {
		NodoDoble aux = listaB.getInicio();
		NodoDoble jefe = null;
		while (jefe == null) {
			if (aux.getEnemigo().jefe == true) {
				jefe = aux;
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
		return jefe;
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
}
