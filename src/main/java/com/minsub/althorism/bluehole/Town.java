package com.minsub.althorism.bluehole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 <Input1.txt �� ������>
 5 4
 0 12 9 4 12
 12 0 7 3 10
 9 7 0 13 4
 4 3 13 0 9
 12 10 4 9 0
 */

/**
 * [Althorism for test of new Empolyee in Bluehole Studio]
 *
 * n������ �� ����� �ִ�. n���� ���� 2��(A, B)�� ������, �� �׷�ȿ� �ִ� ����� ���� T�Ÿ� ������ ������ �Ǿ� �־�� �Ѵ�.
 * 
 * @author jiminsub
 */
public class Town {
	private static final String FILE_NAME_INPUT = "input1.txt";
	private static final String FILE_NAME_OUTPUT = "input2.txt";

	private int homeCnt;
	private int distance;
	private int[][] graph;
	private boolean[] visitedGroupA;
	private boolean[] visitedGroupB;
	private boolean[] visitedTotal;

	// ���, �ּҰŸ�, �׷��� �����͸� ä��
	private void readFile() {
		try {
			File file = new File(FILE_NAME_INPUT);
			BufferedReader br = new BufferedReader(new FileReader(file));

			String tmp;
			String[] tmpArr;

			tmp = br.readLine();
			tmpArr = tmp.split(" ");
			homeCnt = Integer.parseInt(tmpArr[0]);
			distance = Integer.parseInt(tmpArr[1]);

			graph = new int[homeCnt][homeCnt];

			for (int i = 0; i < homeCnt; i++) {
				tmp = br.readLine();
				tmpArr = tmp.split(" ");
				for (int j = 0; j < tmpArr.length; j++) {
					graph[i][j] = Integer.parseInt(tmpArr[j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} // end reafile()

	// ���� �����
	private void writeFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					FILE_NAME_OUTPUT));

			StringBuilder sbA = new StringBuilder();
			StringBuilder sbB = new StringBuilder();

			boolean check = true;
			for (int i = 0; i < graph.length; i++) {
				if (!visitedTotal[i]) {
					bw.write("fail");
					check = false;
					break;
				}

				if (visitedGroupA[i]) {
					sbA.append(i + 1);
					sbA.append(" ");
				} else {
					sbB.append(i + 1);
					sbB.append(" ");
				}
			}

			if (check) {
				bw.write(sbA.toString());
				bw.write("\r\n");
				bw.write(sbB.toString());
			}

			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end writeFile()

	/**
	 * ����
	 */
	public void exec() {
		readFile();

		visitedGroupA = new boolean[graph.length];
		visitedGroupB = new boolean[graph.length];
		visitedTotal = new boolean[graph.length];
		dfs(visitedGroupA, 0);

		System.out.println("GROUP A");
		printVisited(visitedGroupA);

		for (int i = 0; i < visitedGroupA.length; i++) {
			if (!visitedGroupA[i]) { // GroupA�� ���Ե��� �ʴ� v�� ã��
				dfs(visitedGroupB, i);
				break;
			}
		}

		// Total üũ
		for (int i = 0; i < graph.length; i++) {
			if (visitedGroupA[i] || visitedGroupB[i]) {
				visitedTotal[i] = true;
			}
		}

		System.out.println("GROUP B");
		printVisited(visitedGroupB);

		writeFile();
	}

	private void dfs(boolean[] visited, int v) {

		visited[v] = true;
		for (int i = 0; i < visited.length; i++) {
			int tmp = graph[v][i];
			if (tmp <= 4 && tmp != 0 && !visited[i]) {
				dfs(visited, i);
			}
		}
	}

	/**
	 * 
	 * @param visited
	 */
	public static void printVisited(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			System.out.println(i + ": " + visited[i]);
		}
	}

	/**
	 * 
	 * @param arr Graph Structure as int[][]
	 */
	public static void printGraph(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Town town = new Town();
		town.exec();
	}
}
