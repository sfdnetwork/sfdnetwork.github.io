package com.crystalstreak.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Entity {

	protected double x, y, width, height;
	protected double dx, dy;
	
	public Entity(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update(int delta){
		movement(delta);
		input();
	}
	
	public void render(){
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2d(x, y);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2d(x + width, y);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2d(x + width, y + height);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2d(x, y + height);
		GL11.glEnd();
	}
	
	private void movement(int delta){
		this.x += dx * delta;
		this.y += dy * delta;
	}
	
	public void input(){
		
	}
	
}
