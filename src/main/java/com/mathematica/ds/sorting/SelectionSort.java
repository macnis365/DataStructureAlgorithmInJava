package com.mathematica.ds.sorting;

/**
 * 
 * @author micheal
 *Time Complexity is O(n^2) in worst, best and average cases
 *Space Complexity is O(1)
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] inputArray = {12,11,13,8,9,10,11};
		for(int i=0;i<inputArray.length;i++){
			System.out.print(inputArray[i]+", ");
		}
		System.out.println();
		selectionSort(inputArray);
		
	}

	private static void selectionSort(int[] array) {
		for(int i=0;i<array.length-1;i++){
			int minindex = i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[minindex]){
					minindex = j;
				}
			}
			
			if(minindex!=i && array[minindex]!=array[i]){
				swap(array, i, minindex);
			}
		}
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+", ");
		}
		
	}

	private static void swap(int[] array, int i, int minindex) {
		int temp;
		temp = array[i];
		array[i] = array[minindex];
		array[minindex] = temp;
		
	}
}
