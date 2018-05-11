package com.mathematica.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDnaSquenceSolution {
	private static final Map<Character, Integer> encodings = new HashMap<Character, Integer>();
	static {encodings.put('A', 0); encodings.put('C', 1); encodings.put('G', 2); encodings.put('T', 3);}
	private final static int TWO_POW_9 = (int) Math.pow(2, 9);

	public static void main(String[] args) {
		
		List<String> repeatedDnaSequence = findRepeatedDnaSequence("AACAAAAACAAAACCAAAAACAAAAACAAAA");
		
		for (String string : repeatedDnaSequence) {
			System.out.println(string);
		}
	}

	private static List<String> findRepeatedDnaSequence(String string) {
		Set<String> setOfDuplicateString = new HashSet<String>();
		
		HashMap<Integer, String> duplicates = new HashMap<Integer, String>();
		for(int i=0, rhash = 0; i<string.length();i++){
			if(i>9) rhash -= TWO_POW_9*encodings.get(string.charAt(i-10));
			rhash = 2 * rhash +encodings.get(string.charAt(i));
			
			if(i>8){
				if(duplicates.get(rhash)!=null){
					setOfDuplicateString.add(string.substring(i-9, i+1));
				}
				else{
					duplicates.put(rhash, "");
				}
			}
		}
		return new ArrayList<String>(setOfDuplicateString);		
	}
}
