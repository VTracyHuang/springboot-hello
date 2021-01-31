package com.example.demo.generic.demo7;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class InfoImpl implements Info<Integer> {
    @Override
    public Integer info(Integer value) {
        return value;
    }
}
