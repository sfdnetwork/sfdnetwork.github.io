package com.crystalstreak.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.crystalstreak.world.World;

public class EntityAmoeba extends Entity{

	private World world;
	public boolean isAlive;
	private double elasticLimit = 200;
	
	public EntityAmoeba(double x, double y, double width, double height, World world) {
		super(x, y, width, height);
		this.world = world;
		isAlive = true;
	}
	
	@Override
	public void update(int delta){
		checkCollisions();
		removeHealth(0.4);
//		System.out.println("Health: " + isAlive);
		super.update(delta);
	}

	@Override
	public void input() {
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			dx = 1;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			dx = -1;
		}else{
			dx = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			dy = -1;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			dy = 1;
		}else{
			dy = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			addSize(20);
		}
		super.input();
	}
	
	public void addSize(double size){
		x = x - (size / 2);
		y = y - (size / 2);
		width = width + (size);
		height = height + (size);
	}
	
	@Override
	public void render(){
		GL11.glColor3f(0.0f, 0.5f, 1.0f);
		super.render();
	}
	
	private void checkCollisions(){
		for(int i = 0; i < world.aiList.size(); i++){
			if(world.aiList.get(i).isColliding(x, y, width, height)){
				if(isAlive){
					if(world.aiList.get(i).isPoison){
						removeHealth(0.2);
						world.aiList.remove(i);
					}else{
						if(width <= elasticLimit)
							addSize(20);
							world.aiList.remove(i);
							world.addMore();
					}
				}
			}
		}
	}
	
	private void removeHealth(double decreateRate){
		x -= (decreateRate / 2);
		y -= (decreateRate / 2);
		if(width > 0)
		width -= decreateRate;
		if(height > 0)
		height -= decreateRate;
		if(width <= 0){
			isAlive = false;
		}
	}
	
	
	
}
