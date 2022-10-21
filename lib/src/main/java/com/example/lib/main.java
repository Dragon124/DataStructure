package com.example.lib;

import com.example.lib.array_list.tree.BinarySearchTree;

/**
 * Created by K on 2022/10/12
 * function:
 * other:
 */
public class main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(7);
        tree.add(4);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(9);
        tree.add(8);
        tree.add(11);
        tree.add(10);
        tree.add(12);
        tree.show();
        tree.preorderTraversal();
//        System.out.println(((TreeNode)tree.succeed(tree.root)).toString());
    }
}
