package com.christian.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fondo;
	Texture naveJ;
	private NaveJugador ju1;
	private int x;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fondo = new Texture("SpaceInvadersFondo.jpg");
		NaveJugador ju1 = new NaveJugador();	
		naveJ = new Texture("naveJugador.png");
		x = fondo.getWidth()/2-30;
	}

	@Override
	public void render () {
		boolean der = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean izq = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		if (der != izq) {
			if (der == true && x < 660) {

				this.x ++;
			}
			else if(izq == true && x > 0){
				this.x --;
			}
		}
		//ju1.mover();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(fondo, 0, 0);
		batch.draw(naveJ, x, 0);
		batch.end();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fondo.dispose();
		naveJ.dispose();
	}
}		
