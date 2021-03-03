package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 37. 序列化和反序列二叉树   层级遍历的思想
 */
public class Leetcode37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sbd = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sbd.append("[" + root.val);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();           //弹出当前元素作为父节点
            if (node.left != null) {        //检查当前结点node的左孩子是否null
                sbd.append("," + node.left.val);    //不为null，入队列
                queue.add(node.left);
            }else {         //若当前结点node的左孩子为null，入队列
                sbd.append(",null");        //为Null,不入队列，用Null串表示
            }
            if (node.right != null) {        //若当前结点node的右孩子不为null，入队列
                sbd.append("," + node.right.val);
                queue.add(node.right);
            }else {                            //若当前结点node的右孩子为null，入队列
                sbd.append(",null");
            }
        }
        sbd.append("]");
        return sbd.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length()-1);     //去掉字符串中的首尾[]字符，即取中间串
        if (data.equals("")) return null;   //若是空串，则返回null，空树
        String[] values = data.split(",");
       // TreeNode node = new TreeNode(Integer.parseInt(values[0]));       //否则 root结点指向第一个元素
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            // 从队列中取出节点，然后根据是否为null，依次设置left和right
            // 如果不是null，则需要加入队列，后续需要处理此有效节点的左右节点
            if (!values[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);     //左孩子入队列
            }
            i++;
            if (!values[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);    //右孩子入队列
            }
            i++;
        }
        return root;
    }

    public void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);;
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Leetcode37().serialize(root));

        new Leetcode37().inOrder(root);
        System.out.print("\n");
        TreeNode root2 = new Leetcode37().deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
        new Leetcode37().inOrder(root2);
    }


}
