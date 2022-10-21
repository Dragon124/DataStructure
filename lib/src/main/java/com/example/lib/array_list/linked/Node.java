package com.example.lib.array_list.linked;

/**
 * Created by K on 2022/10/19
 * function:
 * other:
 */

public class Node<E> {
    public E element;
    public Node<E> next;
    public Node<E> prev;

    public E getElement() {
        return element;
    }

    public Node(E element, Node<E> next, Node<E> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return element + "";
    }
}
