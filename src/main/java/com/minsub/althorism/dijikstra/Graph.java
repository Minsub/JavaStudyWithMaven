package com.minsub.althorism.dijikstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	private int[][] table;
	private int nTableLength;
	private boolean[] arrChkVisited;
	
	public Graph(int[][] table) {
		this.table = table;
		nTableLength = table.length; //그래프의 길이
		arrChkVisited = new boolean[nTableLength]; // 이동했는지 여부를 체크하는 배열 
	}
	
	/**
	 * DFS
	 * @param start
	 * @return
	 */
	public List<Integer> getVertexListUsingDFS(int start) {
		List<Integer> list = new ArrayList<Integer>(); // 반환할 List객체
		
		// arrChkVisited 초기화
		for (int i = 0; i < nTableLength; i++) {
			arrChkVisited[i] = false;
		}
		
		dfs(list, start);
//		dfsIterative(list, start);
		return list;
	}
	
	/**
	 * BFS
	 * @param start
	 * @return
	 */
	public List<Integer> getVertexListUsingBFS(int start) {
		List<Integer> list = new ArrayList<Integer>(); // 반환할 List객체
		
		// arrChkVisited 초기화
		for (int i = 0; i < nTableLength; i++) {
			arrChkVisited[i] = false;
		}
		
		list.add(start);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		int v;
		
		while (!queue.isEmpty()) {
			v = (Integer) queue.poll();
			arrChkVisited[v] = true;
			
			for (int i = 0; i < nTableLength; i++) {
				if (table[v][i] > 0 && !arrChkVisited[i]) {
					System.out.println("MOVE: " + v + " to " + i);	// print
					queue.add(i);
					list.add(i);
					arrChkVisited[i] = true;
				}
			}
		}
		return list;
	}
	
	/**
	 * Dijikstra를 이용한 최단경로 
	 * @param start
	 * @param desination
	 * @return
	 */
	public List<Integer> getVertexListDijikstra(int start, int desination) {
		
		List<Integer> list = new ArrayList<Integer>(); // 반환할 List객체
		// arrChkVisited 초기화
		for (int i = 0; i < nTableLength; i++) {
			arrChkVisited[i] = false;
		}
		
		int[] distance = new int[nTableLength]; // start to 각각의 vertex까지의 거리
		// 최초 start에서 직접 연결되 거리로 값 세팅
		for(int i = 0; i < table.length; i++){
			distance[i] = table[start][i]; 
		}
		arrChkVisited[start] = true;
		int index1;
		
		
		int[] vertexPath = new int[nTableLength];
		
		for(int i = 0; i < table.length - 1; i++){
			index1 = getShortest(distance); // 현재 Distance중 가장 짧은 vertex index 구하기
			arrChkVisited[index1] = true;	// 풀스캔을 했던 vertex 체크!
			
			for(int j = 0; j < table.length; j++){
				// Distnace를 새로 갱신하기 위해, 다이렉트 거리 > 우회거리 일때 갱신 or 다이렉트 길이 없고 우회가 있을 때
				if (!arrChkVisited[j] && table[index1][j] != 0){ 
					if (distance[j] == 0) {	// 시작지점에서 j-vertex까지 연결된 것이 없을때는 무조건 우회경로 지정
						distance[j] = distance[index1] + table[index1][j];
						vertexPath[j] = index1;	
						
					} else if(distance[index1] + table[index1][j] < distance[j]){ // 다이렉트로 가는것보다 우회비용이 더 적을 때 
						distance[j] = distance[index1] + table[index1][j];
						vertexPath[j] = index1;	
					}
					
				}// end of else
			}
		}
		
		// vertexpath에따라 경로를 List로 만듬
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(desination);
		for(int i = 0; i < nTableLength; i++){
			stack.push(vertexPath[desination]);
			if( vertexPath[desination] != start){
				desination = vertexPath[desination];
			}else{
				break;
			}
		}
		
		while(stack.size() > 0){
			list.add(stack.pop());
		}
		// distance[destination] 이 최종 COST;
		return list;
	}

	
	// 최댄 거리를 구하는 함수 for Dijikstra 
	private int getShortest(int[] distance) {
		int tmp = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < nTableLength; i++) {
			if (distance[i] != 0 && distance[i] < tmp  && !arrChkVisited[i]) {
				tmp = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	// DFS 리컬시브 함수
	private void dfs(List<Integer> list, int vertex) {
		arrChkVisited[vertex] = true;
		list.add(vertex);
		for (int i = 0; i < nTableLength; i++) {
			if (table[vertex][i] > 0 && !arrChkVisited[i]) {
				System.out.println("MOVE: " + vertex + " to " + i);	// print
				dfs(list, i);
			}
		}
	}
	
	// DFS Iterative 함수 (아직 완벽하지 않음)
	private void dfsIterative(List<Integer> list, int vertex) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(vertex);
		int v = vertex;
		arrChkVisited[v] = true;
		int cnt = 0;
		while (!stack.isEmpty()) {
			v = stack.pop();
			arrChkVisited[v] = true;
			list.add(v);
			
			for (int i = nTableLength-1; i >= 0; i--) {
				if (table[v][i] > 0 && !arrChkVisited[i]) {
					
					stack.push(i);
					
				}
			}
			
			cnt++;
			if (cnt == nTableLength) {
				break;
			}
		}
	}
}
