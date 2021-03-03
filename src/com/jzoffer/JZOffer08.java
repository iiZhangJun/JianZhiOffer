package com.jzoffer;

import sun.reflect.generics.tree.Tree;

public class JZOffer08 {

    //  找node中序遍历的后继节点
    public TreeNode getProcessor(TreeNode root, TreeNode node) {
        if (root==null || node == null || root==node) return null;
        if (node.right != null){        //若node的右节点存在，则后继是右子树中的最左子节点
            TreeNode processor = node.right;
            while (processor.left != null){
                processor = processor.left;
            }
            return processor;
        }else {     //若node的右子树不存在，则向上追溯
            TreeNode processor = node.parent;
            if (node == processor.left){
                return processor;
            }else {
                while (processor.parent != null){
                    if (processor == processor.parent.left){
                        return processor.parent;
                    }
                    processor = processor.parent;
                }
                return null;
            }
        }
    }

    public static void main(String[] args) {





    }




}
