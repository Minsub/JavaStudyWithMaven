package com.minsub.inheritance;

public class Main {

	public static void main(String[] args) {
		
		
		Parent p = new Child();
		p.test1();
		((Child)p).test2();
		
		//Child c = new Parent(); //Compile
		//Child c = (Child)new Parent(); //Rumtime 
		Child c;
		Parent p2 = new Parent();
		//c = (Child)p2;  //Rumtime

		
	}

}
