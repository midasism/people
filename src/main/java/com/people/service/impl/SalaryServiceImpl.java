package com.people.service.impl;

import com.people.mapper.SalaryMapper;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Salary;
import com.people.service.SalaryService;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService{

    private SalaryMapper salaryMapper= MyBatisUtils.getSqlSession().getMapper(SalaryMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Salary record) {
        return salaryMapper.insert(record);
    }

    @Override
    public int insertSelective(Salary record) {
        return salaryMapper.insertSelective(record);
    }

    @Override
    public Salary selectByPrimaryKey(Integer id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Salary record) {
        return salaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Salary record) {
        return salaryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByJobId(Salary record) {
        return salaryMapper.updateByJobId(record);
    }

    @Override
    public List<Salary> selectAll() {
        return salaryMapper.selectAll();
    }

}
