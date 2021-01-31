package com.example.demo.generic.demo2;

/**
 * created by huangyating
 * 泛型类派生子类，如果子类不是泛型类，那么父类要明确数据类型
 * @Date 2021/1/27
 */
public class ChildSecond extends Parent<Integer> {
    @Override
    public Integer getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }
}
