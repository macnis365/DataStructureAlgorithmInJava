package com.mathematica.ds.techgig;

import java.util.*;

public class DijkstraAPSP {

	static class Node {
		int data;
		LinkedList<Node> adjacentNode;
		
		Node(int data){
			this.data = data;
			adjacentNode = new LinkedList<>();
		}
	}
	
	static class ShortestDistanceAndPreviousNode{
		int shortestKnowDistance = Integer.MAX_VALUE;
		int prevNodeIndex;
		
		ShortestDistanceAndPreviousNode(int distance, int prevNodeIndex){
			this.shortestKnowDistance = distance;
			this.prevNodeIndex = prevNodeIndex;
		}
	}
	
	static Node[] houses;
	static LinkedList<Integer> visited;
	static LinkedList<Integer> unvisited;
	static ShortestDistanceAndPreviousNode[] shortDistanceMatrix;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int nodes = scan.nextInt();
		int days = scan.nextInt();
		houses = new Node[nodes+1];
		shortDistanceMatrix = new ShortestDistanceAndPreviousNode[nodes+1];
		
		for(int i = 1; i<=nodes+1; i++){
			houses[i] = new Node(i);
			unvisited.add(i);
		}
		
		for(int i = 0; i<nodes-1; i++){
			int u = scan.nextInt();
			int v = scan.nextInt();
			houses[u].adjacentNode.add(houses[v]);
			houses[v].adjacentNode.add(houses[u]);
		}
		
		dijkstra();
		
	}

	private static void dijkstra() {
		int source = 1;
		shortDistanceMatrix[1] = new ShortestDistanceAndPreviousNode(0, 0 );
		LinkedList<Node> adjacentHouses = houses[1].adjacentNode;
		
	}

}
