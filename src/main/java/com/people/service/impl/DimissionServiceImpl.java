package com.people.service.impl;

import com.people.mapper.DimissionMapper;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Dimission;
import com.people.service.DimissionService;
@Service
public class DimissionServiceImpl implements DimissionService{

    private DimissionMapper dimissionMapper= MyBatisUtils.getSqlSession().getMapper(DimissionMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id,String jobId) {
        return dimissionMapper.deleteByPrimaryKey(id,jobId);
    }

    @Override
    public int insert(Dimission record) {
        return dimissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Dimission record) {
        return dimissionMapper.insertSelective(record);
    }

    @Override
    public Dimission selectByPrimaryKey(Integer id,String jobId) {
        return dimissionMapper.selectByPrimaryKey(id,jobId);
    }

    @Override
    public int updateByPrimaryKeySelective(Dimission record) {
        return dimissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dimission record) {
        return dimissionMapper.updateByPrimaryKey(record);
    }

}
