package com.ming.dataStruct;

/**
 * 二叉树的链表实现
 * @param <T>
 */
public class BTree<T> {

    class BTreeNode<T> implements Tree.TreeNode<T>{
        public T data;
        public BTreeNode<T> left,right;
        public BTreeNode(T data,BTreeNode<T> left,BTreeNode<T> right){
            this.data =data;
            this.left=left;this.right=right;
        }
        public BTreeNode(T data){
            this(data,null,null);
        }

        @Override
        public String toString() {
            return "BTreeNode{" +
                    "data=" + data +
                    '}';
        }
        public boolean isLeaf(){
            return this.left==null && this.right==null;
        }
    }
    public BTreeNode<T> root;
    public BTree(){
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root==null;
    }

    //插入x作为根节点，原根节点作为x的左孩子；返回插入节点
    public BTreeNode<T> insertRoot(T x) {
        return this.root = new BTreeNode<T>(x,this.root,null);
    }

    /**
     * 插入x为parent节点的左/右孩子，leftChild指定孩子，取值true(左)，false(右)
     * parent的原左/右孩子成为x节点的孩子；返回插入节点
     * 若x==null，不插入，返回空，若parent==null，抛出空对象异常
     */
    public BTreeNode<T> insertChild(BTreeNode<T> parent, T x,boolean leftChild) {
        if(x==null)return null;
        if(leftChild)return parent.left=new BTreeNode<T>(x,parent.left,null);
        return parent.right=new BTreeNode<T>(x,null,parent.right);
    }

    public int level(Object key) {
        return 0;
    }

    public int size() {
        return 0;
    }

    public int height() {
        return 0;
    }

    /**
     * 先根次序遍历
     * 遍历顺序：根-左-右
     */
    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    /**
     * 先根次序遍历，递归函数
     */
    private void preorder(BTreeNode<T> parent) {
        if(parent!=null){
            System.out.println(parent.data.toString());
            preorder(parent.left);
            preorder(parent.right);
        }
    }

    /**
     * 中序遍历
     */
    public void postorder() {

    }

    /**
     * 层次遍历
     */
    public void levelorder() {

    }


    /**
     * 在二叉树中删除一个结点，不仅要修改其父母节点的左右域，还要约定如何删除子树结构规则，即如何删除一个节点。
     * 原先以该节点为根的子树，变为原左子树和右子树的森林，约定一种规则使这个森林组成一棵子树
     */
    public void remove(BTreeNode<T> parent,boolean leftChild) {
        if(leftChild)
            parent.left = null;
        else parent.right = null;
    }

    public void clear() {
        this.root = null;
    }

    public BTreeNode<T> search(T key) {
        return null;
    }

    public boolean contains(T key) {
        return false;
    }

    public T remove(T key) {
        return null;
    }

}
