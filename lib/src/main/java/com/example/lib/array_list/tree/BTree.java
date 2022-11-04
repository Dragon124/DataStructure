package com.example.lib.array_list.tree;

import com.example.lib.array_list.stack.Stack;
import com.example.lib.array_list.tree.bean.BTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by K on 2022/10/27
 * function:
 * other:
 */
public class BTree {
    public BTreeNode root;

    public void add(Integer element) {
        if (root == null) {
            root = new BTreeNode();
            root.add(element);
        }else {
            root.checkRange(element).add(element);
        }
    }

    public void remove(Integer element) {

    }

    public void print() {
        ArrayList<String> values = new ArrayList<>();
        Queue<BTreeNode> queue = new LinkedList<>();
        Queue<BTreeNode> childQueue = new LinkedList<>();
        queue.add(root);
        BTreeNode currentNode;
        String value = "";
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            value += currentNode.elements.toString();
            //当前层遍历完毕,把下一次加入队列
            if (queue.isEmpty()) {
                values.add(value);
                queue.addAll(childQueue);
                childQueue.clear();
            } else {
                for (BTreeNode childNode : currentNode.getChildNodes()) {
                    if (childNode != null) {
                        childQueue.add(childNode);
                    }
                }
            }
        }
        System.out.println(values);
    }
}
