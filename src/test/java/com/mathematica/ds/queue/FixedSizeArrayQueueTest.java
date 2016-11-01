package com.mathematica.ds.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mathematica.ds.queue.FixedSizeArrayQueue;

public class FixedSizeArrayQueueTest {

	@Test
	public void FixedSizeArrayQueueCreation()
	{
		FixedSizeArrayQueue lFixedSizeArrayQueue = new FixedSizeArrayQueue();
		FixedSizeArrayQueue lUserDefinedSizeArrayQueue = new FixedSizeArrayQueue(32);
	}
	
	@Test
	public void FixedSizeArrayQueueEnQueueTest() throws Exception
	{
		FixedSizeArrayQueue lFixedSizeArrayQueue = new FixedSizeArrayQueue();
		lFixedSizeArrayQueue.enQueue(10);
	}
	
	@Test
	public void FixedSizeArryaQueueSizeTest() throws Exception
	{
		FixedSizeArrayQueue lFixedSizeArrayQueue = new FixedSizeArrayQueue();
		lFixedSizeArrayQueue.enQueue(20);
		lFixedSizeArrayQueue.enQueue(22);
		Assert.assertEquals(lFixedSizeArrayQueue.size(), 2);
	}
	
	@Test
	public void FixedSizeArrayQueueisEmpty()
	{
		FixedSizeArrayQueue lArrayQueue = new FixedSizeArrayQueue();
		Assert.assertEquals(lArrayQueue.isEmpty(), true);
	}
	
	@Test
	public void FixedSizeArrayQueueisFull()
	{
		FixedSizeArrayQueue lFixedSizeArrayQueue = new FixedSizeArrayQueue();
		Assert.assertEquals(lFixedSizeArrayQueue.isFull(), false);
	}
	
	@Test
	public void FixedSizeArrayQueueDeQueue() throws Exception
	{
		FixedSizeArrayQueue lFixedSizeArrayQueue = new FixedSizeArrayQueue();
		lFixedSizeArrayQueue.enQueue(20);
		lFixedSizeArrayQueue.enQueue(22);
		lFixedSizeArrayQueue.enQueue(20);
		lFixedSizeArrayQueue.enQueue(22);
		lFixedSizeArrayQueue.enQueue(20);
		lFixedSizeArrayQueue.enQueue(22);
		lFixedSizeArrayQueue.enQueue(20);
		lFixedSizeArrayQueue.enQueue(22);
		lFixedSizeArrayQueue.deQueue();
		System.out.println(lFixedSizeArrayQueue.toString());
	}
}
