package com.yfd;

/**
 * 思路：头插法  扫描一遍链表，所有小于x的结点插入头
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 */



public class Leetcode0204 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode pre = dumpy;
        if (head.val < x) {
            head = head.next;
            pre = pre.next;
        }
        while (head != null){
            if (head.val < x){
                ListNode curr = head;
                head = head.next;
                pre.next = curr.next;
                curr.next = dumpy.next;
                dumpy.next = curr;
            }else {
                head = head.next;
                pre = pre.next;
            }
        }
//        pre.next = null;
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode xx = new Leetcode0204().partition(head, 3);
        while (xx != null){
            System.out.println(xx.val);
            xx = xx.next;
        }
    }
}
