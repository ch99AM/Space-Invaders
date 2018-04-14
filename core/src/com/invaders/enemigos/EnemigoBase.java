package com.invaders.enemigos;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Sound;
import com.christian.invaders.Disparo;
import com.christian.invaders.MainInvaders;
import com.invaders.listas.ListaBase;
import com.invaders.listas.NodoSimple;

public class EnemigoBase extends EnemigoAbstract {

	protected ListaBase listaEnemigos;
	protected float velocidad;
	protected Sound destruido;

	public EnemigoBase(int numE) {
		listaEnemigos = new ListaBase();
		destruido = Gdx.audio.newSound( Gdx.files.getFileHandle("Sounds/StarGame.wav", FileType.Internal));
		
		int a = 0; // Contador de posiciones para dibujar a los enemigos
		for (int i = 0; i <= numE; i++) {
			listaEnemigos.agregarAlfinal(1, a, 680);
			a += 70;
		}		
		velocidad = (float) 1.25;
	}

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
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 40);
					aux = aux.getSiguiente();
				}
				aux = listaEnemigos.getInicio();
			}
			if (aux.getEnemigo().getX() <= 0) {
				ext = 1;
				while (aux != null) {
					aux.getEnemigo().setY(aux.getEnemigo().getY() - 40);
					aux = aux.getSiguiente();
				}
				aux = listaEnemigos.getInicio();
			}  
			while (aux != null) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + ext*velocidad);
				aux = aux.getSiguiente();
			}
		}
	}

	public void destruirEnemeigo(int x, int y) {
		int posicion = listaEnemigos.buscarNodo(x, y);
		if (posicion != -2) {
			listaEnemigos.eliminarNodo(posicion);
			agrupar(posicion);
			Disparo.y = 720;
			destruido.play();
		}
	}
	public boolean existo() {
		return listaEnemigos.getInicio() != null;
	}
	public void agrupar(int posicion) {
		NodoSimple aux = listaEnemigos.getInicio();
		for (int i = 0; i < listaEnemigos.getTamano(); i++) {
			if (i <= posicion) {
				aux.getEnemigo().setX(aux.getEnemigo().getX() + 35);
			}
			else {
				aux.getEnemigo().setX(aux.getEnemigo().getX() - 35);
			}
			aux = aux.getSiguiente();
		}
	}

}