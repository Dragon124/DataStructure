package com.example.lib.practice;

import com.example.lib.practice.base.AbsArrayList;

import java.util.Arrays;

/**
 * Created by K on 2022/11/1
 * function:
 * other:
 */
public class ArrayListPractice<E> extends AbsArrayList<E> {
    private E[] elements;

    public ArrayListPractice() {
        elements = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkRange(index);
        E olrElement = elements[index];
        elements[index] = element;
        return olrElement;
    }

    @Override
    public void add(int index, E element) {
        checkRangeAdd(index);
        checkDilatation();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        E olrElement = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return olrElement;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return DEFAULT_NO_FOUND;
    }

    //检查搜索删除范围
    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ArrayListSize:" + size + ",index:" + index);
        }
    }

    //检查添加范围
    private void checkRangeAdd(int index) {
        if (index != 0 && (index < 0 || index > size)) {
            throw new IndexOutOfBoundsException("ArrayListSize:" + size + ",addIndex:" + index);
        }
    }

    private void checkDilatation() {
        //到达最大容量,扩容1.5倍
        if (size == elements.length) {
            E[] newArrayList = (E[]) new Object[(elements.length + (elements.length >> 1))];
            System.arraycopy(elements, 0, newArrayList, 0, elements.length);
            elements = newArrayList;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements) + "size:" + size;
    }
}
