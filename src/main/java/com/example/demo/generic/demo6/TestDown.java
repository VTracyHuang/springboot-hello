package com.example.demo.generic.demo6;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class TestDown {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();
        showAnimals(animals);
        showAnimals(cats);
       // showAnimals(miniCats);
    }

    /**
     * @Description:
     * 类型通配符下限，要求集合只能是Cat或Cat的父类类型
     * 定义类型通配符下限的时候，可以添加元素
     * @param list
     * @return void
     * @author huangyating
     * @date 2021/1/31
     */
    public static void showAnimals(List<? super Cat> list){
       /* list.add(new Cat());
        list.add(new MiniCat());*/
        for (Object o:list) {
            System.out.println(o);
        }
    }
}
