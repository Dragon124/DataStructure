package com.example.lib.array_list.tree.bean;

/**
 * Created by K on 2022/10/25
 * function:
 * other:
 */
public class AVLNode<E> extends TreeNode<E> {
    //二叉树高度
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

    //获取平衡因子
    public int getBalance() {
        int leftHeight = left == null ? 0 : ((AVLNode) left).height;
        int rightHeight = right == null ? 0 : ((AVLNode) right).height;
        return leftHeight - rightHeight;
    }

    public AVLNode<E> tallerChild() {
        int leftHeight = left == null ? 0 : ((AVLNode) left).height;
        int rightHeight = right == null ? 0 : ((AVLNode) right).height;
        if (leftHeight > rightHeight) {
            return (AVLNode<E>) left;
        }
        if (leftHeight < rightHeight) {
            return (AVLNode<E>) right;
        }

        if (isLeftTree()) {
            return (AVLNode<E>) left;
        } else {
            return (AVLNode<E>) right;
        }
    }

}
