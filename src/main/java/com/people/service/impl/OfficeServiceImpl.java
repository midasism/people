package com.people.service.impl;

import com.people.mapper.OfficeMapper;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Office;
import com.people.service.OfficeService;
@Service
public class OfficeServiceImpl implements OfficeService{

    private OfficeMapper officeMapper= MyBatisUtils.getSqlSession().getMapper(OfficeMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id,Integer jobId) {
        return officeMapper.deleteByPrimaryKey(id,jobId);
    }

    @Override
    public int insert(Office record) {
        return officeMapper.insert(record);
    }

    @Override
    public int insertSelective(Office record) {
        return officeMapper.insertSelective(record);
    }

    @Override
    public Office selectByPrimaryKey(Integer id,Integer jobId) {
        return officeMapper.selectByPrimaryKey(id,jobId);
    }

    @Override
    public int updateByPrimaryKeySelective(Office record) {
        return officeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Office record) {
        return officeMapper.updateByPrimaryKey(record);
    }

}
