package com.example.demo.generic.demo2;

/**
 * created by huangyating
 * 泛型类派生子类，子类也是泛型类，那么子类的泛型标识要和父类一致
 *  泛型扩展？
 * @Date 2021/1/25
 */
public class ChildFirst<T> extends Parent<T> {

    @Override
    public T getValue() {
        return super.getValue();
    }
}
