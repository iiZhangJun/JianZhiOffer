package com.hot;

/**
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Leetcode02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int flag = 0;
        int val = 0;
        ListNode pre = new ListNode(val);   //使用预备指针简化
        ListNode node = pre;
        while(l1!=null && l2 != null){ //二者不为空 ，值相加
            val = l1.val + l2.val;
            if(flag == 1){      // 若进位标记为1，则val加1表示进位
                val = val+1;
            }
            if(val >= 10){  //最终的值是否大于10 ，大于要进位标记设1，val取个位
                flag=1;
                val = val % 10;
            }else{      //若val小于10 表示不进位，flag标记0
                flag = 0;
            }
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            if(flag == 1){
                val = l1.val + 1;
                if(val >= 10){
                    val = val % 10;
                }else{
                    flag = 0;
                }
                node.next = new ListNode(val);
            }else{
                node.next = new ListNode(l1.val);
            }
            node = node.next;
            l1 = l1.next;
        }

        while(l2 != null){
            if(flag == 1){
                val = l2.val + 1;
                if(val >= 10){
                    val = val % 10;
                }else{
                    flag = 0;
                }
                node.next = new ListNode(val);
            }else{
                node.next = new ListNode(l2.val);
            }
            node = node.next;
            l2 = l2.next;
        }
        if (flag == 1)
            node.next = new ListNode(1);
        return pre;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }



}
