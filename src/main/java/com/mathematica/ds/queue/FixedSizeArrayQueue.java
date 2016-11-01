package com.mathematica.ds.queue;

public class FixedSizeArrayQueue {
//	Array used to implement the queue
	private int[] queueRep;
	
	private int size, front, rear;
	
//	Length of the array used to implement the queue.
	private static final int CAPACITY = 16;
	
//	variable which holds the queue capacity.
	private int mCapacity;
	
//	Initialize the queue with an array of default length.
	public FixedSizeArrayQueue() {
		this(CAPACITY);
	}
	
//	Initialize the queue with an array of user defined lenght.
	public FixedSizeArrayQueue(int capacity)  {
		queueRep = new int[capacity];
		mCapacity = capacity;
		size = 0; front = 0; rear = 0;
	}

//	Insert elements into the Fixed array queue at the rear of the queue. This method runs in O(1) time.
	public void enQueue(int element) throws Exception {
		if(size == mCapacity)
			throw new Exception("Queue overflow.");
		queueRep[rear] = element;
		size++;
//		increamenting rear by 1 and mod mCapacity, bcoz once rear == mCapacity, mod operation will be zero.
//		rear cannot be more than mCapacity
		rear = ((rear + 1) % mCapacity);
	}

/**
 * 
 * @return number of the elements in the queue. This method runs in O(1) time.
 */
	public int size() {
		return size;
	}
/**
 * 
 * @return true if the queue is empty, else false. This method runs in O(1) time.
 */
	public boolean isEmpty() {
		return (size == 0);
		
	}

	/**
	 * 
	 * @return true if the queue is full. This method runs in O(1) time.
	 */
	public boolean isFull() {
		return size == mCapacity; 
		
	}

/**
 * Removes the element at the front of the queue. This method runs in O(1) time.
 * @return element at the front
 * @throws Exception 
 */
	public int deQueue() throws Exception {

		if(isEmpty())
			throw new Exception("Queue Underflow");
		
		int data = queueRep[front % mCapacity];
		queueRep[front] = Integer.MIN_VALUE;
		size--;
		front = (front + 1) % mCapacity;
		return data;		
	}	
	
	/**
	 * Return a string representation of the queue as a list of elements. This method runs in 0(n) time.
	 */
	@Override
		public String toString() {
			String stringQueue = "";
//			stringQueue = "["+queueRep[0]+"]\n";
			for(int i = 0; i<size; i++)
			{
				stringQueue = stringQueue + "["+ queueRep[(front + i) % mCapacity] + "]\n";
			}
			return stringQueue;
		}
}
