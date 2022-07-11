package com.leetcode;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestUncommonSubsequenceII {
    int max = -1;
    static class TreeNode {
        private String word;
        TreeNode left;
        TreeNode right;
        boolean goLeft;
        boolean isNotValid;
        private List<String> subsequence;

        public TreeNode(String word) {
            this.word = word;
            this.subsequence = new LinkedList<>();
        }

    }
    boolean isSubsecuent(TreeNode word, TreeNode sub) {
        //We want to check that all sub letters resides in word
        boolean flagFirstTime = false;
        int i = 0;
        for (int wordI = 0; i < sub.word.length() && wordI < word.word.length(); wordI++) {
            int w = word.word.charAt(wordI);
            int s = sub.word.charAt(i);
            if (w == s) {
                i++;
            } else if (!flagFirstTime) {
                sub.goLeft = s < w;
                flagFirstTime = true;
            }
        }
        return sub.word.length() == i;
    }
    void pushFromRootNode(TreeNode root, TreeNode word) {
        if (root.word.equals(word.word)) {
            root.isNotValid = true;
            return;
        }

        if (isSubsecuent(root, word)) {
            root.subsequence.add(word.word);
            return;
        }

        if (word.goLeft) {
            if (root.left == null) {
                root.left = word;
            } else {
                pushFromRootNode(root.left, word);
            }
        } else {
            if (root.right == null) {
                root.right = word;
            } else {
                pushFromRootNode(root.right, word);
            }
        }
    }

    void findLongestUncommonSubsequence(TreeNode root) {
        if (root == null) {
            return;
        }
        //If valid
        if (!root.isNotValid) {
            max = Math.max(root.word.length(), max);
        }

        findLongestUncommonSubsequence(root.left);
        findLongestUncommonSubsequence(root.right);
    }

    public int findLUSlength(String[] strs) {
        boolean first = false;
        TreeNode root = null;
        for (String s : strs) {
            if (!first) {
                root = new TreeNode(s);
                first = true;
                continue;
            }
            pushFromRootNode(root, new TreeNode(s));
        }
        findLongestUncommonSubsequence(root);
        return max;
    }

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        LongestUncommonSubsequenceII l = new LongestUncommonSubsequenceII();
        l.findLUSlength(new String[]{"abcdef","abcdef","abbdf"});
    }
}
