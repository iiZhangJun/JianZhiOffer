package com.leetcode;

/**
 * 二叉树的最小深度
 * 描述: 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 这道题的关键是搞清楚递归结束条件
 * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
 * 当 root 节点左右孩子都为空时，返回 1
 * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
 * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
 */
public class Leetcode111 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;      //空树 深度为0
        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right==null) return 1;
        //2.如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        if(root.left == null){
            return minDepth(root.right) + 1 ;
        }else if(root.right == null){
            return minDepth(root.left) + 1 ;
        } else {
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            return Math.min(l, r)  + 1;
        }
    }
    //代码简化
    public int minDepth_(TreeNode root) {
        if(root == null) return 0;
        // if(root.left == null && root.right == null) return 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return root.left == null || root.right == null ?  l + r + 1 : Math.min(l, r) + 1;
    }

    static class TreeNode<E>{
        E value;
        TreeNode left;
        TreeNode<E> right;
    }

}
