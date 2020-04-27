package com.hectorflores;

import java.util.LinkedList;

public class LeafSimilarTrees {

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		
		LinkedList<Integer> list1 = new LinkedList<>();
		checkSimi(root1,list1);
		LinkedList<Integer> list2 = new LinkedList<>();
		checkSimi(root2,list2);
		
		if (list1.size() != list2.size()) {
			return false;
		}
		
		for(int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		
		return true;
	}

	private static LinkedList<Integer> checkSimi(TreeNode root, LinkedList<Integer> list) {
		
		if (root == null) {
			return null;
		}else if (root.left == null && root.right == null) {
			list.add(root.val);
		}
			
		
		
		
		checkSimi(root.left, list);
		checkSimi(root.right, list);
		
		
			
		
	
		
		
		return list;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(4);
leafSimilar(node, node1);
	}

}
