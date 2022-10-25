package com.example.lib.array_list.tree;

import com.example.lib.array_list.linked.LinkedList;
import com.example.lib.array_list.queue.Queue;
import com.example.lib.array_list.stack.Stack;
import com.example.lib.array_list.tree.bean.TreeNode;


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

    /**
     * 遍历
     * 1.前序
     * 2.中序
     * 3.后续
     * 4.层序
     * BinarySearchTree<Integer> tree = new BinarySearchTree<>();
     * tree.add(7);
     * tree.add(4);
     * tree.add(2);
     * tree.add(1);
     * tree.add(3);
     * tree.add(5);
     * tree.add(9);
     * tree.add(8);
     * tree.add(11);
     * tree.add(10);
     * tree.add(12);
     */
    //前序(根→左→右的顺序打印) 7 4 2 1 3 5 9 8 11 10 12 LinkedList{[7],[4],[2],[1],[3],[5],[9],[8],[11],[10],[12]}
    public void preorderTraversal() {
        LinkedList<String> linkedList = new LinkedList<>();
        //存放节点
        Stack<TreeNode<E>> stackNode = new Stack<>();
        TreeNode<E> currentNode = root;
        while (currentNode != null || !stackNode.isEmpty()) {
            while (currentNode != null) {
                stackNode.push(currentNode);
                linkedList.add(currentNode.element.toString());
                currentNode = currentNode.left;
            }
            currentNode = stackNode.pop().right;
        }
        System.out.println(linkedList.toString());
    }

    //中序遍历(左→根→右的顺序打印) 7 4 2 1 3 5 9 8 11 10 12 LinkedList{[1],[2],[3],[4],[5],[7],[8],[9],[10],[11],[12]}
    public void inorderTraversal() {
        LinkedList<String> linkedList = new LinkedList<>();
        //存放节点
        Stack<TreeNode<E>> stackNode = new Stack<>();
        TreeNode<E> currentNode = root;
        while (currentNode != null || !stackNode.isEmpty()) {
            while (currentNode != null) {
                stackNode.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stackNode.pop();
            linkedList.add(currentNode.element.toString());
            currentNode = currentNode.right;
        }
        System.out.println(linkedList.toString());
    }

    //后序遍历(左→右→根的顺序打印) 7 4 2 1 3 5 9 8 11 10 12 LinkedList{[1],[3],[2],[5],[4],[8],[10],[12],[11],[9],[7]}
    public void poseOrderTraversal() {
        LinkedList<String> linkedList = new LinkedList<>();
        //存放节点
        Stack<TreeNode<E>> stackNode = new Stack<>();
        TreeNode<E> currentNode = root;
        TreeNode<E> prevNode = null;
        while (currentNode != null || !stackNode.isEmpty()) {
            while (currentNode != null) {
                stackNode.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stackNode.top();
            if (currentNode.right == null || currentNode.right == prevNode) {
                currentNode = stackNode.pop();
                linkedList.add(currentNode.element.toString());
                prevNode = currentNode;
                currentNode = null;
            } else {
                currentNode = currentNode.right;
            }
        }
        System.out.println(linkedList.toString());
    }

    //层序遍历
    public void levelOderTraversal() {
        LinkedList<String> linkedList = new LinkedList<>();
        //存放节点
        Queue<TreeNode<E>> queueNode = new Queue<>();
        TreeNode<E> currentNode;
        queueNode.enQueue(root);
        while (!queueNode.isEmpty()) {
            currentNode = queueNode.deQueue();
            linkedList.add(currentNode.element.toString());
            if (currentNode.left != null) {
                queueNode.enQueue(currentNode.left);
            }
            if (currentNode.right != null) {
                queueNode.enQueue(currentNode.right);
            }
        }
        System.out.println(linkedList.toString());
    }

    //是否是完全二叉树
    public boolean isComplete() {
        //存放节点
        Queue<TreeNode<E>> queueNode = new Queue<>();
        TreeNode<E> currentNode;
        queueNode.enQueue(root);
        boolean isLeaf = false;
        while (!queueNode.isEmpty()) {
            currentNode = queueNode.deQueue();
            if (isLeaf && !currentNode.isLeaf()) {
                return false;
            }
            if (currentNode.left != null && currentNode.right != null) {
                queueNode.enQueue(currentNode.left);
                queueNode.enQueue(currentNode.right);
            }
            if (currentNode.left == null && currentNode.right != null) {
                return false;
            }
            if (currentNode.isLeaf()) {
                isLeaf = true;
            }
        }
        return true;
    }
}
