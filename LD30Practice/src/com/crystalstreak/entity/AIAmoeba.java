package com.crystalstreak.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class AIAmoeba extends Entity{

	public boolean isPoison;
	
	public AIAmoeba(double x, double y, double width, double height, boolean isPoison) {
		super(x, y, width, height);
		this.isPoison = isPoison;
	}
	
	@Override
	public void update(int delta){
		
		super.update(delta);
	}

	@Override
	public void input() {
		
		super.input();
	}
	
	public boolean isColliding(double px, double py, double pwidth, double pheight){
		if(px + pwidth > x && py + pheight > y && px < x + width && py < y + height){
			//System.out.println("Colliding");
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void render(){
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		if(isPoison)
			GL11.glColor3f(1.0f, 0.0f, 0.5f);
		super.render();
	}
	
	public void addSize(double size){
		x = x - (size / 2);
		y = y - (size / 2);
		width = width + (size);
		height = height + (size);
	}
	
	
	
	
}
