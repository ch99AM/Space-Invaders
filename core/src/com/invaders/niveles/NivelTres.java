package com.invaders.niveles;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.control.Servidor;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoC;
import com.invaders.enemigos.FactoryEnemigo;
import com.invaders.main.MainInvaders;
import com.invaders.main.PantallaJuego;

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
		PantallaJuego.setVel((float)2.50);
		font.draw(MainInvaders.batch, "Nivel Tres", 1050, 680);
		if (enemigo1.existo()) {
			enemigo1.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			Servidor.actualizar1("EnemigoB", "EnemigoC", "Nivel Tres");
		} else if (enemigo2.existo()) {
			enemigo2.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoB", 600, 680);
			Servidor.actualizar1("EnemigoC", "EnemigoB", "Nivel Tres");
		} else if (enemigo3.existo()) {
			enemigo3.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			Servidor.actualizar1("EnemigoB", "EnemigoC", "Nivel Tres");
		} else if (enemigo4.existo()) {
			enemigo4.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoB", 600, 680);
			Servidor.actualizar1("EnemigoC", "EnemigoB", "Nivel Tres");
		} else if (enemigo5.existo()) {
			enemigo5.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
			font.draw(MainInvaders.batch, "Fin", 600, 680);
			Servidor.actualizar1("EnemigoB", " Fin", "Nivel Tres");
		} else {
			font.draw(MainInvaders.batch, "FELICIDADES GANASTE", 500, 350);
			Servidor.actualizar1("","","Ganaste!!!!");
		}
	}
}
