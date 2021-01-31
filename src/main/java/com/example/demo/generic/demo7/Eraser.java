package com.example.demo.generic.demo7;

import java.util.List;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Eraser<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * @Description:
     * 泛型列表
     * @param t
     * @return T
     * @author huangyating
     * @date 2021/1/31
     */
    public <T extends List> T show(T t){
        return t;
    }


}
