package com.minsub.althorism.sort;

public class SortInsert {

	public static void sort(int[] arr) {
		if(arr == null) {
			return;
		}
		
		int size = arr.length;
		int tmp;
		for(int i = 1; i < size; i++) {
			tmp = arr[i];
			
			for(int j = 0; j < i; j++) {
				//저장된 tmp 보다 작은 수를 찾으면 메모리카피한 후 브레이크 
				if(tmp < arr[j]) {	
					System.arraycopy(arr, j, arr, j+1, i-j);
					arr[j] = tmp;
					break;
				} 
			}
		}
	}
}
