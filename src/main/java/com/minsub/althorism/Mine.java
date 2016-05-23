package com.minsub.althorism;

import java.util.Scanner;

/**
 * 지뢰찾기 게임은 M x N 매트릭스에 위치해 있는 지뢰를 찾는 게임이다.

M x N 매트릭스 상의 격자(square)는 지뢰이거나 지뢰가 아니다.

지뢰 격자는 *로 표시한다. 지뢰가 아닌 격자(square)는 숫자로 표시하며 그 숫자는 인접해 있는 지뢰의 수를 의미한다. (격자(sqaure)는 최대 8개의 인접한 지뢰를 가질 수 있다.)

다음은 4x4 매트릭스에서 2개의 지뢰(*)를 표시하는 방법이다.

ex) 
입력
4 4
*...
....
.*..
....

츨략
*100
2210
1*10
1110

 * @author hmm1115222
 *
 */
public class Mine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		//배열 만들기
		char[][] arr = new char[m][n];
		for (int i = 0; i < m; i++) {
			String tmp = sc.next();
			for (int j=0; j<n;j++) {
				char c = tmp.charAt(j);
				if (c == '*') {
					arr[i][j] = '1';
				} else {
					arr[i][j] = '0';
				}
			}
		}
		
		//변화
		for (int i = 0; i < m; i++) {
			
			for (int j = 0; j < n; j++) {
			
			}
		}
		char[][] arr2 = new char[m][n];
		print(arr2);
		
	}
	
	public static int getNumberForMine(char[][] arr, int i, int j){
		int cnt = 0;
		
		if (j-1 >= 0) {
			if (arr[i-1][j] == '1') cnt++;
		}
		if (j+1 < arr[0].length ) {
			
		}
		
		
		
		return 1;
	}

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j=0; j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
