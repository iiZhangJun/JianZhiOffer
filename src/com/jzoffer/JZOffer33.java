package com.jzoffer;

public class JZOffer33 {

    public static boolean verifyPostorder(int[] postorder) {
        if(postorder==null||postorder.length==0) return false;
        if(postorder.length == 1) return true;
        return helper(postorder, 0, postorder.length-1);

    }

    private static boolean helper(int[] arr, int l, int r){
        if (l >= r) return true;

        int father = arr[r];
        int k = l;
        while (arr[k] < father && k < r ) k++;  //左子树 都小于
        for (int i=k;i<r;i++){
            if (arr[i] < father)
                return false;
        }
        return helper(arr, l, k-1) && helper(arr, k, r-1);

    }








    public static void main(String[] args) {
        Node root = new Node(5);
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        root.left = node1;
        root.right = node2;
        Node node3 = new Node(7);
        node2.right = node3;

        int[] postorder = new int[]{4,6,7,5};
        System.out.println(verifyPostorder(postorder));

    }



}
