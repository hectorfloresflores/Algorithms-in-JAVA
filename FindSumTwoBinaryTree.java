package com.hectorflores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindSumTwoBinaryTree {

	public static  boolean findTarget(TreeNode root, int k) {
	        
		List<Integer> mylist = new ArrayList<>();
		
		fillList(mylist, root);
		
		Collections.sort(mylist);
		
		int left = 0, right = mylist.size()-1;
		
		int result = 0;
		while(left < right) {
			result = mylist.get(left) + mylist.get(right);
			if (result == k) {
				return true;
			}else if (result > k) {
				right--;
			}else {
				left++;
			}
			
			
		}
		return false;
	 }
	
	public static void fillList(List<Integer> list, TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		list.add(root.val);
		
		fillList(list,root.right);
		fillList(list,root.left);
		
		
	}
	
	public static void main(String[] args) {

		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(1);
		node.right = new TreeNode(3);
		
		System.out.println(findTarget(node, 3));

	}

}
