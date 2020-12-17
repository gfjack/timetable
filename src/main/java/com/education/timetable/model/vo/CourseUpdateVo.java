package com.education.timetable.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程更新vo")
public class CourseUpdateVo {

  @ApiModelProperty("课程名称")
  private String courseName;

  @ApiModelProperty("课程简介")
  private String courseIntroduction;

  @ApiModelProperty("开始时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  @ApiModelProperty("结束时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;

  @ApiModelProperty("教师id")
  private Long teacherId;
}
