package com.imooc.course.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：     Course实体类
 */
@Data
public class Course implements Serializable {
    Integer id;
    Integer courseId;
    String courseName;
    Integer valid;
}
