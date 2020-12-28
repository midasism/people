package com.people.pojo;

import lombok.Data;

@Data
public class Office {
    private Integer id;

    private Integer jobId;

    /**
    * 职称
    */
    private String jobName;
}