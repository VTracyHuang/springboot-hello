package com.example.demo;

import com.example.demo.lambda.CalFunction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//函数式接口的相关测试
@SpringBootTest
class SpringbootHelloApplicationTests {

    @Test
    public void test(){
        boolean result = cal(1, 2, (a, b) -> {
            System.out.println("a:" + a + ",b:" + b);
            return a * b;
        });
        System.out.println("结果为：" +result);
    }

    private boolean cal(int a, int b, CalFunction calFunction){
        int result = calFunction.cal(a, b);
        if(result >= 2) return true;
        return false;
    }

    @Test
    public void testConsumer(){
        happy(1000, m -> System.out.println("消费：" + m));
    }
    private void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void testSupplier(){
        List<Integer> numList = getNumList(10, ()->(int)(Math.random()*100));
        for (Integer i: numList) {
            System.out.println(i);
        }
    }

    private List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i <num;i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void testFunction(){
        String trimStr = strHandler("\t\t  Hello,World!",(str) -> str.trim());
        System.out.println(trimStr);
    }

    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    @Test
    public void testPredicate(){
        List<String> list = Arrays.asList("Hello","World","Hi","o","123");
        List<String> filterStr = filterStr(list, (str) -> str.length() > 1);
        for (String string:filterStr) {
            System.out.println(string);
        }
    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> list2 = new ArrayList<>();
        for (String str:list) {
            if(predicate.test(str)){
                list2.add(str);
            }
        }
        return list2;
    }
}
