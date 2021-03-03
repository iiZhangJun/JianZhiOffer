package com.yfd;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> path = new ArrayList<>();
        helper(ans, path, root, sum);
        return ans;
    }


    public void helper (List<List<Integer>> ans, List<Integer> path, TreeNode root, int sum){
        if (root == null) return ;
        if (root.left == null && root.right == null && root.val == sum){
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return ;
        }
        path.add(root.val);
        helper(ans, path, root.left, sum-root.val);
        helper(ans, path, root.right, sum-root.val);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        node1.left = node3;
        node2.left = node4;
        TreeNode node5 = new TreeNode(4);
        node2.right = node5;
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        node3.left = node6;
        node3.right = node7;
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        node5.left = node8;
        node5.right = node9;
        int sum = 22;
        List<List<Integer>> pathSum = new Leetcode113().pathSum(root, sum);
        System.out.println(pathSum.size());
        for (List l : pathSum){
            for(int i=0;i<l.size();i++){
                System.out.println(l.get(i));
            }
        }
    }
}


