package com.example.lib.array_list;

/**
 * Created by K on 2022/10/18
 * function:
 * ◼ int size(); // 元素的数量
 * ◼ boolean isEmpty(); // 是否为空
 * ◼ boolean contains(E element); // 是否包含某个元素
 * ◼ void add(E element); // 添加元素到最后面
 * ◼ E get(int index); // 返回index位置对应的元素
 * ◼ E set(int index, E element); // 设置index位置的元素
 * ◼ void add(int index, E element); // 往index位置添加元素
 * ◼ E remove(int index); // 删除index位置对应的元素
 * ◼ int indexOf(E element); // 查看元素的位置
 * ◼ void clear(); // 清除所有元素
 * other:
 */
public interface IList<E> {

    // 元素的数量
    public int size();

    // 是否为空
    public boolean isEmpty();

    // 是否包含某个元素
    public boolean contains(E element);

    // 添加元素到最后面
    public void add(E element) ;

    // 返回index位置对应
    public E get(int index);

    //设置index位置的元素
    public E set(int index, E element) ;

    // 往index位置添加元素
    public void add(int index, E element);

    // 删除index位
    public E remove(int index) ;

    // 查看元素的
    public int indexOf(E element);

    // 清除所有元素
    public void clear() ;
}
