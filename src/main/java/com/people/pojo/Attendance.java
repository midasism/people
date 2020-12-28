package com.people.pojo;

import java.util.Date;
import lombok.Data;

@Data
public class Attendance {
    private Integer id;

    /**
    * 记录的日期
    */
    private Date time;

    /**
    * 工号
    */
    private Integer jobId;

    /**
    * 考勤状态（-1 迟到    0：正常）
    */
    private Integer state;

    /**
    * 到达时间
    */
    private Date arrivalTime;
}