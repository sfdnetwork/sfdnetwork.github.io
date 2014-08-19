package com.crystalstreak.world;

import java.util.ArrayList;
import java.util.Random;

import com.crystalstreak.entity.AIAmoeba;

public class World {
	
	public ArrayList<AIAmoeba> aiList = new ArrayList<AIAmoeba>();
	private Random random;
	private double randomX;
	private double randomY;
	private double randomSize;
	private boolean isPoison;
	
	public World() {
		for(int i = 0; i < 10; i++){
			random = new Random();
			randomX = random.nextDouble();
			randomSize = random.nextDouble() * 100;
			if(random.nextInt(4) == 1){
				isPoison = true;
			}else{
				System.out.println("Else");
				isPoison = false;
			}
			//System.out.println("RandomX: " + randomX * 1280);
			aiList.add(new AIAmoeba(random.nextDouble() * 1100, random.nextDouble() * 620, randomSize + 10, randomSize + 10, isPoison));
		}
		
	}
	
	public void update(int delta){
		for(int i = 0; i < aiList.size(); i++){
			aiList.get(i).update(delta);
		}
	}
	
	public void addMore(){
		for(int i = 0; i < 1; i++){
			random = new Random();
			randomX = random.nextDouble();
			randomSize = random.nextDouble() * 150;
			if(random.nextInt(4) == 1){
				isPoison = true;
			}else{
				System.out.println("Else");
				isPoison = false;
			}
//			System.out.println("RandomX: " + randomX * 1280);
			aiList.add(new AIAmoeba(random.nextDouble() * 1280, random.nextDouble() * 720, randomSize + 10, randomSize + 10, isPoison));
		}
	}
	
	public void render(){
		for(int i = 0; i < aiList.size(); i++){
			aiList.get(i).render();
		}
	}
	
}
