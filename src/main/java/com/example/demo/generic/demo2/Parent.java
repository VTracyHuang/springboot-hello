package com.example.demo.generic.demo2;

/**
 * created by huangyating
 *
 * @Date 2021/1/25
 */
public class Parent<E> {

    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
