package com.invaders.enemigos;

public class FactoryEnemigo {
	
	public EnemigoAbstract getEnemigo(String tipo) {
		
		if (tipo == "EnemigoBase") {
			return new EnemigoBase(9);
		}
		if(tipo == "EnemigoA") {
			return new EnemigoA(9);
			
		}
		if(tipo == "EnemigoB") {
			return new EnemigoB(9);
			
		}
		if(tipo == "EnemigoC") {
			return new EnemigoC(9);
			
		}
		if(tipo == "EnemigoD") {
			
		}
		if(tipo == "EnemigoE") {
			
		}
		return null;

	}
}
