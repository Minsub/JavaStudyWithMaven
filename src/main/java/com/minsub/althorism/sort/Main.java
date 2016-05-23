package com.minsub.althorism.sort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = ArrayGenerator.generateArray(10);
		ArrayGenerator.printArray(arr);
		
//		SortSelect.sort(arr);
//		SortInsert.sort(arr);
		SortBubble.sort(arr);
		
		ArrayGenerator.printArray(arr);
	}

}
