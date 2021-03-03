package com.jzoffer;

import java.util.Stack;

public class JZOffer06 {
    public static int[] reversePrint1(ListNode head) {
        int[] ret = null;
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (head != null){
            len++;
            stack.push(head.val);
            head = head.next;
        }
        ret = new int[len];
        int i = 0;
        while (!stack.isEmpty()){
            ret[i] = stack.pop();
            i++;
        }
        return ret;
    }


    public static void main(String[] args) {
        ListNode head = null;//new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        //head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
       int a[] = JZOffer06.reversePrint1(head);
       for (int i=0;i<a.length;i++){
           System.out.println(a[i]);
       }
    }

}


