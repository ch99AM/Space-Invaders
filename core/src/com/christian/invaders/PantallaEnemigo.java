package com.christian.invaders;

public class PantallaEnemigo extends PantallaBase {
		MainInvaders invaders;
		
		private float a, b; //Posicion x y y de los enemigos
		private ListaBase listaEnemigos;
		
		
	public PantallaEnemigo(MainInvaders mainInvaders) {
		// TODO Auto-generated constructor stub
		super(mainInvaders);
		this.invaders = mainInvaders;
		
		listaEnemigos = new ListaBase();
		for (int i = 0; i < 10; i++) {
			listaEnemigos.agregarAlfinal();
		}
		System.out.println(listaEnemigos.getTamanio());
		a = 0;
		b = 500;	
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		listaEnemigos.listar(a, b);
		a += 0.75;
		b -= 0.50;
		
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
