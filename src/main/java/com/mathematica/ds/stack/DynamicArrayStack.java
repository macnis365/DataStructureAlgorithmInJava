package com.mathematica.ds.stack;

/**
 * 
 * @author micheal
 *
 */
public class DynamicArrayStack {
// default capacity of DynamicArrayStack is 16, power of 2
	public static final int CAPACITY = 16;
	
	public static int MINCAPACITY = 1<<15;
	
	public int mCapacity;

	public int[] mStackRep;

	public int mTop = -1;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}

	public DynamicArrayStack(int capacity) {
		mCapacity = capacity;
		mStackRep = new int[mCapacity];
	}

	public int size() {
		return mTop  + 1; 
		
	}

	public boolean isEmpty() {
		return mTop < 0;
		
	}

	/**
	 *insert element into the stack 
	 * @param element
	 */
	public void push(int element) {
		if( size() == mCapacity)
			expand();
		mStackRep[++mTop] = element;
		
	}

	/**
	 * expand the size of the array by 2 once the stack is full
	 */
	private void expand() {
		int length = size();
		int[] newStack = new int[length << 1];
		System.arraycopy(mStackRep, 0, newStack, 0, length);
		mStackRep = newStack;
		
	}

	public int top() throws Exception {
		if(isEmpty())
			throw new Exception("Dynamic Array is Empty, underflow");
		return mStackRep[mTop];
		
	}

	public int pop() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty, underflow");
		int data = mStackRep[mTop];
		mStackRep[mTop--] = Integer.MIN_VALUE; /*Dereference the top element for garbage collection*/
		return data;
	}
	
	@Override
	public String toString()
	{
		String stackRepInString;
		stackRepInString = "[";
		if(size() > 0)
			stackRepInString += mStackRep[0];
		
		if(size() > 1)
			for(int i = 1; i <= size()-1; i++)
				{
				stackRepInString += ", "+ mStackRep[i];
				}
		return stackRepInString + "] ";
	}
		
}

