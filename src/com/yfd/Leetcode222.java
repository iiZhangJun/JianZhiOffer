package com.yfd;
/**
 * 222. 完全二叉树
 * 给出一个完全二叉树，求出该树的节点个数。
 */
public class Leetcode222 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right==null) return 1;

        int height = 0;     //计算出树的高度  可直接一直遍历到最左叶子节点去计算  借助完全二叉树性质
        TreeNode node = root;
        while (node.left!=null){
            height++;
            node = node.left;
        }
        System.out.println(height);

        int nodeNum = (int) (Math.pow(2, height)-1);      //计算0~(d-1)层的结点总数
        System.out.println(nodeNum);

        // 判断 最后一层存在的结点数目
        int lastCount = 1;
        int left = 1;
        int right = (int) (Math.pow(2, height)-1);
        System.out.println(right);
        while (left <= right){
            int pivot = (left+right)/2;
            if (exists(pivot, height, root)){       //若pivot存在， 右侧找
                left = pivot + 1;
            }else {     //若pivot不存在， 左侧找
                right = pivot-1;
            }
        }
        lastCount = left;
        System.out.println(lastCount);
      return nodeNum + lastCount;
    }

    public boolean exists(int id, int height, TreeNode node){
        int left = 0;
        int right = (int) (Math.pow(2, height)-1);
        for (int i=0; i<height; i++){
            int mid = (left + right)/2;
            if (id <= mid){
                node = node.left;
                right = mid;
            }else {
                node = node.right;
                left = mid + 1;
            }
        }
        return node!=null;
    }

    public int getHeight(TreeNode root) {
        if (root==null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return 1 + Math.max(l, r);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(4);
        node2.left = node5;
        System.out.println(new Leetcode222().countNodes(root));
    }



}

