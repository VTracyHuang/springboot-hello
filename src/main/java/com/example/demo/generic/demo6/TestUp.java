package com.example.demo.generic.demo6;

import java.util.ArrayList;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class TestUp {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();
        cats.addAll(miniCats);
        cats.addAll(cats);
        //cats.addAll(animals);
        // showAnimal(animals);
        showAnimal(cats);
        showAnimal(miniCats);
    }

    /**
     * @Description:
     * 泛型上限通配符，传递的集合类型，只能是Cat或者Cat的子类类型
     * 使用泛型上限通配符，不能够填充元素
     * @param list
     * @return void
     * @author huangyating
     * @date 2021/1/31
     */
    public static void showAnimal(ArrayList<? extends  Cat> list){
       /* list.add(new Animal());
        list.add(new Cat());
        list.add(new MiniCat());*/
        for (Cat cat : list) {
            System.out.println(cat);
        }
    }


}
