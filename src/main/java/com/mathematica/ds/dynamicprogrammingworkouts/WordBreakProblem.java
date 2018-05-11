package com.mathematica.ds.dynamicprogrammingworkouts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("arrays" , "dynamic" , "heaps" , "IDeserve" , "learn" , "learning" , "linked" , "list" , "platform" , "programming" , "stacks" , "trees" ));
	
	
	public static void main(String[] args) {
		
		if(isStringCanBeBrokenIntoMeaningfulWords("IDeservelearningplatform")){
			System.out.println("TRUE");
		} else{
			System.out.println("FALSE");
		}
	}


	private static boolean isStringCanBeBrokenIntoMeaningfulWords(String string) {
		int stringLength = string.length();
		boolean [] validWords = new boolean[stringLength];
		for(int i=1;i<stringLength;i++){
			if(dictionary.contains(string.substring(0, i))){
				validWords[i] = true;
			}
			
			if(validWords[i]==true && i == stringLength-1){
				return true;
			}
			
			if(validWords[i]==true){
				for(int j=i+1;j<stringLength;j++){
					if(dictionary.contains(string.substring(i, j+1))){
						validWords[j] = true;
					}
					
					if(j==stringLength-1 && validWords[j]==true){
						return true;
					}
				}
			}
		}
		return false;
	}
}
