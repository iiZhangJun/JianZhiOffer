package com.leetcode;

/**
 * 101.对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的
 */
public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
        //若是一棵空树  或 只有根节点 返回true
        if (root == null || root.left == null && root.right == null)
            return true;
        if (root.left.val == root.right.val){
            return isMirror(root.left.left, root.right.right) && isMirror(root.left.right, root.right.left);
        }else {
            return false;
        }
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;
        if (left.val == right.val){         //两个根结点的值相同
            //子树1的左子树和子树2的右子树镜像对称 且 子树1的右子树和子树2的左子树镜像对称
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }else {
            return false;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new Leetcode101.TreeNode(1);
        root.left = new Leetcode101.TreeNode(2);;
        root.right = new Leetcode101.TreeNode(2);
        //root.right.left = new Leetcode101.TreeNode(2);
        //root.right.right = new Leetcode101.TreeNode(5);
        System.out.println(new Leetcode101().isSymmetric(root));


    }

}
