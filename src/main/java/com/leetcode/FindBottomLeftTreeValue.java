package com.leetcode;

import java.util.stream.IntStream;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class FindBottomLeftTreeValue {
    //mostBottomLeft[0] = level, mostBottomLeft[1] = value
    int[] mostBottomLeft = new int[]{-1,-1};
    public void recursiveSearch(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > mostBottomLeft[0]) {
            mostBottomLeft[0] = level;
            mostBottomLeft[1] = root.val;
        }
        recursiveSearch(root.left, level+1);
        recursiveSearch(root.right, level+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        recursiveSearch(root, 0);
        return mostBottomLeft[0] == -1 ? -1 : mostBottomLeft[1];
    }

    public static void main(String[] args) {
        IntStream.iterate(1, n -> n + 1)
            .skip(Integer.parseInt("8"))
            .limit(Integer.parseInt("8"))
            .forEach(System.out::println);
    }
}

