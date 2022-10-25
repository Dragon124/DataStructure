package com.example.lib.array_list.tree.bean;

/**
 * Created by K on 2022/10/25
 * function:
 * other:
 */
public class AVLNode<E> extends TreeNode<E> {
    public int height = 1;

    public AVLNode(E element) {
        super(element);
    }

    public AVLNode(E element, TreeNode<E> parent) {
        super(element, parent);
    }

    public AVLNode(E element, TreeNode<E> left, TreeNode<E> right, TreeNode<E> parent) {
        super(element, left, right, parent);
    }

    public int getBalance() {
        int leftHeight = left == null ? 0 : ((AVLNode) left).height;
        int rightHeight = right == null ? 0 : ((AVLNode) right).height;
        return leftHeight - rightHeight;
    }
}
