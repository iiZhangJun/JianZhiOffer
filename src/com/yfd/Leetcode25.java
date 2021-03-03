package com.yfd;

/**
 * 25 K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class Leetcode25 {

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode pre = dumpy;
        ListNode start = head;      //初始化start变量
        ListNode end = start;        //初始化end变量
        while (end != null){
            for (int i=1; i<k && end!=null; i++){
                end = end.next;     //移动end截取子链表
            }
            if (end == null){
                break;
            }
            ListNode next = end.next;
            // start - end为长度为k的子链表
            end.next = null;
            end = start;
            start = reverse(start);         //翻转链表
            pre.next = start;           //拼接已翻转子链表与当前翻转后的子链表
            end.next = next;            //拼接当前翻转的子链表与待翻转的子链表
            pre = end;
            start = next;
            end = start;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode pre = new Leetcode25().reverseKGroup(head, 3);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }

}
