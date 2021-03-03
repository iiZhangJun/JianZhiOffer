package com.jzoffer;

public class JZOffer22_ {

    public static ListNode deleteMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode pre = dumpy;
        // 双指针 ，参考指针与当前指针
        ListNode curr = head;
        ListNode ref = head;

        // curr走一步， ref走两步，pre走一步，直到ref指向尾结点
        //当链表长度为奇数时，ref指向尾结点，curr指向中间结点
        //当链表长度为偶数时，指向中间结点的后一个结点
        while (ref != null && ref.next != null){
            ref = ref.next.next;
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = curr.next;
        curr = null;
        /**
         * 删除结点的第二种方式  替换法，用下一个结点去覆盖掉当前结点，并将当前指针指向下一结点的结点
         * curr.val = curr.next.val;
         * curr.next = curr.next.next;
         */
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode head =  new ListNode(1);  //null;
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        //ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //node4.next = node5;

        head = JZOffer22_.deleteMiddleNode(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
