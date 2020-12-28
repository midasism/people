package com.people.service;

import com.people.pojo.Attendance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface AttendanceService{


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
