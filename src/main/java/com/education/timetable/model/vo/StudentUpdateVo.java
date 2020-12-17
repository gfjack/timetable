package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("更新学生信息vo")
public class StudentUpdateVo {

  @ApiModelProperty("学生信息")
  private String studentInfo;

  @ApiModelProperty("学生联系方式")
  private String studentContactInfo;

  @ApiModelProperty("家长联系方式")
  private String parentContactInfo;

  @ApiModelProperty("年级")
  private String gradeLevel;

  @ApiModelProperty("学校名称")
  private String schoolName;
}
