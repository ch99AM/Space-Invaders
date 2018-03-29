package com.christian.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class PantallaJug extends PantallaBase {	
	MainInvaders invaders;
	
	Texture naveJ;
	private int x;
	private int puntaje;
	private String nombre;
	private int vida;

	public PantallaJug(MainInvaders mainInvaders) {	
		super(mainInvaders);
		this.invaders = mainInvaders; 
		
		this.x = (invaders.fondo.getWidth()/2-30);
		naveJ = new Texture("naveJugador.png");
		this.vida = 3;
		this.nombre = "Christian";
		this.puntaje = 0;
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		x = mover();
		MainInvaders.batch.draw(naveJ, x, 0);
			
	}
	public int mover() {
		boolean der = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean izq = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		if (der != izq) {
			if (der == true && x < 1072) {
				this.x += 7;
			}
			else if(izq == true && x > 0){
				this.x -= 7;
			}
		}
		return x;
	}
	
	public int getX() {
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void show() {
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
