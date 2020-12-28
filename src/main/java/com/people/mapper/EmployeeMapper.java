package com.people.mapper;

import com.people.pojo.Attendance;
import com.people.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

//    public Employee getEmployee(Integer job_id);

    public int register(Map<String,Object> map);

    List<Employee> selectByStatus(Integer status);

    Integer selectByName(String nickname);
}
