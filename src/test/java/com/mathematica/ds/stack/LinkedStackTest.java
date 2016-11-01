package com.mathematica.ds.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mathematica.ds.stack.LinkedStack;

public class LinkedStackTest {

	@Test
	public void LinkedStackCreationTest()
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
	}
	
	@Test
	public void LinkedStackSizeTest()
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
		Assert.assertEquals(lLinkedStack.size(), 0);
	}
	
	@Test
	public void LinkedStackIsEmptyTest()
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
		Assert.assertEquals(lLinkedStack.isEmpty(), true);
	}
	
	@Test
	public void LinkedStackPushTest()
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
		lLinkedStack.push(5);
		Assert.assertEquals(lLinkedStack.size(), 1);
	}
	
	@Test
	public void LinkedStackPeekTest() throws Exception
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
		lLinkedStack.push(12);
		lLinkedStack.push(14);
		Assert.assertEquals(lLinkedStack.peek().intValue(), 14);
	}
	
	@Test	
	public void LinkedStackPopTest() throws Exception
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
		lLinkedStack.push(2);
		lLinkedStack.push(1);
		Assert.assertEquals(lLinkedStack.pop().intValue(), 1);
		lLinkedStack.pop();
		Assert.assertEquals(lLinkedStack.size(), 0);
	}
	
	@Test
	public void LinkedStackToStringTest() throws Exception
	{
		LinkedStack<Integer> lLinkedStack = new LinkedStack<Integer>();
		lLinkedStack.push(5);
		lLinkedStack.push(4);
		lLinkedStack.push(3);
		lLinkedStack.push(2);
		lLinkedStack.push(1);
		System.out.println(lLinkedStack.toString());
	}
}
