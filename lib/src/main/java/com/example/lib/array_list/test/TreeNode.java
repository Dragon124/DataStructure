package com.example.lib.array_list.test;

/**
 * Created by K on 2022/10/26
 * function:
 * other:
 */
public class TreeNode<E> {
    public E element;
    public TreeNode<E> parent;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public int height = 1;

    public TreeNode(E element) {
        this.element = element;
    }

    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    public TreeNode(E element, TreeNode<E> parent, TreeNode<E> left, TreeNode<E> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    //是否是叶子节点
    public boolean isLeaf() {
        return right == null && left == null;
    }

    //是否是度为2的节点
    public boolean isTwoChild() {
        return right != null && left != null;
    }

    //是否是左节点
    public boolean isLeft() {
        return parent != null && parent.left == this;
    }

    //是否是右节点
    public boolean isRight() {
        return parent != null && parent.right == this;
    }

    //是否平衡
    public boolean isBalance() {
        return Math.abs((left == null ? 0 : left.height) - (right == null ? 0 : right.height)) < 2;
    }

    //更新高度
    public void upHeight() {
        height = Math.max((left == null ? 0 : left.height), (right == null ? 0 : right.height))+1;
    }

    public int getBalance() {
        return (left == null ? 0 : left.height) - (right == null ? 0 : right.height);
    }


    //是否是左子树
    public boolean isLeftTree() {
        return parent != null && parent.left == this;
    }

    //是否是右子树
    public boolean isRightTree() {
        return parent != null && parent.right == this;
    }
}
