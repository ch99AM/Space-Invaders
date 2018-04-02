package com.christian.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Disparo {
	
	public static int y; // para poder terner acceso desde los enemigos para quitar el diparo cuando los impacta.
	private int x;
	Texture bala;
	boolean disparado;	
	
	public Disparo() {
		bala = new Texture("bala.png");
		this.y = 700;
		this.disparado = false;
	}
	public void render() {		
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			this.disparado = true;
		}
		
		if (this.disparado) {
			MainInvaders.batch.draw(bala, x, y);
			if (this.y < 725) {
				this.y += 8;
			}
			else {
				this.disparado = false;
				this.x = 0;
				this.y = 700;
			}
		}
	}
	public void  setX(int x) {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			if ( y >= 700) {
				this.y = 80;
				this.x = x + 30;
			}
		}
	}
	
	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}	
	
	
	
	
	
	
	
	
	
	
	




/*
public class Disparo extends PantallaBase {
MainInvaders invaders;

private int y;
private int x;
Texture bala;
boolean disparado;	

public Disparo(MainInvaders mainInvaders) {
	super(mainInvaders);
	this.invaders = mainInvaders;

	bala = new Texture("bala.png");
	this.y = 700;
	this.disparado = false;
}

//@Override
public void render(float delta) {		
	if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
		this.disparado = true;
	}
	
	if (this.disparado) {
		MainInvaders.batch.draw(bala, x, y);
		if (this.y < 700) {
			this.y += 45 ;
		}
		else {
			this.disparado = false;
		}
	}
}

public void  setX(int x) {
	if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
		if ( y >= 700) {
			this.y = 80;
			this.x = x + 30;
		}
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
*/