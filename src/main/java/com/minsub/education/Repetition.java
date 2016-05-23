package com.minsub.education;

public class Repetition {

	public static void main(String[] args) {
		
		for (int i = 2; i <= 8; i = i + 2) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " x " + j + " = " + (i * j) + " ");
			}
			System.out.println();
		}
	}

}
