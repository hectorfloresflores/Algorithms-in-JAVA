package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class BinaryTreeLevelOrderTraversal {

	public static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root){
		
		List<List<Integer>> myList = new ArrayList<List<Integer>>();
		
		function(root, myList, 0);
		
		return myList;
	}
	
	public static void function(TreeNode root, List<List<Integer>> list, int level){
		
		
		if (root == null) {
			return;
		}else if (list.size() < level + 1) {
			LinkedList<Integer> auxList = new LinkedList<>();
			auxList.add(root.val);
			list.add(level, auxList);
		}else {
			list.get(level).add(root.val);
		}
		
		function(root.left, list, level + 1);
		function(root.right, list, level + 1);
		
		
	}
	
	public static void main(String[] args) {
		
		
		List<List<Integer>> myList = new ArrayList<List<Integer>>();
		
		myList.add(new LinkedList<>());
		System.out.print(myList.size());
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		
		node.left.right = new TreeNode(4);
		node.left.right.left = new TreeNode(5);
		
		BinaryTreeLevelOrderTraversal.binaryTreeLevelOrderTraversal(node);

	}

}
