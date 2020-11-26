package com.education.timetable.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class TeacherVo {
  @ApiModelProperty("教师id")
  private Long teacherId;

  @ApiModelProperty("教师姓名")
  private String teacherName;

  @ApiModelProperty("联系方式")
  private String contact;
}
