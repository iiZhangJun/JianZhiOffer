package com.yfd;

public class Leetcode86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next==null) return head;
        ListNode pre = new ListNode(0);
        ListNode llpre = pre;
        ListNode bqpre = new ListNode(0);
        ListNode bqq = bqpre;

        while (head != null){
            if (head.val < x){
                llpre.next = head;
                llpre = llpre.next;
            }else {
                bqq.next = head;
                bqq = bqq.next;
            }
            head = head.next;
        }
        bqq.next = null;            //这里要特别注意一下置空操作
        llpre.next = bqpre.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode pre = new Leetcode86().partition(head, 4);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}
