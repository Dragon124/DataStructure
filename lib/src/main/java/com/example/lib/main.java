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
        avlTree.show();
    }
}
