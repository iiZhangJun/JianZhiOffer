package com.jzoffer;

import java.util.Arrays;

public class JZOffer07 {
    public static synchronized TreeNode buildTree(int[] preorder, int[] inorder) {


        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length ==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i=0;i<inorder.length;i++){
            if (preorder[0] == inorder[i]){
                index = i;      //root在中序遍历数组中的位置
            }
        }
        if (index > 0 && index < inorder.length){
            root.left = buildTree(Arrays.copyOfRange(preorder, 1,index+1), Arrays.copyOfRange(inorder, 0, index));
        }
        if (index >= 0 && index < inorder.length-1){
            root.right = buildTree(Arrays.copyOfRange(preorder, index+1,preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));
        }
        return root;
    }


    public void postOrder(TreeNode root) {

        synchronized (this){
            System.out.println("xxx");
        }
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};

        int[] preorder2 = new int[]{1,3,5,6,8};
        int[] inorder2 = new int[]{1,5,3,8,6};

        int[] preorder3 = new int[]{1,3,5,6,8};
        int[] inorder3 = new int[]{1,3,5,6,8};
        TreeNode root = JZOffer07.buildTree(preorder3, inorder3);
        //postOrder(root);
    }






}
