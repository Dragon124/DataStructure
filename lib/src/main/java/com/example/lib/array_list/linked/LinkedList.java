package com.example.lib.array_list.linked;

import com.example.lib.array_list.IList;

/**
 * Created by K on 2022/10/18
 * function:双向链表
 * other:
 */
public class LinkedList<E> implements IList<E> {
    private int size = 0;
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
        Node current = first;
        while (current != null) {
            if (current.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public E get(int index) {
        checkRange(index);
        Node current = first;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return (E) current.element;
    }

    @Override
    public E set(int index, E element) {
        checkRange(index);
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        checkRangeAdd(index);
        if (index == size) {
            Node addNode = new Node(element, null, last);
            if (last == null) {
                first = addNode;
            } else {
                last.next = addNode;
            }
            last = addNode;
        } else {
            Node nextNode = node(index);
            Node prevNode = nextNode.prev;
            Node addNode = new Node(element, nextNode, prevNode);
            if (prevNode == null) {
                first = addNode;
            } else {
                prevNode.next = addNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Node deleteNode = node(index);
        Node prevNode = deleteNode.prev;
        Node nextNode = deleteNode.next;
        if (prevNode == null) {
            nextNode.prev = null;
            first = nextNode;
        } else if (nextNode == null) {
            prevNode.next = null;
            last = prevNode;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return (E) deleteNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node currentElement = first;
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            currentIndex = i;
            if (currentElement.element.equals(element)) {
                break;
            }
            currentElement = currentElement.next;

        }
        return currentIndex;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    //    @Override
//    public String toString() {
//        String value = "";
//        Node current = first;
//        for (int i = 0; i < size; i++) {
//            if (i != 0) {
//                value += ",";
//            }
//            value += "[" + current.prev + "_" + current + "_" + current.next + "]";
//            if (i < size - 1) {
//                current = current.next;
//            }
//        }
//        return "LinkedList{" + value + "}";
//    }
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

    /**
     * 添加范围检查规则:
     * 1.不能超过当前数量
     * 2.不能小于0
     */
    private void checkRangeAdd(int index) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException("ArrayListSize:" + size + ",index:" + index);
        }

    }

    /**
     * 删改差范围检查
     * 1.不能超过当前数量
     * 2.不能等于大于当前数量
     */
    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ArrayListSize:" + size + ",index:" + index);
        }
    }

    private Node node(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
