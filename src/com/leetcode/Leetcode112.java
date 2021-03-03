package com.leetcode;

/**
 * 112路径总和：
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class Leetcode112 {

    public static void main(String[] args) {
        /**
         * TreeNode root = null;
         * System.out.println(new Leetcode112().hasPathSum(root, 0));
         */

        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(11);
        node2.left = node4;
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        node3.left = node5;
        node3.right = node6;
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        node4.left = node7;
        node4.right = node8;
        TreeNode node9 = new TreeNode(1);
        node6.right = node9;
        System.out.println(new Leetcode112().hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


