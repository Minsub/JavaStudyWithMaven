package com.minsub.althorism.eastsoft;

import java.util.Arrays;
import java.util.Scanner;

/**
 * EastSoft문제
 * 1, 2, 3 이 있다면
 * 1 + 2 = 3
 * 3 + 3 = 6
 * --> 3 + 6 = 9
 * 처럼 최소 비용을 구하여라 
 * @author jiminsub
 *
 */
public class Operation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input;
		int[] arr;
		while ((input = sc.nextInt()) != 0) {
			arr = new int[input];
			for (int i = 0; i < input; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			int tmp = 0;
			int result = 0;
			for (int i = 1; i < input; i++) {

				tmp = arr[i - 1] + arr[i];
				result += tmp;
				arr[i] = tmp;

				if (i != input - 1) {
					if (tmp > arr[i + 1]) {
						for (int j = i + 1; j < input; j++) {
							if (tmp <= arr[j]) {
								System.arraycopy(arr, i + 1, arr, i, j - i);
								arr[j] = tmp;
								break;
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}
