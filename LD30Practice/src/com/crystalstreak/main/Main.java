package com.crystalstreak.main;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.crystalstreak.game.GameEngine;

public class Main {

	private GameEngine game;
	
	public Main() {
		initDisplay();
		
		game = new GameEngine();
	}
	
	private void initDisplay(){
		try{
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Ludum Dare 30 Practice");
			Display.create();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String args[]){
		new Main();
	}
	
}
