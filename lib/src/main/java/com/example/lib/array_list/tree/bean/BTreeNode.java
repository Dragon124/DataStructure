package com.example.lib.array_list.tree.bean;

import java.util.ArrayList;

/**
 * Created by K on 2022/10/27
 * function:
 * other:
 */
public class BTreeNode {
    public BTreeNode() {
        degree = 4;
        childNodes = new ArrayList();
        elements = new ArrayList();
    }

    public int degree;
    public ArrayList<BTreeNode> childNodes;
    public ArrayList<Integer> elements;

    //当前节点是否
    public boolean isFull() {
        return elements.size() == degree;
    }

    public void add(Integer element) {
        if (elements.size() == 0) {
            elements.add(element);
            return;
        }
        if (element > elements.get(elements.size() - 1)) {
            elements.add(element);
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == element) {
                return;
            }
            if (element < elements.get(i)) {
                elements.add(i, element);
            }
        }
    }

    public BTreeNode checkRange(Integer element) {
        if (childNodes.size() == 0) {
            return this;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (element < elements.get(i)) {
                return childNodes.get(i);
            }
        }
        return childNodes.get(childNodes.size() - 1);
    }

    public ArrayList<BTreeNode> getChildNodes() {
        return childNodes;
    }
}
