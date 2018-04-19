package com.invaders.main;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainInvaders extends Game {
	
	
	private Music music;
	Menu menu;
	
	public static SpriteBatch batch; // Para facilitar el dibujar figuras del juego

	@Override
	public void create () {
		
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("Game.wav", FileType.Internal));
		music.setVolume(0.5f);
		music.play(); 
		music.setLooping(true);
		
		menu = new Menu(this);
		
		batch = new SpriteBatch();
		
		setScreen(menu);
	}
	@Override
	public void pause() {
		music.pause();
	}
	@Override
	public void resume() {
		music.play(); 
	}
}	

