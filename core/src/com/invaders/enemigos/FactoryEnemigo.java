package com.invaders.enemigos;

/**
 * Fabrica de enemigos, simplifica la creacion de enemigos
 * 
 * @author Christian
 *
 */
public class FactoryEnemigo {

	public EnemigoAbstract getEnemigo(String tipo) {

		if (tipo == "EnemigoBase") {
			return new EnemigoBase(9);
		}
		if (tipo == "EnemigoA") {
			return new EnemigoA(9);

		}
		if (tipo == "EnemigoB") {
			return new EnemigoB(9);

		}
		if (tipo == "EnemigoC") {
			return new EnemigoC(9);

		}
		if (tipo == "EnemigoD") {
			return new EnemigoD(9);

		}
		if (tipo == "EnemigoE") {

		}
		return null;

	}
}
