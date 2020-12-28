package com.people.controller;

import com.people.pojo.Work;
import com.people.service.impl.EmployeeServiceImpl;
import com.people.service.impl.WorkServiceImpl;
import com.people.util.CodeUtils;
import com.people.util.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private EmployeeServiceImpl service;
    @Autowired
    private WorkServiceImpl service2;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SendSmsUtil sendSmsUtil;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String register(HttpServletRequest request) throws FileNotFoundException {
        String vercode = request.getParameter("vercode");
        Map<String, Object> map = new HashMap<>();
        int res=0;
        if (vercode.equals(stringRedisTemplate.opsForValue().get("phoneCode"))) {
            System.out.println("验证码正确");
            map.put("phone",request.getParameter("cellphone"));
            map.put("email",request.getParameter("email"));
            map.put("password",request.getParameter("password"));
            map.put("name",request.getParameter("nickname"));
            map.put("identity",request.getParameter("identity"));
            map.put("level",0);
            map.put("enabled",1);
            map.put("job_status",0);
            map.put("sex","男");
            map.put("hiredate",new Date());
            res = service.register(map);
            Integer job_id = service.selectByName(request.getParameter("nickname"));
            Work work = new Work();
            work.setJobId(job_id);
            work.setDName("技术");
            work.setPName("Java工程师");
            service2.insertSelective(work);
        }
        if (res == 1) {
            //保存登录态
//            String file = "src/main/resources/user.properties";
//            PropertiesUtils.addProperties(file,"userId",username,"userId");
            System.out.println("注册成功");
            return "login";
        } else {
            System.out.println("注册失败");
            return "register";
        }
    }

    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    @ResponseBody
    public String sendSms(@RequestParam String tel) {
        boolean res = sendSmsUtil.SendSms(tel, CodeUtils.randomCode(4, "numCode"));
        if (res) return "ok";
        else return "no";
    }
}
