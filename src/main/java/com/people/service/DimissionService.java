package com.people.service;

import com.people.pojo.Dimission;
public interface DimissionService{


    int deleteByPrimaryKey(Integer id,String jobId);

    int insert(Dimission record);

    int insertSelective(Dimission record);

    Dimission selectByPrimaryKey(Integer id,String jobId);

    int updateByPrimaryKeySelective(Dimission record);

    int updateByPrimaryKey(Dimission record);

}
