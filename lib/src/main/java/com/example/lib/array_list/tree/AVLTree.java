package com.example.lib.array_list.tree;

import com.example.lib.array_list.tree.bean.AVLNode;
import com.example.lib.array_list.tree.bean.TreeNode;

/**
 * Created by K on 2022/10/24
 * function:
 * other:
 */
public class AVLTree<E> extends BinarySearchTree<E> {

    @Override
    protected TreeNode<E> createNode(E element, TreeNode<E> parent) {
        return new AVLNode<E>(element, parent);
    }

    @Override
    protected void addLater(TreeNode<E> element) {
        while ((element = element.parent) != null) {
            int balance = ((AVLNode<E>) element).getBalance();
            if (Math.abs(balance) < 2) {
                upHeight(element);
            } else {
                replyHeight((AVLNode<E>) element, balance);
            }
        }
    }


    private void replyHeight(AVLNode<E> node, int balance) {
        if (balance > 0) {//左
            if (((AVLNode) node.left).getBalance() < 0) {
                rightRotate(node.left);
            }
            leftRotate(node);
            upHeight(node);
        } else {//右
            if (((AVLNode) node.right).getBalance() > 0) {
                leftRotate(node.right);
                System.out.println("右右");
            }
            System.out.println("右");
            rightRotate(node);
        }
    }

    private void leftRotate(TreeNode<E> node) {
        TreeNode parentNode = node.parent;
        TreeNode belowNode = node.left;
        belowNode.parent = parentNode;

    }

    private void rightRotate(TreeNode<E> node) {
        TreeNode parentNode = node.parent;
        TreeNode belowNode = node.right;

    }

    public void upHeight(TreeNode node) {
        int leftHeight = node.left == null ? 0 : ((AVLNode) node.left).height;
        int rightHeight = node.right == null ? 0 : ((AVLNode) node.right).height;
        ((AVLNode) node).height = Math.max(leftHeight, rightHeight) + 1;
    }
}
