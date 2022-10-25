package com.example.lib.array_list.tree;

import com.example.lib.array_list.linked.LinkedList;
import com.example.lib.array_list.queue.Queue;
import com.example.lib.array_list.stack.Stack;
import com.example.lib.array_list.tree.bean.TreeNode;

/**
 * Created by K on 2022/10/24
 * function:
 * other:
 */
public class Utils {
    LinkedList<String> linkedList = new LinkedList<>();
    //存放节点
    Stack<TreeNode> stackNode = new Stack<>();

    public void preOrder(TreeNode node) {
        TreeNode currentNode = node;
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

    public void postOrder(TreeNode node) {
        TreeNode currentNode = node;
        TreeNode preNode = null;
        while (currentNode != null || !stackNode.isEmpty()) {
            while (currentNode != null) {
                stackNode.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stackNode.top();
            if (currentNode.right == null || preNode == currentNode.right) {
                currentNode = stackNode.pop();
                linkedList.add(currentNode.element.toString());
                preNode = currentNode;
                currentNode = null;
            } else {
                currentNode = currentNode.right;
            }
        }
        System.out.println(linkedList.toString());
    }

    public void inorder(TreeNode node) {
        TreeNode currentNode = node;
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

    public void levelOrder(TreeNode node) {
        TreeNode currentNode = node;
        Queue<TreeNode> queue = new Queue();
        queue.enQueue(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.deQueue();
            linkedList.add(currentNode.element.toString());
            if (currentNode.left != null) {
                queue.enQueue(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.enQueue(currentNode.right);
            }
        }
        System.out.println(linkedList.toString());
    }
}
