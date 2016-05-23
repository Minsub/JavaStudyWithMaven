package com.minsub.althorism;

/**
 * 1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
 
	8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
	(※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 함)
 * @author minsub Ji
 */
public class QuestionByGoogle1 {

	public static void main(String[] args) {
		
		
		System.out.println(getCountOfNumber(10000, 8));
	}

	/**
	 * 
	 * @param max 1부터 n까지의 숫자 중 n값
	 * @param targetNumber 0-9까지의 숫자중 카운트 할 타겟 숫자
	 * @return 카운트 결과 값
	 */
	public static int getCountOfNumber(int max, int targetNumber) {
		
		int cnt = 0;
		int tmp = 0;
		
		for (int i = 1; i <= max; i++) {
			tmp = i;
			
			do {
				if (tmp % 10 == 8) {
					cnt++;
				}
			} while ((tmp /= 10) > 0); 
		}
		return cnt;
	}
	
	/*
	 * [다른 해결법] 
	 * 0000부터 9999라고 생각하고 4자리숫자가 10000개이므로 들어가는
	 * 숫자의개수는 4만개 0부터 9까지 10개의 숫자가 같은
	 * 비율로 들어가니 4만을 10으로 나누면 4천!
	 */
}
