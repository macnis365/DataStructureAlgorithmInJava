package com.mathematica.heap;

import org.testng.annotations.Test;

public class HeapTest {

	@Test
	public void testAddElement(){
		Heap minHeap = new Heap();
		minHeap.addElement(9);
		minHeap.addElement(8);
		minHeap.addElement(7);
		minHeap.addElement(10);
		minHeap.addElement(4);
		minHeap.addElement(3);
		minHeap.addElement(2);
		minHeap.addElement(1);
		System.out.println(minHeap.toString());
	}
	
	@Test
	public void delete(){
		Heap minHeap = new Heap();
		minHeap.addElement(9);
		minHeap.addElement(8);
		minHeap.addElement(7);
		minHeap.addElement(10);
		minHeap.addElement(4);
		minHeap.addElement(3);
		minHeap.addElement(2);
		minHeap.addElement(1);
		System.out.println(minHeap.toString());
		
		minHeap.removeMin();
		minHeap.removeMin();
		minHeap.removeMin();
		minHeap.removeMin();
		minHeap.removeMin();
		System.out.println(minHeap.toString());
	}
}
