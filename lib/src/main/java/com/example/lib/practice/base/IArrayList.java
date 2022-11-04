package com.example.lib.practice.base;

/**
 * Created by K on 2022/11/1
 * function:
 * other:
 */
public interface IArrayList<E> {
    // 元素的数量
    public int size();

    // 是否为空
    public boolean isEmpty();

    // 是否包含某个元素
    public boolean contains(E element);

    // 添加元素到最后面
    public void add(E element);

    // 返回index位置对应
    public E get(int index);

    //设置index位置的元素
    public E set(int index, E element);

    // 往index位置添加元素
    public void add(int index, E element);

    // 删除index位
    public E remove(int index);

    // 查看元素的
    public int indexOf(E element);

    // 清除所有元素
    public void clear();
}
