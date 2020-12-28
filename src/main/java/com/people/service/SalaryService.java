package com.people.service;

import com.people.pojo.Employee;
import com.people.pojo.Salary;

import java.util.List;

public interface SalaryService{


    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    int updateByJobId(Salary record);

    List<Salary> selectAll();
}
