package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述：
 *
 * @Author Tracy
 * @Date 2020/7/2 9:22
 */
@Controller
public class HelloPageController {
    @RequestMapping("/helloPage")
    public String helloPage(){
        return "/index";
    }
}
