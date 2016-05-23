package com.minsub.althorism;

import java.util.Scanner;

/**
숫자 n 만큼의 n x n array가 생성되고 해당 배열이 Spiral형태로 숫자가 입력된다.
n은 최대 5 < n 20


[예제]
6 6

  0   1   2   3   4   5
 19  20  21  22  23   6
 18  31  32  33  24   7
 17  30  35  34  25   8
 16  29  28  27  26   9
 15  14  13  12  11  10
위처럼 6 6이라는 입력을 주면 6 X 6 매트릭스에 나선형 회전을 한 값을 출력해야 한다

 * @author minsub ji
 *
 */
public class SpiralArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[][] arr;
			
		int nLength, nLengthCnt, nTmp;
		
		while ( (n = sc.nextInt()) != 0) {
			int nCnt = 0;
			int i = 0, j = 0;
			arr = new int[n][n];
			
			Direction dr = Direction.SOUTH;	//최초 방향을 설정 
			nLength = n - 1; // 한번에 연속되는 숫자의 길이
			nTmp = nLength;
			nLengthCnt = 2; //5번 이동 x2, 4번 이동 x2, 로직, 따라서 2번을 카운트 하는 변수 
			
			while(nCnt < n*n) {
				if (nCnt < n) {	//첫번째 to WEST 는 일단 한번하고 시작.
					j=nCnt;
					arr[i][j] = nCnt;
				} else {
					// 끝까지 도달했는가를 체크 					
					if (nTmp <= 0 ) {
						dr = getNextDirection(dr);
						nLengthCnt--;
						nTmp = nLength;
					}
					//nLength가 다 줄었나를 체크 
					if (nLengthCnt == 0) {
						nLength--;
						nTmp = nLength;
						nLengthCnt = 2;
					}
					
					switch(dr) {
						case EAST: j--;
							break;
						case WEST: j++;
							break;
						case SOUTH: i++;
							break;
						case NORTH: i--;
							break;
					}
					arr[i][j] = nCnt;

					
					nTmp--;
				}
				nCnt++;
			}
			print(arr);
		}
		
		System.out.println("<<END>>");
	}

	public static Direction getNextDirection(Direction dr) {
		switch(dr) {
			case EAST:
				return Direction.NORTH;
			case WEST:
				return Direction.SOUTH;
			case SOUTH:
				return Direction.EAST;
			case NORTH:
				return Direction.WEST;
		}
		return dr;
	}
	
	public static String convertBy2Digit(int n) {
		if (n < 10) {
			return "0" + n;
		} else {
			return String.valueOf(n);
		}
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(convertBy2Digit(arr[i][j]) + " ");
			}
			System.out.println();
		}
	}
	
	enum Direction {
		EAST,
		WEST,
		SOUTH,
		NORTH;
	}
}
