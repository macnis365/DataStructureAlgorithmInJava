package com.mathematica.ds.tree;

import org.testng.annotations.Test;

public class BinaryTreeNodeTest {

	@Test
	public void createBinaryTreeNode()
	{
		
		getBinaryTreeTestData();
		
	}

	private BinaryTreeNode getBinaryTreeTestData() {
		BinaryTreeNode lRootNode = new BinaryTreeNode(1);
		
		BinaryTreeNode lRootNodeLeftChild = new BinaryTreeNode(2);
		
		BinaryTreeNode lRootNodeRigthChild = new BinaryTreeNode(3);
		
		BinaryTreeNode lLeftNodeLeftChild = new BinaryTreeNode(4);
		
		BinaryTreeNode lLeftNodeRightChild = new BinaryTreeNode(5);
		
		BinaryTreeNode lRightNodeLeftChild = new BinaryTreeNode(6);
		
		BinaryTreeNode lRightNodeRightChild = new BinaryTreeNode(7);
		
		lRootNode.setLeft(lRootNodeLeftChild);
		lRootNode.setRight(lRootNodeRigthChild);
		
		lRootNodeLeftChild.setLeft(lLeftNodeLeftChild);
		lRootNodeLeftChild.setRight(lLeftNodeRightChild);
		
		lRootNodeRigthChild.setLeft(lRightNodeLeftChild);
		lRootNodeRigthChild.setRight(lRightNodeRightChild);
		
		return lRootNode;
	}
	
	@Test
	public void TestPreOrderTraversal()
	{
	
		BinaryTrees lBinaryTrees = new BinaryTrees();
		BinaryTreeNode lBinaryTreeNodeData = getBinaryTreeTestData();
		lBinaryTrees.preOrderTraversal(lBinaryTreeNodeData);
	}
	
	@Test
	public void TestPreOrderTraversalIterative()
	{
		BinaryTrees lBinaryTrees = new BinaryTrees();
		BinaryTreeNode lBinaryTreeNodeData = getBinaryTreeTestData();
		
		System.out.println(lBinaryTrees.preOrderTraversalIterative(lBinaryTreeNodeData).toString());
	}
	
	@Test
	public void TestInOrderTraversal()
	{
		BinaryTrees lBinaryTrees = new BinaryTrees();
		BinaryTreeNode lBinaryTreeNode = getBinaryTreeTestData();
		
		lBinaryTrees.inOrderTraversal(lBinaryTreeNode);
	}
	
	@Test
	public void TestInOrderTraversalIterative()
	{
		BinaryTrees lBinaryTrees = new BinaryTrees();
		BinaryTreeNode lBinaryTreeNodeData = getBinaryTreeTestData();
		
		System.out.println(lBinaryTrees.inOrderTraversalIterative(lBinaryTreeNodeData).toString());
	}
	
	@Test
	public void TestPostOrderTraversal()
	{
		
		BinaryTrees lBinaryTrees = new BinaryTrees();
		BinaryTreeNode lBinaryTreeNodeData = getBinaryTreeTestData();
		
		lBinaryTrees.postOrderTraversal(lBinaryTreeNodeData);
		
	}
	
	@Test
	public void TestPostOrderTravesalIterative()
	{
		BinaryTrees lBinaryTrees = new BinaryTrees();
		BinaryTreeNode lBinaryTreeNodeData = getBinaryTreeTestData();
		
		System.out.println(lBinaryTrees.postOrderTrversalIterative(lBinaryTreeNodeData).toString());
	}
}
