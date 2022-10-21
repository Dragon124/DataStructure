package com.example.lib.array_list.tree;

import com.example.lib.array_list.linked.LinkedList;
import com.example.lib.array_list.stack.Stack;

/**
 * Created by K on 2022/10/21
 * function:
 * other:
 */
public abstract class BinaryTree<E> {
    public TreeNode<E> root = null;
    protected int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 遍历
     * 1.前序
     * 2.中序
     * 3.后续
     * 4.层序
     */
    //前序
    public void preorderTraversal() {
        LinkedList<String> linkedList = new LinkedList<>();
        //存放右节点
        Stack<TreeNode<E>> rightNode = new Stack<>();
        rightNode.push(root);
        while (!rightNode.isEmpty()) {
            addNodePreorder(rightNode.pop(), linkedList, rightNode);
        }
        System.out.println(linkedList.toString());
        System.out.println(TraversalCount);
    }

    int TraversalCount = 0;

    private void addNodePreorder(TreeNode<E> node, LinkedList<String> linkedList, Stack<TreeNode<E>> rightNode) {
        TreeNode<E> currentNode = node;
        while (currentNode != null) {
            TraversalCount++;
            linkedList.add(currentNode.element.toString());
            if (currentNode.right != null) {
                rightNode.push(currentNode.right);
            }
            currentNode = currentNode.left;
        }
    }

    //中序遍历
    public void inorderTraversal() {
        LinkedList<String> linkedList = new LinkedList<>();
        //存放右节点
        Stack<TreeNode<E>> rightNode = new Stack<>();
        rightNode.push(root);
        while (!rightNode.isEmpty()) {
            addNodePreorder(rightNode.pop(), linkedList, rightNode);
        }
        System.out.println(linkedList.toString());
        System.out.println(TraversalCount);
    }


    //前驱
    public TreeNode<E> predecessor(TreeNode<E> node) {
        TreeNode<E> currentNode = node;
        if (root == null || root.left == null) {
            return null;
        }
        currentNode = currentNode.left;
        while (currentNode != null) {
            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return currentNode;
    }

    //后继
    public TreeNode<E> succeed(TreeNode<E> node) {
        TreeNode<E> currentNode = node;
        if (root == null || root.right == null) {
            return null;
        }
        currentNode = currentNode.right;
        while (currentNode != null) {
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                break;
            }
        }
        return currentNode;
    }
}
