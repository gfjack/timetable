package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
public class StudentVo {

  @ApiModelProperty("学生id")
  private Long studentId;

  @ApiModelProperty("学生信息")
  private String studentInfo;

  @ApiModelProperty("学生姓名")
  private String studentName;

  @ApiModelProperty("家长姓名")
  private String parentName;

  @ApiModelProperty("拥有的学科")
  @Type(type = "json")
  private List<Long> subjects;

}
