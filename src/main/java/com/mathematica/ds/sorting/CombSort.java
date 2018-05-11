package com.mathematica.ds.sorting;

public class CombSort {
	
	public static void main(String[] args) {
		int[] inputArray = {20, 1, 100, 45, 19, 18};
		printArrayElement(inputArray);
		combSort(inputArray);
		System.out.println();
		printArrayElement(inputArray);
		
	}

	private static void printArrayElement(int[] inputArray) {
		for(int i : inputArray){
			System.out.print(i + ", ");
		}
	}

	private static void combSort(int[] inputArray) {
		double shrinkFactor = 1.3;
		int gap = inputArray.length;
		boolean sorted = false;
		
		while(sorted == false){
			gap = (int) (gap/shrinkFactor);
			
			if(gap>1){
				sorted = false; /*As long as gap > 1 we never sorted*/
			}
			else{
				gap = 1;
				sorted = true;
			}
			
			int i = 0;
			while(i+gap < inputArray.length){
				if(inputArray[i] > inputArray[i+gap]){
					swap(inputArray, i, i+gap);
					sorted = false;
				}
				i=i+1;
			}
		}
	}

	private static void swap(int[] inputArray, int i, int j) {
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}

}
