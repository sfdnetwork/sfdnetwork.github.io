package com.crystalstreak.game;

import com.crystalstreak.entity.EntityAmoeba;
import com.crystalstreak.world.World;

public class Game {

	private EntityAmoeba entity;
	private World world;
	
	public Game() {
		world = new World();
		entity = new EntityAmoeba(10, 10, 100, 100, world);
	}
	
	public void update(int delta){
		world.update(delta);
		entity.update(delta);	
	}
	
	public void render(){
		world.render();
		entity.render();
	}
	
}
