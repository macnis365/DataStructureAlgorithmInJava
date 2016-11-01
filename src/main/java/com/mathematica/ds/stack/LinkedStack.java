package com.mathematica.ds.stack;

/**
 * Implementing stacks using Linked Lists
 * @author micheal
 *
 * @param <E>
 */
public class LinkedStack<E> {

	private int length;
	private ListNode<E> top;

	public LinkedStack()
	{
		length = 0;
		top = null;
	}
	
	class ListNode<E>
	{
		private E data;
		private ListNode<E> next;
		
		ListNode(E data)
		{
			this.data = data;
		}

		public void setNext(ListNode<E> node) {
			this.next = node;
			
		}

		public ListNode<E> getNext() {
			return this.next;
		}
		
		public E getData()
		{
			return this.data;
		}
		
		@Override
		public String toString() {
			return getData().toString();
		}
	}

	public int size() {
		return length;
		
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public void push(E element) {

		ListNode<E> temp = new ListNode<E>(element);
		temp.setNext(top);
		top = temp;
		length++;
	}

	public E peek() throws Exception {
		if( isEmpty() )
			throw new Exception("Stack Underflow");
		return top.getData();
		
	}

	public E pop() throws Exception {
		if(isEmpty())
			throw new Exception("Stack Underflow");
		E result = top.getData();
		top = top.getNext();
		length--;
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		ListNode<E> current = top;
		while(current != null){
			result = result + "[" + current.toString() + "]\n";
			current = current.getNext();
		}
		return result;
	}
}
