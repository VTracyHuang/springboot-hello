package com.example.demo.generic.demo8;

import java.util.ArrayList;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Test08 {
    public static void main(String[] args) {
//        ArrayList[] list = new ArrayList[5];
//        ArrayList<String> [] listArr = list;

        ArrayList<String> [] listArr = new ArrayList[5];
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);
        ArrayList<String> strList = new ArrayList<>();
        strList.add("abc");
      //  list[0] = intList;
        listArr[0] = strList;
        String s = listArr[0].get(0);
        System.out.println(s);
    }
}
