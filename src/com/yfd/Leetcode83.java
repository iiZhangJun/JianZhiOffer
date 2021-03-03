package com.yfd;

/**
 * 83. 删除排序链表中的重复元素
 */
public class Leetcode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null){
            if (pre.val == curr.val){
                pre.next = curr.next;
            }else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode pre = new Leetcode83().deleteDuplicates(head);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }





}
