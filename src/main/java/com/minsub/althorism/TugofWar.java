package com.minsub.althorism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 설명

회사 야유회에서 줄다리기를 하기로 했다. 야유회에 참가한 사람들을 두 편으로 공평하게 나눈다. 모든 사람들이 둘 중 한 편에 참여해야 하며, 두 편의 사람 수는 한 명이 넘게 차이가 나면 안 된다. 그리고 양 편에 속한 사람들 체중의 총합 차를 최소한으로 줄여야 한다.

입력

첫번째 라인은 줄다리기에 참여하는 모든 사람의 수(n명)를 나타낸다. 다음에 사람의 수만큼 n개의 라인이 따라온다. n개의 라인은 순서대로 1번째 사람의 몸무게부터 n번째 사람의 몸무게를 나타낸다. 몸무게는 1~450 사이의 숫자여야 한다. 줄다리기의 참여자는 최대 100명까지(n<=100)이다.

출력

출력값은 한 줄로 표시하며 2개의 숫자만 있어야 한다. 2개의 숫자는 한 팀의 총 몸무게와 다른 한팀의 총 몸무게를 의미한다. 만약 두개의 숫자가 다를 경우 적은 숫자를 앞에 표시한다.

입력 예

3
100
90
200
출력 예

190 200
 * @author hmm1115222
 *
 */
public class TugofWar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < cnt; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		
		int nLeft = list.get(list.size()-1);
		int nRight = 0;
		
		for (int i = list.size()-2; i >= 0; i--) { 
			if (nLeft <= nRight) {
				nLeft += list.get(i);
			} else {
				nRight += list.get(i);
			}
		}
		
		System.out.println(nLeft + " " + nRight);
	}

}
