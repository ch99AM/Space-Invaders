package com.invaders.enemigos;

import com.invaders.listas.ListaBase;
import com.invaders.listas.ListaCirDoble;
import com.invaders.listas.ListaCircular;
import com.invaders.listas.ListaDoble;
import com.invaders.listas.ListaSort;

/**
 * Fabrica de enemigos, simplifica la creacion de enemigos
 * 
 * @author Christian
 *
 */
public class FactoryEnemigo {

	public EnemigoAbstract getEnemigo(String tipo) {

		if (tipo == "EnemigoBase") {
			ListaBase listaEnemigos = new ListaBase();
			int a = 0; // Contador de posiciones para dibujar a los enemigos
			for (int i = 0; i <= 9; i++) {
				listaEnemigos.agregarAlfinal(1, a, 680);
				a += 70;
			}
			return new EnemigoBase(listaEnemigos);
		}
		if (tipo == "EnemigoA") {
			ListaBase listaEnemigos = new ListaBase();
			int b = 0;
			int nJefeA = (int) (Math.random() * 9); // saca la posicion del jefe
			for (int i = 0; i <= 9; i++) {
				if (i == nJefeA) {
					listaEnemigos.agregarAlfinal(4, b, 680);
				} else {
					listaEnemigos.agregarAlfinal(1, b, 680);
				}
				b += 70;
			}
			return new EnemigoA(listaEnemigos);

		}
		if (tipo == "EnemigoB") {
			ListaDoble listaB = new ListaDoble();
			int b = 0; //
			int nJefeB = (int) (Math.random() * 9); // saca la posicion del jefe
			for (int i = 0; i <= 9; i++) {
				if (i == nJefeB) {
					listaB.agregarAlfinal(4, b, 680);
				} else {
					listaB.agregarAlfinal(1, b, 680);
				}
				b += 70;
			}
			return new EnemigoB(listaB);

		}
		if (tipo == "EnemigoC") {
			ListaCircular listaC = new ListaCircular();
			int d = 0; 
			int nJefeC = (int) (Math.random() * 9); // saca la posicion del jefe
			for (int i = 0; i <= 9; i++) {
				if (i == nJefeC) {
					listaC.agregarAlFinal(4, d, 680);
				} else {
					listaC.agregarAlFinal(1, d, 680);
				}
				d += 70;
			}
			return new EnemigoC(listaC);

		}
		if (tipo == "EnemigoD") {
			ListaSort listaSort = new ListaSort();
			int d = 0;
			int nJefeD = (int) (Math.random() * 9); // saca la posicion del jefe
			for (int i = 0; i <= 9; i++) {
				int vida = (int) (Math.random() * 2) + 1;
				if (i == nJefeD) {
					listaSort.agregarAlFinal(4, d, 630);
				} else {
					listaSort.agregarAlFinal(vida, d, 630);
				}
				d += 70;
			}
			return new EnemigoD(listaSort);

		}
		if (tipo == "EnemigoE") {
			ListaCirDoble listaEnemigos = new ListaCirDoble();
			int numE = 6;
			int e = 840;
			for (int i = 0; i <= numE; i++) {
				if (i == 3) {
					listaEnemigos.agregarAlFinal(4, e, 420);
				} else {
					listaEnemigos.agregarAlFinal(1, e, 420);
				}
				e -= 70;
			}
			return new EnemigoE(listaEnemigos);

		}
		return null;

	}
}
