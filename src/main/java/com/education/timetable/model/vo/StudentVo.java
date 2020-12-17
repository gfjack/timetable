package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("返回学生vo")
public class StudentVo implements Serializable {

  @ApiModelProperty("学生id")
  private Long studentId;

  @ApiModelProperty("学生信息")
  private String studentInfo;

  @ApiModelProperty("学生联系方式")
  private String studentContactInfo;

  @ApiModelProperty("学生姓名")
  private String studentName;

  @ApiModelProperty("家长姓名")
  private String parentName;

  @ApiModelProperty("家长联系方式")
  private String parentContactInfo;

  @ApiModelProperty("年级")
  private String gradeLevel;

  @ApiModelProperty("学校名称")
  private String schoolName;
}
