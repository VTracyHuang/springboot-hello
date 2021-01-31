package com.example.demo.generic.demo6;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Cat extends Animal {

    public int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
