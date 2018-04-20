package com.invaders.niveles;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.enemigos.EnemigoA;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoBase;
import com.invaders.enemigos.EnemigoC;
import com.invaders.enemigos.FactoryEnemigo;
import com.invaders.main.MainInvaders;

/**
 * Controla el nivel dos, crea distintos enemigos y aumenta la velocidad del
 * juego
 * 
 * @author Christian
 *
 */
public class NivelDos {

	private FactoryEnemigo getter;
	private EnemigoB enemigo1;
	private EnemigoA enemigo2;
	private EnemigoC enemigo3;
	private EnemigoB enemigo4;
	private EnemigoC enemigo5;

	private NivelTres N3;
	private BitmapFont font;

	public NivelDos(BitmapFont font) {

		N3 = new NivelTres(font);

		getter = new FactoryEnemigo();
		enemigo1 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo2 = (EnemigoA) getter.getEnemigo("EnemigoA");
		enemigo3 = (EnemigoC) getter.getEnemigo("EnemigoC");
		enemigo4 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo5 = (EnemigoC) getter.getEnemigo("EnemigoC");
		this.font = font;

	}

	/**
	 * Controla la forma en la que se muestran los enemigos, llama a la
	 * actualizacion de las hileras de enemigos
	 * 
	 * @param x
	 *            La posicion x del disparo
	 * @param y
	 *            La posicion y del disparo
	 */
	public void render(int x, int y) {
		if (enemigo1.existo()) {
			enemigo1.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoBase", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoA", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Dos", 1050, 680);
		} else if (enemigo2.existo()) {
			enemigo2.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoA", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Dos", 1050, 680);
		} else if (enemigo3.existo()) {
			enemigo3.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoB", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Dos", 1050, 680);
		} else if (enemigo4.existo()) {
			enemigo4.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Dos", 1050, 680);
		} else if (enemigo5.existo()) {
			enemigo5.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "Siguiente Nivel", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Dos", 1050, 680);
		} else {
			N3.render(x, y);
		}
	}
}
