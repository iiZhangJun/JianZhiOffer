package com.jzoffer;

/**
 * 62.两个链表的第一个公共节点
 */
public class JZOffer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB){
            int diff = lenA - lenB;
            for (int i=0; i<diff; i++){
                headA = headA.next;
            }
        }else {
            int diff = lenB - lenA;
            for (int i=0; i<diff; i++){
                headB = headB.next;
            }
        }
        while (headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
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
        node32.next = node11;

        ListNode pre = new JZOffer52().getIntersectionNode(head1, head2);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }





}
