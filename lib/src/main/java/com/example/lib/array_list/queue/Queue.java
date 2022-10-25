package com.example.lib.array_list.queue;

import com.example.lib.array_list.linked.circle.CircleLinkedList;

/**
 * Created by K on 2022/10/19
 * function:队列
 * ◼ int size(); // 元素的数量
 * ◼ boolean isEmpty(); // 是否为空
 * ◼ void clear(); // 清空
 * ◼ void enQueue(E element); // 入队
 * ◼ E deQueue(); // 出队
 * ◼ E front();// 获取队列的头元素
 * other:
 */
public class Queue<E> {
    private CircleLinkedList<E> queue;

    public Queue() {
        queue = new CircleLinkedList<>();
    }

    // 元素的数量
    public int size() {
        return getSize();
    }

    // 是否为空
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // 清空
    public void clear() {
        queue.clear();
    }

    // 入队
    public void enQueue(E element) {
        queue.add(element);
    }

    private int getSize() {
        return queue.size();
    }

    // 出队
    public E deQueue() {
        return queue.remove(0);
    }

    //获取队列的头元素
    public E front() {
        return queue.get(queue.size()-1);
    }

    @Override
    public String toString() {
        String value = "";
        for (int i = 0; i < queue.size(); i++) {
            if (i != 0) {
                value += ",";
            }
            value += "[" + queue.get(i) + "]";
        }
        return value;
    }
}
