package com.mathematica.ds.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mathematica.ds.stack.FixedSizeArrayStack;

public class FixedSizeArrayStackTest {

	@Test
	public void FixedSizeArrayStackCreationTest()
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		Assert.assertEquals(lFixedSizeArrayStack.mCapacity, 10);
	}
	
	@Test
	public void FixedSizeArrayStackSizeTest()
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		Assert.assertEquals(lFixedSizeArrayStack.size(), 0);
	}
	
	@Test
	public void FixedSizeArrayStackIsEmptyTest()
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		Assert.assertEquals(lFixedSizeArrayStack.isEmpty(), true);
		
	}
	
	@Test
	public void FixedSizeArrayStackPush() throws Exception
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		lFixedSizeArrayStack.push(5);
		Assert.assertEquals(lFixedSizeArrayStack.isEmpty(), false);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void FixedSizeArrayStackPushOverflow() throws Exception
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		for(int i = 1; i<lFixedSizeArrayStack.mCapacity+10; i++)
		{
			lFixedSizeArrayStack.push(i);
		}
	}
	
	@Test
	public void FixedSizeArrayStackPop() throws Exception
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		lFixedSizeArrayStack.push(5);
		Assert.assertEquals(lFixedSizeArrayStack.pop(), 5);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void FixedSizeArrayStackTopException() throws Exception
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		lFixedSizeArrayStack.top();
	}
	
	@Test
	public void FixedSizeArrayStackTop() throws Exception
	{
		FixedSizeArrayStack lFixedSizeArrayStack = new FixedSizeArrayStack();
		lFixedSizeArrayStack.push(10);
		Assert.assertEquals(lFixedSizeArrayStack.top(),10);
	}
}
