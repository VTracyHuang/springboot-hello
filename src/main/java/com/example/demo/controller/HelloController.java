package com.example.demo.controller;

import com.example.demo.aop.WebLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@WebLog("test")
	@RequestMapping("/hello")
	public String hello() {
		return "Hello,Springboot!";
	}

}
