package com.hot;

/**
 * 环形链表判断是否有环
 * 给定一个链表，判断链表中是否有环。快慢指针相遇则有环
 * 不能相遇则没有环
 */
public class Leetcode141 {

    public boolean hasCycle(ListNode head) {
        //if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
