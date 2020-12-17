package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("学生创建vo")
public class StudentCreateVo {

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
