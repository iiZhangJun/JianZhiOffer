package com.jzoffer;

/**
 * 26 树的子结构
 */
public class JZOffer26 {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {  //判断是否包含子结构，注意是包含
        if (A == null) return false;
        if (B == null) return false;
        return isSameStructure(A, B)  || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static boolean isSameStructure(TreeNode A, TreeNode B){          //判断是否是相同子结构，注意是相同
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val)
            return false;
        else {
            return isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        node2.left = node5;
        node2.right = node6;

        System.out.println(JZOffer26.isSubStructure(root, node2));
    }


}
