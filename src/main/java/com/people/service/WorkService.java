package com.people.service;

import com.people.pojo.Work;
public interface WorkService{


    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    Work selectByJobId(Integer id);
}
