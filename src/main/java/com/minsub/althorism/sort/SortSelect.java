package com.minsub.althorism.sort;

public class SortSelect {

	public static void sort(int[] arr){
		if(arr == null) {
			return;
		}
		
		int size = arr.length;
		int tmp;
		int nPos = 0;
		for(int i = 0; i < size; i++) {
			tmp = arr[i];
			
			//가장 작은 수 찾기 
			for(int j = i; j < size; j++) {
				
				if(tmp > arr[j]) {
					tmp = arr[j];
					nPos = j;
				}
			}
			
			//스왑 
			if(tmp < arr[i]) {
				arr[nPos] = arr[i];
				arr[i] = tmp;
			}
		}
		
	}
}
