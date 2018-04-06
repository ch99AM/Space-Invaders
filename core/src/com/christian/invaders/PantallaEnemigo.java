package com.christian.invaders;

import com.invaders.enemigos.EnemigoA;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoBase;

public class PantallaEnemigo {

		private EnemigoBase enemigoBase;
		private EnemigoA enemigoA;
		private EnemigoB enemigoB;
		
		
		
	public PantallaEnemigo(int numE) {
			
		enemigoBase = new EnemigoBase();
		int a = 0; // Contador de posiciones para dibujar a los enemigos
		for (int i = 0; i <= numE; i++) {
			enemigoBase.agregarAlfinal(1, a, 480);
			a += 70;
		}
		enemigoA  = new EnemigoA();
		int b = 0; // 
		int nJefeA = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeA) {
				enemigoA.agregarAlfinal(4, b, 680);
			}
			else {
				enemigoA.agregarAlfinal(1, b, 680);
			}
			b +=70;
		}
		enemigoB = new EnemigoB();
		int c = 0; // 
		int nJefeB = (int) (Math.random() * numE); // saca la posicion del jefe
		for (int i = 0; i <= numE; i++) {
			if (i == nJefeB) {
				enemigoB.agregarAlfinal(4, c, 280);
			}
			else {
				enemigoB.agregarAlfinal(1, c, 280);
			}
			c += 70;
		}
	}
	
	public void render(int x, int y) {
		enemigoBase.renderLista(x, y);
		enemigoA.renderLista(x, y);
		enemigoB.renderLista(x, y);
	}	
}
	

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	