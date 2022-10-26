package com.example.lib.array_list.test;

import com.example.lib.array_list.tree.TreeNodeShow;

/**
 * Created by K on 2022/10/26
 * function:
 * other:
 */
public class AVLTree extends BinarySearchTree {
    @Override
    protected void addLater(TreeNode element) {
        while ((element = element.parent) != null) {
            if (element.isBalance()) {
                element.upHeight();
            } else {
                rePlayHeight(element);
                break;
            }
        }
    }

    @Override
    protected void removeLater(TreeNode element) {
        while ((element = element.parent) != null) {
            if (element.isBalance()) {
                element.upHeight();
            } else {
                rePlayHeight(element);
            }
        }
    }

    public void rePlayHeight(TreeNode node) {
        TreeNode postNode = null;
        if (node.getBalance() > 0) {//L
            postNode = node.left;
            if (postNode.getBalance() < 0) {//R
                leftRotate(postNode);
            }
            rightRotate(node);
        } else {//R
            postNode = node.right;
            if (postNode.getBalance() > 0) {//L
                rightRotate(postNode);
            }
            leftRotate(node);
        }
    }

    private void leftRotate(TreeNode ground) {
        TreeNode parent = ground.right;
        ground.right = parent.left;
        parent.left = ground;
        parent.parent = ground.parent;

        if (ground.isLeftTree()) {
            ground.parent.left = parent;
        } else if (ground.isRightTree()) {
            ground.parent.right = parent;
        } else {//根结点
            root = parent;
        }

        if (ground.right != null) {
            ground.right.parent = ground;
        }

        ground.parent = parent;
        ground.upHeight();
        parent.upHeight();
    }

    private void rightRotate(TreeNode ground) {
        TreeNode parent = ground.left;
        ground.left = parent.right;
        if (ground.left != null) {
            ground.left.parent = ground;
        }
        parent.right = ground;
        parent.parent = ground.parent;

        if (ground.isLeftTree()) {
            ground.parent.left = parent;
        } else if (ground.isRightTree()) {
            ground.parent.right = parent;
        } else {
            root = parent;
        }
        ground.parent = parent;
        ground.upHeight();
        parent.upHeight();
    }

    public void show(){
        TreeNodeShow.show(root);
    }
}
