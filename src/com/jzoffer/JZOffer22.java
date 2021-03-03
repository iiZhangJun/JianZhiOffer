package com.jzoffer;

/**
 * 删除链表中倒数第k个节点
 */
public class JZOffer22 {

    public static ListNode deleteLastKNode(ListNode head, int k){
        if (head == null || k<=0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 先找到倒数第k个结点
        ListNode ref = head;
        ListNode curr = head;
        ListNode pre = dummy;       //删除结点还需知道前驱
        //定义一个参考指针 要删掉的结点与参考指针之间相差k-1步
        //初始时curr和ref指针均指向head,先将ref参考指针向前走k-1步
        for (int i=1;i<k;i++){
            ref = ref.next;
            if (ref == null){
                return head;
                // 如果在走这k-1步过程中或者第k-1步走完时参考指针指向了空结点，说明链表长度小于k，
                // 倒数第k个节点超出了链表范围，删除失败，直接返回链表头
            }
        }
        // 否则若参考结点正常的走完了k-1步且不为空，则说明倒数第k个节点存在
        // 此时要开始逐步移动pre, curr, ref结点定位倒数第k个结点的位置
        // 当ref指向尾结点时，curr指向第倒数k个结点，pre指向倒数k+1个结点，即curr的前驱结点
        while (ref.next != null){       //开始遍历，知道参考结点指向尾结点
            ref = ref.next;
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = curr.next;
        curr = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head =  new ListNode(1);  //null;
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = JZOffer22.deleteLastKNode(head,8);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
