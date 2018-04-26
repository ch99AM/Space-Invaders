package com.invaders.niveles;

import java.util.MissingFormatArgumentException;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.control.Servidor;
import com.invaders.enemigos.EnemigoA;
import com.invaders.enemigos.EnemigoB;
import com.invaders.enemigos.EnemigoBase;
import com.invaders.enemigos.EnemigoC;
import com.invaders.enemigos.EnemigoD;
import com.invaders.enemigos.EnemigoE;
import com.invaders.enemigos.FactoryEnemigo;
import com.invaders.main.MainInvaders;
import com.invaders.main.PantallaJuego;

/**
 * Este objeto hace uso de los enemigos para crear varios de ellos y formar un
 * nivel con el que el jugador compita.
 * 
 * @author Christian
 *
 */
public class NivelUno {

	private FactoryEnemigo getter;
	private EnemigoBase enemigo1;
	private EnemigoA enemigo2;
	private EnemigoC enemigo3;
	private EnemigoB enemigo4;
	private EnemigoC enemigo5;
	private NivelDos N2;

	private BitmapFont font;

	// private EnemigoE enemigo6;

	public NivelUno(BitmapFont font) {

		N2 = new NivelDos(font);

		getter = new FactoryEnemigo();
		enemigo1 = (EnemigoBase) getter.getEnemigo("EnemigoBase");
		enemigo2 = (EnemigoA) getter.getEnemigo("EnemigoA");
		enemigo3 = (EnemigoC) getter.getEnemigo("EnemigoC");
		enemigo4 = (EnemigoB) getter.getEnemigo("EnemigoB");
		enemigo5 = (EnemigoC) getter.getEnemigo("EnemigoC");
		this.font = font;

		// enemigo6 = new EnemigoE();

	}

	/**
	 * Controla la forma en que se muestran los enemigos, llama a la actualizacion
	 * de las hileras
	 *
	 * @param x
	 *            Posicion del disparo en x
	 * @param y
	 *            Posicion del disparo en y
	 */
	public void render(int x, int y) {
		PantallaJuego.setVel((float)2);
		if (enemigo1.existo()) {
			enemigo1.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoBase", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoA", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Uno", 1050, 680);
			Servidor.actualizar1("EnemigoBase", "EnemigoA", "Nivel Uno");
		} else if (enemigo2.existo()) {
			enemigo2.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoA", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Uno", 1050, 680);
			Servidor.actualizar1("EnemigoA", "EnemigoC", "Nivel Uno");
		} else if (enemigo3.existo()) {
			enemigo3.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoB", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Uno", 1050, 680);
			Servidor.actualizar1("EnemigoC", "EnemigoB", "Nivel Uno");
		} else if (enemigo4.existo()) {
			enemigo4.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoB", 500, 680);
			font.draw(MainInvaders.batch, "EnemigoC", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Uno", 1050, 680);
			Servidor.actualizar1("EnemigoB", "EnemigoC", "Nivel Uno");
		} else if (enemigo5.existo()) {
			enemigo5.renderLista(x, y);
			font.draw(MainInvaders.batch, "EnemigoC", 500, 680);
			font.draw(MainInvaders.batch, "Siguiente Nivel", 600, 680);
			font.draw(MainInvaders.batch, "Nivel Uno", 1050, 680);
			Servidor.actualizar1("EnemigoC", "Siguiente Nivel", "Nivel Uno");
		} else {
			N2.render(x, y);
		}
	}
}
