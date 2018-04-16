package com.invaders.listas;


public class ListaCirDoble {
	
		private NodoDoble inicio;
		private NodoDoble ultimo;
		private int tamano;
		
		public ListaCirDoble() {
			
			this.inicio = null;
			this.ultimo = null;
			this.tamano = 0;
		}
		
		public void agregarAlfinal(int vida, int x, int y) {
			NodoDoble nuevo = new NodoDoble(vida, x, y);
			if (esVacida()) {                                                                                                                                                   
				inicio = nuevo;
				ultimo = nuevo;
				ultimo.setSiguiente(inicio);
				inicio.setAnterior(ultimo);
			} else {
				ultimo.setSiguiente(nuevo);
				inicio.setAnterior(nuevo);
				nuevo.setAnterior(ultimo);
				ultimo = nuevo;
			}
			tamano++;
		}
		//Elimina Nodo por posicion de la nave
		public boolean eliminarNodo(int posicion) {
			if (0 <= posicion & posicion < tamano) {
				if (posicion == 0) {
					inicio.getEnemigo().disminuirVida();
					if (inicio.getEnemigo().getVida() == 0) { 
						if (inicio.getSiguiente() == null) {
							inicio = null;
						} else {
							inicio = inicio.getSiguiente();
							inicio.setAnterior(ultimo);
						}
						tamano --;
						return true;
					}
				}
				else if (posicion < tamano && posicion > 0) {
					NodoDoble aux = inicio;
					for (int i = 0; i <= posicion; i++) {
						aux = aux.getSiguiente();
					}
					aux.getEnemigo().disminuirVida();
					if (aux.getEnemigo().getVida() == 0) {
						if (aux == ultimo) {
							ultimo.getAnterior().setSiguiente(inicio);
							ultimo = ultimo.getAnterior();
						}
						else {
							aux.getAnterior().setSiguiente(aux.getSiguiente());
							aux.getSiguiente().setAnterior(aux.getAnterior());
						}
						tamano--;
						return true;
					}
				}
			}
			return false;
		}
		
		public int  buscarNodo(int x , int y) {
			if (tamano != 0) {
				NodoDoble aux = inicio;
				for (int i = 0; i < tamano; i++) {
					if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40 &&
						y <= aux.getEnemigo().getY() && aux.getEnemigo().getY() <= y + 10) {
					return 	i;
					}
					aux = aux.getSiguiente();
				}
			}
			return -2;// indica que no hay nadie en esa posicion.
		}
		
		public NodoDoble buscarNodo(int posicion) {
			NodoDoble aux = inicio;
			for(int i = 0; i < posicion; i++) {
				aux= aux.getSiguiente();
			}
			return aux;
			
		}
		
		public void editar(int posicion){
			buscarNodo(posicion).getEnemigo().coverEne();
			
		}
		
		private boolean esVacida() {
			return tamano == 0;
		
		}
		public NodoDoble getInicio() {
			return inicio;
		}
		public void setInicio(NodoDoble valor) {
			this.inicio = valor;		
		}
		
		public int getTamano() {
			return tamano;
		}
}

