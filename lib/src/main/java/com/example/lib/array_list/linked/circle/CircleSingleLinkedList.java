package com.example.lib.array_list.linked.circle;

import com.example.lib.array_list.IList;

/**
 * Created by K on 2022/10/19
 * function:单向循环链表
 * other:
 */
public class CircleSingleLinkedList<E> implements IList<E> {
    private int size = 0;
    private Node<E> first = null;
    private static final int DEFAULT_NO_FOUND = -1;

    public class Node<E> {
        public E element;
        public Node<E> next;

        public E getElement() {
            return element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + element + "_" + next.element + "]";
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            if (element.equals(currentNode.element)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public E get(int index) {
        checkChange(index);
        return (E) node(index).toString();
    }

    @Override
    public E set(int index, E element) {
        checkChange(index);
        node(index).element = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        checkChangeAdd(index);
        if (index == 0) {
            if (first == null) {
                first = new Node<E>(element, null);
                first.next = first;
            } else {
                Node lastNode = node(size - 1);
                Node addNode = new Node(element, first);
                lastNode.next = addNode;
                first = addNode;
            }
        } else {
            Node prevNode = node(index - 1);
            Node addNode = new Node(element, prevNode.next);
            prevNode.next = addNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkChange(index);
        Node deletePrevNode;
        if (size == 0) {
            deletePrevNode = first;
            first = null;
        } else {
            if (index == 0) {
                deletePrevNode = node(size - 1);
            } else {
                deletePrevNode = node(index - 1);
            }
            deletePrevNode.next = deletePrevNode.next.next;
        }
        size--;
        return (E) deletePrevNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            if (element.equals(currentNode.element)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return DEFAULT_NO_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public String toString() {
        String value = "{";
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                value += ",";
            }
            value += current.toString();
            current = current.next;
        }
        value += "}";
        return value;
    }

    private Node node(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkChange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Size:" + size + ",index:" + index);
        }
    }

    private void checkChangeAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Size:" + size + ",index:" + index);
        }
    }
}
