package com.invaders.niveles;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoC;
import com.invaders.enemigos.FactoryEnemigo;
import com.invaders.main.MainInvaders;

/**
 * Controla el nivel tres, crea distintos enemigos y aumenta la velocidad del
 * juego
 * 
 * @author Christian
 *
 */
public class NivelTres {

	private FactoryEnemigo getter;
	private EnemigoB enemigo1;
	private EnemigoC enemigo2;
	private EnemigoB enemigo3;
	private EnemigoC enemigo4;
	private EnemigoB enemigo5;

	private BitmapFont font;

	public NivelTres(BitmapFont font) {

		getter = new FactoryEnemigo();
		enemigo1 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo2 = (EnemigoC) getter.getEnemigo("EnemigoC");
		enemigo3 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo4 = (EnemigoC) getter.getEnemigo("EnemigoC");
		enemigo5 = (EnemigoB) getter.getEnemigo("EnemigoB");
		this.font = font;

	}

	/**
	 * Controla la forma en la que se muestran los enemigos, llama a la
	 * actualizacion de las hileras de enemigos
	 * 
	 * @param x
	 *            La posicon del disparo en x
	 * @param y
	 *            La posicion del disparo en y
	 */
	public void render(int x, int y) {
		font.draw(MainInvaders.batch, "Nivel Tres", 1050, 680);
		if (enemigo1.existo()) {
			enemigo1.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoBase", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoA", 600, 680);
		} else if (enemigo2.existo()) {
			enemigo2.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoA", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
		} else if (enemigo3.existo()) {
			enemigo3.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoB", 600, 680);
		} else if (enemigo4.existo()) {
			enemigo4.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
		} else if (enemigo5.existo()) {
			enemigo5.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "Siguiente Nivel", 600, 680);
		} else {
			font.draw(MainInvaders.batch, "FELICIDADES GANASTE", 500, 350);
		}
	}
}
