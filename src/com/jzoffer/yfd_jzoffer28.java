package com.jzoffer;

import sun.reflect.generics.tree.Tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class yfd_jzoffer28 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        if (root.left==null && root.right==null) return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left!=null) mirrorTree(root.left);
        if (root.right!=null) mirrorTree(root.right);
        return root;
    }

    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(7);
//        root.left = node1;
//        root.right = node2;
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(3);
//        node1.left = node3;
//        node1.right = node4;
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(9);
//        node2.left = node5;
//        node2.right = node6;
        new yfd_jzoffer28().inorder(root);
        new yfd_jzoffer28().mirrorTree(root);
        new yfd_jzoffer28().inorder(root);
    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode parent;
      TreeNode(int x) { val = x; }
}

