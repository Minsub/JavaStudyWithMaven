package com.minsub.syntax;


public class Varargs {

	public static void main(String[] args) {
		
		test1("Smith", "Racheal", "Fiona", "Tom");
	}
	
	public static void test1(String...arrStr ) {
		
		System.out.println("[foreach]");
		for (String s: arrStr) {
			System.out.println(s);
		}
		
		System.out.println("[for]");
		for (int i = 0; i < arrStr.length; i++) {
			System.out.println(arrStr[i]);
		}
	}
	

}
