package com.hectorflores;

public class BinarySearchTreetoGreaterSumTree {

	public static TreeNode binarySearchTreetoGreaterSumTree(TreeNode root) {
		TreeNode theNode = root;
		int myInteger[] = {0};
        return bstToGst(theNode, root, myInteger);
    }
	
	private static TreeNode bstToGst(TreeNode thenode, TreeNode root, int[] value) {
		
		if (root == null) {
			return root;
		}
		
		bstToGst(thenode,root.right, value);
		value[0] =  root.val + value[0];
		root.val = value[0];
	
		bstToGst(thenode,root.left, value);
		
		
		
		return thenode;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.right = new TreeNode(6);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(7);
		node.right.right.right = new TreeNode(8);
		
		node.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		node.left.left = new TreeNode(0);
		node.left.right.right = new TreeNode(3);
		
		BinarySearchTreetoGreaterSumTree.binarySearchTreetoGreaterSumTree(node);
int a = 0;
	}

}
