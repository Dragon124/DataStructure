package com.example.lib.array_list.linked.circle;

import com.example.lib.array_list.IList;
import com.example.lib.array_list.linked.Node;

/**
 * Created by K on 2022/10/19
 * function:
 * other:
 */
public class CircleLinkedList<E> implements IList<E> {
    private int size = 0;
    private static final int DEFAULT_NO_FOUND = -1;
    private Node<E> first = null;
    private Node<E> last = null;

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
        return (E) node(index).element;
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
        if (size == 0) {
            Node<E> addNode = new Node(element, null, null);
            addNode.next = addNode;
            addNode.prev = addNode;
            first = addNode;
            last = addNode;
        } else {
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> addNode = new Node(element, nextNode, prevNode);
            nextNode.prev = addNode;
            prevNode.next = addNode;
            if (index == 0) {
                first = addNode;
            }
        }
        size++;
    }

    private Node node(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public String getLast() {
        return last.toString();
    }

    @Override
    public E remove(int index) {
        E delete;
        checkChange(index);
        if (size == 1) {
            delete=first.element;
            first = null;
            last = null;
        } else {
            Node<E> deleteNode = node(index);
            Node prevNode = deleteNode.prev;
            Node nextNode = deleteNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            if (index == 0) {
                first = nextNode;
            }
            if (index == (size - 1)) {
                last = prevNode;
            }
            delete=deleteNode.element;
        }
        size--;
        return delete;
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
        last = null;
    }

    @Override
    public String toString() {
        String value = "";
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                value += ",";
            }
            value += "[" + current.prev + "_" + current + "_" + current.next + "]";
            if (i < size - 1) {
                current = current.next;
            }
        }
        return "LinkedList{" + value + "}";
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
