package com.example.lib.array_list.array;


import com.example.lib.array_list.IList;

import java.util.Arrays;

/**
 * Created by K on 2022/10/12
 * function:动态数组
 * other:
 */
public class ArrayList<E> implements IList<E> {
    public E[] elements;
    //未找到返回值
    private static final int DEFAULT_INDEX = -1;
    //默认初始大小
    private static final int DEFAULT_SIZE = 10;
    //当前数组大小
    private int size = 0;

    public ArrayList() {
        elements = (E[]) new Object[DEFAULT_SIZE];
    }

    // 元素的数量
    public int size() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 是否包含某个元素
    public boolean contains(E element) {
        return indexOf(element) != DEFAULT_INDEX;
    }

    // 添加元素到最后面
    public void add(E element) {
        add(size, element);
    }

    // 返回index位置对应
    public E get(int index) {
        checkRange(index);
        return elements[index];
    }

    //设置index位置的元素
    public E set(int index, E element) {
        checkRange(index);
        elements[index] = element;
        return element;
    }

    // 往index位置添加元素
    public void add(int index, E element) {
        checkRangeAdd(index);
        checkNull(element);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    // 删除index位
    public E remove(int index) {
        checkRange(index);
        E deleteElement = elements[index];
        size--;
        if (index == size) {
            return deleteElement;
        }
        for (int i = index; i < (size - 1); i++) {
            elements[i] = elements[i + 1];
        }
        return deleteElement;
    }

    // 查看元素的下标
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return DEFAULT_INDEX;
    }

    // 清除所有元素
    public void clear() {
        size = 0;
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
        if (size == elements.length - 1) {
            dilatation();
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

    private void checkNull(E element) {
        if (element == null) {
            throw new NullPointerException("element == null");
        }
    }

    //扩容1.5倍
    public void dilatation() {
        E[] oldElement = elements;
        elements = (E[]) new Object[((elements.length >> 1) + elements.length)];
        System.arraycopy(oldElement, 0, elements, 0, oldElement.length);
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", currentSize=" + size +
                ", Size="+elements.length+
                '}';
    }
}
