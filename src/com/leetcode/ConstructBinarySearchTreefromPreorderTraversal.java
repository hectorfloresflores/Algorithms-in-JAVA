package com.leetcode;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * The values of preorder are distinct.
 */



class TreeNodeTras {
    int val;
    TreeNodeTras left;
    TreeNodeTras right;
    TreeNodeTras() {}
    TreeNodeTras(int val) { this.val = val; }
    TreeNodeTras(int val, TreeNodeTras left, TreeNodeTras right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinarySearchTreefromPreorderTraversal {

    TreeNodeTras tree;
    public TreeNodeTras bstFromPreorder(int[] preorder) {

        for(int i : preorder) {
            if (tree == null) {
                tree = new TreeNodeTras(i);
            } else {
                push(tree, i);
            }

        }
        return tree;
    }

    public void push(TreeNodeTras aux, int a) {


        if (a < aux.val) {
            if (aux.left == null) {
                aux.left = new TreeNodeTras(a);
                return;
            }
            push(aux.left, a);
        } else {
            if (aux.right == null) {
                aux.right = new TreeNodeTras(a);
                return;
            }
            push(aux.right, a);
        }

    }

    public static void main(String[] args) {
        ConstructBinarySearchTreefromPreorderTraversal tree =
                new ConstructBinarySearchTreefromPreorderTraversal();
        int[] arr = new int[]{8,5,1,7,10,12};
        tree.bstFromPreorder(arr);
        int a = 0;
    }
}
