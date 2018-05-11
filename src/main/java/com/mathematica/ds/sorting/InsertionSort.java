package com.mathematica.ds.sorting;


/**
 * 
 * @author micheal
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] inputArray = {12,35,87,26,9,28,7};
		for(int i=0;i<inputArray.length;i++){
			System.out.print(inputArray[i]+", ");
		}
		System.out.println();
		insertionSort(inputArray);
	}

	private static void insertionSort(int[] inputArray) {
		int arrayLength = inputArray.length;
		if(inputArray != null && arrayLength < 2){
			return;
		}
		
		for(int i = 1;i<arrayLength;i++){
			int temp;
			temp = inputArray[i];
			int j = i-1;
			while(j>=0 && temp<inputArray[j]){
				inputArray[j+1] = inputArray[j];
				j--;
			}
			inputArray[j+1] = temp;
		}
		
		for(int i=0;i<arrayLength;i++){
			System.out.print(inputArray[i]+", ");
		}
		
	}
}
