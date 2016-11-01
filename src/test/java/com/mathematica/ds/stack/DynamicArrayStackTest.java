package com.mathematica.ds.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mathematica.ds.stack.DynamicArrayStack;

public class DynamicArrayStackTest {

	@Test
	public void DynamicArrayStackCreationTest()
	{
	
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		Assert.assertEquals(DynamicArrayStack.CAPACITY, 16);
	}
	
	@Test
	public void DynamicArrayStackSizeTest()
	{
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		Assert.assertEquals(lDynamicArrayStack.size(), 0);
	}
	
	@Test
	public void DynamicArrayStackIsEmptyTest()
	{
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		Assert.assertEquals(lDynamicArrayStack.isEmpty(), true);
	}
	
	@Test
	public void DynamicArrayStackPushTest()
	{
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		lDynamicArrayStack.push(12);
		Assert.assertEquals(lDynamicArrayStack.isEmpty(), false);
		Assert.assertEquals(lDynamicArrayStack.size(), 1);
	}
	
	@Test
	public void DynamicArrayStackTopTest() throws Exception
	{
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		lDynamicArrayStack.push(13);
		lDynamicArrayStack.push(12);
		lDynamicArrayStack.push(11);
		Assert.assertEquals(lDynamicArrayStack.top(), 11);
	}
	
	@Test
	public void DynamicArrayStackPopTest() throws Exception
	{
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		lDynamicArrayStack.push(13);
		lDynamicArrayStack.push(12);
		lDynamicArrayStack.push(11);
		Assert.assertEquals(lDynamicArrayStack.pop(), 11);
		Assert.assertEquals(lDynamicArrayStack.size(), 2);
	}
	
	@Test
	public void DynamicArrayStackToString()
	{
		DynamicArrayStack lDynamicArrayStack = new DynamicArrayStack();
		System.out.println("Size of the stack before push" + lDynamicArrayStack.size());
		lDynamicArrayStack.push(13);
		lDynamicArrayStack.push(12);
		lDynamicArrayStack.push(11);
		System.out.println("Size of the stack after push" + lDynamicArrayStack.size());
		System.out.println(lDynamicArrayStack.toString());
	}
}
