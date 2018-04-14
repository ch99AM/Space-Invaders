package com.christian.invaders;

import com.invaders.enemigos.EnemigoA;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoBase;
import com.invaders.enemigos.EnemigoC;
import com.invaders.enemigos.EnemigoD;
import com.invaders.enemigos.FactoryEnemigo;

public class NivelUno {

	
		private FactoryEnemigo getter;
		private EnemigoBase enemigo1;
		private EnemigoA enemigo2;
		private EnemigoC enemigo3;
		private EnemigoB enemigo4;
		private EnemigoC enemigo5;
		
		private EnemigoD enemigo6;
		
	public NivelUno() {
		
		
		
		getter = new FactoryEnemigo();
		enemigo1 = (EnemigoBase) getter.getEnemigo("EnemigoBase");
		enemigo2 =  (EnemigoA) getter.getEnemigo("EnemigoA");
		enemigo3 = (EnemigoC) getter.getEnemigo("EnemigoC");
		enemigo4 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo5 = (EnemigoC) getter.getEnemigo("EnemigoC");
				
		enemigo6 = (EnemigoD) getter.getEnemigo("EnemigoD");
		

	}
	
	public void render(int x, int y) {
		/*
		if(enemigo1.existo()) {
			enemigo1.renderLista(x, y);
		}
		else if(enemigo2.existo()){
			enemigo2.renderLista(x, y);
		}
		else if(enemigo3.existo()) {
			enemigo3.renderLista(x, y);
		}
		else if(enemigo4.existo()) {
			enemigo4.renderLista(x, y);			
		}
		else if(enemigo5.existo()) {
			enemigo5.renderLista(x, y);
		}*/
		enemigo6.renderLista(x, y);
	}
}
	
//enemigoB = new EnemigoB(9);

/*
int c = 0; // 
int nJefeB = (int) (Math.random() * numE); // saca la posicion del jefe
for (int i = 0; i <= numE; i++) {
	if (i == nJefeB) {
		enemigoB.listaB.agregarAlfinal(4, c, 280);
	}
	else {
		enemigoB.listaB.agregarAlfinal(1, c, 280);
	}
	c += 70;
}*/
/*
enemigoD = new EnemigoD();
int e = 0; // 
int nJefeD = (int) (Math.random() * numE); // saca la posicion del jefe
for (int i = 0; i <= numE; i++) {
	int vida =  (int) (Math.random() * 2) +1;
	if (i == nJefeD) {
		enemigoD.listaSort.agregarAlFinal(4, e, 580);
	}
	else {
		enemigoD.listaSort.agregarAlFinal(vida, e, 580);
	}
	e += 70;
}*/
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	