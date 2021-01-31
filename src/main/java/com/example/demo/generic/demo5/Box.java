package com.example.demo.generic.demo5;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Box<E> {

    private E first;

    public E getFirst(){
        return first;
    }

    public void setFirt(E first){
        this.first = first;
    }
}
