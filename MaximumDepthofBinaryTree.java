package com.hectorflores;

public class MaximumDepthofBinaryTree {

	
	public static int MaximumDepthofBinaryTree(TreeNode node) {
		return maxLevel(node,0);
	}
	
	private static int maxLevel(TreeNode node, int level) {
		
		if (node == null) {
			return level;
		}
		
		
		return Math.max(maxLevel(node.left, level+1), maxLevel(node.right, level+1));
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		
		
		
		System.out.println(MaximumDepthofBinaryTree(node));

	}

}
