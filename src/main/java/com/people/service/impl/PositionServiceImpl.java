package com.people.service.impl;

import com.people.mapper.PositionMapper;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Position;
import com.people.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService{

    private PositionMapper positionMapper= MyBatisUtils.getSqlSession().getMapper(PositionMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Position record) {
        return positionMapper.insert(record);
    }

    @Override
    public int insertSelective(Position record) {
        return positionMapper.insertSelective(record);
    }

    @Override
    public Position selectByPrimaryKey(Integer id) {
        return positionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Position record) {
        return positionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Position record) {
        return positionMapper.updateByPrimaryKey(record);
    }

}
