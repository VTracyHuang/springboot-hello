package com.example.demo.generic.demo1;

import java.util.ArrayList;
import java.util.Random;

/**
 * created by huangyating
 *  泛型类里的泛型和泛型方法里的泛型是区分独立的，即使都声明成T
 * @Date 2021/1/25
 */
public class ProductGetter<T> {

    Random random = new Random();

    //奖品
    private T product;

    //奖品池
    ArrayList<T> list = new ArrayList<>();

    //添加奖品
    public void addProduct(T t){
        list.add(t);
    }

    //如果采用类的泛型，那么它将不能被声明成静态的
    public T getProduct(){
        product = list.get(random.nextInt(list.size()));
        return product;
    }

    
    /**
     * @Description:
     * 定义的泛型方法
     * @param list<E> 泛型标识，具体类型，由调用方法的时候来指定
     * @return E
     * @author huangyating
     * @date 2021/1/31
     */
    public <T> T getProduct(ArrayList<T> list){
        return list.get(random.nextInt(list.size()));
    }

    /**
     * @Description:
     * 静态的泛型方法，采用多个泛型类型
     * @param t
     * @param e
     * @param k
     * @return void
     * @author huangyating
     * @date 2021/1/31
     */
    public static <T,E,K> void printType(T t, E e,K k){
        System.out.println(t + "\t" + t.getClass().getSimpleName());
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println(k + "\t" + k.getClass().getSimpleName());
    }

    /**
     * @Description:
     * 泛型可变参数的定义
     * @param e
     * @return void
     * @author huangyating
     * @date 2021/1/31
     */
    public static <E> void print(E...e){
        for (E e1 : e){
            System.out.println(e1);
        }
    }
}
