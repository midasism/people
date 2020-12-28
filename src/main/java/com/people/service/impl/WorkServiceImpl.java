package com.people.service.impl;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Work;
import com.people.mapper.WorkMapper;
import com.people.service.WorkService;
@Service
public class WorkServiceImpl implements WorkService{

    private WorkMapper workMapper = MyBatisUtils.getSqlSession().getMapper(WorkMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return workMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Work record) {
        return workMapper.insert(record);
    }

    @Override
    public int insertSelective(Work record) {
        return workMapper.insertSelective(record);
    }

    @Override
    public Work selectByPrimaryKey(Integer id) {
        return workMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Work record) {
        return workMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Work record) {
        return workMapper.updateByPrimaryKey(record);
    }

    public Work selectByJobId(Integer id){
        return workMapper.selectByJobId(id);
    }
}
