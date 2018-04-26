package com.invaders.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.invaders.control.Servidor;
import com.invaders.jugador.Disparo;
import com.invaders.jugador.Jugador;
import com.invaders.niveles.NivelUno;

/**
 * Clase que controla todo el juego Se encarga de ejecutar el juego completo y
 * mostrar en pantalla la salida para el jugador
 * 
 * @author Christian
 *
 */
public class PantallaJuego extends PantallaBase {
	MainInvaders invaders;
	Texture fondo;
	private Sound gameOver;
	private BitmapFont font;
	private Jugador ju1;
	private Disparo disparo;
	private NivelUno N1;
	private Servidor servidor;
	private static float velocidad;
	
	
	/**
	 * Contructor Inicia los componetes necesarios para que el juego funcione
	 * 
	 * @param mainInvaders
	 *            Una instancia del nucleo en el que esta desarrollodo el juego.
	 */
	public PantallaJuego(MainInvaders mainInvaders) {
		super(mainInvaders);
		this.invaders = mainInvaders;

		font = new BitmapFont();

		fondo = new Texture("Space.jpg");
		gameOver = Gdx.audio.newSound(Gdx.files.getFileHandle("Sounds/GameOver.wav", FileType.Internal));

		ju1 = new Jugador();
		disparo = new Disparo();
		N1 = new NivelUno(font);

		servidor = new Servidor();
		servidor.start();
	}

	/**
	 * Este metodo se ejecuta cada nuevo fotograma que se muestra en la pantalla Se
	 * ejecuta por defecto al implemetar AbstractPantalla
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0.15f);

		MainInvaders.batch.begin();
		
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			servidor.stop();
			Menu menu = new Menu(invaders);
			invaders.setScreen(menu);
		}
		
		MainInvaders.batch.draw(fondo, 0, 0);

		String StrPuntaje = Integer.toString(Jugador.puntaje);
		String StrVida = Integer.toString(Jugador.getVida());
		font.draw(MainInvaders.batch, "Ptns: " + StrPuntaje, 0, 680);
		font.draw(MainInvaders.batch, "Vida: " + StrVida, 100, 680);
		servidor.actualizar(StrPuntaje, StrVida);

		if (Jugador.getVida() > 0) {
			disparo.setX(ju1.getX(), false);
			control();
			ju1.renderJugador();
			disparo.render();
			N1.render(disparo.getX() - 30, disparo.getY());
		} else {
			servidor.stop();
			Menu menu = new Menu(invaders);
			invaders.setScreen(menu);
			gameOver.play(50f);
		}
		MainInvaders.batch.end();
	}

	/**
	 * a se rec Se encarga de tratar la informacion del control cuando este
	 * convectado
	 */
	public void control() {
		if (servidor.getDisparo() != null) {
			System.out.println(servidor.getDisparo());
			if (servidor.getDisparo().equals("true")) {
				disparo.setX(ju1.getX(), true);
				disparo.ctrDisparado(true);
			}
			if (servidor.getSeeMov().equals("derecha")) {
				ju1.moverAux(true, false);
			} else if (servidor.getSeeMov().equals("izquierda")) {
				ju1.moverAux(false, true);
			}
		}
	}

	/**
	 * Se encarga de borrar los datos que java no hace cuando el juego se cierre
	 */
	@Override
	public void dispose() {
		fondo.dispose();
		servidor.stop();
	}

	/**
	 * @return Da la velocidad a la que debe ir el juego
	 */
	public static float getVel() {
		return velocidad;
	}

	/**
	 * @param vel
	 *            Permite cambiar la velocidad del juego cuando se sube de nivel
	 */
	public static void setVel(float vel) {
		velocidad = vel;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}
}
