package com.cmxy;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    public void addLast(E element) {
        this.add(size, element);
    }

    public void addFirst(E element) {
        this.add(0, element);
    }

    public void add(int index, E element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Fail2");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Fail3");
        }
        return data[index];
    }


    public E getFirst() {
        return this.get(0);
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Fail3");
        }
        data[index] = element;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed");
        }
        E ret = data[index];
        for (int i = index ; i < size-1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length))
                .append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
    }
}
