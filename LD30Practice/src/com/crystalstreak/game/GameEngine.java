package com.crystalstreak.game;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GameEngine {

	//Engine Variables
	private int fps;
	private long lastFPS;
	private long lastFrame;
	
	//Game
	private Game game;
	
	public GameEngine() {
		initGL();
		
		getDelta();
		lastFPS = getTime();
		
		game = new Game();
		
		while(!Display.isCloseRequested()){
			int delta = getDelta();
			
			update(delta);
			render();
			Display.update();
			Display.sync(120);
		}
		Display.destroy();
	}
	
	private void initGL(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glOrtho(0, 1280, 720, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private void update(int delta){
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			Display.destroy();
			System.exit(0);
		}
		
		game.update(delta);
		updateFPS();
	}
	
	public void render(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		
		GL11.glPushMatrix();
		
			game.render();
		
		GL11.glPopMatrix();
	}
	
	public int getDelta(){
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}
	
	public long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public void updateFPS(){
		if(getTime() - lastFPS > 1000){
			//System.out.println("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	
	
	
}
