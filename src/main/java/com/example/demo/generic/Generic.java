package com.example.demo.generic;

/**
 * created by huangyating
 * 泛型类的定义
 * @param <T> 泛型标识————类型形参
 *           T 创建对象的时候里指定具体的数据类型
 * @Date 2021/1/25
 */
public class Generic<T> {

    //是由外部使用类的时候来指定的
    private T key;


    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "key=" + key +
                '}';
    }
}
