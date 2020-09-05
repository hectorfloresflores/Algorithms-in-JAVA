package com.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class AllElementsinTwoBinarySearchTrees {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            List<Integer> list1 = new LinkedList<>();

            recursiveGet(list1, root2);

            return list1;
        }
        List<Integer> list1 = new LinkedList<>();

        recursiveGet(list1, root1);

        recursiveInsert(list1, new int[]{0}, root2);

        return list1;
    }

    static void  recursiveInsert(List<Integer> list, int[] pos, TreeNode root) {
        if (root == null) {
           return;
        }
        recursiveInsert(list, pos, root.left);
        while (pos[0] < list.size()) {
            if (list.get(pos[0]) == root.val) {
                list.add(pos[0]+1, root.val);
                pos[0]++;
                break;
            } else if (list.get(pos[0]) > root.val) {

                list.add(pos[0], root.val);

                break;
            } else if (list.get(pos[0]) < root.val &&
                    pos[0] == (list.size() - 1)) {
                list.add(pos[0]+1, root.val);
                break;
            }
            pos[0]++;

        }

        recursiveInsert(list, pos, root.right);
    }

    static void  recursiveGet(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveGet(list, root.left);
        list.add(root.val);
        recursiveGet(list, root.right);
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
//        node1.left = new TreeNode(1);
//        node1.right = new TreeNode(4);
//        node1.right = new TreeNode(5);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(0);
        node2.right = new TreeNode(3);

        getAllElements(node1, node2);


    }
}