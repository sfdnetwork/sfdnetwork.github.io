package com.crystalstreak.utils;

public class TextureMath {

	public static int powerRoundup(int i){
		if( i < 0)
			return 0;
		
		--i;
		
		i |= i >> 1;
		i |= i >> 2;
		i |= i >> 4;
		i |= i >> 8;
		i |= i >> 16;
		return i + 1;
	}
	
}
