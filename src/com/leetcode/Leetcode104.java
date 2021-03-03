package com.leetcode;

/**
 * 104.二叉树的最大深度,其实实质就是求高度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Leetcode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null){
            return maxDepth(root.right) + 1;
        }else if(root.right == null){
            return maxDepth(root.left) + 1;
        }else {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return Math.max(l, r) + 1;
        }
    }


    static class TreeNode<E>{
        E value;
        TreeNode left;
        TreeNode<E> right;
    }

}
