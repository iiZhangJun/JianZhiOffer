package com.yfd;

/**
 * 206 反转链表
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode later = curr.next;
            curr.next = pre;
            pre = curr;
            curr = later;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode pre = new Leetcode206().reverseList(head);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


