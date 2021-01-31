package com.example.demo.generic.demo5;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Test5 {

    public static void main(String[] args) {
        Box<Number> box1 = new Box<>();
        box1.setFirt(100);
        showBox(box1);

        Box<Integer> box2 = new Box<>();
        box2.setFirt(200);
        showBox(box2);
    }

    /*
        类型通配符的上限
     */
    public static void showBox(Box<? extends Number> box){
        Number first = box.getFirst();
        System.out.println(first);
    }
}
