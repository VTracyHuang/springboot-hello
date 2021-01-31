package com.example.demo.lambda;

/**
 * created by huangyating
 *
 * @Date 2021/1/25
 */
//函数式接口的定义: 接口中只有一个抽象方法（接口中重写Object的public方法不算函数式接口的方法），可用@FunctionInterface修饰，也可以不被该注解修饰的接口
//简化方法传递方法的代码编写
//java8内置四大函数式接口和其他接口：消费型，供给型，函数型，断言型
@FunctionalInterface
public interface CalFunction {

    int cal(int a,int b);
}
