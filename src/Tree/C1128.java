package Tree;

public class C1128<E> {

    public boolean isBalanced(TreeNode root){
        if (root == null|| root.left==null&&root.right==null) return true;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.abs(l-r) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node){
        if(node == null) return 0;
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        return Math.max(l, r) + 1;
    }


    static class TreeNode<E> {
        E data;
        TreeNode<E> left;
        TreeNode<E> right;
    }

    public static void main(String[] args) {
        C1128.TreeNode node = new TreeNode<>();
        C1128.TreeNode left = new TreeNode<>();
        C1128.TreeNode left2 = new TreeNode<>();
        node.left = left;
        node.left.left = left2;
        System.out.println(new C1128<>().getHeight(node.right));
        System.out.println(new C1128<>().isBalanced(node));
    }
}
