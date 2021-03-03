package com.yfd;

public class Main {

        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;
            int height = 0;         //计算高度
            TreeNode node = root.left;
            while(node != null){
                node = node.left;
                height++;
            }
            System.out.println(height);
            //计算除掉最后一层之外的其余层所有结点数目
            int nodeNum = (int)(Math.pow(2, height)-1);
            System.out.println(nodeNum);
            int lastcount = 1;  //最后一层最左节点存在
            //计算最后一层的结点数目，最左侧一定有一个结点，所以从索引1-2^d-1的遍历，二分
            int left = 1;
            int right = (int)(Math.pow(2, height)-1);
            while(left<=right){
                int pivot = (left+right)/2;
                if(exists(pivot, height, root)){
                    left = pivot+1;
                }else{
                    right = pivot-1;
                }
            }
            lastcount = left;
            System.out.println(lastcount);
            return lastcount + nodeNum;
        }

        public boolean exists(int id, int height, TreeNode node){
            int left = 0;
            int right = (int)(Math.pow(2, height)-1);
            for(int i=0;i<height;i++){
                int mid = (left+right)/2;
                if(id <= mid){
                    node = node.left;
                    right = mid;
                }else{
                    node = node.right;
                    left = mid + 1;
                }
            }
            return node != null;
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
        System.out.println(new Main().countNodes(root));

    }
}

