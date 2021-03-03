package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树中的列表      //判断子路径
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
 */
public class Leetcode1367<E> {
    /**
     * 解法一
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode<E> head, TreeNode<E> root){
        if(head == null) return true;       //若head为空，即链表为空，返回TRUE
        if(root == null) return false;      //此时说明head不为空，链表不为空，而root为空，即树空树，返回false
        if(head.value == root.value){       //此时root和head均不为空，若root和head的值域相等时，继续比较左右子树
             return isSubPath(head, root.left) || isSubPath(head, root.right)|| isHeadSubPath(head.next, root.left) || isHeadSubPath(head.next, root.right);
         }else {
            //此时head.value != root.value ，则要查找root.left或root.right中是否存在以head为头结点的链表
             return isSubPath(head, root.left) || isSubPath(head, root.right);
         }
    }

    public boolean isHeadSubPath(ListNode<E> head, TreeNode<E> root){
        if(head==null) return true;
        if(root==null) return false;
        if(head.value != root.value){
            return false;
        }else{
            return isHeadSubPath(head.next, root.left) || isHeadSubPath(head.next, root.right);
        }

    }


    static class TreeNode<E>{
        E value;
        TreeNode<E> left;
        TreeNode<E> right;
    }
    static class ListNode<E>{
        E value;
        ListNode<E> next;
    }

    /**
     * 解法二: BFS + DFS
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath_(ListNode<E> head, TreeNode<E> root){
        if(head == null) return true;       //若空链表返回true,空链表可作为一个子路径
        if(root == null) return false;      //若链表不为空，root树为空，返回false
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();   //使用队列层级遍历BFS
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode<E> parent = queue.poll();      //出队列
            if(parent.left != null)     //孩子结点入队列
                queue.add(parent.left);
            if(parent.right != null)
                queue.add(parent.right);
            if(parent.value == head.value){     //出队列时若当前结点的值和head结点的值相等，开始dfs深度搜索
                if(dfs(head, parent)) return true;
            }       //否则，若当前结点的值和head结点的值不相等时，继续遍历
        }
        return false;
    }

    public boolean dfs(ListNode<E> head, TreeNode<E> root){
        if(head == null) return true;
        if(root == null) return false;
        if(head.value == root.value){
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }else {
            return false;
        }
    }


}
