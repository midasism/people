package com.people.controller;

import com.people.mapper.EmployeeMapper;
import com.people.mapper.SalaryMapper;
import com.people.pojo.Employee;
import com.people.pojo.Salary;
import com.people.service.impl.SalaryServiceImpl;
import com.people.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryServiceImpl service;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/salaryUpdate", method = RequestMethod.GET)
    public String stateUpdate(HttpServletRequest request) {
        Integer job_id = Integer.valueOf(request.getParameter("id"));
        Salary s = new Salary();
        s.setJobId(job_id);
        s.setBasic(Integer.valueOf(request.getParameter("basic")));
        s.setBonus(Integer.valueOf(request.getParameter("bonus")));
        s.setCheck(Integer.valueOf(request.getParameter("check")));
        service.updateByJobId(s);
        return "information_update";
    }

    @ResponseBody
    @RequestMapping(value = "/getSalary", method = RequestMethod.GET)
    public Map<String, Object> getSalary(HttpServletRequest request) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SalaryMapper mapper = sqlSession.getMapper(SalaryMapper.class);
        EmployeeMapper mapper2 = sqlSession.getMapper(EmployeeMapper.class);
        List<Salary> temp_Salary = mapper.selectAll();
        for (int i = 0; i < temp_Salary.size(); i++) {
            Employee e = mapper2.selectByPrimaryKey(temp_Salary.get(i).getJobId());
            Map<String, Object> map1 = new HashMap<>();
            map1.put("id", i + 1);
            map1.put("job_id", temp_Salary.get(i).getJobId());
            map1.put("name",e.getName());
            map1.put("basic",temp_Salary.get(i).getBasic());
            map1.put("bonus",temp_Salary.get(i).getBonus());
            map1.put("check",temp_Salary.get(i).getCheck());
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
}
