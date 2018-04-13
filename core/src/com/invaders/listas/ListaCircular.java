package com.invaders.listas;

import com.christian.invaders.Disparo;

public class ListaCircular {
	
	protected NodoSimple inicio;
	protected NodoSimple ultimo;
	protected int tamano;
	
    public ListaCircular(){
        inicio = null;
        ultimo = null;
        tamano = 0;
    }
    public void agregarAlFinal(int vida, int x, int y){
    	NodoSimple nuevo = new NodoSimple (vida, x , y);
        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
            ultimo = nuevo;
        }
        tamano++;
    }
    
    // Elimina un nodo por su posicion
	public void eliminarNodo(int posicion) {
		if (0 <= posicion && posicion < tamano) {
			if (posicion == 0) {
				inicio.getEnemigo().disminuirVida();
				if (inicio.getEnemigo().getVida() == 0) {
					inicio = inicio.getSiguiente();
					ultimo.setSiguiente(inicio);
					tamano--;
				}
			} else {
				NodoSimple aux = inicio;
				for (int i = 0; i < posicion - 1; i++) {// Llego hasta la posicion antes del que queiero eliminar
					aux = aux.getSiguiente();
				}
				aux.getSiguiente().getEnemigo().disminuirVida();
				if (aux.getSiguiente().getEnemigo().getVida() == 0) {
					if (aux.getSiguiente() == ultimo) {
						aux.setSiguiente(inicio);
						ultimo = aux;
					} else {
						NodoSimple siguiente = aux.getSiguiente();
						aux.setSiguiente(siguiente.getSiguiente());
					}
				tamano--;
				}
			}
			Disparo.y = 720;
		}
	}
    // Retorna la posicon del nodo
	public int  buscarNodo(int x , int y) {
		if (tamano != 0) {
			if (x <= inicio.getEnemigo().getX() && inicio.getEnemigo().getX() <= x + 40
					&& y <= inicio.getEnemigo().getY() && inicio.getEnemigo().getY() <= y + 10) {

				return 0;
			} else {
				int posicion = 1;
				NodoSimple aux = inicio.getSiguiente();
				while (aux != inicio) {
					if (x <= aux.getEnemigo().getX() && aux.getEnemigo().getX() <= x + 40
							&& y <= aux.getEnemigo().getY() && aux.getEnemigo().getY() <= y + 10) {
						return posicion;
					}
					posicion++;
					aux = aux.getSiguiente();
				}
			}
		}
		return -2; // me indica que no hay nadie en esas coordenadas
	}
	
	//Convierte el nodo en un jefe
	public void editarNodo(int posicion) {
		if (posicion >= 0 && posicion < tamano ) {
			if (posicion == 0) {
				inicio.getEnemigo().coverJefe();
			}
			else {
				NodoSimple aux = inicio;
				for (int i = 0; i <= posicion; i++) {
					aux = aux.getSiguiente();
				}
				aux.getEnemigo().coverJefe();
			}
		}
	}
	
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamano(){
        return tamano;
    }
    public NodoSimple getInicio() {
    	return inicio;
    }
    public NodoSimple getUltimo() {
    	return ultimo;
    }

}
