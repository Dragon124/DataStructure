package com.example.lib.array_list.tree.bean;

/**
 * Created by K on 2022/10/31
 * function:
 * other:
 */
public class BRTreeNode extends TreeNode<Integer>{

    //true 红色 false 黑色
    public boolean color = true;

    public BRTreeNode(Integer element) {
        super(element);
    }

    public BRTreeNode(Integer element, TreeNode<Integer> parent) {
        super(element, parent);
    }

    public BRTreeNode(Integer element, TreeNode<Integer> left, TreeNode<Integer> right, TreeNode<Integer> parent) {
        super(element, left, right, parent);
    }



}
