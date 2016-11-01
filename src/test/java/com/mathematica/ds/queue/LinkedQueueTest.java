package com.mathematica.ds.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedQueueTest {

	@Test
	public void LinkedQueueCretion()
	{
		LinkedQueue lLinkedQueue = new LinkedQueue();
	}
	
	@Test
	public void LinkedQueueEnQueueTest()
	{
		LinkedQueue<Integer> lLinkedQueue = new LinkedQueue<Integer>();
		lLinkedQueue.enQueue(121);
		Assert.assertEquals(lLinkedQueue.isEmpty(), false);
	}
	
	@Test(expectedExceptions=Exception.class)
	public void LinkedQueueDeQueueTest() throws Exception
	{
		LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();
		linkedQueue.deQueue();
	}
}
