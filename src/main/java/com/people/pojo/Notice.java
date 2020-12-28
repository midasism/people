package com.people.pojo;

import lombok.Data;

@Data
public class Notice {
    private Integer id;

    /**
    * 公告内容
    */
    private String message;
}