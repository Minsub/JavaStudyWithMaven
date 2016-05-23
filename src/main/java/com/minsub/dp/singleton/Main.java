package com.minsub.dp.singleton;

public class Main {
	
	public static void main(String[] args) {	
		
		Singleton st = Singleton.getInstance();
		
		Singleton st2 = Singleton.getInstance();
		
		if (st == st2) { // st, st2는 완전히 같은 instance 
			System.out.println("st and st2 are same");
		}
	}

}
