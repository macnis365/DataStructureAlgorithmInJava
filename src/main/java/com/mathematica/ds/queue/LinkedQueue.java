package com.mathematica.ds.queue;

/**
 * Implementing Queue using Linked List DS
 * @author user
 *
 */
public class LinkedQueue <E> {

	private int length;
	
	private ListNode<E> front, rear;
	
	public LinkedQueue() {
		length = 0;
		front = rear = null;
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

	/**
	 * Add items into the queue
	 * @param element
	 */
	public void enQueue(E element) {
		
		ListNode newNode = new ListNode(element);
		if(isEmpty())
			front = newNode;
		else
			rear.setNext(newNode);
		rear = newNode;
		length++;
	}

	/**
	 * true if queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	public E deQueue() throws Exception {
		if(isEmpty())
			throw new Exception("Queue Underflow");
		
		E result = front.getData();
		front = front.getNext();
		length--;
		if(isEmpty())/*since rear and front both will point to same element when the size is 1, so check this check is made*/
			rear = null;
		return result;
	}

}
