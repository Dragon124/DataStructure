package com.example.lib.array_list.test;

import com.example.lib.array_list.linked.LinkedList;
import com.example.lib.array_list.queue.Queue;
import com.example.lib.array_list.stack.Stack;
import com.example.lib.array_list.tree.TreeNodeShow;

/**
 * Created by K on 2022/10/26
 * function:
 * other:
 */
public class BinaryTree {
    public int size;
    public TreeNode<Integer> root;


    public boolean contain(Integer element) {
        return node(element) == null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected TreeNode<Integer> node(Integer element) {
        TreeNode<Integer> currentNode = root;
        while (currentNode != null) {
            if (element < currentNode.element) {
                currentNode = currentNode.left;
            } else if (element == currentNode.element) {
                return currentNode;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }


    public void show() {
//        TreeNodeShow.show(root);
    }


    //前驱
    public TreeNode<Integer> precursor(TreeNode node) {
        if (node == null || node.left == null) {
            return null;
        }
        TreeNode precursorNode = node.left;
        TreeNode parentNode = null;
        while (precursorNode != null) {
            parentNode = precursorNode;
            precursorNode = precursorNode.right;
        }
        System.out.println("前驱:" + parentNode.element);
        return parentNode;
    }

    //后继
    public TreeNode<Integer> succeed(TreeNode node) {
        if (node == null || node.right == null) {
            return null;
        }
        TreeNode precursorNode = node.right;
        TreeNode parentNode = null;
        while (precursorNode != null) {
            parentNode = precursorNode;
            precursorNode = precursorNode.left;
        }
        System.out.println("后继:" + parentNode.element);
        return parentNode;
    }

    //前序遍历
    public void preOrder() {
        LinkedList<String> treeElement = new LinkedList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                treeElement.add(currentNode.element.toString());
                currentNode = currentNode.left;
            }
            currentNode = stack.pop().right;
        }
        System.out.println(treeElement);
    }

    //中序遍历
    public void inOrder() {
        LinkedList<String> treeElement = new LinkedList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            treeElement.add(currentNode.element.toString());
            currentNode = currentNode.right;
        }
        System.out.println(treeElement);
    }

    //后续遍历
    public void postOrder() {
        LinkedList<String> treeElement = new LinkedList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currentNode = root;
        TreeNode preNode = null;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode node = stack.top();
            if (node.right == null || node.right == preNode) {
                currentNode = stack.pop();
                preNode = currentNode;
                treeElement.add(currentNode.element.toString());
                currentNode = null;
            } else {
                currentNode = node.right;
            }
        }
        System.out.println(treeElement);
    }

    //层序遍历
    public void levelOrder() {
        LinkedList<String> treeElement = new LinkedList<>();
        Queue<TreeNode> queue = new Queue<>();
        queue.enQueue(root);
        TreeNode currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.deQueue();
            treeElement.add(currentNode.element.toString());
            if (currentNode.left != null) {
                queue.enQueue(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.enQueue(currentNode.right);
            }
        }
        System.out.println(treeElement);
    }
}
