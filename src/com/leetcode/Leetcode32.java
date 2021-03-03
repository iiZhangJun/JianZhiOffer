package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 32.从上至下打印二叉树
 */
public class Leetcode32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};       //注意 空数组的初始化
        List<TreeNode> res = new ArrayList<>();     //由于结点树未知，先使用列表动态数组保存 在转化到数组中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        int[] nodes = new int[res.size()];
        for (int i=0; i < nodes.length; i++){
            nodes[i] = res.get(i).val;
        }
        return nodes;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList();
            int len = queue.size();
            for(int i=len; i > 0; i--){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }







    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        List<List<Integer>> ans = new Leetcode32().levelOrder2(root);
        for (int i=0; i < ans.size(); i++){
            for(Integer it: ans.get(i)){
                System.out.print(it);
            }
            System.out.println();
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
