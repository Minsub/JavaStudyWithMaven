package com.minsub.althorism.bluehole;

/**
 * [Althorism for test of new Empolyee in Bluehole Studio]
 * 
 * 숫자를 입력받으면, 1부터 입력받은 숫자까지
 * 첫줄은 -> 방향으로 숫자가 증가하고 다음줄은 <- 줄로 숫자가 증가하도록 숫자를 Console에 프린프 하시오. 
 * ---[Sample]----
 * intput: 15
 * 1
 * 3 2
 * 4 5 6
 * 10 9 8 7
 * 11 12 13 14 15
 * ----------------
 * @author Minsub Ji
 */
public class Tryangle {

	public static void make(int n) {
		int lineCnt = 1;
		int lineMax = 1;
		boolean check = true;

		while (lineMax <= n) {
			if (check) {
				for (int i = lineMax - lineCnt + 1; i <= lineMax; i++) {
					System.out.print(i + " ");
				}
			} else {
				for (int i = lineMax; i >= lineMax - lineCnt + 1; i--) {
					System.out.print(i + " ");
				}
			}
			System.out.println();

			check = !check;

			lineCnt += 1;
			lineMax += lineCnt;
		}

	}

	public static void main(String[] args) {

		Tryangle.make(15);

	}
}
