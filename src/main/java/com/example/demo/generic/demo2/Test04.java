package com.example.demo.generic.demo2;

/**
 * created by huangyating
 *
 * @Date 2021/1/25
 */
public class Test04 {
    public static void main(String[] args) {
        ChildFirst<String> childFirst = new ChildFirst<>();
        childFirst.setValue("abc");
        String value = childFirst.getValue();
        System.out.println(value);
        System.out.println("==========================");
        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue(100);
        Integer value1 = childSecond.getValue();
        System.out.println(value1);
    }
}
