package com.mathematica.ds.arrays;

import java.util.Arrays;


public class RemoveDuplicates {

	
	public static int[] removeDuplicates(int[] arr){
		
		int i = 1;
		int j = 0;
		
		if(arr.length<2){
			return arr;
		}
		
		while(i<arr.length){
			if(arr[i] == arr[j]){
				i++;
			}else {
				arr[++j] = arr[i++];
			}
		}
		
		int output[] = new int[j+1];
		for(int k=0;k<output.length;k++){
			output[k] = arr[k];
		}
		
		return output;
	}
	
	
	public static int[] bruteFroceRemoveDuplicates(int[] arr){
		int[] nonDuplicate = new int[arr.length];
		for(int i = 0; i<arr.length-1; i++){
			for(int j=1; j<arr.length; j++){
				if(arr[i]!=arr[j] && i!=j){
					nonDuplicate[i]=arr[i];
				}
			}
		}
		return nonDuplicate;
	}
	
	public static int[] stringBasedRemoveDuplicates(int[] arr){
		String string = "";
		for(int i =0; i<arr.length; i++){
			if(!checkNumberExist(string, arr[i])){
				string = string+arr[i]+"#";
			}
		}
		
		String completedString[] = string.substring(0, string.length()-1).split("#");
		int[] nonDuplicateArray = new int[completedString.length];
		for(int i = 0; i<nonDuplicateArray.length; i++){
			nonDuplicateArray[i] = Integer.valueOf(completedString[i]);
		}
		
		return nonDuplicateArray;
	}
	
	private static boolean checkNumberExist(String string, int num) {
		String s[] = string.trim().split("#");
		for(int k =0; k<s.length && s[k] != ""; k++){
			if(num ==  Integer.valueOf(s[k])){
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int[] input1 = {12, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12 };
		
		System.out.println(Arrays.toString(stringBasedRemoveDuplicates(input1)));
	}
}
