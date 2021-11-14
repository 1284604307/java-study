package com.ming.dataStruct;

public interface Tree<T> {
    boolean isEmpty();
    int level(T key);
    int size();
    int height();
    void preorder();
    void postorder();
    void levelorder();  // 层次遍历输出
    TreeNode<T> insertRoot(T x);
    TreeNode<T> insertChild(TreeNode<T> p,T x,int i);
    void remove(TreeNode<T> p,int i);
    void clear();
    TreeNode<T> search(T key);
    boolean contains(T key);
    T remove(T key);

    interface TreeNode<T>{

    }

}
