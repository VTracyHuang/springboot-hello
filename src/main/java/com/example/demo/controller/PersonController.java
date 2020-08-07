package com.example.demo.controller;

import com.example.demo.entity.PageRequest;
import com.example.demo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Api(description = "用户操作接口")
public class PersonController {

    @Autowired
    private PersonService personService;


    @ApiOperation(value = "用户查询",notes = "用户查询")
    @GetMapping
    public Object findPage(@RequestBody PageRequest pageRequest){
        return personService.findPage(pageRequest);
    }
}
