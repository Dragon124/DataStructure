package com.example.lib.array_list.tree;

/**
 * Created by K on 2022/10/21
 * function:
 * other:
 */
public class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> parent;

    TreeNode() {
    }

    TreeNode(E element) {
        this.element = element;
    }

    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    public TreeNode(E element, TreeNode<E> left, TreeNode<E> right, TreeNode<E> parent) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public boolean isLeaf() {
        if (right == null && left == null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return element +"P"+ parent.element ;
    }
}
