package com.example.lib.array_list.test;

/**
 * Created by K on 2022/10/26
 * function:
 * other:
 */
public class BinarySearchTree extends BinaryTree {

    public void add(Integer element) {
        size++;
        if (root == null) {
            root = new TreeNode<Integer>(element);
            return;
        }
        TreeNode<Integer> currentNode = root;
        TreeNode<Integer> parentNode = root;
        //找出要添加的parent位置
        while (currentNode != null) {
            parentNode = currentNode;
            if (element < currentNode.element) {
                currentNode = currentNode.left;
            } else if (element == currentNode.element) {
                size--;
                return;
            } else {
                currentNode = currentNode.right;
            }
        }
        //判断左右,然后添加
        if (element < parentNode.element) {
            parentNode.left = new TreeNode<>(element, parentNode);
            addLater(parentNode.left);
        } else {
            parentNode.right = new TreeNode<>(element, parentNode);
            addLater(parentNode.right);
        }
    }

    public void remove(Integer element) {
        TreeNode<Integer> removeNode = node(element);
        //删除为空直接返回
        if (removeNode == null) {
            return;
        }
        size--;
        //如果是度为2的节点,则用前驱值替换现在值,然把前驱节点替换成要删除的节点
        if (removeNode.isTwoChild()) {
            TreeNode<Integer> succeedNode = precursor(removeNode);
            removeNode.element = succeedNode.element;
            removeNode = succeedNode;
        }
        //node==null,则removeNode是叶子节点;node!=null,则removeNode是度1节点
        TreeNode node = removeNode.left == null ? removeNode.right : removeNode.left;
        //如果是叶子节点直接删除
        if (node == null) {
            //parent为空则是根结点
            if (removeNode.parent == null) {
                root = null;
            } else if (removeNode.isLeft()) {
                removeNode.parent.left = null;
            } else {
                removeNode.parent.right = null;
            }
        } else {//度为1
            node.parent = removeNode.parent;
            if (removeNode.parent == null) {
                root = node;
            } else if (removeNode.isLeft()) {
                removeNode.parent.left = node;
            } else {
                removeNode.parent.right = node;
            }
        }
        removeLater(removeNode);
    }

    protected void addLater(TreeNode treeNode){

    }

    protected void removeLater(TreeNode treeNode){

    }
}
