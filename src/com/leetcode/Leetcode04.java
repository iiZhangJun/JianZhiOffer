package com.leetcode;

/**
 * 04 检查平衡性
 * 描述：实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class Leetcode04<E>{


    public boolean isBalanced(TreeNode<E> root) {
        if(root == null) return true;       // 如果是一颗空树 返回true默认平衡的
        int l = getHeight(root.left);       //计算左子树的高度
        int r = getHeight(root.right);      //计算右子树的高度
        // 每个结点的平衡因子等于左右子树高度的差绝对值   判断整棵树和递归检查左右子树是否平衡，都平衡才满足平衡条件返回true
        return Math.abs(r-l) < 2 && isBalanced(root.left) && isBalanced(root.right);        //

    }

    public int getHeight(TreeNode<E> root){
        if(root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return 1 + Math.max(l, r);
    }

    static class TreeNode<E>{
        E val;
        TreeNode<E> left;
        TreeNode<E> right;
    }



}
