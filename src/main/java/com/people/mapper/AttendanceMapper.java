package com.people.mapper;

import com.people.pojo.Attendance;

import java.util.List;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

    int updateTime(Attendance record);

    List<Attendance> selectAll();

    int selectNum(Integer state);
}


