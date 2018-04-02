package com.christian.invaders;

import com.invaders.enemigos.ListaA;
import com.invaders.enemigos.ListaBase;

public class PantallaEnemigo {

		private ListaBase listaBase;
		private ListaA listaA;
		
		
	public PantallaEnemigo(int numE) {
			
		listaBase = new ListaBase();
		int a = 0; // Contador de posiciones para dibujar a los enemigos
		for (int i = 0; i <= numE; i++) {
			listaBase.agregarAlfinal(1, a, 600);
			a += 70;
		}
		listaA  = new ListaA();
		int b = 0; // 
		int nJefe = (int) (Math.random() * numE); // saca la posicion del jefe
		System.out.println(nJefe);
		for (int i = 0; i <= numE; i++) {
			if (i == nJefe) {
				listaA.agregarAlfinal(3, b, 680);
			}
			else {
				listaA.agregarAlfinal(1, b, 680);
			}
			b +=70;
		}
	}
	
	public void render(int x, int y) {
		listaA.renderLista(x, y);
		listaBase.renderLista(x, y);
	}	
}
	

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	