package com.example.demo;


import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;


@SpringBootTest
class SpringbootHelloApplicationTests {
    @Features("测试目录")
    @Stories("测试子目录")
    @Title("测试一")
    @Test
    public void Test(){

        int a = 9;
        int b = 3;
        assert (a+b == 11);
        // LOGGER.info("jenkins单元测试");
    }
    @Features("测试目录")
    @Stories("测试子目录")
    @Title("测试二")
    @Test
    public void Test2(){

        int a = 9;
        int b = 3;
        assert (a+b == 12);
        // LOGGER.info("jenkins单元测试");
    }
}
