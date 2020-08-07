package com.example.demo.service;

import com.example.demo.entity.PageRequest;
import com.example.demo.entity.PageResult;
import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService {

    /**
     * 查询所有Person
     */
    List<Person> findAll();

    /**
     * 分页查询所有Person
     */
    PageResult findPage(PageRequest pageRequest);
}
