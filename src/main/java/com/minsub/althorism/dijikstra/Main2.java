package com.minsub.althorism.dijikstra;

import java.util.List;

public class Main2 {
	
	public static void main(String[] args) {
		// Test Data
		int[][] table ={{	0,	7,	0,   0,	 3,	10,  0 },
						{	7,	0,  4,  10,	 2,	 6,  0 },
						{   0,	4,	0,   2,  0,  0,  0 },
				  		{   0, 10,	2,   0, 11,	 9,  4 },
				  		{	3,	2,	0,  11,	 0,  0,  5 },
				  		{  10,	6,	0,   9,  0,	 0,  0 },
				  		{   0,  0,  0,   4,	 5,  0,  0 }};

		Graph graph = new Graph(table);
		List<Integer> list1 = graph.getVertexListUsingDFS(0);
		System.out.println("List1: DFS");
		print(list1);
		
	
		List<Integer> list2 =graph.getVertexListUsingBFS(0);
		System.out.println("List2: BFS");
		print(list2);
		
		System.out.println("List3: JDijkstra");
		List<Integer> list3 =graph.getVertexListDijikstra(0,6);
		print(list3);
		
	}
	
	public static void print(List<Integer> list) {
		for (Integer n : list) {
			System.out.print(n + " -> ");
		}
		System.out.println();
	}

}
