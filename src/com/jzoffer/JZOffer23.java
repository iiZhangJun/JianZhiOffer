package com.jzoffer;
/**
 * 23. 链表中环的入口结点
 * 若链表中不存在环返回，
 * 只有存在环的时候才能找到环入口，使用快慢指针找到相遇点，相遇点一定位于环内某个结点处
 * 根据相遇结点走一圈找到环中包含的结点数。
 */
public class JZOffer23 {

    public static ListNode findCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (slow!=null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){  // 若slow和fast相遇，说明有环，相遇结点在环状内
                // 找到环包含的结点个数
                ListNode node = slow;
                int len = 1;  //找到环形链表长度
                while (node.next != slow){
                    len++;
                    node = node.next;
                }
                node = head;
                // 从头结点开始移动len步
                for (int i=0;i<len;i++){
                    node = node.next;
                }
                while (head!=node){
                    node = node.next;
                    head = head.next;
                }
                return node;
            }
        }
        return null;        //只要slow或fast为null时，说明不存在环，返回null退出
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);  //null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        head = JZOffer23.findCycle(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
