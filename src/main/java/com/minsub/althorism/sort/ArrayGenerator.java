package com.minsub.althorism.sort;

import java.util.Random;

public class ArrayGenerator {
	
	private static final int MAX_SIZE = 99;
	
	public static int[] generateArray(int size) {
		if(size <= 0) {
			return null;
		}
		
		int[] arr = new int[size];
		Random random = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(MAX_SIZE);
		}
		
		return arr;
	}
	
	public static void printArray(int[] arr) {
		System.out.println("ARRAY PRINT, SIZE: "+ arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("=============");
	}
}
