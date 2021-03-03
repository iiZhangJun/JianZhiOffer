package Tree;

import sun.awt.windows.WPrinterJob;

import java.awt.print.PrinterGraphics;
import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<K, V> implements IBinarySearchTree<K, V>{
    BSTNode<K, V> root;
    int size;
    Comparator comparator;

    public BinarySearchTree(Comparator comparator){
        this.comparator = comparator;
    }

    public BinarySearchTree() {

    }

    private int compare(K key1, K key2) {
        if (null == comparator) {
            return ((Comparable) key1).compareTo((Comparable) key2);
        } else {
            return comparator.compare(key1, key2);
        }
    }


    @Override
    public BSTNode<K, V> insert(K key, V value) {
        if (!(key instanceof Comparable)) {
            throw new ClassCastException();
        }

        BSTNode<K, V> parent = null;
        BSTNode<K, V> curr = root;

        BSTNode<K, V> node= new BSTNode(key, value, null, null, null);
        //先定位到节点插入的位置
        while(curr != null){
            parent = curr;
            if(compare(key, curr.key) < 0){
                curr = curr.leftChild;
            }else if(compare(key, curr.key) > 0){
                curr = curr.rightChild;
            }else{
                curr.value = value;
                return curr;  //
            }
        }
        curr = node;
        curr.parent = parent;
        //执行插入操作
        if(parent == null){
             root = curr;
        }else if(compare(key, parent.key) < 0){
            parent.leftChild = curr;
            curr.isleftChild = true;
        }else if(compare(key, parent.key) > 0){
            parent.rightChild = curr;
            curr.isleftChild=false;
        }
        size++;
        return curr;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight(BSTNode<K, V> root) {
        if(root==null) return 0;
        int l = getHeight(root.leftChild);
        int r = getHeight(root.rightChild);
        return 1+ Math.max(l, r);
    }

    /**
     * 中序遍历
     * @param con  处理中序遍历的每个元素的函数
     */
    @Override
    public void inorder(Consumer<K> con) {
        if (root != null){
            inorder(root, con);
        }
    }
    public void inorder(BSTNode<K,V> parent, Consumer<K> con) {
        if(parent !=null){
            inorder(parent.leftChild, con);
            con.accept(parent.key);
            inorder(parent.rightChild, con);
        }
    }


    @Override
    public V lookupValue(K key) {
        BSTNode<K,V> node = lookupNode(key);
        return node == null ? null : node.value;
    }

    protected BSTNode<K,V> lookupNode(K key) {
        BSTNode<K,V> curr = root;
        //只要P不为空，并且没找到
        while(curr != null && compare(key, curr.key) != 0){
            if(compare(key, curr.key) < 0){
                curr = curr.leftChild;
            }else{
                curr = curr.rightChild;
            }
        }
        return curr;
    }

    @Override
    public K min() {
        return minNode(root).key;
    }
    public BSTNode<K,V> minNode(BSTNode<K,V> parent){
        BSTNode<K,V> curr = parent;
        while(curr.leftChild!=null){
            curr = curr.leftChild;
        }
        return curr;
    }

    @Override
    public K max() {
        return maxNode(root).key;
    }
    public BSTNode<K,V> maxNode(BSTNode<K,V> parent){
        BSTNode<K,V> curr = parent;
        while(curr.rightChild!=null){
            curr = curr.rightChild;
        }
        return curr;
    }
    @Override
    public void remove(K key) {
        //先查找关键字key所在的结点，若不存在则删除也无意义，存在时再执行删除操作
        remove(lookupNode(key));

    }
    public void remove(BSTNode<K,V> node) {
        if (node != null){
            if(node.leftChild == null && node.rightChild == null){  //node为叶子结点
                if(node.parent == null){        //先判断node.parent是否为空，若空直接node.parent.child 会出现异常
                    //若node.parent为空，说明node为根节点，删除根节点，直接将root置空 方法返回结束即可
                    root = null;
                    return ;
                }
                //否则node的parent不为空，断开node和parent之间的连接
                // 若node为parent的左孩子, parent.left == null
                if(node.isleftChild) {
                    node.parent.leftChild = null;
                }else { //node是右孩子
                    node.parent.rightChild = null;
                }
                node.parent = null;
                node = null;
            }else if(node.leftChild == null) {            //若node是单支结点  只有左支或只有右支
                //node只有右支时，
                //分情况讨论，node是其父亲的左孩子还是右孩子
                if(node.isleftChild){       //将node的右孩子链接到node父亲节点的左支上
                    BSTNode<K, V> c = node.rightChild;
                    BSTNode<K, V> p = node.parent;
                    p.leftChild = c;
                    c.parent = p;
                    c.isleftChild = true;
                }else {     //node是右孩子， 将Node的的右支链接到node父亲节点的右孩子上
                    if(node.parent != null){
                        node.parent.rightChild = node.rightChild;
                        node.rightChild.parent = node.parent;
                        node.rightChild.isleftChild = false;
                    }else {
                        root = null;
                    }
                }
                node.parent = null;
                node = null;
            }else if(node.rightChild == null) {            //若node是单支结点  只有左支或只有右支
                //node只有左支时，
                //分情况讨论，node是其父亲的左孩子还是右孩子
                if(node.isleftChild){
                    node.parent.leftChild = node.leftChild;
                    node.leftChild.parent = node.parent;
                }else {
                    if(node.parent != null){    //若Node.parent不为空，说明此时node为右孩子
                        node.parent.rightChild = node.leftChild;
                        node.leftChild.parent = node.parent;
                        node.leftChild.isleftChild = false;
                    }else {     // 否则node为根节点
                        root = null;
                    }
                }
                node.parent = null;
                node = null;
            }else {         //node是双支，即node的左右孩子均存在, 使用替代法删除， 替换成单支或叶子结点， 可找到右子树的最左边界Min结点替代删除
                //将node替换到单支或叶子结点的位置 去删除即可。
                BSTNode<K, V> minOfRight = minNode(node.rightChild);
                node.key = minOfRight.key;
                // node.value = minOfRight.value;
                remove(minOfRight);
            }
        }
    }


    @Override
    public K successor(K x) {       //节点x的后继
        BSTNode<K, V> node = successor(lookupNode(x));
        return node == null ? null : node.key;
    }

    public BSTNode<K,V> successor(BSTNode<K,V> node) {       //节点x的后继
        if(node != null){
            //若节点node存在右子树，则node的后继为其右子树的最小节点即最左边界
            if(node.rightChild != null){
                return minNode(node.leftChild);
            }else { //若Node的右子树为空
               //若node节点自身是左孩子, 否则找到node的祖先中第一个作为左孩子的祖先，返回该祖先的父亲节点
                BSTNode<K,V> curr = node;
                while (!curr.isleftChild){
                    curr = curr.parent;
                }
                return curr.parent;
            }
        }
        return null;
    }

    @Override
    public K predecessor(K x) {        //节点x的前驱
        BSTNode<K,V> node = predecessor(lookupNode(x));
        return node == null ? null : node.key;
    }

    public BSTNode<K,V> predecessor(BSTNode<K,V> node) {        //节点node的前驱,前一个比node小的元素
        if(node != null){
            //若node有左子树，则左子树的的右边界是node的前驱，因左子树的结点全部小于node，找到左子树中最大结点便是node德前驱
            if(node.leftChild != null){
                return maxNode(node.leftChild);
            }else {
                BSTNode<K,V> curr = node;
                while (curr.isleftChild){
                    curr = curr.parent;
                }
                return curr;
            }
        }
        return null;
    }

    @Override
    public boolean isBalance() {
        return false;
    }

    @Override
    public List<List<BSTNode<K, V>>> levelOrder() {         //二叉树的层级遍历
        List<List<BSTNode<K, V>>> res = new ArrayList<>();
        while (root!=null){
            Queue<BSTNode<K, V>> queue = new LinkedList<>();
            List<BSTNode<K, V>> list = new ArrayList<>();
            queue.add(root);
            BSTNode<K, V> last = root;
            BSTNode<K, V> nlast = root;
            res.add(list);
            while(!queue.isEmpty()){
                BSTNode<K, V> curr = queue.poll();
                list.add(curr);
                if(curr.leftChild != null){
                    queue.add(curr.leftChild);
                    nlast = curr.leftChild;
                }
                if(curr.rightChild != null){
                    queue.add(curr.rightChild);
                    nlast = curr.rightChild;
                }
                if(curr == last){
                    list = new ArrayList<BSTNode<K, V>>();
                    res.add(list);
                    last = nlast;
                }
            }
        }
        return res;
    }

    /**
     * 使用parent解决
     * 1. 暴力解法
     * 2。链表思想
     * @param root
     * @param p
     * @param q
     * @return
     */
    public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q) {
        if(root == null || p == null || q == null) return null;
        //p固定  固定一个节点，另一个结点移动
        // 以p为基准，q不断parent去撞 直到q.parent为空退出，再将p移动p=p.parent,再次以q向上追溯，直到q.parent撞到p
        BSTNode temp = q;
        while (q.parent != p && p.parent != null){
            while (q.parent != null){
                q = q.parent;
            }
            p = p.parent;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        BSTNode left = null;
        BSTNode right = null;
        BSTNode root = new BSTNode(1,8, left, right, null);
        left = new BSTNode(2, 7, null, null,root);
        right = new BSTNode(5, 7, null,null, root);
        BSTNode zisun2 = new BSTNode(6, 9, null,null, left);
        BSTNode zisun1 = new BSTNode(5, 0, null,null, right);
        BSTNode lcp = new BinarySearchTree<>().lowestCommonAncestor(root, zisun2, zisun1);
        System.out.print(lcp.value);
    }
}
