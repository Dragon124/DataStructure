package com.example.lib.array_list.tree;

import com.example.lib.array_list.linked.LinkedList;
import com.example.lib.array_list.queue.Queue;
import com.example.lib.array_list.stack.Stack;
import com.example.lib.array_list.tree.bean.TreeNode;

/**
 * Created by K on 2022/10/25
 * function:
 * other:
 */
public class Test {
    LinkedList<String> linkedList = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    public void preOrder(TreeNode node) {
        TreeNode current = node;
        TreeNode preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.top();
            if (current.right == null || preNode == current.right) {
                current = stack.pop();
                linkedList.add(current.element.toString());
                preNode = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        System.out.println(linkedList.toString());
    }

    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enQueue(node);
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.deQueue();
            linkedList.add(current.element.toString());
            if (current.left != null) {
                queue.enQueue(current.left);
            }
            if (current.right != null) {
                queue.enQueue(current.right);
            }
        }
        System.out.println(linkedList.toString());
    }
}
