package com.jzoffer;

public class JZOffer18 {

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode dumpy = new ListNode(-1);
        ListNode curr = head;
        dumpy.next = head;
        ListNode pre = dumpy;
        // 删除头 中间 或者尾部 结点
        while (curr != null){
            if (curr.val == val){
                pre.next = curr.next;
                curr = null;
                break;
            }
            pre = pre.next;
            curr = curr.next;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);  //null;
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = JZOffer18.deleteNode(head, 2);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }


}
