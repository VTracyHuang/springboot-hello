package com.example.demo.lambda;

/**
 * created by huangyating
 *
 * @Date 2021/1/25
 */
public class Test {

    public static void main(String[] args) {
        cal(1,2,((a, b) -> a + b));
    }

    public static void cal(int a, int b, CalFunction calFunction){
        int result = calFunction.cal(a,b);
        System.out.println(result);
    }
}
