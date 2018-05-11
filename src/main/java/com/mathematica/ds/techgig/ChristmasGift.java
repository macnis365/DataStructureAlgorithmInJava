package com.mathematica.ds.techgig;

import java.util.*;

public class ChristmasGift {
	
    static	int[][] distance;
    static	int[][] nextNode;
    static int[] routes;
    	
    	
    static void floydWarshallAlgorithm(){
    	    for(int k = 1; k<routes.length; k++){
    	        for(int i = 1; i<routes.length; i++){
    	            for(int j = 1; j<routes.length; j++){
    	            	try{
    	                if(distance[i][j] > Math.addExact(distance[i][k], distance[k][j])){
    	                    distance[i][j] = distance[i][k]+distance[k][j];
    	                    nextNode[i][j] = nextNode[i][k];
    	                }
    	            	}catch(Exception e){
    	            		
    	            	}
    	            }
    	        }
    	    }
    }
    
    static void path(int a, int b){
        if(nextNode[a][b] == 0){
            return;
        }
        
        int u = a;
        routes[u]++;
        while(u != b){
            u = nextNode[u][b];
            routes[u]++;
            
        }
    }
    	
    public static void main(String args[] ) throws Exception {

    	Scanner scan = new Scanner(System.in);
    	int houses = scan.nextInt();
    	int days = scan.nextInt();
    	routes = new int[houses+1];
    	distance = new int[houses+1][houses+1];
    	nextNode = new int[houses+1][houses+1];
    	
    	for(int i = 1; i<= houses; i++){
    	    routes[i] = 0;
    	}
    	
    	for(int i = 1; i< houses+1; i++){
    		for(int j = 1; j< houses+1; j++ ){
    			if(i != j) {
    				distance[i][j] = Integer.MAX_VALUE-1;
    			}else {
    				distance[i][j] = 0;
    			}
    		}
    	}
    	for(int i = 0; i<houses-1; i++){
    	    int u = scan.nextInt();
    	    int v = scan.nextInt();
    	    
    	    distance[u][v] = 1;
    	    distance[v][u] = 1;
    	    nextNode[u][v] = v;
    	    nextNode[v][u] = u;
    	}
    	
    	floydWarshallAlgorithm();
    	
    	for(int i = 0; i<days; i++){
    	    path(scan.nextInt(), scan.nextInt());
    	}
    	
    	int max = routes[1];
    	for(int i = 2; i<routes.length; i++){
    	    if(routes[i] > max){
    	        max = routes[i];
    	    }
    	}
    	
    	System.out.println(max);

   }
    

}
