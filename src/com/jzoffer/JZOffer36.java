package com.jzoffer;

public class JZOffer36 {

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node trailNode = null;
        convertNode(root, trailNode);
        Node head = trailNode;
        Node trail = trailNode;
        System.out.println(trailNode);
        while (head != null && head.left != null){
            head = head.left;
        }
        while (trail!=null && trail.right!=null){
            trail = trail.right;
        }
        //head.left = trail;
        //trail.right = head;
        return head;
    }

    public void convertNode(Node root, Node trailNode){
        if (root == null) return ;
        if (root.left != null){
            convertNode(root.left, trailNode);
        }

        root.left = trailNode;
        if (trailNode!=null)
            trailNode.right = root;
        trailNode = root;

        if (root.right != null){
            convertNode(root.right, trailNode);
        }
        System.out.println(trailNode.val);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        root.left = node1;
        root.right = node2;
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        node1.left = node3;
        node1.right = node4;

        Node head = new JZOffer36().treeToDoublyList(root);
        while (head!=null){
            System.out.println(head.right);
        }

    }
}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int _val) {
        val = _val;
    }
}