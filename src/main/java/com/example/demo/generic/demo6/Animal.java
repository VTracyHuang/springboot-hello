package com.example.demo.generic.demo6;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
