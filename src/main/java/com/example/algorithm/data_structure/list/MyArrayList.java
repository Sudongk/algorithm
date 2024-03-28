package com.example.algorithm.data_structure.list;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    // 타입 안정성 때문에 Object 타입 대신 제네릭 타입 사용
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;


    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T t) {
        if(this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        this.elements[this.size++] = t;
    }

    @Override
    public void insert(int index, T t) {
        if(this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = t;
        this.size++;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T t) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        System.out.println(list.size);
        System.out.println(Arrays.toString(list.elements));

        list.insert(1, 4);

        System.out.println(list.size);
        System.out.println(Arrays.toString(list.elements));
    }

}
