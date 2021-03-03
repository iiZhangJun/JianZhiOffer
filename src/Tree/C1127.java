package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径数字串之和
 * 所有根到叶子结点的路径找出来
 *
 */
public class C1127<E> {

    List<String> path = new ArrayList<>();      //存放路径字符串

    public int getPathSum(TreeNode root){
        if(root == null) return 0;      // 若空树返回0
        getPathString("", root);
        int sum = 0;
        for (String s : path){
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    /**
     * 带前缀的dfs
     * @param pre
     * @param root
     * @return
     */
    public void getPathString(String pre, TreeNode node){     //找从node结点开始的路径
        pre = node.data + pre ; //将当前结点的值附加到前缀上
        if(node.left == null && node.right== null){         //若为叶子结点， 结算将路径结束加入listj
            path.add(pre);
            return;
        }
        if(node.left != null) getPathString(pre, node.left);
        if(node.right != null) getPathString(pre, node.right);
    }

    class TreeNode<String> {
        String data;
        TreeNode<E> left;
        TreeNode<E> right;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("002"));
    }

}
