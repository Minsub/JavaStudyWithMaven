package com.minsub.althorism;

import java.util.Scanner;

/**
 * 너비가 같은 N개의 나무 판자를 붙여 세운 울타리가 있습니다. 시간이 지남에 따라 판자들이 부러지거나 망가져 높이가 다 달라진 관계로
 * 울타리를 통째로 교체하기로 했습니다. 이 때 버리는 울타리의 일부를 직사각형으로 잘라내 재활용하고 싶습니다. 그림 (b)는 (a)의
 * 울타리에서 잘라낼 수 있는 많은 직사각형 중 가장 넓은 직사각형을 보여줍니다. 울타리를 구성하는 각 판자의 높이가 주어질 때, 잘라낼 수
 * 있는 직사각형의 최대 크기를 계산하는 프로그램을 작성하세요. 단 (c)처럼 직사각형을 비스듬히 잘라낼 수는 없습니다.
 * 
 * 판자의 너비는 모두 1이라고 가정합니다.
 * 
 * URL : http://algospot.com/judge/problem/read/FENCE
 * 
 * 
    [예제 입력]
	3
	7
	7 1 5 9 6 7 3
	7
	1 4 4 4 4 1 1
	4
	1 8 2 2
	
	[예제 출력]
	20
	16
	8
 * 
 * @author minsub ji
 * 
 */
public class Fence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nCnt = sc.nextInt();
		
		if (nCnt > 50 || nCnt <=0) {
			return;
		}
		
		int nFenceCnt;	//Fence 길이
		int[] arrFence; //각 Fence 길이가 저장된 배열 
		for (int i = 0; i < nCnt; i++) {
			nFenceCnt = sc.nextInt();
			arrFence = new int[nFenceCnt];
			for (int j = 0; j < nFenceCnt; j++) {
				arrFence[j] = sc.nextInt();
			}
			
			System.out.println(getArea(nFenceCnt, arrFence));
		}
	}
	
	/**
	 * @param length fence의 갯수 
	 * @param arr int[]로 fence의 모든 높이 
	 * @return 최대 사각형의 넓이 
	 */
	public static int getArea(int length, int[] arr) {
		
		return 0;
	}

}
