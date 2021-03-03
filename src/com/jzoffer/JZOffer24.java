package com.jzoffer;

/**
 * 24.翻转链表
 */
public class JZOffer24 {


    public static ListNode reverseList(ListNode head) {

        if (head==null || head.next==null) return head;  //当链表为空或只要一个结点时无需翻转

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);  //null;
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = JZOffer24.reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }





}
