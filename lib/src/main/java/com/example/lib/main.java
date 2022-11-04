package com.example.lib;

import com.example.lib.practice.LinkedList;

/**
 * Created by K on 2022/10/12
 * function:
 * other:
 */
public class main {
    public static void main(String[] args) {

        test();
    }

    public static void test() {
        LinkedList<Integer> listPractice = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            listPractice.add(i);
        }
        listPractice.remove(5);
        System.out.println(listPractice);

    }
}
