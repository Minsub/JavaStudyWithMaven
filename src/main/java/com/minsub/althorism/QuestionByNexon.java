package com.minsub.althorism;

/**
 * 어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
 * 
 * 예를 들어 [d(91) = 9 + 1 + 91 = 101] 이 때, n을 d(n)의 제네레이터(generator)라고 한다.
 * 위의 예에서 91은 101의 제네레이터이다.
 * 
 * 어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다. 그런데 반대로, 제네레이터가
 * 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다. 예를 들어
 * 1,3,5,7,9,20,31 은 셀프 넘버 들이다.
 * 
 * 1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
 * 
 * @author Minsub Ji
 * 
 */

public class QuestionByNexon {

	public static void main(String[] args) {
		System.out.println(getSum(5000));
	}
	
	/**
	 * 1 - amx까지의 모든 셀프 넘버들의 합
	 * @param max 
	 * @return 셀프 넘버들의 합
	 */
	static int getSum(int max) {
		// 1~max까지의 숫자를 다 더하고 self-number가 아닌 수를 빼는 방식을 사용 
		int total = 0;
		// max만큼의 boolean 배열을 만들어 self-number가 아닌 숫자의 경우 표시 
		boolean arrChk[]= new boolean[max];
		for (int i = 1; i <= max; i++) {
			arrChk[i-1] = true;
			total += i;
		}
		
		int tmp = 0;
		for (int i = 1; i <= max; i++) {
			tmp = d(i);
			if (tmp <= max) {
				if (arrChk[tmp-1]) {
					total -= tmp;
					arrChk[tmp-1] = false;
				}
			}
		}
		
		return total;
	}
	
	/**
	 * d(91) = 9 + 1 + 91 = 101 이 때, n을 d(n)의 제네레이터(generator)라고 한다.
	 * 
	 * 이를 구현
	 * 
	 * @param n
	 * @return 제네레이터 값 
	 */
	static int d(int n) {
		int result = n;
		
		do {
			result += (n % 10);
		} while ( (n /= 10) > 0); 
		
		return result;
	}
}
