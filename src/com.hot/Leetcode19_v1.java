package com.hot;

/**
 * 19.删除链表的倒数第n个结点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 思路：双指针，p和q初始都指向头结点，p先走n-1步，指向第n个结点，
 * 然后p和q开始逐个向后遍历，直到p为Null，删除q返回head即可
 * 注：本题 给定的n保证是有效的
 * 思路：1.p停止条件指向最后一个结点，q指向倒数n+1个结点，p和q之间相距n，p先走n步后p和q再同时走，
 * 另外：要注意边界问题删除头指针或链表为空
 */

public class Leetcode19_v1 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        ListNode p = head;
        ListNode q = head;
        int len = 1;
        // 1 2 3 4 5 6
        for (int i=1;i<=n;i++){ //q不动，p向前移动n步，p和q之间相差n个结点，移动一步差1个，结点n步差n个结点
            if (p.next == null){
                break;
            }
            p = p.next;
            len ++;
        }
        while (p.next!=null){           //之后，p和q开始同时移动 删除结点时要找到被删除结点的前一个结点，进行指针调整
            p = p.next;
            q = q.next;
            len++;
        }
        if (n==len)
            head = head.next;
        else {
            ListNode delNode = q.next;
            q.next = delNode.next;
            delNode.next = null;
        }

        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(3);
        head.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        ListNode node4 = new ListNode(6);
        node3.next = node4;
        head = removeNthFromEnd(head, 1);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
