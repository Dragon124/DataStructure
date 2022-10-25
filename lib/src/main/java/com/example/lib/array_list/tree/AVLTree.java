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
            if (isBalance(element)) {
                upHeight(element);
            } else {
                replyHeight((AVLNode<E>) element);
                break;
            }
        }
    }


    private void replyHeight(AVLNode<E> ground) {
        AVLNode parent = ground.tallerChild();
        AVLNode child = parent.tallerChild();
        if (parent.isLeftTree()) {
            if (child.isRightTree()) {//LR
                leftRotate(parent);
            }
            rightRotate(ground);
        }
        if (parent.isRightTree()) {
            if (child.isLeftTree()) {//RL
                rightRotate(parent);
            }
            leftRotate(ground);
        }
    }

    private void leftRotate(TreeNode<E> ground) {
        TreeNode parent = ground.right;
        ground.right = parent.left;
        parent.left = ground;

        parent.parent = ground.parent;
        if (ground.isLeftTree()) {
            ground.parent.left = parent;
        } else if (ground.isRightTree()) {
            ground.parent.right = parent;
        } else {
            root = parent;
            parent.parent = null;
        }

        if (ground.right != null) {
            ground.right.parent = ground;
        }

        ground.parent = parent;

        upHeight(ground);
        upHeight(parent);
    }

    private void rightRotate(TreeNode<E> ground) {
        TreeNode parent = ground.left;
        ground.left = parent.right;
        parent.right = ground;

        parent.parent = ground.parent;
        if (ground.isRightTree()) {
            ground.parent.right = parent;
        } else if (ground.isLeftTree()) {
            ground.parent.left = parent;
        } else {
            root = parent;
            parent.parent = null;
        }

        ground.parent = parent;

        upHeight(ground);
        upHeight(parent);
    }

    //该节点是否平衡
    private boolean isBalance(TreeNode<E> element) {
        return Math.abs(((AVLNode) element).getBalance()) <= 1;
    }

    public void upHeight(TreeNode node) {
        int leftHeight = node.left == null ? 0 : ((AVLNode) node.left).height;
        int rightHeight = node.right == null ? 0 : ((AVLNode) node.right).height;
        ((AVLNode) node).height = Math.max(leftHeight, rightHeight) + 1;
    }
}
