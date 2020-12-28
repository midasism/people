package com.people.service;

import com.people.pojo.Office;
public interface OfficeService{


    int deleteByPrimaryKey(Integer id,Integer jobId);

    int insert(Office record);

    int insertSelective(Office record);

    Office selectByPrimaryKey(Integer id,Integer jobId);

    int updateByPrimaryKeySelective(Office record);

    int updateByPrimaryKey(Office record);

}
