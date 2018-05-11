package com.mathematica.ds.sorting;

public class PankcakeSort {

	public static void main(String[] args) {
		int[] array = {89,100,99,98,97,96,95,94,93,92,91};
		printArrayElement(array);
		pankcakeSort(array);
		printArrayElement(array);
		
	}

	private static void printArrayElement(int[] array) {
		for(int element : array){
			System.out.print(element+", ");
		}
		System.out.println();
	}
	
	private static void pankcakeSort(int[] array) {
		for(int i = array.length-1; i>=0; i--){
			int maxValueIndex = getMaxValueIndex(array, i);
			if(maxValueIndex!=i){
				if(maxValueIndex!=0){
					flipArray(array, maxValueIndex);
				}
				flipArray(array,i);
			}
		}
	}

	private static void flipArray(int[] array, int end) {
		int start = 0;
		while(start<end){
			swap(array, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] array, int start, int end) {
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}

	private static int getMaxValueIndex(int[] array, int endIndex) {
		int max = 0;
		for(int i = 1; i<endIndex; i++){
			if(array[i]>array[max]){
				max = i;
			}
		}
		return max;
	}
}
