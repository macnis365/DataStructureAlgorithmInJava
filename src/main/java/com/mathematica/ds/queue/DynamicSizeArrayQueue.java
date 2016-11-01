package com.mathematica.ds.queue;
/**
 * Queue implementation for dynamic array size
 * @author micheal
 *
 */
public class DynamicSizeArrayQueue {
//	Array used to  implement the queue.
	private int[] queueRep;
	
	private int size, front, rear;
	
//	Capacity of the queue
	private int mCapacity;
	
//	Default length of the queue
	private static final int CAPACITY = 16;
	
	public DynamicSizeArrayQueue() {
		this(CAPACITY);
	}

	public DynamicSizeArrayQueue(int capacity) {
		mCapacity = capacity;
		queueRep = new int[mCapacity];
		front = 0; rear = 0; size = 0;
	}

/**
 * add the data into queue at rear side
 * @param data
 */
	public void enQueue(int data) {
		if(size == mCapacity)
			expand();
		
		queueRep[rear] = data;
		rear = (rear + 1) % mCapacity;
		size++;
	}

	/**
	 * double queue size
	 */
	private void expand() {
		int length = size;
		
//		2*length
		int[] newQueue = new int[length<<1 ];
		
//		copy items from front of the queue till size of the old queue.
		for(int i = front; i <= size; i++)
			newQueue[i] = queueRep[i%mCapacity];
		
		queueRep = newQueue;
		front = 0;
		mCapacity = length<<1; /* Doubled capacity of the queue*/
		rear = (length+1) % mCapacity; /*rear will be  pointing at the last inserted position, not the total capacity of the queue*/
		
	}

	public int deQueue() throws Exception {
		
		if(size()==0)
			throw new Exception("Queue Underflow");
		
		int length = size();
		int data = queueRep[front%mCapacity];
		queueRep[front] = Integer.MIN_VALUE;
		front = (front + 1) % mCapacity;
		return data;
	}

	/**
	 * returns number of elements in the queue
	 * @return
	 */
	public int size() {
		return size;
	}
}
