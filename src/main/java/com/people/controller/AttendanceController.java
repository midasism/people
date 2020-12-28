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
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceServiceImpl service;
    @Autowired
    private EmployeeServiceImpl service2;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @RequestMapping(value = "/getAttendance", method = RequestMethod.GET)
    public Map<String, Object> GetAttendance(HttpServletRequest request) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        AttendanceMapper mapper=sqlSession.getMapper(AttendanceMapper.class);
        List<Attendance> temp_Attendance=mapper.selectAll();
        for (int i = 0; i < temp_Attendance.size(); i++) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("id", temp_Attendance.get(i).getId());
            map1.put("job_id", temp_Attendance.get(i).getJobId());
            Date now1 = temp_Attendance.get(i).getArrivalTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            String strDate1 = format1.format(now1);
            map1.put("arrival_time", strDate1);
            Date now = temp_Attendance.get(i).getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            String strDate = format.format(now);
            map1.put("time", strDate);
            int m = temp_Attendance.get(i).getState();
            if (m == 0) map1.put("state", "正常");
            else map1.put("state", "迟到");
            data.add(map1);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "消息");
        map.put("count", data.size());
        map.put("data", data);
        sqlSession.close();
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getSearch", method = RequestMethod.GET)
    public Map<String, Object> GetSearch(@RequestParam("id") String id) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
        Employee temp=mapper.selectByPrimaryKey(Integer.parseInt(id));
        Map<String, Object> map = new HashMap<>();
        map.put("name", temp.getName());
        map.put("phone", temp.getPhone());
        System.out.println(temp.getPhone());
        sqlSession.close();
        return map;
    }

    @RequestMapping(value = "/punchIn", method = RequestMethod.GET)
    public String punchIn() {
        Integer job_id = Integer.valueOf(stringRedisTemplate.opsForValue().get("job_id"));
        Attendance at = new Attendance();
        at.setJobId(job_id);
        Date d = new Date();
        at.setArrivalTime(d);
        if (d.getHours() > 9) at.setState(-1);
        else at.setState(0);
        service.insertSelective(at);
        stringRedisTemplate.opsForValue().set("arriveTime", String.valueOf(d.getTime()));
        return "punchIn";
    }

    @RequestMapping(value = "/punchOut", method = RequestMethod.GET)
    public String punchOut() {
        Integer job_id = Integer.valueOf(stringRedisTemplate.opsForValue().get("job_id"));
        Date date = new Date(Long.valueOf(stringRedisTemplate.opsForValue().get("arriveTime")));
        Attendance at = new Attendance();
        at.setJobId(job_id);
        at.setArrivalTime(date);
        Date d = new Date();
        at.setTime(d);
        service.updateTime(at);
        return "punchOut";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(@RequestParam("id") String id) {
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        AttendanceMapper mapper=sqlSession.getMapper(AttendanceMapper.class);
        mapper.deleteByPrimaryKey(Integer.parseInt(id));
        sqlSession.close();
        return "punchOut";
    }
}
