package com.example.lib;

import com.example.lib.array_list.tree.AVLTree;

/**
 * Created by K on 2022/10/12
 * function:
 * other:
 */
public class main {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (int i = 1; i <20; i++) {
            avlTree.add(i);
        }
        avlTree.remove(1);
        avlTree.remove(2);
        avlTree.remove(15);
        avlTree.remove(13);
        avlTree.remove(14);
        avlTree.show();
    }
}
