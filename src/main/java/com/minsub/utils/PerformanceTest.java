package com.minsub.utils;


/**
 * 성능측정 함수
 * @author hmm1115222
 *
 */
public class PerformanceTest {
	private static long time = 0; 
	private static boolean isStart = false;
	public static void start(){
		time = System.currentTimeMillis();
		isStart = true;
	}
	
	public static double end() {
		if (isStart) {
			long result = System.currentTimeMillis() - time;
			isStart = false;
			return (double)result / 1000f;
		} else {
			return -1;
		}
	}
	
	/**
	 * 인터페이스를 사용한 속도 측정
	 * @param TestMethod를 구현해 excute()에 테스트할 함수를 넣는다.
	 * @return 초단위의 속도측정 값
	 */
	public static double excute(TestMethod method) {
		PerformanceTest.start();
		method.excute();
		return PerformanceTest.end();
	}
	
	public interface TestMethod {
		public void excute();
	}
}
