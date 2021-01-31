package com.example.demo.generic;

import java.util.ArrayList;

/**
 * created by huangyating
 *
 * @Date 2021/1/25
 */
public class TestGeneric {


    //不用泛型，很容易引起ClassCastException
    public static void main(String[] args) {
        /*ArrayList list = new ArrayList<>();

        list.add("java");
        list.add(100);
        list.add(true);

        list.forEach( o -> System.out.println(o));

        ArrayList<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");

        strList.forEach(o -> System.out.println(o));*/

        Generic<String> stringGeneric = new Generic<>("a");
        String key1 = stringGeneric.getKey();
        System.out.println("key1:" + key1);

        //int 和 Integer自动拆装箱
        Generic<Integer> integerGeneric = new Generic<>(1);
        Integer key2 = integerGeneric.getKey();
        System.out.println("key2:" + key2);

        //泛型类在创建对象的时候，没有指定类型，将按照Object类型来操作。
        Generic generic = new Generic("123");
        Object key3 = generic.getKey();
        System.out.println("key3:" + key3);

        //泛型不支持基本数据类型
        //Generic<int> generic1 = new Generic<int>(100);   X

        System.out.println("==========================");

        //同一泛型类，根据不同的数据类型创建的对象，本质上是同一类型
        System.out.println(integerGeneric.getClass());
        System.out.println(stringGeneric.getClass());
        System.out.println(integerGeneric.getClass() == stringGeneric.getClass());
    }
}
