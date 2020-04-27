package com.leetcode;

//Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//        Example:
//        Given a binary tree
//        1
//        / \
//        2   3
//        / \
//        4   5
//        Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//        Note: The length of path between two nodes is represented by the number of edges between them.



  class TreeNode3 {
      int val;
      TreeNode3 left;
      TreeNode3 right;
      TreeNode3(int x) { val = x; }
  }


public class DiameterofBinaryTree {

    static public int recursive(int max, TreeNode3 node) {
        if (node == null) {
            return max;
        }
        return Math.max(recursive(max + 1, node.left), recursive(max + 1, node.right));
    }

    static public int diameterOfBinaryTree1(TreeNode3 root) {

        if (root == null) return 0;
        return DiameterofBinaryTree.recursive(0, root.left) +
                 DiameterofBinaryTree.recursive(0, root.right);

    }

    static public int eachNode(int max, TreeNode3 node) {

        if (node == null) {
            return max;
        }

        max = Math.max(diameterOfBinaryTree1(node),max);
        return Math.max(eachNode(max, node.left), eachNode(max, node.right));
    }

    static public int diameterOfBinaryTree(TreeNode3 node) {
        return eachNode(0,node);
    }

    public static void main(String[] args) {

        TreeNode3 node1 = new TreeNode3(4   );
        node1.left = new TreeNode3(-3);

        TreeNode3 node = new TreeNode3(-9   );

        node.left = new TreeNode3(9);
        node.left.left = new TreeNode3(6);
        node.left.left.left = new TreeNode3(0);
        node.left.left.left.right = new TreeNode3(-1);

        node.left.left.right = new TreeNode3(6);
        node.left.left.right.left = new TreeNode3(-4);


        node.right = new TreeNode3(-7);
        node.right.right = new TreeNode3(-6);
        node.right.right.right = new TreeNode3(9);
        node.right.right.right.right = new TreeNode3(-2);
        node1.left.right = node;
        int[] max = new int[]{0};
//        DiameterofBinaryTree.eachNode(max,node);
//        System.out.println(max[0]);
        System.out.println(DiameterofBinaryTree.diameterOfBinaryTree(node1));
    }

}
