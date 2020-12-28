package com.people.service.impl;

import com.people.mapper.NoticeMapper;
import com.people.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import com.people.pojo.Notice;
import com.people.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService{

    private NoticeMapper noticeMapper= MyBatisUtils.getSqlSession().getMapper(NoticeMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public int insertSelective(Notice record) {
        return noticeMapper.insertSelective(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeMapper.updateByPrimaryKey(record);
    }

}
