package com.yfd;

/**
 * 27. 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Jzoffer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        if (root.left==null && root.right == null) return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
