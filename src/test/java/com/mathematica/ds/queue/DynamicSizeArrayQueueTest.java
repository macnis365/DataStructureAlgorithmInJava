package com.mathematica.ds.queue;

import org.testng.annotations.Test;

public class DynamicSizeArrayQueueTest {

	@Test
	public void DynamicSizeArrayQueueCreation()
	{
		DynamicSizeArrayQueue lDynamicSizeArrayQueue = new DynamicSizeArrayQueue();
		DynamicSizeArrayQueue lArrayQueue = new DynamicSizeArrayQueue(32);
	}
	
	@Test
	public void DynamicSizeArrayQueueEnQueueTest() {
		DynamicSizeArrayQueue lDynamicSizeArrayQueue = new DynamicSizeArrayQueue(3);
		lDynamicSizeArrayQueue.enQueue(1231);
		lDynamicSizeArrayQueue.enQueue(1231);
		lDynamicSizeArrayQueue.enQueue(1231);
		lDynamicSizeArrayQueue.enQueue(1231);
	}
	
	@Test
	public void DynamicSizeArrayQueueDeQueueTest() throws Exception {
		DynamicSizeArrayQueue lDynamicSizeArrayQueue = new DynamicSizeArrayQueue(6);
		lDynamicSizeArrayQueue.deQueue();
		
	}
}
