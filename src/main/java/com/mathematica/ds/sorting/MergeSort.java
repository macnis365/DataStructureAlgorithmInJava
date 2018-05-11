package com.mathematica.ds.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = {20,11,21,12,5,10,1};
		printArray(array);
		mergeSort(array);
		printArray(array);
	}

	private static void printArray(int[] array) {
		for(int i=0;i<array.length-1;i++){
			System.out.print(array[i]+", ");
		}
		System.out.println();
	}

	private static void mergeSort(int[] array) {
		mergeSort(array,0,array.length-1);		
	}

	private static void mergeSort(int[] array, int start, int end) {
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
		}
		
	}

	private static void merge(int[] array, int start, int mid, int end) {
		System.out.println("start = "+start+" mid= "+mid+" end ="+end);
		
		int n1 = mid-start+1;
		int n2 = end-mid;
		
		int[] temp1 = new int[n1];
		int[] temp2 = new int[n2];
		
		for(int i = 0; i<n1; i++){
			temp1[i] = array[start+i];
		}
		
		for(int j = 0; j<n2; j++){
			temp2[j] = array[mid+j+1];
		}
		
		int i=0, j=0, k=start;
		while(i<n1 && j<n2){
			if(temp1[i]<=temp2[j]){
				array[k] = temp1[i];
				i++;
			}else{
				array[k] = temp2[j];
				j++;
			}
			k++;
		}
		
		while(i<n1){
			array[k] = temp1[i];
			i++;
			k++;
		}
		
		while(j<n2){
			array[k] = temp2[j];
			j++;
			k++;
		}
	}
}
