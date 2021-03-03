package com.jzoffer;

/**
 * 删除链表中的重复节点
 */
public class JZOffer18_ {

    public static ListNode deleteSameNode(ListNode head){
        if (head == null || head.next ==null) return head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr!=null){
            if (pre.val == curr.val){
                pre.next = curr.next;
                curr = curr.next;    //这里要特别注意 当删除一个结点的时候pre不变，curr后移，因可能出现多个（大于2）重复结点
            }else {
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head =  new ListNode(1);  //null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = JZOffer18_.deleteSameNode(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
