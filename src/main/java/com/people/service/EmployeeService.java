package com.people.service;

import com.people.pojo.Attendance;
import com.people.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService{

    int deleteByPrimaryKey(Integer jobId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int register(Map<String,Object> map);

    List<Employee> selectByStatus(Integer status);

    Integer selectByName(String nickname);
}
