package com.mathematica.ds.stack;

/**
 * Fixed Size Array Stack Implementation
 * @author micheal
 *
 */
public class FixedSizeArrayStack {

//	Default capacity for the stack is 10
	public static final int CAPACITY = 10;
//	Length of the array used to implement the stack
	public int mCapacity;
	
	public int[] mStackRep;
	public int top = -1;

	public FixedSizeArrayStack() {
		this(CAPACITY);
	}

	public FixedSizeArrayStack(int capacity) {
		this.mCapacity = capacity;
		mStackRep = new int[mCapacity];
	}

	/*
	 * Returns the size or number of elements in the stack
	 */
	public int size() {
		return top + 1;
		
	}

	/*
	 * Returns true if the stack is empty, else false
	 */
	public boolean isEmpty() {
		return top < 0;
		
	}

	public void push(int element) throws Exception {
		if( size() == mCapacity)
		
			throw new Exception("Stack is full, overflow");

		mStackRep[++top] = element;
		
	}

	/**
	 * 
	 * @return the top element in the stack and removes this element from the stack
	 * @throws Exception
	 */
	public int pop() throws Exception {
		int data;
		if(isEmpty())
			throw new Exception("No elements in the stack, underflow");
		data = mStackRep[top];
		mStackRep[top--] = Integer.MIN_VALUE;
		
		return data;
		
	}

	public int top() throws Exception {
		 if( isEmpty() )
			 throw new Exception("No element in the stack, underflow");
		 return mStackRep[top];
		
	}
	
	
}
