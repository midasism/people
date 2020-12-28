package com.people.service.impl;

import com.people.mapper.DepartmentMapper;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Department;
import com.people.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentMapper departmentMapper= MyBatisUtils.getSqlSession().getMapper(DepartmentMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

}
