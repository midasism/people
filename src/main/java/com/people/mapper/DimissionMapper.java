package com.people.mapper;

import com.people.pojo.Dimission;
import org.apache.ibatis.annotations.Param;

public interface DimissionMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("jobId") String jobId);

    int insert(Dimission record);

    int insertSelective(Dimission record);

    Dimission selectByPrimaryKey(@Param("id") Integer id, @Param("jobId") String jobId);

    int updateByPrimaryKeySelective(Dimission record);

    int updateByPrimaryKey(Dimission record);
}
