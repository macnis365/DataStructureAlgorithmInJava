package com.mathematica.ds.techgig;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DijkstraHackerRank {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(new BufferedInputStream(System.in, 65536));
		int testcase = scanner.nextInt();
		
		int nodes = scanner.nextInt();
		int edges = scanner.nextInt();
		long[][] weight = new long[nodes+1][nodes+1];
		
		for(long[] row : weight){
			Arrays.fill(row, 1000000l);
		}
		
		int distance = 1;
		
		for(int i = 0; i<edges; i++){
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			
			if(weight[u][v] > distance){
				weight[u][v] = distance;
				weight[v][u] = distance;
			}
		}
	}

}
