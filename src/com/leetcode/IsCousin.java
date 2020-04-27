package com.leetcode;

/*
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 * 
 * 
 */

class TreeNode{
	Integer val;
	 TreeNode left;
     TreeNode right;
	 TreeNode(Integer x) { val = x; }
}

public class IsCousin {

		
	public static boolean isCousin(TreeNode root, int x, int y) {
		
		
		Integer[] array1 = whichLevelIfExits(root, x, 0,root.val);
		Integer[] array2 = whichLevelIfExits(root, y, 0,root.val);
		
		if (array1 == null || array2 == null) {
			return false;
		}
		
		return array1[0] == array2[0] && array1[1] != array2[1];
	}
		
	public static Integer[] whichLevelIfExits(TreeNode root, int value, int level, int parent) {
		
		if (root == null) {
			return null;
		}else if (root.val == value) {
			Integer[] array = new Integer[] {level,parent,0};		
			return array;
		}
		
		

		Integer[] array1 = whichLevelIfExits(root.left, value, level+1,root.val);
		
		if (array1 != null) {
			return array1;
		}else {
			return whichLevelIfExits(root.right, value, level+1,root.val);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		
		node.left.right = new TreeNode(4);
		node.left.right.left = new TreeNode(5);
		
		
		
		System.out.println(isCousin(node, 2,4));

	}

}
