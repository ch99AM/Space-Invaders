package com.invaders.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.invaders.jugador.Jugador;
import com.invaders.main.PantallaJuego;

/**
 * Clase para control y comunicacion con el celular que funciona como control
 * del juego
 * 
 * @author Christian
 *
 */
public class Servidor extends Thread {

	private final static int PORT = 21857;
	private static String infoJuego;
	private String seeMov;
	private String disparo;
	
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Servidor> Servidor iniciado");
			System.out.println("Servidor> En espera de cliente...");
			Socket socket;
			while (true) {
				socket = serverSocket.accept();

				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream output = new PrintStream(socket.getOutputStream());

				seeMov = input.readLine();
				disparo = input.readLine();

				output.flush();
				output.println(infoJuego);

				socket.close();
			}
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * Actualiza parte de la informacion que se envia al juego
	 * 
	 * @param puntaje
	 *            El puntaje acomulado por el juegador
	 * @param vida
	 *            El valor de vida que le queda al jugador
	 */
	public void actualizar(String puntaje, String vida) {
		String infoAux = "Ptn :" + puntaje + " Vida: " + vida;
		this.infoJuego = infoAux;
	}

	/**
	 * Completa la informacion completa que se le envia al control
	 * 
	 * @param enemigoActual
	 * @param enemigoSiguiente
	 * @param nivel
	 */
	public static void actualizar1(String enemigoActual, String enemigoSiguiente, String nivel) {
		String infoAux = infoJuego + "     " + enemigoActual + "------> " + enemigoSiguiente + "          " + nivel;
		infoJuego = infoAux;
	}

	/**
	 * Es un notificador para quien consulte si el control se movio hacia un lado
	 * 
	 * @return responde afirmativo en caso de haberce movido
	 */
	public String getSeeMov() {
		return seeMov;
	}

	/**
	 * Responde cuandos pregunta si alguien disparo
	 * 
	 * @return afirmativo en caso de haberce disparado
	 */
	public String getDisparo() {
		return disparo;
	}
}