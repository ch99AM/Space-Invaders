package com.christian.invaders;

import com.invaders.enemigos.ListaBase;

public class PantallaEnemigo {

		private ListaBase listaEnemigos;
		
		
	public PantallaEnemigo(int numE) {
		
		listaEnemigos = new ListaBase();
		int a = 0;
		for (int i = 0; i <= numE; i++) {
			listaEnemigos.agregarAlfinal(1, a, 600);
			a += 70;
		}
		System.out.println(listaEnemigos.getTamanio());
	}
	
	public void render(int x, int y) {
		listaEnemigos.renderLista(x, y);
	}	
}
	

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	