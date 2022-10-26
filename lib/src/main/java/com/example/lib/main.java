package com.example.lib;

import com.example.lib.array_list.test.AVLTree;

/**
 * Created by K on 2022/10/12
 * function:
 * other:
 */
public class main {
    public static void main(String[] args) {
//        AVLTree<Integer> avlTree = new AVLTree<>();
//        for (int i = 1; i <20; i++) {
//            avlTree.add(i);
//        }
//        avlTree.remove(1);
//        avlTree.remove(2);
//        avlTree.remove(15);
//        avlTree.remove(13);
//        avlTree.remove(14);
//        avlTree.show();
        test();
    }

    public static void test() {
        AVLTree binaryTree = new AVLTree();
        for (int i = 1; i <20; i++) {
            binaryTree.add(i);
        }
        binaryTree.remove(8);
        binaryTree.remove(1);
        binaryTree.remove(2);
        binaryTree.remove(3);
        binaryTree.remove(19);
        binaryTree.remove(18);
        binaryTree.remove(17);
        binaryTree.remove(13);
        binaryTree.remove(14);
        binaryTree.remove(15);
        binaryTree.remove(7);
        binaryTree.remove(6);
        binaryTree.remove(10);
        binaryTree.add(2);
        binaryTree.show();
    }
}
