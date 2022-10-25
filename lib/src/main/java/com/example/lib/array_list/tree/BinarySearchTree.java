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
                return;
            } else {
                currentNode = currentNode.right;
            }
        }
        if (compare < 0) {
            parentNode.left = createNode(element, parentNode);
            addLater(parentNode.left);
        } else if (compare == 0) {
            size--;
            parentNode.element = element;
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
        if (removeNode == root) {
            clear();
            return;
        }
        size--;
        if (removeNode == removeNode.parent.left) {
            removeNode.parent.left = null;
            return;
        }
        if (removeNode == removeNode.parent.right) {
            removeNode.parent.right = null;
        }
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public int compare(E e1, E e2) {
        if ((Integer) e1 < (Integer) e2) {
            return -1;
        }
        if ((Integer) e1 == (Integer) e2) {
            return 0;
        }
        return 1;
    }

    public void show() {
        TreeNodeShow.show(root);
    }

    private TreeNode<E> node(E element) {
        TreeNode<E> currentNode = root;
        while (currentNode != null) {
            int compare = compare(element, currentNode.element);
            if (compare == 0) {
                return currentNode;
            }
            if (compare < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    protected TreeNode<E> createNode(E element, TreeNode<E> parent) {
        return new TreeNode<E>(element, parent);
    }

    protected void addLater(TreeNode<E> element) {
    }
}
