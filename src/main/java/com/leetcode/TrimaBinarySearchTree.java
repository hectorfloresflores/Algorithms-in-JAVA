package com.leetcode;

/**
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 */
public class TrimaBinarySearchTree {

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
        private static int lowRange;
        private static int highRange;
        public static TreeNode trimBST(TreeNode root, int low, int high) {
            lowRange = low;
            highRange = high;

            return recursive(root);

        }

        private static TreeNode recursive(TreeNode root){



            if (isInRange(root.val)) {

                if (root.left != null)
                    root.left = recursive(root.left);

                if (root.right != null)
                    root.right = recursive(root.right);

                return root;
            }
            //If is lower than range
            else if (root.val < lowRange) {
                root.left = null;
                if (root.right != null)
                    return recursive(root.right);

            } else{
                root.right = null;
                if (root.left != null)
                    return recursive(root.left);
            }

            return null;
        }

        private static boolean isInRange(int number) {
            if (number <= highRange && number >= lowRange){
                return true;
            }

            return false;
        }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(11);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);

        node.left.right = new TreeNode(9);
        node.left.right.right = new TreeNode(10);
        node.left.left = new TreeNode(3);

        TrimaBinarySearchTree.trimBST(node, 9, 15);

    }

}
