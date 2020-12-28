package com.people.pojo;

import lombok.Data;

@Data
public class Salary {
    private Integer id;

    /**
    * 工号
    */
    private Integer jobId;

    /**
    * 基础工资
    */
    private Integer basic;

    /**
    * 奖金
    */
    private Integer bonus;

    /**
    * 考勤所得
    */
    private Integer check;
}