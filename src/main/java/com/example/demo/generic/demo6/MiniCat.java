package com.example.demo.generic.demo6;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class MiniCat extends Cat {

    public int level;

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "level=" + level +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
