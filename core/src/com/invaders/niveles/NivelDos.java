package com.invaders.niveles;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.enemigos.EnemigoA;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoBase;
import com.invaders.enemigos.EnemigoC;
import com.invaders.enemigos.FactoryEnemigo;
import com.invaders.main.MainInvaders;

public class NivelDos {

	
		private FactoryEnemigo getter;
		private EnemigoBase enemigo1;
		private EnemigoA enemigo2;
		private EnemigoC enemigo3;
		private EnemigoB enemigo4;
		private EnemigoC enemigo5;
		
		private NivelTres N3;
		private BitmapFont font;
		

		
	public NivelDos(BitmapFont font) {
		
		N3 = new NivelTres();
		
		getter = new FactoryEnemigo();
		enemigo1 = (EnemigoBase) getter.getEnemigo("EnemigoBase");
		enemigo2 =  (EnemigoA) getter.getEnemigo("EnemigoA");
		enemigo3 = (EnemigoC) getter.getEnemigo("EnemigoC");
		enemigo4 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo5 = (EnemigoC) getter.getEnemigo("EnemigoC");
		this.font = font;
		

	}
	
	public void render(int x, int y) {
			if(enemigo1.existo()) {
				enemigo1.renderLista(x, y);
				font.draw(MainInvaders.batch, "EnemigoBase", 500, 680);
				font.draw(MainInvaders.batch, "EnemigoA", 600, 680);
			}
			else if(enemigo2.existo()){
				enemigo2.renderLista(x, y);
				font.draw(MainInvaders.batch, "EnemigoA", 500, 680);
				font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			}
			else if(enemigo3.existo()) {
				enemigo3.renderLista(x, y);
				font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
				font.draw(MainInvaders.batch, "EnemigoB", 600, 680);
			}
			else if(enemigo4.existo()) {
				enemigo4.renderLista(x, y);
				font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
				font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			}
			else if(enemigo5.existo()) {
				enemigo5.renderLista(x, y);
				font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
				font.draw(MainInvaders.batch, "Siguiente Nivel", 600, 680);
			}
		else {
			//N3.render(x, y);
	}
	}
}
	
