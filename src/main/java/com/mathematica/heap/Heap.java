package com.mathematica.heap;

public class Heap {

	int[] heap = new int[8];
	int lastChild = 1;

	public int parent(int pos){
		if(pos <=0 || pos > lastChild){
			return -1;
		}
		return pos/2;
	}

	public int leftChild(int pos){
		int left = pos * 2;
		if(left<=0 || left >= lastChild){
			return -1;
		}
		return left;
	}

	public int rightChild(int pos){
		int right = pos * 2 + 1;
		if(right >= lastChild){
			return -1;
		}
		return right;
	}

	public void addElement(int key){
		if(lastChild == heap.length){
			doubleSizeOf();
		}
		heap[lastChild] = key;
		swim(lastChild);
		lastChild++;
	}

	public void doubleSizeOf(){
		int[] tempHeap = new int[heap.length*2];
		for(int i = 0; i<heap.length; i++){
			tempHeap[i] = heap[i];
		}
		heap = tempHeap;
	}

	public int getMin(){
		if(lastChild>1){
			return heap[1];
		}

		return -1;
	}

	public void removeMin(){
		lastChild--;
		swap(1, lastChild);
		sink(1, lastChild);
//		swim(1);
	}

	public void sink(int pos, int lastChild){
		int left = leftChild(pos);
		int right = rightChild(pos);
		int posToSwap = pos;
		if(left >0 && left <= lastChild && heap[left] < heap[posToSwap]){
			posToSwap = left;
		}
		if(right > 0 && right < lastChild && heap[right] < heap[posToSwap]){
			posToSwap = right;
		}
		if(pos == posToSwap){
			return;
		}
		swap(posToSwap, pos);
		sink(posToSwap, lastChild);
	}

	public void swim(int pos){
		int parentElement = parent(pos);
		while(parentElement > 0 && heap[parentElement] > heap[pos]){
			swap(parentElement, pos);
			pos = parentElement;
			parentElement = pos/2;
		}
	}

	public void swap(int from, int to){
		int temp = heap[from];
		heap[from] = heap[to];
		heap[to] = temp;
	}
	
	@Override
	public String toString() {
		StringBuilder heapToString = new StringBuilder();
		
		heapToString.append("[");
		for(int i = 0; i<lastChild; i++){
			heapToString.append(heap[i]).append(",");
		}
		heapToString.append("]");
		return heapToString.toString();
	}
}
