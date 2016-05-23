package com.minsub.althorism;

import java.text.SimpleDateFormat;


/**
 * 앞뒤가 같은 수는 바로 쓴 값과 거꾸로 쓴 값이 같은 수이다. 다음과 같은 예를 들 수 있다.
	
	1
	44
	101
	2002
	8972798
	1111111111111
	0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, ... 과 같이,
	0 이상의 앞뒤가 같은 수를 크기 순으로 나열할 때, n 번째 수를 계산하는 프로그램을 작성하라.
	n은 1부터 시작하며 크기에는 제한이 없다.
	
	
	입출력예
	예 1) 1 => 0
	예 2) 4 => 3
	예 3) 30 => 202
	예 4) 100 => 909
	예 5) 30000 => 200000002
	예 6) 1000000 => 90000000009
 * @author Minsub Ji
 *
 */
public class Symmetry {

	/**
	 * 지금 성능이 너무 느림!!! 제길
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1000;
		
		long lStartTime = System.currentTimeMillis();
		System.out.println(a+ " => " + getIndexofSymetry(a));
		
		long time = System.currentTimeMillis() - lStartTime;
		
		System.out.println(time);
		System.out.println(miliToHHMMSS(time));
		
	}
	
	static public String miliToHHMMSS(long time) {
		StringBuilder sb = new StringBuilder();
		sb.append(time / (60 * 60 * 1000));
		sb.append(":");
		sb.append(time / (60 * 1000));
		sb.append(":");
		sb.append(time / 1000);
		return sb.toString();
	}

	static public long getIndexofSymetry(int value) {
		long i = 0;
		int cnt = 0;
		while (i <= Integer.MAX_VALUE) {
			if (checkSymetry(i)) {
				cnt++;
				if (cnt == value) {
					return i;
				}
			}
			
			i++;
		}
		
		return -1;
	}
	
	/**
	 * 입력받은 n이 좌우 대칭인가를 true/false로 반환 
	 * @param n
	 * @return 같으면 true, 다르면 false
	 */
	static public boolean checkSymetry(long n) {
		if (n < 10 && n>=0) {
			return true;
		}
		
		int nDigit = getDigit(n);
		
		int nHead = nDigit;
		int nTail = 1;
		for (int i = 0; i < (nDigit/2); i++) {
			if (n / get10(nHead) % 10 != n / get10(nTail) % 10) {
				return false;
			}
			nHead--;
			nTail++;
		}
		return true;
	}
	
	/**
	 * 입력받은 digit자리수만큼 10^으로 표시 
	 * @param digit
	 * @return 10^digit
	 */
	static public long get10(long digit) {
		if (digit == 1) {
			return 1;
		} else {
			int result = 1;
			for (int i = 1; i < digit; i++) {
				result *= 10;
			}
			return result;
		}
	}
	
	/**
	 * 입력받은 n의 자릿수를 int형으로 반환 
	 * @param n 
	 * @return 자릿수
	 */
	public static int getDigit(long n) {
		int digit = 1;
		while (n >= 10) {
			n /= 10;
			digit++;
		}
		return digit;
	}
}
