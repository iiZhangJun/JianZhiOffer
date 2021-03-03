package Tree;

import java.util.List;
import java.util.function.Consumer;

public interface IBinarySearchTree<K, V> {
    /**
     * 新增节点
     * K 关键字 V 值
     */
    BSTNode<K, V> insert(K key,V value);

    /**
     * 返回节点数
     * @return
     */
    int getSize();

    /**
     * 高度
     * @return
     */
    int getHeight(BSTNode<K, V> root);

    /**
     * 中序遍历
     * @param con
     */
    void inorder(Consumer<K> con);

    /**
     * 查找元素
     * @param key
     */
    V lookupValue(K key);

    /**
     * 获取最小关键字
     * @return
     */
    K min();

    /**
     * 获取最大关键字
     * @return
     */
    K max();

    /**
     * 移除关键字对应结点
     */
    void remove(K key);

    /**
     * x的后继——比x大的第一个元素
     * 1、是其右子树的最小值
     * 2、没有右子树，则向上追溯，直到某个祖先节点是左孩子，返回这个祖先节点的父节点，它就是x的后继
     * @param x
     * @return
     */
    K successor(K x);

    /**
     * 前驱
     * @param x 关键字
     * @return
     */
    K predecessor(K x);

    boolean isBalance();

    List<List<BSTNode<K, V>>> levelOrder();

    class BSTNode<K, V>{
        K key;
        V value;
        BSTNode<K, V> leftChild;
        BSTNode<K, V> rightChild;
        BSTNode<K, V> parent;
        boolean isleftChild;
        int size;
        int height;


        public BSTNode(K key, V value, BSTNode<K, V> leftChild, BSTNode<K, V> rightChild,BSTNode<K, V> parent){
            this.key = key;
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        public boolean isleftChild(){
            return isleftChild;
        }
        public boolean isrightChild(){
            return !isleftChild;
        }

        @Override
        public String toString() {
            return "BSTNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", parent=" + parent +
                    ", isleftChild=" + isleftChild +
                    ", size=" + size +
                    ", height=" + height +
                    '}';
        }
    }

}
