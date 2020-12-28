package com.people.service.impl;

import com.people.mapper.EmployeeMapper;
import com.people.pojo.Attendance;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Employee;
import com.people.service.EmployeeService;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeMapper employeeMapper = MyBatisUtils.getSqlSession().getMapper(EmployeeMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer jobId) {
        return employeeMapper.deleteByPrimaryKey(jobId);
    }

    @Override
    public int insert(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Integer jobId) {
        return employeeMapper.selectByPrimaryKey(jobId);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }

//    @Override
//    public Employee getEmployee(Integer jobId) {
//        return employeeMapper.getEmployee(jobId);
//    }

    @Override
    public int register(Map<String, Object> map) {
        return employeeMapper.register(map);
    }

    @Override
    public List<Employee> selectByStatus(Integer status) {
        return employeeMapper.selectByStatus(status);
    }

    @Override
    public Integer selectByName(String nickname) {
        return employeeMapper.selectByName(nickname);
    }


}
