package com.jzoffer;

/**
 * 25.合并两个排序链表
 */
public class JZOffer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node21 = new ListNode(8);
        ListNode node31 = new ListNode(9);
        head1.next = node11;
        node11.next = node21;
        node21.next = node31;

        ListNode head2 = new ListNode(1);
        ListNode node20 = new ListNode(3);
        ListNode node22 = new ListNode(5);
        ListNode node32 = new ListNode(10);
        head2.next = node20;
        node20.next = node22;
        node22.next = node32;

        ListNode pre = new JZOffer25().mergeTwoLists(head1, head2);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }


}
