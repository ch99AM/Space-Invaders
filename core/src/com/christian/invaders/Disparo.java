package com.christian.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Disparo extends PantallaBase {
	MainInvaders invaders;
	
	private int x,y;
	Texture bala;
	boolean disparado;	
	
	public Disparo(MainInvaders mainInvaders) {
		super(mainInvaders);
		this.invaders = mainInvaders;
		
		Texture bala = new Texture("bala.png");
		this.y = 80;
		this.disparado = false;
	}
	@Override
	public void render(float delta) {
		this.disparado = true; 
		
		MainInvaders.batch.draw(bala, 30, this.y);
		y++;
		if (y == 100) {
			this.disparado =  false;
		}
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
