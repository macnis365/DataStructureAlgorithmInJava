package com.mathematica.ds.tree;

/**
 * 
 * @author micheal
 *
 */
public class BinaryTreeNode {

	public int data;
	
	public BinaryTreeNode left;
	
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int data)
	{
		this.data = data;
		
		left = null;
		
		right = null;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinaryTreeNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	
	
}
