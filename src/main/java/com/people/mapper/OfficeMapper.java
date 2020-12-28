package com.people.mapper;

import com.people.pojo.Office;
import org.apache.ibatis.annotations.Param;

public interface OfficeMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("jobId") Integer jobId);

    int insert(Office record);

    int insertSelective(Office record);

    Office selectByPrimaryKey(@Param("id") Integer id, @Param("jobId") Integer jobId);

    int updateByPrimaryKeySelective(Office record);

    int updateByPrimaryKey(Office record);
}
