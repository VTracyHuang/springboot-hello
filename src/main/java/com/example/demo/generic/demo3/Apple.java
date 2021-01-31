package com.example.demo.generic.demo3;

/**
 * created by huangyating
 * 实现泛型接口的类，不是泛型类，需要明确实现泛型接口的数据类型
 * @Date 2021/1/27
 */
public class Apple implements Generator<String> {
    @Override
    public String getKey() {
        return "hello generic";
    }
}
