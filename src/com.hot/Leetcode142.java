package com.hot;

/**
 * 142.环形链表 双指针法解决
 * 定义快慢两个双指针
 * 双指针：slow慢指针走一步fast快指针走两步
 * 有环和无环两种状态，无环时，fast指针最先到达尾结点，判空返回
 * 有环两指针必会相遇，假设链表头到环首结点长度为k，
 * slow指针走了k到达环首，fast走了2k，进入到环中某个节点处，此时fast指针从环首走了k步到达它所处位置
 * 假设fast指针再走x步可再次达到环首，那么slow指针走x步，fast指针指针走2x步二者相遇，
 * 此时从相遇点slow指针再走k步达到环首，而k正是整个链表头到环首的长度。
 *
 */
public class Leetcode142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode curr = head;
                while(curr != slow){
                    curr = curr.next;
                    slow = slow.next;
                }
                return curr;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }



}
