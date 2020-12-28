package com.people.service.impl;

import com.people.mapper.AttendanceMapper;
import com.people.util.MyBatisUtils;
import org.apache.catalina.webresources.JarResource;
import org.springframework.stereotype.Service;
import com.people.pojo.Attendance;
import com.people.service.AttendanceService;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    private AttendanceMapper attendanceMapper = MyBatisUtils.getSqlSession().getMapper(AttendanceMapper.class);

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attendanceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Attendance record) {
        return attendanceMapper.insert(record);
    }

    @Override
    public int insertSelective(Attendance record) {
        return attendanceMapper.insertSelective(record);
    }

    @Override
    public Attendance selectByPrimaryKey(Integer id) {
        return attendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Attendance record) {
        return attendanceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Attendance record) {
        return attendanceMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateTime(Attendance record) {
        return attendanceMapper.updateTime(record);
    }

    @Override
    public List<Attendance> selectAll() {
        return attendanceMapper.selectAll();
    }

    @Override
    public int selectNum(Integer state) {
        return attendanceMapper.selectNum(state);
    }
}
