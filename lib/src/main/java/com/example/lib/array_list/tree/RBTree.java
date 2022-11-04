package com.example.lib.array_list.tree;

import com.example.lib.array_list.tree.bean.BRTreeNode;
import com.example.lib.array_list.tree.bean.TreeNode;

/**
 * Created by K on 2022/10/31
 * function:
 * other:
 */
public class RBTree extends BinarySearchTree<Integer> {
    @Override
    protected void addLater(TreeNode<Integer> element) {
        if (element.parent == null) {
            black(element);
            return;
        }
        TreeNode parent = element.parent;
        //如果父节点是黑色,直接返回
        if (isBlack(parent)) {
            return;
        }
        //叔父节点是红色
        if (isRed(element.uncle())) {
            //把父节点和叔父节点染成黑色
            black(parent);
            black(element.uncle());
            //把祖父节点当做新添加节点
            red(element.parent.parent);
            addLater(element.parent.parent);
            return;
        }

        //叔父不是红色
        if (parent.isLeftTree()) {
            red(parent.parent);
            if (element.isRightTree()) {//LR
                black(element);
                leftRotate(parent);
                rightRotate(element.parent);
            } else {//LL
                black(parent);
                rightRotate(parent.parent);
            }
        }
        if (parent.isRightTree()) {
            red(parent.parent);
            if (element.isLeftTree()) {//RL
                black(element);
                rightRotate(parent);
                leftRotate(element.parent);
            } else {//RR
                black(parent);
                leftRotate(parent.parent);
            }
        }
    }

    @Override
    protected void removeLater(TreeNode<Integer> element, TreeNode<Integer> replace) {
        //删除红色不处理
        if (isRed(element)) {
            return;
        }
        //删除替换节点是红色,把替换节点染成黑色
        if (isRed(replace)) {
            black(replace);
            return;
        }
        TreeNode parent = element.parent;
        //删除的跟节点
        if (parent == null) {
            return;
        }
        //删除黑色叶子节点
        //判断被删除的node是左还是右
        boolean left = parent.left == null || element.isLeftTree() ;
        TreeNode<Integer> sibling = left ? parent.right : parent.left;
        if (left) {//被删除的节点在左边,兄弟在右边
            if (isRed(sibling)) {//兄弟节点是红色
                black(sibling);
                red(parent);
                leftRotate(parent);
                //旋转后换兄弟节点
                sibling = parent.right;
            }
            //兄弟节点必定是黑色
            if (isBlack(sibling.right) && isBlack(sibling.left)) {
                //兄弟节点没有红色节点,父节点要向下合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    removeLater(parent, null);
                }
            } else {//兄弟节点至少有一个红色节点,向兄弟节点借元素
                //左边是黑色,兄弟要先进行左旋转
                if (isBlack(sibling.right)) {
                    rightRotate(sibling);
                    sibling = parent.right;
                }
                color(sibling, colorOf(parent));
                black(parent);
                black(sibling.right);
                leftRotate(parent);
            }
        } else {//被删除的节点在右边,兄弟在左边
            if (isRed(sibling)) {//兄弟节点是红色
                black(sibling);
                red(parent);
                rightRotate(parent);
                //旋转后换兄弟节点
                sibling = parent.left;
            }
            //兄弟节点必定是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //兄弟节点没有红色节点,父节点要向下合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    removeLater(parent, null);
                }
            } else {//兄弟节点至少有一个红色节点,向兄弟节点借元素
                //左边是黑色,兄弟要先进行左旋转
                if (isBlack(sibling.left)) {
                    leftRotate(sibling);
                    sibling = parent.left;
                }
                color(sibling, colorOf(parent));
                black(parent);
                black(sibling.left);
                rightRotate(parent);

            }
        }
    }

    public void leftRotate(TreeNode<Integer> ground) {
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
        }

        if (ground.right != null) {
            ground.right.parent = ground;
        }

        ground.parent = parent;
    }

    public void rightRotate(TreeNode<Integer> ground) {
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
    }

    public boolean colorOf(TreeNode node) {
        return node != null && ((BRTreeNode) node).color;
    }

    public boolean isBlack(TreeNode node) {
        return !colorOf(node);
    }

    public boolean isRed(TreeNode node) {
        return colorOf(node);
    }

    public BRTreeNode color(TreeNode node, boolean color) {
        if (node == null) {
            return null;
        }
        ((BRTreeNode) node).color = color;
        return ((BRTreeNode) node);
    }

    public BRTreeNode red(TreeNode node) {
        return color(node, true);
    }

    public BRTreeNode black(TreeNode node) {
        return color(node, false);
    }

    @Override
    protected TreeNode<Integer> createNode(Integer element, TreeNode<Integer> parent) {
        return new BRTreeNode(element, parent);
    }
}
