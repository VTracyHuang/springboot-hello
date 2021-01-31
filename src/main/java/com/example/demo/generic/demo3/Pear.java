package com.example.demo.generic.demo3;

/**
 * created by huangyating
 * 泛型接口的实现类，是一个泛型类，那么要保证实现接口的泛型类泛型标识包含泛型
 * @Date 2021/1/27
 */
public class Pear<T,E> implements Generator<T> {

    private T key;

    private E value;

    @Override
    public T getKey() {
        return key;
    }

    public E getValue(){
        return value;
    }
}
