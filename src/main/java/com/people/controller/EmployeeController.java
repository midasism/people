package com.people.controller;

import com.people.mapper.EmployeeMapper;
import com.people.mapper.WorkMapper;
import com.people.pojo.Employee;
import com.people.pojo.Work;
import com.people.service.impl.EmployeeServiceImpl;
import com.people.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl service;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @RequestMapping(value = "/passwordupdate", method = RequestMethod.POST)
    public String passwordUpdate(HttpServletRequest request) {
        Integer job_id = Integer.valueOf(stringRedisTemplate.opsForValue().get("job_id"));
        String password = service.selectByPrimaryKey(job_id).getPassword();
        if (password.equals(request.getParameter("oldPassword"))) {
            if (request.getParameter("password").equals(request.getParameter("repassword"))) {
                Employee e = new Employee();
                e.setJobId(job_id);
                e.setPassword(request.getParameter("password"));
                service.updateByPrimaryKeySelective(e);
            } else {
                return "两次输入密码不相同";
            }
            return "修改成功";
        }
        return "修改错误";
    }

    @ResponseBody
    @RequestMapping(value = "/getLevel", method = RequestMethod.GET)
    public String getLevel() {
        Integer job_id = Integer.valueOf(stringRedisTemplate.opsForValue().get("job_id"));
        int level = service.selectByPrimaryKey(job_id).getLevel();
        if (level == 0) return "user";
        else if (level == 1) return "admin";
        else return "";
    }

    @ResponseBody
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public Employee getInfo() {
        Integer job_id = Integer.valueOf(stringRedisTemplate.opsForValue().get("job_id"));
        Employee employee = service.selectByPrimaryKey(job_id);
        return employee;
    }

    @RequestMapping(value = "/infoUpdate", method = RequestMethod.POST)
    public String infoUpdate(HttpServletRequest request) {
        Integer job_id = Integer.valueOf(stringRedisTemplate.opsForValue().get("job_id"));
        Employee e = new Employee();
        e.setJobId(job_id);
        e.setEmail(request.getParameter("email"));
        e.setIdentity(request.getParameter("identity"));
        e.setPhone(request.getParameter("cellphone"));
        e.setName(request.getParameter("nickname"));
        service.updateByPrimaryKeySelective(e);
        return "information_update";
    }

    @ResponseBody
    @RequestMapping(value = "/getSearch", method = RequestMethod.GET)
    public Map<String, Object> GetSearch(@RequestParam("id") String id) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee temp = mapper.selectByPrimaryKey(Integer.parseInt(id));
        Map<String, Object> map = new HashMap<>();
        map.put("name", temp.getName());
        map.put("phone", temp.getPhone());
        System.out.println(temp.getPhone());
        sqlSession.close();
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Map<String, Object> getEmployee(HttpServletRequest request) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        WorkMapper mapper2 = sqlSession.getMapper(WorkMapper.class);
        List<Employee> temp_Employee = mapper.selectByStatus(0);
        for (int i = 0; i < temp_Employee.size(); i++) {
            Work work = mapper2.selectByJobId(temp_Employee.get(i).getJobId());
            Map<String, Object> map1 = new HashMap<>();
            map1.put("id", i + 1);
            map1.put("job_id", temp_Employee.get(i).getJobId());
            map1.put("name",temp_Employee.get(i).getName());
            map1.put("sex",temp_Employee.get(i).getSex());
            map1.put("identity",temp_Employee.get(i).getIdentity());
            map1.put("email",temp_Employee.get(i).getEmail());
            map1.put("phone",temp_Employee.get(i).getPhone());
            map1.put("department",work.getDName());
            map1.put("position",work.getPName());
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

    @RequestMapping(value = "/stateUpdate", method = RequestMethod.GET)
    public String stateUpdate(HttpServletRequest request) {
        Integer job_id = Integer.valueOf(request.getParameter("id"));
        Employee e = new Employee();
        e.setJobId(job_id);
        e.setJobStatus(1);
        service.updateByPrimaryKeySelective(e);
        return "information_update";
    }

    //获取在职
    @ResponseBody
    @RequestMapping(value = "/getInEmployee", method = RequestMethod.GET)
    public Map<String, Object> getInEmployee(HttpServletRequest request) {
        List<Map<String, Object>> data = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        WorkMapper mapper2 = sqlSession.getMapper(WorkMapper.class);
        List<Employee> temp_Employee = mapper.selectByStatus(1);
        for (int i = 0; i < temp_Employee.size(); i++) {
            Work work = mapper2.selectByJobId(temp_Employee.get(i).getJobId());
            Map<String, Object> map1 = new HashMap<>();
            map1.put("id", i + 1);
            map1.put("job_id", temp_Employee.get(i).getJobId());
            map1.put("name",temp_Employee.get(i).getName());
            map1.put("sex",temp_Employee.get(i).getSex());
            map1.put("identity",temp_Employee.get(i).getIdentity());
            map1.put("email",temp_Employee.get(i).getEmail());
            map1.put("phone",temp_Employee.get(i).getPhone());
            map1.put("department",work.getDName());
            map1.put("position",work.getPName());
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

    @RequestMapping(value = "/outStateUpdate", method = RequestMethod.GET)
    public String outStateUpdate(HttpServletRequest request) {
        Integer job_id = Integer.valueOf(request.getParameter("id"));
        Employee e = new Employee();
        e.setJobId(job_id);
        e.setJobStatus(-1);
        service.updateByPrimaryKeySelective(e);
        return "information_update";
    }
}
