package com.minsub.althorism.sort;

public class SortBubble {
	
	public static void sort(int[] arr) {
		if(arr == null) {
			return;
		}
		
		int size = arr.length - 1;
		int tmp;
		
		// size가 계속 줄면서 가장 우측의 공간이 가장 큰 수로 확정됨 
		for(int i = 0; i < size; size--) {
			// tmp에 가장 큰수를 넣어서 계속 비교 
			for(int j = 0; j < size; j++) {
				if(arr[j] > arr[j+1]) {
					
					// 현재 j와 j+1의 값을 swap
					tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
