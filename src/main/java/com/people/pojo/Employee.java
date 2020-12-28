package com.people.pojo;

import java.util.Date;
import lombok.Data;

@Data
public class Employee {
    /**
    * 工号，登录账号
    */
    private Integer jobId;

    /**
    * 密码
    */
    private String password;

    private String name;

    private String sex;

    /**
    * 身份证
    */
    private String identity;

    private String email;

    private String phone;

    /**
    * 入职时间
    */
    private Date hiredate;

    /**
    * 在职状态（1在职 0未入职 -1离职）
    */
    private Integer jobStatus;

    /**
    * 账户是否可用 默认1
    */
    private Object enabled;

    /**
    * 权限等级
    */
    private Integer level;
}