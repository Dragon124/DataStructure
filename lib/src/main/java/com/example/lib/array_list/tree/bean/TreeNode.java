package com.example.lib.array_list.tree.bean;

/**
 * Created by K on 2022/10/21
 * function:
 * other:
 */
public class TreeNode<E> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public TreeNode<E> parent;


    public TreeNode(E element) {
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

    //是否是叶子结点
    public boolean isLeaf() {
        if (right == null && left == null) {
            return true;
        }
        return false;
    }

    //是否是左子树
    public boolean isLeftTree() {
        return parent != null && parent.left == this;
    }

    //是否是右子树
    public boolean isRightTree() {
        return parent != null && parent.right == this;
    }

    @Override
    public String toString() {
        return element + "P" + parent.element;
    }

    //是否是度为2的节点
    public boolean hasTwoChild() {
        return left != null && right != null;
    }

    //获取兄弟节点
    public TreeNode<E> sibling() {
        if (isLeftTree()) {
            return parent.right;
        }
        if (isRightTree()) {
            return parent.left;
        }
        return null;
    }

    //获取叔父节点
    public TreeNode<E> uncle() {
        if (parent == null) {
            return null;
        }
        return parent.sibling();
    }
}
