package com.example.demo.generic.demo7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * created by huangyating
 *
 * @Date 2021/1/31
 */
public class Test07 {

    /**
     * @Description:
     * 编译阶段可以将其声明成不同类型的泛型，但编译完成后泛型已经被擦除了
     * @param args
     * @return void
     * @author huangyating
     * @date 2021/1/31
     */
    public static void main(String[] args) {
       /* ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        System.out.println(intList.getClass().getSimpleName());
        System.out.println(strList.getClass().getSimpleName());
        System.out.println(intList.getClass() == strList.getClass());*/

       Eraser<Integer> eraser = new Eraser<>();
       //利用反射,获取Eraser类的字节码文件的Class类对象
        Class<? extends Eraser> aClass = eraser.getClass();
        //获取所有的成员变量
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {

            //打印成员变量的名称和类型
            System.out.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }
        System.out.println("===============");

        //获取Eraser下的所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {

            //打印方法名和方法的返回类型
            System.out.println(declaredMethod.getName() + ":" + declaredMethod.getReturnType().getSimpleName());
        }

        System.out.println("============");

        Class<InfoImpl> infoClass = InfoImpl.class;

        //获取所有的方法
        Method[] declaredMethods1 = infoClass.getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println(method.getName()+":"+method.getReturnType().getSimpleName());
        }
    }
}
