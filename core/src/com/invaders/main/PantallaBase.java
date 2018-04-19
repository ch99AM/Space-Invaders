package com.invaders.main;

import com.badlogic.gdx.Screen;

public abstract class PantallaBase implements Screen {
	private MainInvaders invaders;
	
	public PantallaBase(MainInvaders invaders) 
	{
		this.invaders = invaders;
	}
}
