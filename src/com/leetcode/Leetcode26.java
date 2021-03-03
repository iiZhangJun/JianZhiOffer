package com.leetcode;

/**
 * 判断树的子结构    // 判断子树
 * 描述：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 */
public class Leetcode26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;//B为空树
        if(A == null) return false;//A为空树
        if(A.val == B.val){     // 若A结点和B结点相同，判断A的左子树和B的左子树是否相同， 或者A的右子树和B的右子树相同
            return isSubStructure(A.left, B) || isSubStructure(A.right, B)|| isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);
        }else {
            //A和B结点不同，则判断B树是不是A左子树中的子树 或 B树是不是A右子树中的子树
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }
    public boolean isSameStructure(TreeNode A, TreeNode B){ //判断A和B结构是否相同
        if(B == null) return true;      //若子树B为空说明以匹配完成
        if(A == null) return false;     //此时B不为空，若A为空说明B已经超越过A，匹配失败
        if (A.val != B.val) {   //当A和B的值不同时，匹配失败
            return false;
        }else {
            //若A与B都不为空，且A与B结点值相等，则分别继续判断A和B的左右子树
            return isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);        //
        }


    }


    class TreeNode<E>{
        E val;
        TreeNode<E> left;
        TreeNode<E> right;
    }

}
