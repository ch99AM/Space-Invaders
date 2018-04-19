package com.invaders.enemigos;

import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.listas.ListaCirDoble;
import com.invaders.listas.NodoDoble;
import com.invaders.main.MainInvaders;

public class EnemigoE extends EnemigoAbstract{
	
	private ListaCirDoble listaEnemigos;
	private float velocidad;
	
	
	public EnemigoE(int numE) {
		numE = 6;
		listaEnemigos = new ListaCirDoble();
		
		int e = 350;
		for (int i = 0; i <= numE; i++) {
			if (i == 3) {
				listaEnemigos.agregarAlFinal(4, e, 420);
			}
			else {
				listaEnemigos.agregarAlFinal(1, e, 420);
			}
			e += 70;
		}
		velocidad = (float) 0.75;
	}
	public void renderLista(int x , int y) {
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
				listaEnemigos.editarNodo((listaEnemigos.getTamano()/2)-(listaEnemigos.getTamano()%2));
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
	
	private int ext = 2;
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
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext*velocidad);
				aux = aux.getSiguiente();
			}
		}
	}
	public boolean existo() {
		return listaEnemigos.getTamano() != 0;
	}
	public void agrupar(int posicion) {
		NodoDoble aux = listaEnemigos.getInicio();
		for (int i = 0; i < listaEnemigos.getTamano(); i++) {
			if (i >= posicion && listaEnemigos.getTamano() > 1) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			}
			else if(listaEnemigos.getTamano() > 1){
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			aux = aux.getSiguiente();
		}
	}
	public void perder() {
		if (listaEnemigos.getInicio().getEnemigo().getY() < 110) {
			listaEnemigos.EliLista();
			Jugador.perder();
		}
	}	

	public void girar() {
		if (listaEnemigos.getInicio() != null) {
			if (listaEnemigos.getInicio().getEnemigo().getX() < 560) {
				NodoDoble aux = listaEnemigos.getInicio();
				double angulo = 1; //grados
				double anguloRadianes = Math.toRadians(angulo);
				anguloRadianes = anguloRadianes % 1;
				for (int i = 0; i < listaEnemigos.getTamano(); i++) {
					if (aux.getEnemigo().jefe != true) {
						if (i < listaEnemigos.getTamano() / 2) {
							aux.getEnemigo().setX( (float) (aux.getEnemigo().getX() + 10*Math.cos(anguloRadianes)));
							aux.getEnemigo().setY((float) (aux.getEnemigo().getY() + 10*Math.cos(anguloRadianes)));
						}
						else {
							aux.getEnemigo().setX( (float) (aux.getEnemigo().getX() - 10*Math.cos(anguloRadianes)));
							aux.getEnemigo().setY( (float) (aux.getEnemigo().getY() - 10*Math.cos(anguloRadianes)));
							
						}
					}
					aux = aux.getSiguiente();
				}
				angulo += 1;
			}
			if (listaEnemigos.getInicio().getEnemigo().getX() > 559) {
				NodoDoble aux = listaEnemigos.getInicio();
				for (int i = 0; i < listaEnemigos.getTamano(); i++) {
					if (aux.getEnemigo().jefe != true) {
						aux.getEnemigo().setX(aux.getEnemigo().getX() + 1);
						aux.getEnemigo().setY(aux.getEnemigo().getY() - 1);
					}
					System.out.println("Hola");
					aux = aux.getSiguiente();
				}
			}
		}

	}
		
}


