package com.people.pojo;

import lombok.Data;

@Data
public class Work {
    private Integer id;

    private Integer jobId;

    /**
    * 部门
    */
    private String dName;

    /**
    * 岗位
    */
    private String pName;
}