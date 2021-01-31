package com.example.demo.generic.demo1;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by huangyating
 *
 * @Date 2021/1/25
 */
public class MainClass {

    public static void main(String[] args) {
        //创建抽奖器对象，指定数据类型
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        String [] strProducts = {"苹果手机","华为手机","扫地机器人","咖啡机"};

        //给抽奖器里，填充奖品
        List<String> products = Arrays.asList(strProducts);
        products.forEach( (o) -> stringProductGetter.addProduct(o));

        //抽奖
        String product1 = stringProductGetter.getProduct();
        System.out.println("恭喜您，您抽中了：" + product1);

        System.out.println("===============================");
        ProductGetter<Integer> integerProductGetter = new ProductGetter<>();
        Integer [] intProducts = {1000,5000,10000,500};
        List<Integer> ints = Arrays.asList(intProducts);
        ints.forEach( (o) -> integerProductGetter.addProduct(o));
        Integer product2 = integerProductGetter.getProduct();
        System.out.println("恭喜您，您抽中了：" + product2);
    }
}
