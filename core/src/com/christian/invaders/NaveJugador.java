
package com.christian.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class NaveJugador {
	private int puntaje;
	private String nombre;
	private int vida;
	private int x;
    
	public NaveJugador() {
		this.vida = 3;
		this.nombre = null;
	}
	

	public void mover() {
		boolean der = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean izq = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		if (der != izq) {
			if (der == true) {
				this.x ++;
			}
			else {
				this.x --;
			}
		}
	}
	/*public void render(final SpriteBatch batch) {
		//mover();
        batch.draw(naveJugador, this.x, 0);
	}*/
}

