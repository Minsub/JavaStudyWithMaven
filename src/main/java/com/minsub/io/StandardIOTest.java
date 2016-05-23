package com.minsub.io;

import java.io.IOException;
import java.util.Scanner;

public class StandardIOTest {

	public static void main(String[] args) {
		
		useScanner();
//		useSystemInRead();
	}

	/**
	 * Scanner를 이용한 IO 
	 */
	public static void useScanner() {
		Scanner sc = new Scanner(System.in);
		int a;
		while( (a = sc.nextInt()) != 0){
			if (a == 1) {
				System.out.println("you input " + a);
			} else {
				System.out.println("XXXX");
			}
		}
		System.out.println("break");
	}
	
	/**
	 * System.in.read()를 이용한 I/O
	 */
	public static void useSystemInRead() {
		char a;
		try {
			while( (a = (char)System.in.read()) != '0'){
				System.out.println("YOu input: " + a);
			}
			System.out.println("break");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
