package com.example.lib.array_list.tree;

import com.example.lib.array_list.tree.bean.TreeNode;

/**
 * Created by K on 2022/10/21
 * function:
 * other:
 */
public class BinarySearchTree<E> extends BinaryTree<E> {
    public void add(E element) {
        size++;
        if (root == null) {
            root = createNode(element, null);
            addLater(root);
            return;
        }
        TreeNode<E> currentNode = root;
        TreeNode<E> parentNode = root;
        int compare = 0;
        while (currentNode != null) {
            parentNode = currentNode;
            compare = compare(element, currentNode.element);
            if (compare < 0) {
                currentNode = currentNode.left;
            } else if (compare == 0) {
                size--;
                return;
            } else {
                currentNode = currentNode.right;
            }
        }
        if (compare < 0) {
            parentNode.left = createNode(element, parentNode);
            addLater(parentNode.left);
        } else {
            parentNode.right = createNode(element, parentNode);
            addLater(parentNode.right);
        }
    }

    public void remove(E element) {
        TreeNode<E> removeNode = node(element);
        if (removeNode == null) {
            return;
        }
        //度为2的节点
        if (removeNode.hasTwoChild()) {
            //找到后继节点
            TreeNode<E> node = succeed(removeNode);
            //把后继节点覆盖到度为2的节点
            removeNode.element = node.element;
            //删除后继节点
            removeNode = node;
        }
        size--;
        TreeNode childNode = removeNode.left == null ? removeNode.right : removeNode.left;
        //removeNode肯定度等于1或0
        if (childNode == null) {//度为0
            //根结点
            if (removeNode.parent == null) {
                root = null;
            }
            //叶子节点
            if (removeNode.isLeftTree()) {
                removeNode.parent.left = null;
            } else {
                removeNode.parent.right = null;
            }
        } else {
            childNode.parent = removeNode.parent;
            if (removeNode.parent == null) {
                root = childNode;
            } else if (removeNode.isLeftTree()) {
                removeNode.parent.left = childNode;
            } else {
                removeNode.parent.right = childNode;
            }
        }
        removeLater(removeNode, childNode);
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public void show() {
        TreeNodeShow.show(root);
    }

    protected TreeNode<E> createNode(E element, TreeNode<E> parent) {
        return new TreeNode<E>(element, parent);
    }

    protected void addLater(TreeNode<E> element) {
    }

    protected void removeLater(TreeNode<E> element, TreeNode<E> replace) {
    }
}
