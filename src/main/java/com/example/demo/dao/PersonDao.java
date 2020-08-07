package com.example.demo.dao;

import com.example.demo.entity.Person;
import java.util.List;

public interface PersonDao {

    /**
     * 查询全部Person
     */

    List<Person> selectAll();

    /**
     * 分页查询Person
     */
    List<Person> selectPage();

}
