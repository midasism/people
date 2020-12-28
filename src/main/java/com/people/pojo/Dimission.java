package com.people.pojo;

import java.util.Date;
import lombok.Data;

@Data
public class Dimission {
    private Integer id;

    /**
    * 工号
    */
    private String jobId;

    /**
    * 离职时间
    */
    private Date outdate;
}