package com.mathematica.ds.tree;

import java.util.ArrayList;

import com.mathematica.ds.stack.LinkedStack;

/**
 * 
 * @author micheal
 *
 */
public class BinaryTrees {

	/**
	 * PreOrder(DLR) Traversal
	 * Recursive method
	 * 
	 */
	public void preOrderTraversal(BinaryTreeNode root) {
		
		if(root != null)
		{
			System.out.println(root.data);
			
			preOrderTraversal(root.left);
			
			preOrderTraversal(root.right);
		}
		
	}

	/**
	 * PreOrder(DLR) Traversal
	 * Non Recursive method
	 * @param root
	 * @return arraylist of preOrdered tree data
	 */
	public ArrayList<Integer> preOrderTraversalIterative(BinaryTreeNode root) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();	
		
		if(root == null)
			return result;
		
		LinkedStack<BinaryTreeNode> stack = new LinkedStack<BinaryTreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			try {
				BinaryTreeNode temp = stack.pop();
				result.add(temp.data);
				
				if(temp.right != null)
					stack.push(temp.right);
				
				if(temp.left != null)
					stack.push(temp.left);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	/**
	 * InOrder(LDR) Traversal
	 * @param root
	 * Recursive approach
	 */
	public void inOrderTraversal(BinaryTreeNode root) {
		
		if(root != null)
		{
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
		
	}

	/**
	 * InOrder(LDR) Traversal
	 * @param lBinaryTreeNodeData
	 * Non Recursive approach
	 * @return 
	 */
	public ArrayList<Integer> inOrderTraversalIterative(BinaryTreeNode root) {
		ArrayList<Integer> lResult = new ArrayList<Integer>();
		LinkedStack<BinaryTreeNode> lStack = new LinkedStack<BinaryTreeNode>();
		BinaryTreeNode lCurrentNode = root;
		boolean done = false;
		
		while(!done)
		{
			if(lCurrentNode != null)
			{
				lStack.push(lCurrentNode);
				lCurrentNode = lCurrentNode.left;
			}
			else
			{
				if(lStack.isEmpty())
				{
					done = true;
				}
				else
				{
					try {
						lCurrentNode = lStack.pop();
						lResult.add(lCurrentNode.data);
						lCurrentNode = lCurrentNode.right;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return lResult;
	}

	/**
	 * PostOrder(LRD) Traversal
	 * @param root
	 * Recursive approach
	 */
	public void postOrderTraversal(BinaryTreeNode root) {
		if(root != null)
		{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
		
	}

	/**
	 * PostOrder(LRD) Traversal
	 * @param root
	 * @return
	 * Non Recursive approach
	 */
	public ArrayList<Integer> postOrderTrversalIterative(BinaryTreeNode root) {
		ArrayList<Integer> lResult = new ArrayList<Integer>();
		if(root == null)
			return lResult;
		
		LinkedStack<BinaryTreeNode> lStack = new LinkedStack<BinaryTreeNode>();
		lStack.push(root);
		BinaryTreeNode lPreviousNode = null;
		while(!lStack.isEmpty())
		{
			try {
				BinaryTreeNode lCurrentNode = lStack.peek();
				
				if( lPreviousNode == null || lPreviousNode.left == lCurrentNode || lPreviousNode.right == lCurrentNode)
				{
					/*Traverse from top to bottom, and if lCurrentNode has left child or right child,
					 * push into the Stack, otherwise, pop out*/
					if( lCurrentNode.left != null)
					{
						lStack.push(lCurrentNode.left);
					}
					else if( lCurrentNode.right != null)
					{
						lStack.push(lCurrentNode.right);
					}
				}
				else if( lCurrentNode.left == lPreviousNode)
				{
					if(lCurrentNode.right != null)
						lStack.push(lCurrentNode.right);
					
				}
				else
				{
					lResult.add(lCurrentNode.data);
					lStack.pop();
				}
				
				lPreviousNode = lCurrentNode;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return lResult;
	}

}
