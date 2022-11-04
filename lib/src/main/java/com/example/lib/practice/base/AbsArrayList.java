package com.example.lib.practice.base;

/**
 * Created by K on 2022/11/1
 * function:
 * other:
 */
public abstract class AbsArrayList<E> implements IArrayList<E> {
    //默认数组大小
    protected static final int DEFAULT_SIZE = 10;
    //找不到默认返回值
    protected static final int DEFAULT_NO_FOUND = -1;
    //数组大小
    protected int size = 0;

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
        return indexOf(element) != DEFAULT_NO_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void clear() {
        size = 0;
    }
}
