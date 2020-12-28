package com.people.controller;

import com.people.mapper.AttendanceMapper;
import com.people.mapper.EmployeeMapper;
import com.people.pojo.Attendance;
import com.people.pojo.Employee;
import com.people.service.impl.AttendanceServiceImpl;
import com.people.service.impl.EmployeeServiceImpl;
import com.people.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/count")
public class CountController {
    @Autowired
    private AttendanceServiceImpl service;
    @Autowired
    private EmployeeServiceImpl service2;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @RequestMapping(value = "/getTable", method = RequestMethod.GET)
    public Map<String, Object> GetTable(HttpServletRequest request) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        AttendanceMapper mapper=sqlSession.getMapper(AttendanceMapper.class);
        int Normal_state=mapper.selectNum(0);
        int No_state=mapper.selectNum(-1);
        Map<String, Object> map = new HashMap<>();
        map.put("No",No_state);
        map.put("Normal",Normal_state);
        return map;
    }
}
