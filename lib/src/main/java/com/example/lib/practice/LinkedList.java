package com.example.lib.practice;

import com.example.lib.practice.base.AbsArrayList;

/**
 * Created by K on 2022/11/1
 * function:
 * other:
 */
public class LinkedList<E> extends AbsArrayList<E> {
    public Node<E> first;
    public Node<E> last;

    @Override
    public E get(int index) {
        checkRange(index);
        return null;
    }

    @Override
    public E set(int index, E element) {
        checkRange(index);
        return null;
    }

    @Override
    public void add(int index, E element) {
        checkRangeAdd(index);
        if (index == size) {
            Node<E> newNode = new Node<>(element, last, null);
            if (first == null) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
        } else {
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, prevNode, nextNode);
            if (prevNode == null) {
                first = newNode;
            } else {
                prevNode.next = newNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Node<E> deleteNode = node(index);
        Node<E> nextNode = deleteNode.next;
        Node<E> prevNode = deleteNode.prev;
        if (prevNode == null) {
            first = nextNode;
            nextNode.prev = null;
        } else if (nextNode == null) {
            last = prevNode;
            prevNode.next = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return deleteNode.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void clear() {
        super.clear();
        first = null;
    }

    private static class Node<E> {
        public E element;
        public Node<E> prev;
        public Node<E> next;

        public Node(E element, Node<E> prev) {
            this.element = element;
            this.prev = prev;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return (prev == null ? "null" : prev.element) + "_" + element + "_" + (next == null ? "null" : next.element);
        }
    }

    //检查搜索删除范围
    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("LinkedList:" + size + ",index:" + index);
        }
    }

    //检查添加范围
    private void checkRangeAdd(int index) {
        if (index != 0 && (index < 0 || index > size)) {
            throw new IndexOutOfBoundsException("LinkedList:" + size + ",addIndex:" + index);
        }
    }

    private Node<E> node(int index) {
        Node<E> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        String value = "";
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                value += ",";
            }
            value += "[" + current + "]";
            if (i < size - 1) {
                current = current.next;
            }
        }
        return "LinkedList{" + value + "}";
    }
}
