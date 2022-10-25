package com.example.lib.array_list.stack;


import com.example.lib.array_list.array.ArrayList;

/**
 * Created by K on 2022/10/19
 * function:栈
 * ◼ int size(); // 元素的数量
 * ◼ boolean isEmpty(); // 是否为空
 * ◼ void push(E element); // 入栈
 * ◼ E pop(); // 出栈
 * ◼ E top(); // 获取栈顶元素
 * ◼ void clear(); // 清空
 * other:
 */
public class Stack<E> {
    private ArrayList<E> arrayList;
    private int size = 0;

    public Stack() {
        arrayList = new ArrayList<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E element) {
        arrayList.add(size, element);
        size++;
    }

    //出栈
    public E pop() {
        E value = arrayList.remove(size-1);
        size--;
        return value;
    }

    //获取栈顶元素
    public E top() {
        return arrayList.get(size-1);
    }

    // 清空
    public void clear() {
        arrayList.clear();
    }
}
