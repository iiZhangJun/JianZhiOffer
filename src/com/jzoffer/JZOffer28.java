package com.jzoffer;

import sun.reflect.generics.tree.Tree;

public class JZOffer28 {
    /**
     * 判断左右子树是否互为兑成即镜像关系
     * 镜像关系：根节点相同，左右互为镜像，右左互为镜像
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right==null) return true;
        if (root.left == null || root.right == null) return false;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode rootA, TreeNode rootB){
        if (rootA == null && rootB==null) return true;
        if (rootA == null || rootB==null) return false;
        if (rootA.val != rootB.val) return false;
        return isMirror(rootA.left, rootB.right) && isMirror(rootA.right, rootB.left);
    }


    public boolean isSymmetric2(TreeNode root) {
        if(root == null || root.left == null && root.right==null) return true;
        if (root.left == null || root.right == null) return false;
        return preOrder(root).equals(mirrorpreOrder(root));
    }

    public String preOrder(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root==null) return sb.toString();
        sb.append(root.val);
        if (root.left ==null)
            sb.append("Null");
        else
            sb.append(preOrder(root.left));

        if (root.right == null)
            sb.append("Null");
        else
            sb.append(preOrder(root.right));
        return sb.toString();
    }


    public String mirrorpreOrder(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root==null) return sb.toString();
        sb.append(root.val);
        if (root.right == null)
            sb.append("Null");
        else
            sb.append(mirrorpreOrder(root.right));

        if (root.left ==null)
            sb.append("Null");
        else
            sb.append(mirrorpreOrder(root.left));
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);
        node2.left = node5;
        node2.right = node6;
        System.out.println(new JZOffer28().preOrder(root));
        System.out.println(new JZOffer28().mirrorpreOrder(root));
        System.out.println(new JZOffer28().isSymmetric2(root));
    }


}
