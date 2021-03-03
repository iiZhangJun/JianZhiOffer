package com.hot;

/**
 * 改进: 解决边界问题，删除第一个元素
 * 思路：设个指向head的预备指针,返回时直接返回pre.next即可，这样可方便的删除首元素
 *
 */
public class Leetcode19_v2 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = pre;
        ListNode q = pre;
        for(int i=0;i<n;i++){   //p走n步，指向第n个结点
            p = p.next;
        }
        while(p.next!=null){
            p = p.next;
            q = q.next;
        }
        ListNode delNode = q.next;
        q.next = delNode.next;
        delNode.next = null;
        return pre.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(3);
        head.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        node3.next = node4;
        head = removeNthFromEnd(head, 1);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
