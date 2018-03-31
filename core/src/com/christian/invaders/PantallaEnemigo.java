package com.christian.invaders;

import com.invaders.enemigos.ListaBase;

public class PantallaEnemigo extends PantallaBase {
		MainInvaders invaders;

		private ListaBase listaEnemigos;
		
		
	public PantallaEnemigo(MainInvaders mainInvaders, int numE) {
		super(mainInvaders);
		this.invaders = mainInvaders;
		
		listaEnemigos = new ListaBase();
		int a = 0;
		for (int i = 0; i <= numE; i++) {
			listaEnemigos.agregarAlfinal(1, a, 600);
			a += 70;
		}
		System.out.println(listaEnemigos.getTamanio());
	}
	
	public void render1(float delta, int x, int y) {
		listaEnemigos.renderLista(x, y);
	}	
	
	

		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
